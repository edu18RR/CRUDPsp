package com.UNID.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.UNID.Entity.HistorialPago;
import com.UNID.Entity.PSP;
import com.UNID.Repository.PSPRepository;
import com.UNID.DTO.HistorialPagoDTO;
import com.UNID.DTO.PSPDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PSPService {
    
    private final PSPRepository pspRepository;

    @Autowired
    public PSPService(PSPRepository pspRepository) {
        this.pspRepository = pspRepository;
    }

    @Transactional
    public PSP guardarPSP(PSP psp) {
        return pspRepository.save(psp);
    }

    @Transactional(readOnly = true)
    public PSP buscarPorId(int id) {
        return pspRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<PSP> obtenerTodosLosPSP() {
        return (List<PSP>) pspRepository.findAll();
    }

    @Transactional
    public PSP actualizarPSP(int id, PSP pspDetails) {
        return pspRepository.findById(id)
            .map(pspExistente -> {
                pspExistente.setNombre(pspDetails.getNombre());
                pspExistente.setApellidos(pspDetails.getApellidos());
                pspExistente.setCorreoContacto(pspDetails.getCorreoContacto());
                pspExistente.setTelefono(pspDetails.getTelefono());
                pspExistente.setEstado(pspDetails.getEstado());
                pspExistente.setFechaInicioContratacion(pspDetails.getFechaInicioContratacion());
                pspExistente.setFechaFinContrato(pspDetails.getFechaFinContrato());
                pspExistente.setProyectoAsignado(pspDetails.getProyectoAsignado());
                pspExistente.setSueldo(pspDetails.getSueldo());
                pspExistente.setProyectosExtra(pspDetails.getProyectosExtra());
                return pspRepository.save(pspExistente);
            })
            .orElseGet(() -> {
                pspDetails.setId(id);
                return pspRepository.save(pspDetails);
            });
    }

    @Transactional
    public void eliminarPSP(int id) {
        pspRepository.deleteById(id);
    }

    public PSPDTO convertirAPSPDTO(PSP psp) {
        List<HistorialPagoDTO> historialPagoDTOs = psp.getHistorialPagos().stream()
            .map(this::convertirAHistorialPagoDTO)
            .collect(Collectors.toList());

        return new PSPDTO(
            psp.getId(),
            psp.getNombre(),
            psp.getApellidos(),
            psp.getCorreoContacto(),
            psp.getTelefono(),
            psp.getEstado(),
            psp.getFechaInicioContratacion(),
            psp.getFechaFinContrato(),
            psp.getProyectoAsignado(),
            psp.getSueldo(),
            psp.getProyectosExtra(),
            historialPagoDTOs
        );
    }

    private HistorialPagoDTO convertirAHistorialPagoDTO(HistorialPago historialPago) {
        // Argumentos de HistorialPagoDTO
        return new HistorialPagoDTO(
            historialPago.getId(),
            historialPago.getNombre(),
            historialPago.getSueldoActual(),
            historialPago.getFechaDePago(),
            historialPago.getPagoActual(),
            historialPago.getPagoAnterior(),
            historialPago.getPsp() != null ? historialPago.getPsp().getId() : null // Obtiene el ID de PSP si está presente

        );
    }
}