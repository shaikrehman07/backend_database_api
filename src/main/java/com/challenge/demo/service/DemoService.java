package com.challenge.demo.service;

import com.challenge.demo.model.User;
import com.challenge.demo.repository.DemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    @Autowired
    private DemoRepo demoRepo;

    public List<String> getSectors(){
        List<String> result = demoRepo.getAllSectors();
        return result;
    }

    public boolean insertUser(User user){
        boolean result = demoRepo.insertUser(user);
        return result;
    }

    public List<String> getUser(String name){
        List<String> result = demoRepo.getUser(name);
        return result;
    }

    public boolean updateUser(User user, String name){
        boolean result = demoRepo.updateUser(user, name);
        return result;
    }
}
