package com.example.magicdoc.controllers;
import com.example.magicdoc.data.operations.Delta;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/hello")
public class HelloController {
    @PostMapping
    @RequestMapping("/say")
    public Delta hello(@RequestBody Delta delta) {
        System.out.println(delta);
        return delta;
    }
}
