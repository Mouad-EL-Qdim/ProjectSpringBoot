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

import com.football.football.entity.Equipe;
import com.football.football.entity.Joueur;
import com.football.football.service.EquipeService;

@RestController
@RequestMapping("/teams")
public class EquipeController {
    @Autowired
    private EquipeService equipeService;

    @GetMapping
    public List<Equipe> getAllTeams() {
        return equipeService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Equipe getEquipeById(@PathVariable Long id) {
        return equipeService.getEquipeById(id);
    }

    @PostMapping
    public Equipe createEquipe(@RequestBody Equipe equipe) {
        return equipeService.createEquipe(equipe);
    }

    @PutMapping("/{id}")
    public Equipe updateEquipe(@PathVariable Long id, @RequestBody Equipe equipe) {
        return equipeService.updateEquipe(id, equipe);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipe(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
    }

    @GetMapping("/maroc")
    public List<Equipe> getTeamsFromMorocco() {
        return equipeService.getTeamsFromMorocco();
    }

    @GetMapping("/{nomEquipe}/joueurs")
    public List<Joueur> getPlayersByTeam(@PathVariable String nomEquipe) {
        return equipeService.getPlayersByTeam(nomEquipe);
    }

    @GetMapping("/{nomEquipe}/joueurs/attaquant")
    public List<Joueur> getAttackingPlayersByTeam(@PathVariable String nomEquipe) {
        return equipeService.getAttackingPlayersByTeam(nomEquipe);
    }
}
