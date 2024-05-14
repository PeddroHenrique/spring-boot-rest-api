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
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Object with the token information the will be sent along with the login response"
)
public class JWTAuthResponse {
    
    @Schema(
            description = "JWT String token"
    )
    private String accesseToken;
    
    @Schema(
            description = "Token type"
    )
    private String tokenType = "Bearer";
}
