package mx.com.gapsi.examen.mm.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.gapsi.examen.mm.dto.GapsiGenericResponseDto;
import mx.com.gapsi.examen.mm.dto.GapsiProveedoresResponseDto;
import mx.com.gapsi.examen.mm.ws.model.Proveedor;
import mx.com.gapsi.examen.mm.ws.service.ProveedorFacade;

@RestController
public class GapsiController {

	private static final Logger LOG = LoggerFactory.getLogger(GapsiController.class);

	@Autowired
	ProveedorFacade proveedorService;

	@Value("${gapsi.version}")
	private String version;

	@GetMapping("/check")
	public void check() {
		LOG.info("Check!");
	}

	@GetMapping("/gapsi/version")
	public ResponseEntity<String> getVersion() {
		LOG.info("Calling getVersion");
		return new ResponseEntity<>(version, HttpStatus.OK);
	}

	@GetMapping("/candidato/{idCandidato}/bienvenida")
	public ResponseEntity<String> getBienvenidaCandidato(@PathVariable String idCandidato) {
		LOG.info("Calling getBienvenidaCandidato. IdCandidato: {}", idCandidato);
		return new ResponseEntity<>("Bienvenido Candidato ".concat(idCandidato), HttpStatus.OK);
	}

	@GetMapping("/proveedores")
	public ResponseEntity<GapsiProveedoresResponseDto> getProveedores(int page, int size) {
		LOG.info("Calling getProveedores. Page: {}. Size: {}", page, size);
		GapsiProveedoresResponseDto response = new GapsiProveedoresResponseDto();
		response.setData(proveedorService.getProveedores(PageRequest.of(page, size)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/proveedores")
    public ResponseEntity<GapsiGenericResponseDto> postProveedor(@RequestBody Proveedor proveedor) {
    	LOG.info("Calling postProveedor");
    	proveedorService.agregarProveedor(proveedor);
    	GapsiGenericResponseDto response = new GapsiGenericResponseDto();
    	return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/proveedores/{id}")
    public ResponseEntity<GapsiGenericResponseDto> deleteProveedor(@PathVariable Long id) {
    	LOG.info("Calling postProveedor");
    	proveedorService.delete(id);
    	GapsiGenericResponseDto response = new GapsiGenericResponseDto();
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
