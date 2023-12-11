package com.UNID.Repository;

import org.springframework.data.repository.CrudRepository;
import com.UNID.Entity.HistorialPago;


public interface HistorialPagoRepository extends CrudRepository<HistorialPago, Integer> {
    // Aquí puedes agregar consultas personalizadas si es necesario
}