package com.example.CRM.Repository;

import com.example.CRM.Entity.Company;
import com.example.CRM.Entity.Deal;
import com.example.CRM.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDeal(Deal deal);
    List<Task> findByCompleted(Boolean completed);
}