package com.example.CRM.Repository;

import com.example.CRM.Entity.Company;
import com.example.CRM.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> findByEmail(String email);
    List<Contact> findByCompany(Company company);
}
