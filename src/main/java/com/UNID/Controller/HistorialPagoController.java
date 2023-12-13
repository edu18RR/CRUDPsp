package com.UNID.Controller;

import com.UNID.Entity.HistorialPago;
import com.UNID.Service.HistorialPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.UNID.DTO.HistorialPagoDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/historialPago")
public class HistorialPagoController {

    private final HistorialPagoService historialPagoService;

    @Autowired
    public HistorialPagoController(HistorialPagoService historialPagoService) {
        this.historialPagoService = historialPagoService;
    }

    @GetMapping
    public ResponseEntity<List<HistorialPagoDTO>> getAllHistorialPagos() {
        List<HistorialPagoDTO> dtos = historialPagoService.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialPagoDTO> getHistorialPagoById(@PathVariable int id) {
        return historialPagoService.findById(id)
                .map(this::convertirADTO)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<HistorialPagoDTO> crearHistorialPago(@RequestBody HistorialPagoDTO historialPagoDTO) {
        HistorialPago historialPago = convertirADominio(historialPagoDTO);
        HistorialPago nuevoHistorialPago = historialPagoService.guardarHistorialPago(historialPago, historialPagoDTO.getPspId());
        return new ResponseEntity<>(convertirADTO(nuevoHistorialPago), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialPagoDTO> updateHistorialPago(@PathVariable int id, @RequestBody HistorialPagoDTO historialPagoDTO) {
        return historialPagoService.findById(id)
                .map(existingHistorialPago -> {
                    HistorialPago actualizado = convertirADominio(historialPagoDTO);
                    actualizado.setId(id); // Asegúrate de establecer el ID
                    historialPagoService.save(actualizado);
                    return new ResponseEntity<>(convertirADTO(actualizado), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorialPago(@PathVariable int id) {
        historialPagoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private HistorialPago convertirADominio(HistorialPagoDTO dto) {
        // Implementa la lógica de conversión aquí
        // Debes adaptar esta parte según la estructura de tus clases
        return new HistorialPago(...); // Completa con los parámetros adecuados
    }

    private HistorialPagoDTO convertirADTO(HistorialPago historialPago) {
        // Implementa la lógica de conversión aquí
        return new HistorialPagoDTO(
            historialPago.getId(), 
            historialPago.getNombre(), 
            historialPago.getSueldoActual(), 
            historialPago.getFechaDePago(), 
            historialPago.getPagoActual(), 
            historialPago.getPagoAnterior()
            // Agrega otros campos si son necesarios
        );
    }
}
