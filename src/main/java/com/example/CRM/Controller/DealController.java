package com.example.CRM.Controller;

import com.example.CRM.Entity.Deal;
import com.example.CRM.Service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deals")
@RequiredArgsConstructor
public class DealController {
    private final DealService dealservice;
    @GetMapping("/{id}")
    public ResponseEntity<Deal> getAllById(@PathVariable Long id){
        return ResponseEntity.ok(dealservice.getDealById(id));
    }
    @GetMapping
    public ResponseEntity<Page<Deal>> getAllDeals(Pageable pageable){
        return ResponseEntity.ok(dealservice.getAllDeals(pageable));
    }
    @PostMapping
    public ResponseEntity<Deal> addDeal(@RequestBody Deal deal){
        return ResponseEntity.ok(dealservice.addDeal(deal));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDealById(@PathVariable Long id){
        dealservice.deleteDeal(id);
        return ResponseEntity.ok("deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Deal> updateDeal(@PathVariable Long id, @RequestBody Deal deal) {
        return ResponseEntity.ok(dealservice.updateDeal(id, deal));
    }
}
