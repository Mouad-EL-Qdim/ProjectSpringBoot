package com.football.football.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.football.entity.Joueur;
import com.football.football.repository.JoueurRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class JoueurService {
    @Autowired
    private JoueurRepository joueurRepository;

    public List<Joueur> getAllPlayers() {
        return joueurRepository.findAll();
    }

    public Joueur getPlayerById(Long id) {
        Optional<Joueur> joueur=joueurRepository.findById(id);
        return joueur.isPresent()? joueur.get() : null;
    }

    public Joueur createPlayer(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public Joueur updatePlayer(Long id, Joueur joueur) {
        Joueur existingJoueur = joueurRepository.findById(id).orElse(null);

        if (existingJoueur != null) {
            existingJoueur.setNomJoueur(joueur.getNomJoueur());
            existingJoueur.setPoste(joueur.getPoste());
            return joueurRepository.save(existingJoueur);
        } else {
            throw new EntityNotFoundException("Le joueur avec l'ID " + id + " n'a pas été trouvé.");
        }
    }

    public void deletePlayer(Long id) {
        if (joueurRepository.existsById(id)) {
            joueurRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Le joueur avec l'ID " + id + " n'a pas été trouvé.");
        }
    }
}
