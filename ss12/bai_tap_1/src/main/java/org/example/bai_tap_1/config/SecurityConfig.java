package org.example.bai_tap_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers("/", "/home").permitAll()  // Cho phép các URL này không cần đăng nhập
                        .anyRequest().authenticated()  // Các URL khác yêu cầu xác thực
                )
                .formLogin((form) -> form
                        .loginPage("/login")  // Đường dẫn trang đăng nhập
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Sử dụng mã hóa mật khẩu
    }
}
