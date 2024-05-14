/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.controller;

import br.com.springbootrestapi.payload.CommentDto;
import br.com.springbootrestapi.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pedro
 */
@RestController
@RequestMapping("/api/v1")
@Tag(
        name = "CRUD REST APIs for Comment Resource"
)
public class CommentController {
    
    private CommentService commentService;
    
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    
    @Operation(
            summary = "Create Comment REST API",
            description = "The Create Comment REST API is used to save a comment to the database."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                                    @Valid @RequestBody CommentDto commentDto) {
        
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }
    
    @Operation(
            summary = "Get All Comments REST API",
            description = "The Get All Comments REST API is used to retrieve all comments from the database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getAllComments(@PathVariable(value = "postId") long postId) {
        return commentService.getCommentsByPostId(postId);
    }
    
    @Operation(
            summary = "Get Comment REST API",
            description = "The Get Comment REST API is used to retrieve a single comment from the database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable(value = "postId") long postId, 
            @PathVariable(value = "commentId") long commentId) {
        return new ResponseEntity<>(commentService.getCommentById(postId, commentId), HttpStatus.OK);
    }
    
    @Operation(
            summary = "Update Comment REST API",
            description = "The Update Comment REST API is used to modify a particular comment from the database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(
            @Valid @RequestBody CommentDto commentDto,
            @PathVariable(value = "postId") long postId,
            @PathVariable(value = "commentId") long commentId) {
        return new ResponseEntity<>(commentService.updateComment(commentDto, postId, commentId), HttpStatus.OK);
    }
    
    @Operation(
            summary = "Delete Comment REST API",
            description = "The Delete Comment REST API is used to delete a particular comment from the database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable(value = "postId") long postId, 
            @PathVariable(value = "commentId") long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
