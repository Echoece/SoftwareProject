package com.example.softwareproject.controller;


import com.example.softwareproject.entity.ApplicationUser;
import com.example.softwareproject.entity.DTO.UsernameAndPasswordAuthenticationRequest;
import com.example.softwareproject.repository.ApplicationUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final ApplicationUserRepository userRepository;

    @PostMapping("register")
    public ApplicationUser register(@RequestBody UsernameAndPasswordAuthenticationRequest authDTO){
        ApplicationUser user = ApplicationUser.builder()
                .email(authDTO.getUserName())
                .password(authDTO.getPassword())
                .build();
        return userRepository.save(user);

    }
}
