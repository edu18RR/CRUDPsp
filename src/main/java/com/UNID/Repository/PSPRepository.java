package com.UNID.Repository;

import org.springframework.data.repository.CrudRepository;
import com.UNID.Entity.PSP;

public interface PSPRepository extends CrudRepository<PSP, Integer> {
    // Métodos CRUD están incluidos por defecto.
}