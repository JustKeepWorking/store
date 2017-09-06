package com.nduyhai.store.repository.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
           name = "Customer.getCustomer"
            , procedureName = "getFakeCustomer"
            , resultSetMappings = {"customerResultMapping"}
            , parameters = {
                @StoredProcedureParameter(name = "id", mode = ParameterMode.IN, type = Integer.class)
            }

    )
})

@SqlResultSetMappings({
    @SqlResultSetMapping(
            name = "customerResultMapping"
            , entities = {
                @EntityResult(
                        entityClass = Customer.class
                        , fields = {
                            @FieldResult(name = "id", column = "id"),
                            @FieldResult(name = "name", column = "name"),
                            @FieldResult(name = "age", column = "age")
                        })
            }
    )
})
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
    

}
