/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.dto;

import lombok.Data;

/**
 *
 * @author Pedro
 */
@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;
}
