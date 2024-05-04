package mx.com.gapsi.examen.mm.ws.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.gapsi.examen.mm.ws.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
	
	Optional<Proveedor> findByNombre(String nombre);
}