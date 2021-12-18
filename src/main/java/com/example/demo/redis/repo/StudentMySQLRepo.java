package com.example.demo.redis.repo;

import com.example.demo.redis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMySQLRepo extends JpaRepository<Student, String> {

    public Student findStudentById(String id);

}
