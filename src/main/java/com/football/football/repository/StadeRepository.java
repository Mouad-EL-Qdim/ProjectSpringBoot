package com.football.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.football.entity.Stade;

public interface StadeRepository extends JpaRepository<Stade, Long>{
    
}
