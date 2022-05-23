package com.karim.assessment.repository;

import com.karim.assessment.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepo extends JpaRepository<Course,Long> {
}
