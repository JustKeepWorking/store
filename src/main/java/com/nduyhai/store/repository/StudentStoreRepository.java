package com.nduyhai.store.repository;

import com.nduyhai.store.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentStoreRepository {

    @Autowired
    private EntityManagerFactory factory;

    @Transactional
    public List<Student> callStoreGetAllStudent() {
        EntityManager manager = factory.createEntityManager();
        StoredProcedureQuery getAllStudent = manager.createNamedStoredProcedureQuery("Student.callStoreGetAllStudent");
        return getAllStudent.getResultList();
    }

//    public List<Student> callStoreGetStudent(Integer `) {
//        EntityManager manager = factory.createEntityManager();
//        StoredProcedureQuery getAllStudent = manager.createNamedStoredProcedureQuery("Student.callStoreGetStudent");
//        getAllStudent.setParameter("id", id);
//        return getAllStudent.getResultList();
//    }
}
