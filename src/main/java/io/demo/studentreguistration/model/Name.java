package io.demo.studentreguistration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class Name {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 2, message = "First name should be at Least 2 characters")
    private String fName;
    @Size(min = 2, message = "Last name should be at Least 2 characters")
    private String lName;

    @OneToOne
    private Student student;

    protected Name() {

    }

    public Name(@Size(min = 2, message = "First name should be at Least 2 characters") String fName,
            @Size(min = 2, message = "Last name should be at Least 2 characters") String lName, Student student) {
        this.fName = fName;
        this.lName = lName;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
