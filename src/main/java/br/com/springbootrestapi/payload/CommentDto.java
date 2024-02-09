/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.payload;

import lombok.Data;

/**
 *
 * @author Pedro
 */
@Data
public class CommentDto {

    private Long id;
    private String name;
    private String email;
    private String body;
}
