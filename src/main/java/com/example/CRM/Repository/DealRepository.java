package com.example.CRM.Repository;

import com.example.CRM.Entity.Company;
import com.example.CRM.Entity.Deal;
import com.example.CRM.Entity.DealStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

    List<Deal> findByStage(DealStage stage);
    List<Deal> findByCompany(Company company);
}
