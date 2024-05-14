/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Pedro
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "LoginDto Model Information"
)
public class LoginDto {
    
    @Schema(
            description = "Blog Login username or email field"
    )
    private String usernameOrEmail;
    
    @Schema(
            description = "Blog Login password field"
    )
    private String password;
}
