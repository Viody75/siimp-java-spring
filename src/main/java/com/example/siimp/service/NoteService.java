package com.example.siimp.service;

import com.example.siimp.model.Note;
import com.example.siimp.model.User;
import com.example.siimp.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> getAllNotes(User user) {
        return noteRepository.findByUser(user);
    }

    public Page<Note> getNotes(User user, String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return noteRepository.findByUserAndTitleContainingIgnoreCaseOrUserAndContentContainingIgnoreCase(
                user, keyword, user, keyword, pageable
        );
    }

    public Note createNote(User user, Note note) {
        note.setUser(user);
        return noteRepository.save(note);
    }

    public Note updateNote(User user, Long id, Note updatedNote) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        if (!note.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Unauthorized");
        }
        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        return noteRepository.save(note);
    }

    public void deleteNote(User user, Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        if (!note.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Unauthorized");
        }
        noteRepository.delete(note);
    }
}
