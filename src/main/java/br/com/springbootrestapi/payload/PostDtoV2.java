/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author Pedro
 */
@Data
@Schema(
        description = "PostDtoV2 Model Information"
)
public class PostDtoV2 {
    
    @Schema(
        description = "Blog Post unique identifier number"
    )
    private Long id;
    
    @Schema(
            description = "Blog Post Title"
    )
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;
    
    @Schema(
            description = "Blog Post Description"
    )
    @NotEmpty
    @Size(min = 10, message = "post discription should have at least 10 characters")
    private String description;
    
    @Schema(
            description = "Blog Post Content"
    )
    @NotEmpty
    private String content;
    
    @Schema(
            description = "Blog Post all comments"
    )
    private Set<CommentDto> comments;
    
    @Schema(
            description = "Blog Post Category"
    )
    private Long categoryId;
    
    @Schema(
            description = "Blog Post Tags"
    )
    private List<String> tags;
}

