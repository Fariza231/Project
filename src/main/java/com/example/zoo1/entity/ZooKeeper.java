package com.example.zoo1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "zookeepers", schema = "public")
public class ZooKeeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private int experience;

    @ManyToOne
    @JoinColumn(name = "zoo_id", nullable = false)
    private Zoo zoo;

    public ZooKeeper() {}

    public ZooKeeper(String name, int age, int experience, Zoo zoo) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.zoo = zoo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
