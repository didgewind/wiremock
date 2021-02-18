package profe.empleados.wiremock;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
@EnableSidecar
public class EmpleadosWireMockSidecar {
	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "empleados-wiremock-sidecar");
		SpringApplication.run(EmpleadosWireMockSidecar.class, args);
	}
	
}
