package com.example.web_angular_spring_rest.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class Creature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Creature.class)
    private Long id;
    @JsonView(View.Creature.class)
    private String birthday;
    @JsonView(View.Creature.class)
    private String name;
    @JsonView(View.Creature.class)
    @ManyToOne(fetch = FetchType.LAZY)
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
