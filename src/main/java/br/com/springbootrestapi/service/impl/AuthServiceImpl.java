/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.service.impl;

import br.com.springbootrestapi.entity.Role;
import br.com.springbootrestapi.entity.User;
import br.com.springbootrestapi.exception.BlogAPIException;
import br.com.springbootrestapi.payload.LoginDto;
import br.com.springbootrestapi.payload.RegisterDto;
import br.com.springbootrestapi.repository.RoleRepository;
import br.com.springbootrestapi.repository.UserRepository;
import br.com.springbootrestapi.security.JwtTokenProvider;
import br.com.springbootrestapi.service.AuthService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class AuthServiceImpl implements AuthService{

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    
    public AuthServiceImpl(AuthenticationManager authenticationManager,
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder,
            JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    
    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginDto.getUsernameOrEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String token = jwtTokenProvider.generateToken(authentication);
        
        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {
        
        if (userRepository.existsByUsername(registerDto.getUsername())) {
                throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!");
        }
        
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!");
        }
        
        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        
        Set<Role> roles = new HashSet<>();
        if (user.getUsername().equals("admin")) {
            roles.add(roleRepository.findByName("ROLE_ADMIN").get());
        }
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRole(roles);
        
        userRepository.save(user);
        
        return "User registered successfully!";
    }
    
}
