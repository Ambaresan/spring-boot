package com.ty.cricketapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ty.cricketapp.dao.PlayerDao;
import com.ty.cricketapp.dto.Player;

@Service
public class PlayerService {
	
	@Autowired
private	PlayerDao PlayerDao;

	public Player savePlayer(Player newplayer) {
		
		return PlayerDao.savePlayer(newplayer);
	}

	public Player searchPlayer(int playerId) {
		
		return PlayerDao.searchPlayer(playerId);
	}

	public Player updatePlayer(Player player) {
	
		return PlayerDao.updatePlayer(player);
	}

	public Player deletePlayer(Player searchedPlayer) {
		
		return PlayerDao.deletePlayer(searchedPlayer);
	}

	public  List<Player> getAllPlayers(int pageNo,int recordCount) {
		
	
	
		return PlayerDao.getAllPlayers(pageNo, recordCount);
	}

}
