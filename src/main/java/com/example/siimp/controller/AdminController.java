package com.example.siimp.controller;

import com.example.siimp.model.Note;
import com.example.siimp.model.User;
import com.example.siimp.repository.NoteRepository;
import com.example.siimp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    @GetMapping("/hello")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Hello Admin 👑");
    }

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteRepository.findAll());
    }
}
