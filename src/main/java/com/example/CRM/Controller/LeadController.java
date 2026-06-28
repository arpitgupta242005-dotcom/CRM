package com.example.CRM.Controller;

import com.example.CRM.Entity.Lead;
import com.example.CRM.Service.LeadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leads")
@RequiredArgsConstructor
public class LeadController {
    private final LeadService leadservice;
    @GetMapping("/{id}")
    public ResponseEntity<Lead> getAllById(@PathVariable Long id){
        return ResponseEntity.ok(leadservice.getLeadById(id));
    }
    @GetMapping
    public ResponseEntity<Page<Lead>> getAllLeads(Pageable pageable){
        return ResponseEntity.ok(leadservice.getAllLeads(pageable));
    }
    @PostMapping
    public ResponseEntity<Lead> addLead(@Valid @RequestBody Lead lead){
        return ResponseEntity.ok(leadservice.addLead(lead));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeadById(@PathVariable Long id){
        leadservice.deleteLead(id);
        return ResponseEntity.ok("deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(@PathVariable Long id, @Valid @RequestBody Lead lead) {
        return ResponseEntity.ok(leadservice.updateLead(id, lead));
    }



}
