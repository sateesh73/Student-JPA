package io.demo.studentreguistration.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @OneToOne
    private Name name;
    @OneToMany
    private List<Address> address;
    @Past(message = "Date of Birth should be in Past")
    private LocalDate dob;
    @Size(min = 0, max = 10, message = "Mobile Number should be 10 digit")
    private String mobileNumber;

    public Student() {
    }

    public Student(@NotNull Name name, List<Address> address,
            @Past(message = "Date of Birth should be in Past") LocalDate dob,
            @Size(min = 0, max = 10, message = "Mobile Number should be 10 digit") String mobileNumber) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Student [address=" + address + ", dob=" + dob + ", id=" + id + ", mobileNumber=" + mobileNumber
                + ", name=" + name + "]";
    }

}
