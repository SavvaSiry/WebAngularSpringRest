package com.example.web_angular_spring_rest.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "technique")
public class Technique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "combat_strength")
    private BigDecimal combatStrength;

    @Column(name = "mining_rate")
    private BigDecimal miningRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private TechType techType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public TechType getTechType() {
        return techType;
    }

    public void setTechType(TechType techType) {
        this.techType = techType;
    }

    public BigDecimal getMiningRate() {
        return miningRate;
    }

    public void setMiningRate(BigDecimal miningRate) {
        this.miningRate = miningRate;
    }

    public BigDecimal getCombatStrength() {
        return combatStrength;
    }

    public void setCombatStrength(BigDecimal combatStrength) {
        this.combatStrength = combatStrength;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}