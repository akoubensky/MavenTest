package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "POSITIONS",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Positions {
    private Integer id;
    private String name;
    private Integer lowerSalary;
    private Integer higherSalary;

    public Positions() {
    }

    public Positions(Integer id, String name, Integer lowerSalary, Integer higherSalary) {
        this.id = id;
        this.name = name;
        this.lowerSalary = lowerSalary;
        this.higherSalary = higherSalary;
    }

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "LOWERSALARY")
    public Integer getLowerSalary() {
        return lowerSalary;
    }

    public void setLowerSalary(Integer lowerSalary) {
        this.lowerSalary = lowerSalary;
    }

    @Column(name = "HIGHERSALARY")
    public Integer getHigherSalary() {
        return higherSalary;
    }

    public void setHigherSalary(Integer higherSalary) {
        this.higherSalary = higherSalary;
    }
}
