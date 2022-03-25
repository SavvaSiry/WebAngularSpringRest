package com.example.web_angular_spring_rest.entity;

public class View {
    public interface Clan {}
    public interface Creature extends Clan {}
    public interface OrderSpice extends Clan { }
    public interface Mining extends Creature, OrderSpice, WorkerType, Clan {}
    public interface WorkerType { }
}
