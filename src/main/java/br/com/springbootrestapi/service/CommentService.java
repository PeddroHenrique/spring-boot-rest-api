/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.springbootrestapi.service;

import br.com.springbootrestapi.payload.CommentDto;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    CommentDto updateComment(CommentDto commentDto, long postId, long commentId);
    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(long postId, long commentId);
    void deleteComment(long postId, long commentId);
}
