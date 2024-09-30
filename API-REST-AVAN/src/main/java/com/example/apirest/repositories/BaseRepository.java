package com.example.apirest.repositories;

import com.example.apirest.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean //base para todos los repositorios de las entidades no necesitan que se instancie
// No se pueden crear instancias de éste repositorio
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
}
