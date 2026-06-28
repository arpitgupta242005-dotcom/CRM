package com.example.CRM.Controller;

import com.example.CRM.Entity.Company;
import com.example.CRM.Service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyservice;
    @GetMapping("/{id}")
    public ResponseEntity<Company> getAllById(@PathVariable Long id){
        return ResponseEntity.ok(companyservice.getCompanyById(id));
    }
    @GetMapping
    public ResponseEntity<Page<Company>> getAllCompanies(Pageable pageable){
        return ResponseEntity.ok(companyservice.getAllCompanies(pageable));
    }
    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        return ResponseEntity.ok(companyservice.addCompany(company));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        companyservice.deleteCompany(id);
        return ResponseEntity.ok("deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        return ResponseEntity.ok(companyservice.updateCompany(id, company));
    }

}
