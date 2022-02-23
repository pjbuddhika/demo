package com.example.demo.controller;

import com.example.demo.data.Student;
import com.example.demo.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student", consumes = MediaType.APPLICATION_JSON_VALUE)
public class StudentController
{
  private StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService)
  {
    this.studentService = studentService;
  }

  @GetMapping(path = "/getstudent")
  public List<Student> getStudent()
  {
    return studentService.getStudents();
  }

  //pass the student data get from client request and pass it as a parameter to post method. since it took from Client request we annotated it as @RequestBody
  @PostMapping
  public void registerNewStudent(@RequestBody  Student student)
  {
    studentService.registerStudent(student);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long id)
  {
    studentService.deleteStudent(id);
  }

}
