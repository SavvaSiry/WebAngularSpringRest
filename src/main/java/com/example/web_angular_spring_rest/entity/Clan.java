package com.example.web_angular_spring_rest.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Clan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonView(View.Clan.class)
    private String name;

    @OneToMany(mappedBy = "clan")
    private Set<SpiceStorage> spiceStorages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "seller")
    private Set<SpiceGood> spiceGoods = new LinkedHashSet<>();

    @OneToMany(mappedBy = "clan")
    private Set<OrderSpice> orderSpices = new LinkedHashSet<>();

    @OneToMany(mappedBy = "clan")
    private Set<Creature> creatures = new LinkedHashSet<>();

    @OneToMany(mappedBy = "clan")
    private Set<ClanPlace> clanPlaces = new LinkedHashSet<>();

    @OneToMany(mappedBy = "buyer")
    private Set<Purchase> purchases = new LinkedHashSet<>();

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Set<ClanPlace> getClanPlaces() {
        return clanPlaces;
    }

    public void setClanPlaces(Set<ClanPlace> clanPlaces) {
        this.clanPlaces = clanPlaces;
    }

    public Set<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(Set<Creature> creatures) {
        this.creatures = creatures;
    }

    public Set<OrderSpice> getOrderSpices() {
        return orderSpices;
    }

    public void setOrderSpices(Set<OrderSpice> orderSpices) {
        this.orderSpices = orderSpices;
    }

    public Set<SpiceGood> getSpiceGoods() {
        return spiceGoods;
    }

    public void setSpiceGoods(Set<SpiceGood> spiceGoods) {
        this.spiceGoods = spiceGoods;
    }

    public Set<SpiceStorage> getSpiceStorages() {
        return spiceStorages;
    }

    public void setSpiceStorages(Set<SpiceStorage> spiceStorages) {
        this.spiceStorages = spiceStorages;
    }

    public Clan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
