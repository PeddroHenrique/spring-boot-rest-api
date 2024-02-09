/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.springbootrestapi.service;

import br.com.springbootrestapi.payload.PostDto;
import br.com.springbootrestapi.payload.PostResponse;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto updatePost(PostDto postDto, Long id);
    void deletePost(Long id);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(Long id);
}
