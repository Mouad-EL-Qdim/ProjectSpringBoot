package com.football.football.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.football.entity.Arbitre;
import com.football.football.entity.Match;
import com.football.football.repository.ArbitreRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ArbitreService {
    @Autowired
    private ArbitreRepository arbitreRepository;

    public List<Arbitre> getAllReferees() {
        return arbitreRepository.findAll();
    }

    public Arbitre getArbitreById(Long id) {
        Optional<Arbitre> arbitre=arbitreRepository.findById(id);
        return arbitre.isPresent()? arbitre.get() : null;
    }

    public Arbitre createArbitre(Arbitre arbitre) {
        return arbitreRepository.save(arbitre);
    }

    public Arbitre updateArbitre(Long id, Arbitre arbitre) {
        Arbitre existingArbitre = arbitreRepository.findById(id).orElse(null);
        if(existingArbitre!=null){
            existingArbitre.setNom(arbitre.getNom());
            existingArbitre.setNationalite(arbitre.getNationalite());
            return arbitreRepository.save(existingArbitre);
        }else{
            throw new EntityNotFoundException("l'arbitre avec l'ID "+id+" n'est pas été trouvé");
        }
    }

    public void deleteArbitre(Long id) {
        Arbitre existingArbitre = arbitreRepository.findById(id).orElse(null);
        if(existingArbitre != null){
            for (Match matches : existingArbitre.getMatches()) {
                matches.setArbitre(null);
            }
            arbitreRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("l'arbitre avec l'ID "+id+" n'est pas été trouvé");
        }
    }
}
