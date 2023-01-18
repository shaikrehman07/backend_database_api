package com.challenge.demo.controller;

import com.challenge.demo.model.Sector;
import com.challenge.demo.model.User;
import com.challenge.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/sectors")
    public List<String> getSectors(){
        return demoService.getSectors();
    }

    @GetMapping("/user/{name}")
    public List<String> getUser(@PathVariable String name){
        return demoService.getUser(name);
    }

    @PostMapping("/user")
    public boolean insertUser(@RequestBody User user){
        return demoService.insertUser(user);
    }

    @PostMapping("/user/{name}")
    public boolean updateUser(@RequestBody User user, @PathVariable String name){
        return demoService.updateUser(user,name);
    }
}
