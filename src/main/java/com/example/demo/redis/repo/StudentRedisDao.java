package com.example.demo.redis.repo;

import com.example.demo.redis.model.Student;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class StudentRedisDao {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    //向Redis缓存里保存Student数据
    public void saveStudent(String id, int expireTime, Student student){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(id, gson.toJson(student), expireTime, TimeUnit.SECONDS);
    }
    //从Redis缓存里根据id查找Student数据
    public Student findByID(String id){
        Gson gson = new Gson();
        Student student = null;
        String studentJson = redisTemplate.opsForValue().get(id);
        if(studentJson != null && !studentJson.equals("")){
            student =  gson.fromJson(studentJson, Student.class);
        }
        return student;
    }
    //从Redis里删除指定id的Student数据
    public void deleteByID(String id){
        redisTemplate.opsForValue().getOperations().delete(id);
    }
}
