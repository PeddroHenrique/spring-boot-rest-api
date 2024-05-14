/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Pedro
 */
@Data
@Schema(
        description = "CommentDto Model Information"
)
public class CommentDto {

    @Schema(
           description = "Blog Comment unique identifier number" 
    )
    private Long id;
    
    @Schema(
            description = "Blog Comment Name"
    )
    @NotEmpty(message = "Name should not bel null or empty")
    private String name;
    
    @Schema(
            description = "Blog Comment Email"
    )
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;
    
    @Schema(
            description = "Blog Comment Body"
    )
    @NotEmpty(message = "Body should not be null or empty")
    @Size(min = 10, message = "Body should not be null or empty")
    private String body;
}
