package com.football.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.football.football.entity.Equipe;
import com.football.football.entity.Match;
import com.football.football.entity.Stade;
import com.football.football.service.MatchService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/matches")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    @GetMapping("/date/{date}")
    public List<Match> getMatchesByDate(@PathVariable LocalDate date) {
        return matchService.getMatchesByDate(date);
    }

    @GetMapping("/{id}/stade")
    public Stade getStadeByMatchId(@PathVariable Long id) {
        return matchService.getStadeByMatchId(id);
    }

    @PostMapping
    public Match createMatch(@RequestBody Match match) {
        return matchService.createMatch(match);
    }

    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable Long id, @RequestBody Match match) {
        return matchService.updateMatch(id, match);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
    }

    @GetMapping("/2021-02-28")
    public List<Match> getMatchesScheduledOnDate() {
        LocalDate date = LocalDate.parse("2021-02-28");
        return matchService.getMatchesByDate(date);
    }

    @GetMapping("/{id}/equipes")
    public Set<Equipe> getTeamsByMatchId(@PathVariable Long id) {
        return matchService.getTeamsByMatchId(id);
    }

    @DeleteMapping("/past")
    public void deletePastMatches() {
        matchService.deletePastMatches();
    }
}

