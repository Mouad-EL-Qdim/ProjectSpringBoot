package com.football.football.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.football.entity.Match;

public interface MatchRepository extends JpaRepository<Match, Long>{

    List<Match> findByDateMatch(LocalDate dateMatch);

    List<Match> findByDateMatchBefore(LocalDate currentDate);
    
}
