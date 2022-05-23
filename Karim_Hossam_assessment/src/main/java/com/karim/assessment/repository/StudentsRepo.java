package com.karim.assessment.repository;

import com.karim.assessment.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentsRepo extends JpaRepository<Student,Long> {
}
