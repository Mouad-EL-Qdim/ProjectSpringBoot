package com.football.football.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.football.entity.Match;
import com.football.football.entity.Stade;
import com.football.football.repository.StadeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StadeService {
    @Autowired
    private StadeRepository stadeRepository;

    public List<Stade> getAllStadiums() {
        return stadeRepository.findAll();
    }

    public Stade getStadiumById(Long id) {
        Optional<Stade> stade=stadeRepository.findById(id);
        return stade.isPresent()? stade.get() : null;
    }

    public Stade createStadium(Stade stade) {
        return stadeRepository.save(stade);
    }

    public Stade updateStadium(Long id, Stade stade) {
        Stade existingStade = stadeRepository.findById(id).orElse(null);
        if(existingStade!=null){
            existingStade.setNomStade(stade.getNomStade());
            existingStade.setVille(stade.getVille());
            return stadeRepository.save(existingStade);
        }else{
            throw new EntityNotFoundException("le stade avec l'ID "+id+" n'est pas été trouvé");
        }
    }

    public void deleteStadium(Long id) {
        Stade existingStade = stadeRepository.findById(id).orElse(null);
        if(existingStade != null){
            for (Match matches : existingStade.getMatches()) {
                matches.setStade(null);
            }
            stadeRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("le stade avec l'ID "+id+" n'est pas été trouvé");
        }
    }
}
