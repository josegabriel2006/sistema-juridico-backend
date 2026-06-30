package br.com.josedev.sistemaJuridico.controller;

import br.com.josedev.sistemaJuridico.model.LegalProcess;
import br.com.josedev.sistemaJuridico.service.LegalProcessesService;
import br.com.josedev.sistemaJuridico.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processos")
public class ProcessController {
    @Autowired
    private LegalProcessesService legalProcessesService;

    @GetMapping
    public ResponseEntity<List<?>> getAllProcesses() {
        return ResponseEntity.ok().body(legalProcessesService.getAllLegalProcesses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LegalProcess> getAllProcessesById(@PathVariable Long id) {
        return ResponseEntity.ok().body(legalProcessesService.getLegalProcessById(id));
    }

    @PostMapping
    public ResponseEntity<LegalProcess> createLegalProcess(@RequestBody LegalProcess legalProcess) {
        System.out.println("Processo Legal criado: " + legalProcess.getProcessNumber());
        legalProcessesService.createLegalProcess(legalProcess);
        return new ResponseEntity<>(legalProcess, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LegalProcess> updateProcess(@RequestBody LegalProcess legalProcess, @PathVariable Long id) {
        LegalProcess updateLegalProcess = legalProcessesService.updateLegalProcess(legalProcess, id);
        if (updateLegalProcess == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(updateLegalProcess);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcessById(@PathVariable Long id) {
        legalProcessesService.deleteLegalProcessById(id);
        return ResponseEntity.ok().build();
    }

}
