package com.api.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.games.model.Game;
import com.api.games.repository.IGameRepository;

@Service
public class GameService implements IGameService {

	@Autowired
	private IGameRepository gameRepository;

	/**
	 * 
	 */
	@Override
	public List<Game> getAll() {
		return (List<Game>) gameRepository.findAllGames();
	}

	/**
	 * 
	 */
	@Override
	public Game getById(int id) {
		return (Game) gameRepository.findById(id).orElse(null);
	}


	@Override
	public void save(Game game) {
		this.gameRepository.save(game);
	}

	@Override
	public List<Game> findByName(String name) {
		return (List<Game>) gameRepository.findByNameContaining(name);
	}

}
