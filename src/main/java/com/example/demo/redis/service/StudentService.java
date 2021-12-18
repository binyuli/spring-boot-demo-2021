package com.example.demo.redis.service;

import com.example.demo.redis.model.Student;
import com.example.demo.redis.repo.StudentMySQLRepo;
import com.example.demo.redis.repo.StudentRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StudentService {
    @Autowired
    private StudentRedisDao studentRedisDao;
    @Autowired
    private StudentMySQLRepo studentMySQLRepo;

    public void saveStudent(Student student){
        //在插入和更新前，删除缓存中的数据
        studentRedisDao.deleteByID(student.getId());
        //更新后暂时不放入缓存，待读取时再放入
        studentMySQLRepo.save(student);
    }

    public Student findByID(String id){
        Student empStudent = new Student();
        empStudent.setId("emptyID");

        Random rand = new Random();
        Student student = studentRedisDao.findByID(id);
        if (student != null) {
            System.out.println("Get Student From Redis");
            //如果Redis有真实数据则返回
            if (!student.getId().equals("emptyID")) {
                return student;
            } else {
                return null;
            }
        } else {
            System.out.println("Get Student From MySQL");
            student = studentMySQLRepo.findStudentById(id);
            int randNum = rand.nextInt(100);

            //如果在数据库存在则加入缓存, 否则缓存空数据, 防穿透
            if (student != null) {
                studentRedisDao.saveStudent(id, 24 * 60 * 60 + randNum, student);
            } else {
                studentRedisDao.saveStudent(id, 24 * 60 * 60 + randNum, empStudent);
            }
            return student;
        }
    }

    public void deleteByID(String id){
        studentRedisDao.deleteByID(id);
        studentMySQLRepo.deleteById(id);
    }
}
