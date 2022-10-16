package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DEPARTMENT",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Department {
    private Integer id;
    private String name;
    private Integer director;

    public Department() {
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DIRECTOR")
    public Integer getDirector() {
        return director;
    }

    public void setDirector(Integer director) {
        this.director = director;
    }
}
