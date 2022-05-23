package com.karim.assessment.controllers;

import com.karim.assessment.models.Course;
import com.karim.assessment.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {
    @Autowired
    private CourseService courseService;


    @GetMapping("courses")
    public List<Course> getAllCourse()
    {
        return courseService.getAll();
    }
    @PostMapping("course")
    public ResponseEntity addCourse(@RequestBody Course course)
    {
        Course course1= courseService.add(course);
        if (course1!=null)
        {
            return ResponseEntity.ok("Course has been added successfully");
        }
        return ResponseEntity.ok("Course was not added");
    }
    @PutMapping( "course")
    public ResponseEntity updateCourse(@RequestBody Course course)
    {
        return courseService.update(course);
    }
    @DeleteMapping( "course")
    public ResponseEntity deleteCourse(Long id)
    {
        return courseService.delete(id);
    }
    @GetMapping("course")
    public Course getCourseById(Long id)
    {
        return courseService.getById(id);
    }
}
