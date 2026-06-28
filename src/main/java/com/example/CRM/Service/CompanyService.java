package com.example.CRM.Service;

import com.example.CRM.Entity.Company;
import com.example.CRM.Entity.Lead;
import com.example.CRM.Repository.CompanyRepository;
import com.example.CRM.Repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
    }

    public Page<Company> getAllCompanies(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Transactional
    public Company updateCompany(Long id, Company updatedCompany) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
        company.setName(updatedCompany.getName());
        company.setEmail(updatedCompany.getEmail());
        company.setPhone(updatedCompany.getPhone());
        company.setIndustryType(updatedCompany.getIndustryType());
        company.setWebsite(updatedCompany.getWebsite());
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
