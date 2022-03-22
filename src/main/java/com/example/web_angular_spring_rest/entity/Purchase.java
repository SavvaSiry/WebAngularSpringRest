package com.example.web_angular_spring_rest.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer")
    private Clan buyer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item", nullable = false)
    private SpiceGood spiceGoods;

    @Column(name = "date")
    private Instant date;

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public SpiceGood getSpiceGoods() {
        return spiceGoods;
    }

    public void setSpiceGoods(SpiceGood spiceGoods) {
        this.spiceGoods = spiceGoods;
    }

    public Clan getBuyer() {
        return buyer;
    }

    public void setBuyer(Clan buyer) {
        this.buyer = buyer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}