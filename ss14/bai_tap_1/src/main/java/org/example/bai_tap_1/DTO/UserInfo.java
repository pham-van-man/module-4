package org.example.bai_tap_1.DTO;

import org.example.bai_tap_1.model.Role;
import org.example.bai_tap_1.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserInfo implements UserDetails {
    private final String email;
    private final String password;
    private final List<GrantedAuthority> authorities;

    public UserInfo(User User, List<Role> rolls) {
        email = User.getEmail();
        password = User.getPassword();
        authorities = new ArrayList<>();
        if (rolls != null) {
            for (Role roll : rolls) {
                GrantedAuthority authority = new SimpleGrantedAuthority(roll.getRole());
                authorities.add(authority);
            }
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
