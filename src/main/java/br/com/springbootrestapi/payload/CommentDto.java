/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Pedro
 */
@Data
public class CommentDto {

    private Long id;
    
    @NotEmpty(message = "Name should not bel null or empty")
    private String name;
    
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;
    
    @NotEmpty(message = "Body should not be null or empty")
    @Size(min = 10, message = "Body should not be null or empty")
    private String body;
}
