package com.nduyhai.store.controller;

import com.nduyhai.store.repository.StudentRepository;
import com.nduyhai.store.entities.Student;
import com.nduyhai.store.repository.StudentStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentController {
    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentStoreRepository storeRepository;

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public List<Student> getStudent(@PathVariable("id") Integer id) {
        return repository.callStoreGetStudent(id);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getAllStudent() {
        return storeRepository.callStoreGetAllStudent();
    }


    @RequestMapping(value = "/student1", method = RequestMethod.GET)
    public List<Student> getAllStudent1() {
        return repository.callNativeQueryGetAllStudentWithMapping();
    }

    @RequestMapping(value = "/student2", method = RequestMethod.GET)
    public List<Student> getAllStudent2() {
        return repository.callNativeQueryGetAllStudentWithConstruct();
    }

    @RequestMapping(value = "/student3", method = RequestMethod.GET)
    public List<Student> getAllStudent3() {
        return repository.callNativeQueryGetAllStudentWithResultClass();
    }
}
