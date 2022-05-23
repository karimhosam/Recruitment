package com.karim.assessment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.karim.assessment.controllers.StudentsController;
import com.karim.assessment.models.Student;
import com.karim.assessment.repository.StudentsRepo;
import com.karim.assessment.services.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.accept;

@RunWith(MockitoJUnitRunner.class)
    public class StudentControllerTest {
    private MockMvc mockMvc;
    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();
    @Mock
        private StudentService studentService;
    @InjectMocks
        private StudentsController studentsController;
    @Before
        public void setUP()
    {
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(studentsController).build();
    }
    Student student1=new Student(1L,"karim",23);
    Student student2=new Student(2L,"omar",20);
    Student student3=new Student(3L,"hossam",30);
@Test
        public void getAllStudentsSuccess() throws Exception
{
    List<Student> students=new ArrayList<>(Arrays.asList(student1,student2,student3));
    Mockito.when(studentService.getAll()).thenReturn(students);
    mockMvc.perform(MockMvcRequestBuilders.get("/students").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3))).andExpect(jsonPath("$[2].name",is("hossam")));
}
    @Test
    public void getStudentSuccess() throws Exception
    {
        Student student=student3;
        Mockito.when(studentService.getById(1L)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.get("/student?id=1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is("hossam")));
    }
    @Test
    public void addStudentSuccess() throws Exception
    {
        Student student=new Student(4L,"karim",16);
        Mockito.when(studentService.add(student)).thenReturn(student);
        String content= objectWriter.writeValueAsString(student);
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }
}
