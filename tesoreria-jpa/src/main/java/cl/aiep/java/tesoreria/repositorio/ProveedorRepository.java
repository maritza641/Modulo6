package cl.aiep.java.tesoreria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.tesoreria.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

	
}
