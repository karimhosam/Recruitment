package com.karim.assessment.services;

import com.karim.assessment.models.Student;
import com.karim.assessment.repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {

    @Autowired
    private StudentsRepo studentsRepo;
    public List<Student> getAll()
    {
        return studentsRepo.findAll();
    }
    public Student add(Student student)
    {
        student.setId(null);
        return studentsRepo.save(student);
    }
    public ResponseEntity update(Student newStudent)
    {
        Student student=getById(newStudent.getId());
        if(student!=null)
        {
            studentsRepo.save(student);
            return ResponseEntity.ok("Updated Successfully");
        }
        return ResponseEntity.ok("There is no Student with this id");

    }
    public Student getById(Long id)
    {
        Optional<Student> optional=studentsRepo.findById(id);
        if(optional.isPresent())
            return optional.get();
        return null;
    }
    public ResponseEntity delete(Long Id)
    {
        Student student=getById(Id);
        if(student!=null)
        {
            studentsRepo.delete(student);
            return ResponseEntity.ok("Deleted Successfully");
        }
        return ResponseEntity.ok("There is no Student with this id");
    }
}
