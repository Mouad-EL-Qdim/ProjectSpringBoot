package com.football.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.football.entity.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long>{
    
}
