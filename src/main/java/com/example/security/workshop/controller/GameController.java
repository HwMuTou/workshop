package com.example.security.workshop.controller;

import com.example.security.workshop.domain.Game;
import com.example.security.workshop.repository.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('admin','guest')")
    public Page<Game> index(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    @PostMapping
//    @PreAuthorize("hasAnyAuthority('admin')")
    public Game create(@RequestBody Game game) {
        return gameRepository.save(game);
    }
}
