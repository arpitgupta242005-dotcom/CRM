package com.example.CRM.Repository;

import com.example.CRM.Entity.Company;
import com.example.CRM.Entity.Deal;
import com.example.CRM.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByDeal(Deal deal);
}