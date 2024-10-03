package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.Role;
import org.example.bai_tap_1.model.User;
import org.example.bai_tap_1.repository.RollRepository;
import org.example.bai_tap_1.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final UserRepository userRepository;
    private final RollRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private RegisterService(UserRepository userRepository, RollRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be null or empty");
        }
        User newUser = userRepository.save(user);
        Role role = new Role();
        role.setUser(newUser);
        role.setRole("User");
        roleRepository.save(role);
    }
}
