package com.football.football.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="football_match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatch;
    @EqualsAndHashCode.Include
    private LocalDate dateMatch; 
    @Column(length = 2)
    private int heureMatch;

    @ManyToOne
    @JsonBackReference
    private Arbitre arbitre;

    @ManyToOne
    private Stade stade;

    @ManyToMany
    @JoinTable(name = "match_equipe",
    joinColumns = @JoinColumn(name = "idMatch"),
    inverseJoinColumns = @JoinColumn(name = "idEquipe")
    )
    private Set<Equipe> equipes = new HashSet<>();
}
