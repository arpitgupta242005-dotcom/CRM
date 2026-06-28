package com.example.CRM.Repository;

import com.example.CRM.Entity.Lead;
import com.example.CRM.Entity.LeadStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

    Optional<Lead> findByEmail(String email);
    List<Lead> findByStatus(LeadStatus status);
}