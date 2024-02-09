/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.service.impl;

import br.com.springbootrestapi.payload.PostDto;
import br.com.springbootrestapi.entity.Post;
import br.com.springbootrestapi.exception.ResourceNotFoundException;
import br.com.springbootrestapi.payload.PostResponse;
import br.com.springbootrestapi.repository.PostRepository;
import br.com.springbootrestapi.service.PostService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;
    
    private ModelMapper model;
    
    public PostServiceImpl(PostRepository postRepository, ModelMapper model) {
        this.postRepository = postRepository;
        this.model = model;
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
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        
        Pageable pegeable = PageRequest.of(pageNo, pageSize, sort);
        
        Page<Post> posts = postRepository.findAll(pegeable);
        
        List<Post> listOfPosts = posts.getContent();
        
        List<PostDto> content = listOfPosts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());
        
        return postResponse;
    }
    
    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }
    
    private PostDto mapToDto(Post post) {
        PostDto postDto = model.map(post, PostDto.class);
//        PostDto postDto = new PostDto();
//        postDto.setId(post.getId());
//        postDto.setTitle(post.getTitle());
//        postDto.setDescription(post.getDescription());
//        postDto.setContent(post.getContent());
        return postDto;
    }
    
    private Post mapToEntity(PostDto postDto) {
        Post post = model.map(postDto, Post.class);
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
        return post;
    }
}
