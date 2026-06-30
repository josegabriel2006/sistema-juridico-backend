package br.com.josedev.sistemaJuridico.controller;

import br.com.josedev.sistemaJuridico.model.Financial;
import br.com.josedev.sistemaJuridico.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financeiro")
public class FinancialController {
    @Autowired
    private FinancialService financialService;

    @GetMapping
    public ResponseEntity<List<Financial>> getAllFinancials() {
        return ResponseEntity.ok().body(financialService.getAllFinancials());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Financial> getAllFinancialsById(@PathVariable Long id) {
        return ResponseEntity.ok().body(financialService.getAllFinancialsById(id));
    }

    @PostMapping
    public ResponseEntity<Financial> createFinancials(@RequestBody Financial financial) {
        return ResponseEntity.ok().body(financialService.createFinancial(financial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Financial> updateFinancial(@RequestBody Financial financial, @PathVariable Long id) {
        Financial updateFinancial = financialService.updateFinancial(financial, id);
        if (updateFinancial == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updateFinancial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinancialById(@PathVariable Long id) {
        financialService.deleteFinancialById(id);
        return ResponseEntity.ok().build();
    }

}
