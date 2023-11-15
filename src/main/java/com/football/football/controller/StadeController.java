package com.football.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.football.entity.Stade;
import com.football.football.service.StadeService;

@RestController
@RequestMapping("/stadiums")
public class StadeController {
    @Autowired
    private StadeService stadeService;

    @GetMapping
    public List<Stade> getAllStadiums() {
        return stadeService.getAllStadiums();
    }

    @GetMapping("/{id}")
    public Stade getStadeById(@PathVariable Long id) {
        return stadeService.getStadiumById(id);
    }

    @PostMapping
    public Stade createStade(@RequestBody Stade stade) {
        return stadeService.createStadium(stade);
    }

    @PutMapping("/{id}")
    public Stade updateStade(@PathVariable Long id, @RequestBody Stade stade) {
        return stadeService.updateStadium(id, stade);
    }

    @DeleteMapping("/{id}")
    public void deleteStade(@PathVariable Long id) {
        stadeService.deleteStadium(id);
    }
}
