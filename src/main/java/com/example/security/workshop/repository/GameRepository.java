package com.example.security.workshop.repository;

import com.example.security.workshop.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
