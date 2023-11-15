package com.football.football.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="arbitre")
public class Arbitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArbitre; 
    private String nom; 
    private String nationalite;

    @OneToMany(mappedBy = "arbitre")
    @JsonManagedReference
    private List<Match> matches= new ArrayList<>();
}
