/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.controller;

import br.com.springbootrestapi.bean.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pedro
 */
@RestController
public class StudentController {

    @GetMapping("/getStudent")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Pedro",
                "Santos");

        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "Pedro")
                .body(student);
    }

    //return a json with list
    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList();
        students.add(new Student(1, "Pedro", "Santos"));
        students.add(new Student(2, "Leonardo", "Mendes"));
        students.add(new Student(3, "Joaquim", "blabla"));

        return ResponseEntity.ok(students);
    }

    //Path Variable
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(
            @PathVariable(name = "id") int studentId,
            @PathVariable(name = "first-name") String firstName,
            @PathVariable(name = "last-name") String lastName) {
        return ResponseEntity.ok(new Student(studentId, firstName, lastName));
    }

    //Request param
    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequestParam(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName) {
        return ResponseEntity.ok(new Student(id, firstName, lastName));
    }

    //@PostMapping and @RequestBody
    @PostMapping("/students/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //@PutRequest
    @PutMapping("/students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable(name = "id") int studentId) {
        List<Student> students = new ArrayList();
        students.add(new Student(1, "Pedro", "Santos"));
        students.add(new Student(2, "Ricardo", "Santos"));
        students.add(new Student(3, "Maria", "Aparecida"));
        for (Student studentList : students) {
            if (studentList.getId() == studentId) {
                System.out.println(studentList.getFirstName());
                System.out.println(studentList.getLastName());

                studentList.setFirstName(student.getFirstName());
                studentList.setLastName(student.getLastName());

                System.out.println(studentList.getFirstName());
                System.out.println(studentList.getLastName());
            }
        }
        return ResponseEntity.ok(student);
    }

    //@DeleteRequest
    @DeleteMapping("/students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") int studentId) {
        List<Student> students = new ArrayList();
        students.add(new Student(1, "Pedro", "Santos"));
        students.add(new Student(2, "Ricardo", "Santos"));
        students.add(new Student(3, "Maria", "Aparecida"));
        for (Student studentList : students) {
            if (studentList.getId() == studentId) {
                System.out.println(studentList.getFirstName());
                System.out.println(studentList.getLastName());
                
                studentList.setFirstName(null);
                studentList.setLastName(null);
                
                System.out.println(studentList.getFirstName());
                System.out.println(studentList.getLastName());
            }
        }
        return ResponseEntity.ok("deleted successfully");
    }
}
