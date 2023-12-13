package com.UNID.Service;

import com.UNID.Entity.HistorialPago;
import com.UNID.Entity.PSP;
import com.UNID.Repository.HistorialPagoRepository;
import com.UNID.Repository.PSPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialPagoService {
    private final HistorialPagoRepository historialPagoRepository;
    private final PSPRepository pspRepository;

    @Autowired
    public HistorialPagoService(HistorialPagoRepository historialPagoRepository, PSPRepository pspRepository) {
        this.historialPagoRepository = historialPagoRepository;
        this.pspRepository = pspRepository;
    }

    public HistorialPago guardarHistorialPago(HistorialPago historialPago, Integer pspId) {
        PSP psp = pspRepository.findById(pspId)
                      .orElseThrow(() -> new RuntimeException("PSP no encontrado"));
        historialPago.setPsp(psp);
        return historialPagoRepository.save(historialPago);
    }

    // Método para obtener todos los HistorialPago
    public List<HistorialPago> findAll() {
        return historialPagoRepository.findAll();
    }

    // Método para buscar un HistorialPago por ID
    public Optional<HistorialPago> findById(Integer id) {
        return historialPagoRepository.findById(id);
    }
    
 // Método para guardar un HistorialPago por ID
    public HistorialPago save(HistorialPago historialPago) {
        return historialPagoRepository.save(historialPago);
    }

    // Método para eliminar un HistorialPago por ID
    public void deleteById(Integer id) {
        historialPagoRepository.deleteById(id);
    }
    
    // Método adicional para buscar un PSP por su ID
    public PSP findPspById(Integer id) {
        return pspRepository.findById(id).orElseThrow(() -> new RuntimeException("PSP no encontrado"));
    }

}
