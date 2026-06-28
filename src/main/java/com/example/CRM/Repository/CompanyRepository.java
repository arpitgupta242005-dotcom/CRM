package com.example.CRM.Repository;

import com.example.CRM.Entity.Company;
import com.example.CRM.Entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByEmail(String email);
    List<Company> findByName(String name);
}
