package mx.com.gapsi.examen.mm.ws;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.gapsi.examen.mm.ws.model.Proveedor;
import mx.com.gapsi.examen.mm.ws.service.ProveedorFacade;

@SpringBootApplication
public class App {
	
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
    CommandLineRunner runner(ProveedorFacade proveedorService) {
        return args -> {
            //NOTE Lee JSON y graba a DB en memoria
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Proveedor>> typeReference = new TypeReference<List<Proveedor>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/proveedores.json");
            try {
                List<Proveedor> proveedores = mapper.readValue(inputStream,typeReference);
                proveedorService.agregarProveedores(proveedores);
                LOG.info("Proveedores guardados");
            } catch (IOException e){
            	LOG.info("No se pudo guardar proveedor", e);
            }
        };
    }
}
