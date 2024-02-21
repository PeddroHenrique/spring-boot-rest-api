/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.springbootrestapi.repository;

import br.com.springbootrestapi.entity.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Pedro
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
    
    Optional<Role> findByName(String name);
}
