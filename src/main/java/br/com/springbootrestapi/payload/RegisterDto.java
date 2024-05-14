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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "RegisterDto Model Information"
)
public class RegisterDto {
    
    @Schema(
            description = "Blog Register name"
    )
    private String name;
    
    @Schema(
            description = "Blog Register username"
    )
    private String username;
    
    @Schema(
            description = "Blog Register email"
    )
    private String email;
    
    @Schema(
            description = "Blog Register password"
    )
    private String password;
}