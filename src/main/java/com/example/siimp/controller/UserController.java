package com.example.siimp.controller;
import com.example.siimp.model.User;
import com.example.siimp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/hello")
    public ResponseEntity<String> userHello() {
        return ResponseEntity.ok("Hello User ✨");
    }

    @PostMapping("/profile/upload")
    public ResponseEntity<String> uploadProfileImage(
            @AuthenticationPrincipal User user,
            @RequestParam("file") MultipartFile file) throws IOException {

        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path imagePath = Paths.get("uploads/profile/" + filename);
        Files.createDirectories(imagePath.getParent());
        Files.write(imagePath, file.getBytes());

        user.setProfileImageUrl("/uploads/profile/" + filename);
        userRepository.save(user);

        return ResponseEntity.ok("Profile image uploaded successfully!");
    }

    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getUserProfile(@AuthenticationPrincipal User user) {
        Map<String, Object> profile = new HashMap<>();
        profile.put("username", user.getUsername());
        profile.put("bio", user.getBio());
        profile.put("profileImage", user.getProfileImageUrl());

        return ResponseEntity.ok(profile);
    }

    @PutMapping("/profile")
    public ResponseEntity<String> updateBio(
            @AuthenticationPrincipal User user,
            @RequestBody Map<String, String> body) {

        user.setBio(body.get("bio"));
        userRepository.save(user);
        return ResponseEntity.ok("Bio updated!");
    }
}
