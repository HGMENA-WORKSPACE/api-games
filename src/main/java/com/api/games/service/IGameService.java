package com.api.games.service;

import java.util.List;

import com.api.games.model.Game;

public interface IGameService {
	public List<Game> getAll();
	public Game getById(int id);
	public void save(Game game);
	public List<Game> findByName(String name);
}
