package mx.com.gapsi.examen.mm.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.com.gapsi.examen.mm.ws.dao.ProveedorRepository;
import mx.com.gapsi.examen.mm.ws.model.Proveedor;
import mx.com.gapsi.examen.mm.ws.service.exception.GapsiException;

@Service
public class ProveedorFacadeImpl implements ProveedorFacade {

	@Autowired
	ProveedorRepository proveedorRepository;
	
	@Override
	public Page<Proveedor> getProveedores(Pageable pageable) {
		return proveedorRepository.findAll(pageable);
	}
	
	@Override
	public Iterable<Proveedor> agregarProveedores(Iterable<Proveedor> proveedores){
		return proveedorRepository.saveAll(proveedores);
	}

	@Override
	public Proveedor agregarProveedor(Proveedor proveedor) {
		validarInput(proveedor);
		return proveedorRepository.save(proveedor);
	}

	@Override
	public void delete(Long id) {
		proveedorRepository.deleteById(id);
	}
	
	private void validarInput(Proveedor proveedor) {
		if(proveedor.getNombre() == null || proveedor.getNombre().isBlank()) {
			throw new GapsiException("El nombre del proveedor no puede estar vacío");
		}
		if(proveedor.getDireccion() == null || proveedor.getDireccion().isBlank()) {
			throw new GapsiException("La dirección del proveedor no puede estar vacía");
		}
		if(proveedor.getRazonSocial() == null || proveedor.getRazonSocial().isBlank()) {
			throw new GapsiException("La razón social del proveedor no puede estar vacía");
		}		
		if(proveedorRepository.findByNombre(proveedor.getNombre()).isPresent()){
			throw new GapsiException("El nombre del proveedor ya existe y no puede estar duplicado");
		}
	}
	

}
