package com.football.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.football.entity.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long>{
    
}
