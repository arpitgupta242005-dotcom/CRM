package com.example.CRM.Service;

import com.example.CRM.Entity.Deal;
import com.example.CRM.Repository.DealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DealService {

    private final DealRepository dealRepository;

    public Deal getDealById(Long id) {
        return dealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deal not found with id: " + id));
    }

    public Page<Deal> getAllDeals(Pageable pageable) {
        return dealRepository.findAll(pageable);
    }

    public Deal addDeal(Deal deal) {
        return dealRepository.save(deal);
    }

    @Transactional
    public Deal updateDeal(Long id, Deal updatedDeal) {
        Deal deal = dealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deal not found with id: " + id));
        deal.setTitle(updatedDeal.getTitle());
        deal.setValue(updatedDeal.getValue());
        deal.setStage(updatedDeal.getStage());
        deal.setCompany(updatedDeal.getCompany());
        deal.setContact(updatedDeal.getContact());
        return dealRepository.save(deal);
    }

    public void deleteDeal(Long id) {
        dealRepository.deleteById(id);
    }
}