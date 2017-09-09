package com.nduyhai.store.repository;

import com.nduyhai.store.repository.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
//    @Query(name = "Student.getStudentById")
    List<Student> getStudentById(String id);
}
