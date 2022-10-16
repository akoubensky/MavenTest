package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "STAFF",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Staff {
    private Integer id;
    private String name;
    private String firstName;
    private Integer salary;
    private Integer chief;
    private Integer department;
    private Integer position;

    public Staff() {
    }

    public Staff(Integer id, String name, String firstName, int salary) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.salary = salary;
    }

    @Id
    @Column(name="ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="NAME", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="FIRSTNAME", length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "SALARY")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Column(name = "CHIEF")
    public Integer getChief() {
        return chief;
    }

    public void setChief(Integer chief) {
        this.chief = chief;
    }

    @Column(name = "DEPARTMENT")
    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    @Column(name="POSITION")
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
