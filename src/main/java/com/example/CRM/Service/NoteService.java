package com.example.CRM.Service;

import com.example.CRM.Entity.Note;
import com.example.CRM.Repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
    }

    public Page<Note> getAllNotes(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    @Transactional
    public Note updateNote(Long id, Note updatedNote) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
        note.setContact(updatedNote.getContact());
        note.setDeal(updatedNote.getDeal());
        note.setContact(updatedNote.getContact());
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}