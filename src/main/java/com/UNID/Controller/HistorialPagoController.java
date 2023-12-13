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
                    actualizado.setId(id);
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
        HistorialPago historialPago = new HistorialPago();
        historialPago.setNombre(dto.getNombre());
        historialPago.setSueldoActual(dto.getSueldoActual());
        historialPago.setFechaDePago(dto.getFechaDePago());
        historialPago.setPagoActual(dto.getPagoActual());
        historialPago.setPagoAnterior(dto.getPagoAnterior());
      
        return historialPago;
    }

    private HistorialPagoDTO convertirADTO(HistorialPago historialPago) {
        
        return new HistorialPagoDTO(
            historialPago.getId(), 
            historialPago.getNombre(), 
            historialPago.getSueldoActual(), 
            historialPago.getFechaDePago(), 
            historialPago.getPagoActual(), 
            historialPago.getPagoAnterior(),
            historialPago.getPsp() != null ? historialPago.getPsp().getId() : null

            
        );
    }
}
