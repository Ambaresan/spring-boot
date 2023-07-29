package com.ty.cricketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.cricketapp.dto.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
