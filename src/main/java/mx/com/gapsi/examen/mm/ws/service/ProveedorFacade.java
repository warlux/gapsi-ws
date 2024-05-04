package mx.com.gapsi.examen.mm.ws.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.com.gapsi.examen.mm.ws.model.Proveedor;

public interface ProveedorFacade {

	Page<Proveedor> getProveedores(Pageable pageable);
	
	Iterable<Proveedor> agregarProveedores(Iterable<Proveedor> proveedores);
	
	Proveedor agregarProveedor(Proveedor proveedor);
	
	void delete(Long id);
}
