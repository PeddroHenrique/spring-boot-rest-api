/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author Pedro
 */
@Data
public class PostDto {
    private Long id;
    
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;
    
    @NotEmpty
    @Size(min = 10, message = "post discription should have at least 10 characters")
    private String description;
    
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}
