package profe.empleados.wiremock;


import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;

@SpringBootApplication
@EnableSidecar
public class EmpleadosWireMockSidecar {
	
	public static void main(String[] args) {
		
		// Primero lanzamos el wiremock server
		WireMockServer wireMockServer = 
				new WireMockServer(
						options()
							.port(5555)
							.usingFilesUnderDirectory("standalone server") // Usamos las mismas carpetas __files y mappings que el standaalone server
							.extensions(new ResponseTemplateTransformer(true))); // permite usar variables {{ }} en las respuestas para todos los stubs (parámetro true)
		wireMockServer.start();
		
		// Luego el sidecar
		System.setProperty("spring.config.name", "empleados-wiremock-sidecar");
		SpringApplication.run(EmpleadosWireMockSidecar.class, args);
	}
	
}
