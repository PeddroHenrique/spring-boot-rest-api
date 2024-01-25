/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.controller;

import br.com.springbootrestapi.bean.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pedro
 */
@RestController
public class StudentController {
    
    @GetMapping("/getStudent")
    public Student getStudent(
            @RequestParam(defaultValue = "") String firstName,
            @RequestParam(defaultValue = "") String lastName) {
        Student student = new Student(
        1,
        firstName.substring(0, 1).toUpperCase() + firstName.substring(1),
        lastName.substring(0, 1).toUpperCase() + lastName.substring(1));
        
        return student;
    }
    
    //return a json with list
    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList();
        students.add(new Student(1, "Pedro", "Santos"));
        students.add(new Student(2, "Leonardo", "Mendes"));
        students.add(new Student(3, "Joaquim", "blabla"));
        
        return students;
    }
    
    //Path Variable
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(
            @PathVariable(name = "id") int studentId,
            @PathVariable(name = "first-name") String firstName,
            @PathVariable(name = "last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }
    
    //Request param
    @GetMapping("students/query")
    public Student studentRequestParam(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName) {
        return new Student(id, firstName, lastName);
    }
    
    //@PostMapping and @RequestBody
    @PostMapping("/students/create")
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
}
