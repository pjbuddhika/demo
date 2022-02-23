package com.example.demo.commandine;

import com.example.demo.data.Student;
import com.example.demo.repository.StudentRepository;
import com.google.common.collect.ImmutableList;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration
{
  @Bean
  CommandLineRunner CommandLineRunner(StudentRepository studentRepository)
  {
    return args -> {
      Student student1 = new Student();
      Student student2 = new Student();

      student1.setName("Emil Nilson");
      student1.setEmail("email@gmail.com");
      student1.setBirthDate(LocalDate.of(2000, Month.MARCH, 20));

      student2.setName("Samadhi Kalpana");
      student2.setEmail("samadhi@gmail.com");
      student2.setBirthDate(LocalDate.of(1990, Month.SEPTEMBER, 11));

      studentRepository.saveAll(ImmutableList.of(student1, student2));
    };
  }
}
