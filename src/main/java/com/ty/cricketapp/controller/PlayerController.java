package com.ty.cricketapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.ty.cricketapp.dto.Player;
import com.ty.cricketapp.response.ResponseStructure;
import com.ty.cricketapp.service.PlayerService;

@RestController
public class PlayerController {
	@Autowired
private	PlayerService playerservice;
	
	//@RequestMapping(path="/save-player",method = RequestMethod.POST)
	@PostMapping("/save-player")
	public ResponseEntity<ResponseStructure<Player>> savePlayer(@RequestBody Player newplayer) {
		
		Player savedPlayer= playerservice.savePlayer(newplayer);
		ResponseStructure<Player> responseStructure=new ResponseStructure<>();
		

		if (savedPlayer!=null) {
	
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("player saved");
			responseStructure.setData(savedPlayer);
			return new ResponseEntity<ResponseStructure<Player>>(responseStructure, HttpStatus.CREATED);
			}
		else
		{
			
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseStructure.setMessage("player not saved");
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Player>>(responseStructure, HttpStatus.BAD_REQUEST);
			}
		
		
			
		}
	
	@GetMapping("/search-player/{id}")
	public ResponseEntity<ResponseStructure<Player>> getPlayer(@PathVariable("id") int playerId) {
		
	Player searchedPlayer=	 playerservice.searchPlayer(playerId);
    ResponseStructure<Player> responseStructure = new ResponseStructure<>();
	
	if (searchedPlayer!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("player found");
		responseStructure.setData(searchedPlayer);
		
		return new ResponseEntity<ResponseStructure<Player>>(responseStructure, null, HttpStatus.FOUND.value());
		
		
	} else {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("player not found");
		responseStructure.setData(null);
		
		return new ResponseEntity<ResponseStructure<Player>>(responseStructure, null, HttpStatus.NOT_FOUND.value());
		
		

	}
		
	}
	
	
	@PutMapping("/update-player")
	public ResponseEntity<ResponseStructure<Player>> updatePlayer(@RequestBody Player player) {
	Player searchedPlayer= playerservice.searchPlayer(player.getId());
	if (searchedPlayer!=null) {
		Player updatedPlayer= playerservice.updatePlayer(player);
		
		if (updatedPlayer!=null) {
			ResponseStructure<Player> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("updated Done");
			responseStructure.setData(updatedPlayer);
			
			return new ResponseEntity<ResponseStructure<Player>>(responseStructure, HttpStatus.OK);
			
		} else {
			ResponseStructure<Player> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseStructure.setMessage("updated not Done");
			responseStructure.setData(null);
			
			return new ResponseEntity<ResponseStructure<Player>>(responseStructure, HttpStatus.BAD_REQUEST);
			
			

		}
		
	} else {
		ResponseStructure<Player> responseStructure=new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("updated not Done bcz id is not found");
		responseStructure.setData(null);
		
		return new ResponseEntity<ResponseStructure<Player>>(responseStructure, HttpStatus.BAD_REQUEST);
		
		

	}
	
		
	}
	
	@DeleteMapping("/delete-player/{id}")
	
	public ResponseEntity<ResponseStructure<Player>> deletePlayer(@PathVariable("id") int playerId) {
		Player searchedPlayer= playerservice.searchPlayer(playerId);
		if (searchedPlayer!=null) {
			Player deletedPlayer= playerservice.deletePlayer(searchedPlayer);
			
			if (deletedPlayer!=null) {
				ResponseStructure<Player> responseStructure=new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("deleted Done");
				responseStructure.setData(deletedPlayer);
				
				return new ResponseEntity<ResponseStructure<Player>>(responseStructure, HttpStatus.OK);
				
			} else {
				ResponseStructure<Player> responseStructure=new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
				responseStructure.setMessage("deleted not Done");
				responseStructure.setData(null);
				
				return new ResponseEntity<ResponseStructure<Player>>(responseStructure, HttpStatus.BAD_REQUEST);
				
				

			}
			
			
			
			
			
			
		} else {
			ResponseStructure<Player> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseStructure.setMessage("deleted not Done bcz id is not found");
			responseStructure.setData(null);
			
			return new ResponseEntity<ResponseStructure<Player>>(responseStructure, HttpStatus.BAD_REQUEST);
			
			

		}
		
	}
	@GetMapping("/players/{pageNo}/{recordCount}")
	public ResponseEntity<ResponseStructure<List<Player>>> getAllPlayer(@PathVariable int pageNo, @PathVariable int recordCount) {
		
		List<Player> players= playerservice.getAllPlayers(pageNo ,recordCount);
		
		ResponseStructure<List<Player>> responseStructure= new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("All players");
		responseStructure.setData(players);
		
		return new ResponseEntity<ResponseStructure<List<Player>>>(responseStructure, HttpStatus.OK);
		
		
		
	}
	
	
	
		
		
	}


