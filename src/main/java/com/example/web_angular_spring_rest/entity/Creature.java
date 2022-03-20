package com.example.web_angular_spring_rest.entity;

import javax.persistence.*;

@Entity
public class Creature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String birthday;
    private String name;
    @ManyToOne
    @JoinColumn(name="clan_id", nullable=false)
    private Clan clan;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
