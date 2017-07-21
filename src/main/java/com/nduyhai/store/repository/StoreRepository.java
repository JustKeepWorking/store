package com.nduyhai.store.repository;

import com.nduyhai.store.repository.entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nduyhai
 */
@Repository
public class StoreRepository {

    @Autowired
    @Qualifier(value = "storeManagerFactory")
    private EntityManagerFactory factory;

    public List<Customer> getCustomer() {
        EntityManager entityManager = factory.createEntityManager();
        StoredProcedureQuery findCustomer= entityManager.createNamedStoredProcedureQuery("findFakeCustomer");
        StoredProcedureQuery storedProcedure = findCustomer.setParameter("id", 1);
        storedProcedure.getResultList().forEach((i) -> {
            System.out.println(i);
        });
        return storedProcedure.getResultList();
    }
    
    public List<Customer> getFakeCustomer() {
        EntityManager entityManager = factory.createEntityManager();
        StoredProcedureQuery storedProcedure= entityManager.createStoredProcedureQuery("getFakeCustomer")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .setParameter("id", 1);
        storedProcedure.getResultList().forEach((i) -> {
            System.out.println(i);
        });
        return storedProcedure.getResultList();
    }
}
