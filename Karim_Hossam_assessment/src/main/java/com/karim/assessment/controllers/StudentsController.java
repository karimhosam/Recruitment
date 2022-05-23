package com.karim.assessment.controllers;

import com.karim.assessment.models.Student;
import com.karim.assessment.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudent()
    {
        return studentService.getAll();
    }
    @PostMapping("/student")
    public ResponseEntity addStudent(@RequestBody Student student)
    {   Student student1= studentService.add(student);
        if(student1!=null)
        return ResponseEntity.ok("student added successfully");
        return ResponseEntity.ok("student was not added");
    }
    @PutMapping( "student")
    public ResponseEntity updateStudent(@RequestBody Student student)
    {
        return studentService.update(student);
    }
    @DeleteMapping( "student")
    public ResponseEntity deleteStudent(Long id)
    {
        return studentService.delete(id);
    }
    @GetMapping("student")
    public Student getStudentById(Long id)
    {
        return studentService.getById(id);
    }
}
