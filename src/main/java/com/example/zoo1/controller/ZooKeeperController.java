package com.example.zoo1.controller;

import com.example.zoo1.entity.ZooKeeper;
import com.example.zoo1.service.ZooKeeperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zookeeper")
public class ZooKeeperController {
    private final ZooKeeperService service = new ZooKeeperService();

    @PostMapping("/add")
    public String addZooKeeper(@RequestBody ZooKeeper zooKeeper) {
        return service.addZooKeeper(zooKeeper);
    }

    @GetMapping("/all")
    public List<ZooKeeper> getAllZooKeepers() {
        return service.getAllZooKeepers();
    }

    @PutMapping("/update")
    public String updateZooKeeper(@RequestBody ZooKeeper zooKeeper) {
        return service.updateZooKeeper(zooKeeper);
    }

    @DeleteMapping("/delete/{name}")
    public String deleteZooKeeper(@PathVariable String name) {
        return service.deleteZooKeeper(name);
    }
}
