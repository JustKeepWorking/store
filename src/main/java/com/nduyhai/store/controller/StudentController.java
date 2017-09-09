package com.nduyhai.store.controller;

import com.nduyhai.store.repository.StudentRepository;
import com.nduyhai.store.repository.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class StudentController {
    @Autowired
    private StudentRepository repository;
    
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public List<Student> getCustomer(@PathVariable("id") String id) {
        return repository.getStudentById(id);
    }

}
