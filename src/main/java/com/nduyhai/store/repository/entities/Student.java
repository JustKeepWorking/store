package com.nduyhai.store.repository.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Student.getStudentById",
                procedureName = "get_all_student",
                resultSetMappings = {"StudentMapper"},
                parameters = {
                        @StoredProcedureParameter(name = "id", mode = ParameterMode.IN, type = String.class)
                })
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "StudentMapper",
                classes = {
                        @ConstructorResult(
                                targetClass = Student.class,
                                columns = {
                                        @ColumnResult(name = "id", type = String.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "id", type = String.class),
                                }
                        )
                }

        )
})
public class Student implements Serializable {
    @Id
//    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "age")
    private String age;

    public Student() {
    }

    public Student(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
