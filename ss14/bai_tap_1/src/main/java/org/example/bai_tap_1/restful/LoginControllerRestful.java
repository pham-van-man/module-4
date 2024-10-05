package org.example.bai_tap_1.restful;

import org.example.bai_tap_1.model.JwtResponse;
import org.example.bai_tap_1.model.User;
import org.example.bai_tap_1.service.UserInfoService;
import org.example.bai_tap_1.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginControllerRestful {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserInfoService userInfoService;

    public LoginControllerRestful(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                                  UserInfoService userInfoService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userInfoService = userInfoService;
    }

    //    @PostMapping("/login")
//    public ResponseEntity<JwtResponse> login(@RequestBody User user) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtil.generateTokenLogin(authentication);
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        User userInfo = userInfoService.findByEmail(user.getEmail());
//        return ResponseEntity.ok(new JwtResponse(jwt, userInfo.getEmail(), userDetails.getAuthorities()));
//    }
    @PostMapping("/api/login")
    public ResponseEntity<JwtResponse> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User userInfo = userInfoService.findByEmail(user.getEmail());
        return ResponseEntity.ok(new JwtResponse(jwt, userInfo.getEmail(), userDetails.getAuthorities()));
    }
}
