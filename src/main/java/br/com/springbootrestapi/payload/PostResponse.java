/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Pedro
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Carry all the informations about the Get All Posts response"
)
public class PostResponse {
    
    @Schema(
            description = "All posts"
    )
    private List<PostDto> content;
    
    @Schema(
            description = "Page number"
    )
    private int pageNo;
    
    @Schema(
            description = "Page size"
    )
    private int pageSize;
    
    @Schema(
            description = "Total posts of a page"
    )
    private long totalElements;
    
    @Schema(
            description = "Total pages"
    )
    private int totalPages;
    
    @Schema(
            description = "Inform if it is the last page"
    )
    private boolean last;
}
