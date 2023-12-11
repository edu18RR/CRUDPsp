package com.UNID.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.UNID.DTO.PSPDTO;
import com.UNID.Entity.PSP;
import com.UNID.Service.PSPService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/psp")
public class PSPController {
    private final PSPService pspService;

    @Autowired
    public PSPController(PSPService pspService) {
        this.pspService = pspService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearPSP(@RequestBody PSP psp) {
        PSP nuevoPSP = pspService.guardarPSP(psp);
        PSPDTO pspDTO = pspService.convertirAPSPDTO(nuevoPSP);
        return new ResponseEntity<>(pspDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPSPPorId(@PathVariable int id) {
        PSP psp = pspService.buscarPorId(id);
        if (psp == null) {
            return new ResponseEntity<>("PSP no encontrado", HttpStatus.NOT_FOUND);
        }
        PSPDTO pspDTO = pspService.convertirAPSPDTO(psp);
        return new ResponseEntity<>(pspDTO, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<?> obtenerTodosLosPSP() {
        List<PSPDTO> pspDTOs = pspService.obtenerTodosLosPSP().stream()
                .map(pspService::convertirAPSPDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(pspDTOs, HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarPSP(@PathVariable int id, @RequestBody PSP pspDetails) {
        PSP pspActualizado = pspService.actualizarPSP(id, pspDetails);
        PSPDTO pspDTO = pspService.convertirAPSPDTO(pspActualizado);
        return new ResponseEntity<>(pspDTO, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPSP(@PathVariable int id) {
        pspService.eliminarPSP(id);
        return new ResponseEntity<>("PSP eliminado con éxito", HttpStatus.OK);
    }
}

