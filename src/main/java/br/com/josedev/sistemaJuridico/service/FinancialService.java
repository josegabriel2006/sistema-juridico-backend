package br.com.josedev.sistemaJuridico.service;

import br.com.josedev.sistemaJuridico.model.Financial;
import br.com.josedev.sistemaJuridico.repository.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialService {
    @Autowired
    private FinancialRepository financialRepository;

    public List<Financial> getAllFinancials() {
        return financialRepository.findAll();
    }

    public Financial getAllFinancialsById(Long id) {
        return financialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Financeiro de id: " + id + ", não encontrado no banco de dados"));
    }

    public Financial createFinancial(Financial financial) {
        return financialRepository.save(financial);
    }

    public Financial updateFinancial(Financial financial, Long id) {
        Financial existingFinancial = financialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Financeiro de id: " + id + ", não encontrado no banco de dados."));
        existingFinancial.setDescription(financial.getDescription());
        existingFinancial.setTotalValue(financial.getTotalValue());
        existingFinancial.setPaidValue(financial.getPaidValue());
        existingFinancial.setDueDate(financial.getDueDate());
        existingFinancial.setPaymentDate(financial.getPaymentDate());
        existingFinancial.setFeeType(financial.getFeeType());
        existingFinancial.setStatusFinancial(financial.getStatusFinancial());
        existingFinancial.setClient(financial.getClient());
        existingFinancial.setLegalProcess(financial.getLegalProcess());
        existingFinancial.setObservations(financial.getObservations());
        return financialRepository.save(existingFinancial);
    }

    public void deleteFinancialById(Long id) {
        financialRepository.deleteById(id);
    }

}
