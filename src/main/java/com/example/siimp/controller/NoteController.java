package com.example.siimp.controller;


import com.example.siimp.model.Note;
import com.example.siimp.model.User;
import com.example.siimp.service.NoteService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor

public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<Page<Note>> getNotes(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(noteService.getNotes(user, keyword, page, size));
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@AuthenticationPrincipal User user, @RequestBody Note note) {
        return ResponseEntity.ok(noteService.createNote(user, note));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@AuthenticationPrincipal User user,
                                           @PathVariable Long id,
                                           @RequestBody Note note) {
        return ResponseEntity.ok(noteService.updateNote(user, id, note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@AuthenticationPrincipal User user,
                                           @PathVariable Long id) {
        noteService.deleteNote(user, id);
        return ResponseEntity.noContent().build();
    }
}
