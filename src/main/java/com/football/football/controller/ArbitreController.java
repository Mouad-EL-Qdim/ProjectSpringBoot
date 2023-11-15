package com.football.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.football.entity.Arbitre;
import com.football.football.service.ArbitreService;

@RestController
@RequestMapping("/referees")
public class ArbitreController {
    @Autowired
    private ArbitreService arbitreService;

    @GetMapping
    public List<Arbitre> getAllReferees() {
        return arbitreService.getAllReferees();
    }

    @GetMapping("/{id}")
    public Arbitre getArbitreById(@PathVariable Long id) {
        return arbitreService.getArbitreById(id);
    }

    @PostMapping
    public Arbitre createArbitre(@RequestBody Arbitre arbitre) {
        return arbitreService.createArbitre(arbitre);
    }

    @PutMapping("/{id}")
    public Arbitre updateArbitre(@PathVariable Long id, @RequestBody Arbitre arbitre) {
        return arbitreService.updateArbitre(id, arbitre);
    }

    @DeleteMapping("/{id}")
    public void deleteArbitre(@PathVariable Long id) {
        arbitreService.deleteArbitre(id);
    }
}
