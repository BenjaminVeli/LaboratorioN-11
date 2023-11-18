package com.tecsup.petclinic.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "specialties")
@Data
public class Specialties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "office", nullable = false, length = 40)
    private String office;

    @Column(name = "h_open", length = 4)
    private Integer open;

    @Column(name = "h_close", length = 4)
    private Integer close;


    public Specialties() {
    }

    public Specialties(Integer id, String name , String office, Integer open, Integer close) {
        this.id = id;
        this.name = name;
        this.office = office;
        this.open = open;
        this.close = close;
    }

    public Specialties(String name , String office, Integer open, Integer close) {
        this.name = name;
        this.office = office;
        this.open = open;
        this.close = close;
    }
}