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

import com.football.football.entity.Joueur;
import com.football.football.service.JoueurService;

@RestController
@RequestMapping("/players")
public class JoueurController {
    @Autowired
    private JoueurService joueurService;

    @GetMapping
    public List<Joueur> getAllPlayers() {
        return joueurService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Joueur getPlayerById(@PathVariable Long id){
        return joueurService.getPlayerById(id);
    }

    @PostMapping
    public Joueur createPlayer(@RequestBody Joueur joueur){
        return joueurService.createPlayer(joueur);
    }

    @PutMapping("/{id}")
    public Joueur updatePlayer(@PathVariable Long id, @RequestBody Joueur joueur){
        return joueurService.updatePlayer(id, joueur);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id){
        joueurService.deletePlayer(id);
    }
}
