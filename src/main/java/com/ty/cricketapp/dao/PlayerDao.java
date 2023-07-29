package com.ty.cricketapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.ty.cricketapp.dto.Player;
import com.ty.cricketapp.repository.PlayerRepository;


@Repository
public class PlayerDao {
	
	@Autowired
	private PlayerRepository playerRepository;

	public  Player savePlayer(Player newplayer) {
		
		return playerRepository.save(newplayer);
	}

	public Player searchPlayer(int playerId) {
	Optional<Player> playerOptional= playerRepository.findById(playerId);
		
	if (playerOptional.isEmpty()) {
		return null;
		
	} else {
		
		return playerOptional.get();

	}
		 
	}

	public Player updatePlayer(Player player) {
	
		return playerRepository.save(player);
	}

	public Player deletePlayer(Player searchedPlayer) {
		
		
		playerRepository.delete(searchedPlayer);
		return searchedPlayer;
	}

	public List<Player> getAllPlayers(int pageNo,int recordCount) {
		org.springframework.data.domain.Pageable pageable= PageRequest.of(pageNo, recordCount);
		
		return playerRepository.findAll(pageable).get().toList();
	}

}
