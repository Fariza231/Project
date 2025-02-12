package com.example.zoo1.service;

import com.example.zoo1.entity.ZooKeeper;
import com.example.zoo1.util.DatabaseConnection;

import java.sql.*;
        import java.util.ArrayList;
import java.util.List;

public class ZooKeeperService {
    public String addZooKeeper(ZooKeeper zooKeeper) {
        String query = "INSERT INTO zookeepers (name, age, experience, zoo_id) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, zooKeeper.getName());
            ps.setInt(2, zooKeeper.getAge());
            ps.setInt(3, zooKeeper.getExperience());
            ps.setInt(4, zooKeeper.getZoo().getId());
            ps.executeUpdate();
            return "ZooKeeper added successfully!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    public List<ZooKeeper> getAllZooKeepers() {
        String query = "SELECT * FROM zookeepers";
        List<ZooKeeper> zooKeepers = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ZooKeeper z = new ZooKeeper();
                z.setName(rs.getString("name"));
                z.setAge(rs.getInt("age"));
                z.setExperience(rs.getInt("experience"));
                zooKeepers.add(z);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zooKeepers;
    }

    public String updateZooKeeper(ZooKeeper zooKeeper) {
        String query = "UPDATE zookeepers SET age = ?, experience = ? WHERE name = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, zooKeeper.getAge());
            ps.setInt(2, zooKeeper.getExperience());
            ps.setString(3, zooKeeper.getName());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0 ? "ZooKeeper updated successfully!" : "ZooKeeper not found!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    public String deleteZooKeeper(String name) {
        String query = "DELETE FROM zookeepers WHERE name = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0 ? "ZooKeeper deleted successfully!" : "ZooKeeper not found!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }
}