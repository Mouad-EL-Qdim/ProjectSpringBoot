package com.football.football.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.football.entity.Equipe;
import com.football.football.entity.Match;
import com.football.football.entity.Stade;
import com.football.football.repository.MatchRepository;

import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        Optional<Match> match=matchRepository.findById(id);
        return match.isPresent()? match.get() : null;
    }

    public List<Match> getMatchesByDate(LocalDate dateMatch) {
        return matchRepository.findByDateMatch(dateMatch);
    }

    public Stade getStadeByMatchId(Long matchId) {
        Match match = matchRepository.findById(matchId).orElse(null);
        if (match != null) {
            return match.getStade();
        }
        return null;
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(Long id, Match updatedMatch) {
        Match existingMatch = matchRepository.findById(id).orElse(null);
        if (existingMatch != null) {
            existingMatch.setDateMatch(updatedMatch.getDateMatch());
            existingMatch.setHeureMatch(updatedMatch.getHeureMatch());
            existingMatch.setArbitre(updatedMatch.getArbitre());
            return matchRepository.save(existingMatch);
        } else {
            throw new EntityNotFoundException("Le match avec l'ID " + id + " n'a pas été trouvé.");
        }
    }

    public void deleteMatch(Long id) {
        if (matchRepository.existsById(id)) {
            matchRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Le match avec l'ID " + id + " n'a pas été trouvé.");
        }
    }

    public Set<Equipe> getTeamsByMatchId(Long id) {
        Match match= getMatchById(id);
        return match != null ? match.getEquipes() : Collections.emptySet();
    }

    public void deletePastMatches() {
        LocalDate currentDate= LocalDate.now();
        List<Match> pastMatches = matchRepository.findByDateMatchBefore(currentDate);
        matchRepository.deleteAll(pastMatches);
    }
}
