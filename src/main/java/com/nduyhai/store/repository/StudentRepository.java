package com.nduyhai.store.repository;

import com.nduyhai.store.entities.Student;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * View more information at https://github.com/spring-projects/spring-data-examples/tree/master/jpa/jpa21
 */
@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student, Integer> {

    //    @Query(name = "Student.callStoreGetStudent")
//    @Procedure
//    List<Student> callStoreGetStudent(@Param("id") Integer id);

    @Procedure(name = "Student.callStoreGetAllStudent")
    List<Student> callStoreGetAllStudent();

    List<Student> callNativeQueryGetAllStudentWithMapping();

    List<Student> callNativeQueryGetAllStudentWithConstruct();

    List<Student> callNativeQueryGetAllStudentWithResultClass();
}
