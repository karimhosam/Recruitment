package com.karim.assessment.services;

import com.karim.assessment.models.Course;
import com.karim.assessment.models.Course;
import com.karim.assessment.repository.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseService {
    @Autowired
    private CoursesRepo coursesRepo;
    public List<Course> getAll()
    {
        return coursesRepo.findAll();
    }
    public Course add(Course course)
    {
        course.setId(null);
        return coursesRepo.save(course);
    }
    public ResponseEntity update(Course newCourse)
    {
        Course course=getById(newCourse.getId());
        if(course!=null)
        {
            coursesRepo.save(course);
            return ResponseEntity.ok("Updated Successfully");
        }
        return ResponseEntity.ok("There is no Course with this id");

    }
    public Course getById(Long id)
    {
        Optional<Course> optional=coursesRepo.findById(id);
        if(optional.isPresent())
            return optional.get();
        return null;
    }
    public ResponseEntity delete(Long Id)
    {
        Course course=getById(Id);
        if(course!=null)
        {
            coursesRepo.delete(course);
            return ResponseEntity.ok("Deleted Successfully");
        }
        return ResponseEntity.ok("There is no Course with this id");
    }
}
