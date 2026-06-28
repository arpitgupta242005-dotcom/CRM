package com.example.CRM.Controller;

import com.example.CRM.Entity.Contact;
import com.example.CRM.Entity.Lead;
import com.example.CRM.Service.ContactService;
import com.example.CRM.Service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactservice;
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getAllById(@PathVariable Long id){
        return ResponseEntity.ok(contactservice.getContactById(id));
    }
    @GetMapping
    public ResponseEntity<Page<Contact>> getAllContacts(Pageable pageable){
        return ResponseEntity.ok(contactservice.getAllContacts(pageable));
    }
    @PostMapping
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        return ResponseEntity.ok(contactservice.addContact(contact));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContactById(@PathVariable Long id){
        contactservice.deleteContact(id);
        return ResponseEntity.ok("deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        return ResponseEntity.ok(contactservice.updateContact(id, contact));
    }

}
