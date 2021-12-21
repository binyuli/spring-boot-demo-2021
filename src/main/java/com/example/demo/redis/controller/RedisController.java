package com.example.demo.redis.controller;

import com.example.demo.redis.model.Student;
import com.example.demo.redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    StudentService studentService;

    @PostMapping("/saveStudent")
    public void saveStudent() {
        Student newStudent = new Student();
        newStudent.setId("Student_001");
        newStudent.setName("Tim");
        newStudent.setScore("100");
        studentService.saveStudent(newStudent);
    }

    @GetMapping("/findByID/{id}")
    public Student findByID(@PathVariable String id) {
        return studentService.findByID(id);
    }

    @DeleteMapping("/deleteByID/{id}")
    public void deleteByID(@PathVariable String id) {
        studentService.deleteByID(id);
    }
}
