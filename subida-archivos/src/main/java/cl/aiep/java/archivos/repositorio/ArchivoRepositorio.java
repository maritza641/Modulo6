package cl.aiep.java.archivos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.archivos.modelo.Archivo;

public interface ArchivoRepositorio extends JpaRepository<Archivo, Long>{

}
