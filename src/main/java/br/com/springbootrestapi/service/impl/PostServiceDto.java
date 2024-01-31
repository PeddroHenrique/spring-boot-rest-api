/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.service.impl;

import br.com.springbootrestapi.dto.PostDto;
import br.com.springbootrestapi.entity.Post;
import br.com.springbootrestapi.exception.ResourceNotFoundException;
import br.com.springbootrestapi.repository.PostRepository;
import br.com.springbootrestapi.service.PostService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class PostServiceDto implements PostService{

    private PostRepository postRepository;
    
    public PostServiceDto(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        
        Post newPost = postRepository.save(post);
        
        PostDto postResponse = mapToDto(newPost);
        
        return postResponse;
    }
    
    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        Post dbPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        dbPost.setTitle(postDto.getTitle());
        dbPost.setDescription(postDto.getDescription());
        dbPost.setContent(postDto.getContent());
        
        postRepository.save(dbPost);
        
        return mapToDto(dbPost);
        
    }
    
    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }
    
    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }
    
    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        
        return postDto;
    }
    
    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
