package com.example.CRM.Service;

import com.example.CRM.Entity.Contact;
import com.example.CRM.Repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
    }

    public Page<Contact> getAllContacts(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Transactional
    public Contact updateContact(Long id, Contact updatedContact) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
        contact.setName(updatedContact.getName());
        contact.setEmail(updatedContact.getEmail());
        contact.setPhone(updatedContact.getPhone());
        contact.setJobTitle(updatedContact.getJobTitle());
        contact.setCompany(updatedContact.getCompany());
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}