package com.example.web_angular_spring_rest.entity;

import javax.persistence.*;

@Entity
@Table(name = "spice_goods")
public class SpiceGood {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller")
    private Clan seller;

    public Clan getSeller() {
        return seller;
    }

    public void setSeller(Clan seller) {
        this.seller = seller;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}