package com.example.siimp.repository;

import com.example.siimp.model.Note;
import com.example.siimp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUser(User user);
    Page<Note> findByUserAndTitleContainingIgnoreCaseOrUserAndContentContainingIgnoreCase(
            User user1, String title,
            User user2, String content,
            Pageable pageable
    );
}
