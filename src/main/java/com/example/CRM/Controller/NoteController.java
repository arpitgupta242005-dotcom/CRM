package com.example.CRM.Controller;

import com.example.CRM.Entity.Note;
import com.example.CRM.Service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteservice;
    @GetMapping("/{id}")
    public ResponseEntity<Note> getAllById(@PathVariable Long id){
        return ResponseEntity.ok(noteservice.getNoteById(id));
    }
    @GetMapping
    public ResponseEntity<Page<Note>> getAllNotes(Pageable pageable){
        return ResponseEntity.ok(noteservice.getAllNotes(pageable));
    }
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return ResponseEntity.ok(noteservice.addNote(note));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNoteById(@PathVariable Long id){
        noteservice.deleteNote(id);
        return ResponseEntity.ok("deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        return ResponseEntity.ok(noteservice.updateNote(id, note));
    }
}
