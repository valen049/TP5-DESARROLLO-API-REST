package com.example.apirest.repositories;


import com.example.apirest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    Set<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);


    // boolean existsByDni(int dni);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Set<Persona> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM Persona WHERE nombre LIKE %:filtro% OR apellido LIKE %:filtro%",
            nativeQuery = true
    )
    Set<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM Persona WHERE nombre LIKE %:filtro% OR apellido LIKE %:filtro%",
            countQuery = "SELECT COUNT(*) FROM Persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}