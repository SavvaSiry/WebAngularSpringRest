package com.example.web_angular_spring_rest.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "order_spice")
public class OrderSpice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonView(View.OrderSpice.class)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clan_id")
    @JsonView(View.OrderSpice.class)
    private Clan clan;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer", nullable = false)
    @JsonView(View.OrderSpice.class)
    private Clan clan2;

    @Column(name = "status", nullable = false)
    @JsonView(View.OrderSpice.class)
    private String status;

    @Column(name = "weight")
    @JsonView(View.OrderSpice.class)
    private BigDecimal weight;

    @Column(name = "date", nullable = false)
    @JsonView(View.OrderSpice.class)
    private Instant date;

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Clan getClan2() {
        return clan2;
    }

    public void setClan2(Clan clan2) {
        this.clan2 = clan2;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}