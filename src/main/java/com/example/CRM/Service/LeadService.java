package com.example.CRM.Service;

import com.example.CRM.Entity.Lead;
import com.example.CRM.Repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LeadService {

    private final LeadRepository leadRepository;

    public Lead getLeadById(Long id) {
        return leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found with id: " + id));
    }

    public Page<Lead> getAllLeads(Pageable pageable) {
        return leadRepository.findAll(pageable);
    }

    public Lead addLead(Lead lead) {
        return leadRepository.save(lead);
    }

    @Transactional
    public Lead updateLead(Long id, Lead updatedLead) {
        Lead lead = leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found with id: " + id));
        lead.setName(updatedLead.getName());
        lead.setEmail(updatedLead.getEmail());
        lead.setPhone(updatedLead.getPhone());
        lead.setStatus(updatedLead.getStatus());
        return leadRepository.save(lead);  // return missing tha
    }

    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }
}