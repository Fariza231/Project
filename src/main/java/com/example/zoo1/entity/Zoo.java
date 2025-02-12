package com.example.zoo1.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "zoos", schema = "public")
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ZooKeeper> zookeepers;

    public Zoo() {}

    public Zoo(String name, String location) {
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<ZooKeeper> getZookeepers() {
        return zookeepers;
    }

    public void setZookeepers(List<ZooKeeper> zookeepers) {
        this.zookeepers = zookeepers;
    }
}
