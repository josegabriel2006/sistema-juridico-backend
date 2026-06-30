package br.com.josedev.sistemaJuridico.service;

import br.com.josedev.sistemaJuridico.model.LegalProcess;
import br.com.josedev.sistemaJuridico.repository.LegalProcessesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegalProcessesService {
    @Autowired
    private LegalProcessesRepository legalProcessesRepository;

    public List<LegalProcess> getAllLegalProcesses() {
        return legalProcessesRepository.findAll();
    }

    public LegalProcess getLegalProcessById(Long id) {
        return legalProcessesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Processo de id: " + id + ", não encontrado."));
    }

    public LegalProcess createLegalProcess(LegalProcess legalProcess) {
        return legalProcessesRepository.save(legalProcess);
    }

    public LegalProcess updateLegalProcess(LegalProcess legalProcess, Long id) {
        LegalProcess existing = legalProcessesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Processo de id: " + id + ", não encontrado."));
        existing.setProcessNumber(legalProcess.getProcessNumber());
        existing.setLegalArea(legalProcess.getLegalArea());
        existing.setActionType(legalProcess.getActionType());
        existing.setDistributionDate(legalProcess.getDistributionDate());
        existing.setClient(legalProcess.getClient());
        existing.setClientPole(legalProcess.getClientPole());
        existing.setAdverseParty(legalProcess.getAdverseParty());
        existing.setAdversePartyLawyer(legalProcess.getAdversePartyLawyer());
        existing.setCourt(legalProcess.getCourt());
        existing.setCourtDivision(legalProcess.getCourtDivision());
        existing.setDistrict(legalProcess.getDistrict());
        existing.setState(legalProcess.getState());
        existing.setCaseValue(legalProcess.getCaseValue());
        existing.setRequestValue(legalProcess.getRequestValue());
        existing.setFeeValue(legalProcess.getFeeValue());
        existing.setFeeType(legalProcess.getFeeType());
        existing.setActionDescription(legalProcess.getActionDescription());
        return legalProcessesRepository.save(existing);
    }

    public void deleteLegalProcessById(Long id) {
        legalProcessesRepository.deleteById(id);
    }
}