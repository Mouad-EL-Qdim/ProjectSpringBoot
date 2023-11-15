package com.football.football.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.football.entity.Equipe;
import com.football.football.entity.Joueur;
import com.football.football.entity.Match;
import com.football.football.repository.EquipeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EquipeService {
    @Autowired
    private EquipeRepository equipeRepository;

    public List<Equipe> getAllTeams() {
        return equipeRepository.findAll();
    }

    public Equipe getEquipeById(Long id) {
        Optional<Equipe> equipe=equipeRepository.findById(id);
        return equipe.isPresent()? equipe.get() : null;
    }

    public Equipe createEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public Equipe updateEquipe(Long id, Equipe equipe) {
        Equipe existingEquipe = equipeRepository.findById(id).orElse(null);
        if(existingEquipe!=null){
            existingEquipe.setNomEquipe(equipe.getNomEquipe());
            existingEquipe.setPays(equipe.getPays());
            return equipeRepository.save(existingEquipe);
        }else{
            throw new EntityNotFoundException("l'equipe avec l'ID "+id+" n'est pas été trouvé");
        }
    }

    public void deleteEquipe(Long id) {
        Equipe equipe = equipeRepository.findById(id).orElse(null);
        if (equipe != null) {
            for (Match match : equipe.getMatches()) {
                match.getEquipes().remove(equipe);
            }

            for (Joueur joueur : equipe.getJoueurs()) {
                joueur.setEquipe(null);
            }

            equipeRepository.delete(equipe);
        } else {
            throw new EntityNotFoundException("L'équipe avec l'ID " + id + " n'a pas été trouvée");
        }
    }

    public List<Equipe> getTeamsFromMorocco() {
        return getAllTeams().stream()
        .filter(equipe->"Maroc".equals(equipe.getPays()))
        .collect(Collectors.toList());
    }

    public List<Joueur> getPlayersByTeam(String nomEquipe) {
        Equipe equipe = getAllTeams().stream()
        .filter(equipE->nomEquipe.equals(equipE.getNomEquipe()))
        .findFirst()
        .orElse(null);
        if (equipe != null) {
            return equipe.getJoueurs();
        }else{
            return Collections.emptyList();
        }
    }

    public List<Joueur> getAttackingPlayersByTeam(String nomEquipe) {
        return getPlayersByTeam(nomEquipe).stream()
        .filter(joueur->"attaquant".equals(joueur.getPoste()))
        .collect(Collectors.toList());
    }
}
