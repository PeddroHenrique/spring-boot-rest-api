/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.springbootrestapi.repository;

import br.com.springbootrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Pedro
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    
}
