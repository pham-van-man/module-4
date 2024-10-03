package org.example.bai_tap_1.service;

import org.example.bai_tap_1.DTO.UserInfo;
import org.example.bai_tap_1.model.Role;
import org.example.bai_tap_1.model.User;
import org.example.bai_tap_1.repository.RollRepository;
import org.example.bai_tap_1.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RollRepository rollRepository;

    public UserInfoService(UserRepository userRepository, RollRepository rollRepository) {
        this.userRepository = userRepository;
        this.rollRepository = rollRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<Role> userRole = rollRepository.findByUser(user);
        return new UserInfo(user, userRole);
    }
}
