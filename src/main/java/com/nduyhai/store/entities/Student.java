package com.nduyhai.store.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Student.callStoreGetStudent",
                procedureName = "get_student_with_id",
                resultSetMappings = {
                        "StudentMapper"
                },
                parameters = {
                        @StoredProcedureParameter(name = "id", mode = ParameterMode.IN, type = Integer.class)
                }),
        @NamedStoredProcedureQuery(
                name = "Student.callStoreGetAllStudent",
                procedureName = "get_all_student",
                resultClasses = {
                        Student.class ////Will try to map the returned columns to the entity properties based on their name and type
                })
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Student.callNativeQueryGetAllStudentWithConstruct",
                query = "SELECT * FROM student",
                resultSetMapping = "StudentMapper"
        ),
        @NamedNativeQuery(
                name = "Student.callNativeQueryGetAllStudentWithMapping",
                query = "SELECT * FROM student",
                resultSetMapping = "StudentMapperWithoutConstruct"
        ),
        @NamedNativeQuery(
                name = "Student.callNativeQueryGetAllStudentWithResultClass",
                query = "SELECT * FROM student",
                resultClass = Student.class //Will try to map the returned columns to the entity properties based on their name and type
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "StudentMapper",
                classes = {
                        @ConstructorResult(
                                targetClass = Student.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Integer.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "age", type = String.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "StudentMapperWithoutConstruct",
                entities = {
                        @EntityResult(
                                entityClass = Student.class //Will try to map the returned columns to the entity properties based on their name and type
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "StudentMapperWithoutConstruct2",
                entities = {
                        @EntityResult(
                                entityClass = Student.class,
                                fields = {
                                        @FieldResult(name = "id", column = "id"),
                                        @FieldResult(name = "name", column = "name"),
                                        @FieldResult(name = "age", column = "age")
                                }
                        )
                }
        )
})
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String age;

    /**
     * This method need for @Entity
     */
    public Student() {
    }

    /**
     * This method need for use @ConstructorResult
     *
     * @param id
     * @param name
     * @param age
     */
    public Student(Integer id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
