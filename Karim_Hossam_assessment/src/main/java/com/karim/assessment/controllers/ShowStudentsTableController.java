package com.karim.assessment.controllers;

import com.karim.assessment.models.Student;
import com.karim.assessment.repository.StudentsRepo;
import com.karim.assessment.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ShowStudentsTableController {
@Autowired
    private StudentService studentService;
    @GetMapping("/")
    public String showStudents(Model model)
    {
        model.addAttribute("students",studentService.getAll());
        return "index";
    }
}
