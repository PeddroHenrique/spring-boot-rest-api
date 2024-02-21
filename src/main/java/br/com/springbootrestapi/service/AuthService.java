/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.springbootrestapi.service;

import br.com.springbootrestapi.payload.LoginDto;
import br.com.springbootrestapi.payload.RegisterDto;

/**
 *
 * @author Pedro
 */
public interface AuthService {
    String login(LoginDto loginDto);
    
    String register(RegisterDto registerDto);
}
