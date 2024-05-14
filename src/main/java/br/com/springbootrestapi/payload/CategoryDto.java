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
        description = "CategoryDto Model Information"
)
public class CategoryDto {
    
    @Schema(
            description = "Blog Category unique identifier number"
    )
    private Long id;
    
    @Schema(
            description = "Blog Category name"
    )
    private String name;
    
    @Schema(
            description = "Blog Category description"
    )
    private String description;
}
