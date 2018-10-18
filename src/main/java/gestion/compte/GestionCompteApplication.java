package gestion.compte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@SpringBootApplication
//@ImportResource("spring-beans.xml")
public class GestionCompteApplication {
    
	@Bean
	public SimpleJaxWsServiceExporter getJWS(){
		SimpleJaxWsServiceExporter exporter =new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://127.0.0.1:8091/gestionCompte");
		return exporter;
	}
	public static void main(String[] args) {
		SpringApplication.run(GestionCompteApplication.class, args);
		
	}
}
