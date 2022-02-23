package com.example.demo.service;

import com.example.demo.data.Student;
import com.example.demo.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
  private StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository)
  {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents()
  {
    return studentRepository.findAll();
  }

  public void registerStudent(Student student)
  {
    if (hasEmailAlreadyAddedEmail(student))
    {
      throw new IllegalStateException("A Student with same email address is already added");
    }

    studentRepository.save(student);
  }

  private boolean hasEmailAlreadyAddedEmail(Student student)
  {
    Optional<Student> studentWithEmail = studentRepository.findByEmail(student.getEmail());
    return studentWithEmail.isPresent();
  }

  public void deleteStudent(Long id)
  {
    boolean studentExists = studentRepository.existsById(id);
    if (!studentExists)
    {
      throw new IllegalArgumentException( "Student with id: " + id + "exists");
    }

    studentRepository.deleteById(id);
  }
}
