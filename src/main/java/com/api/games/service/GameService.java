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
     * @return
     */
    @Override
    public List<Game> getAll() {
        return (List<Game>) gameRepository.findAllGames();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Game getById(int id) {
        return (Game) gameRepository.findById(id).orElse(null);
    }

    /**
     * @param game
     */
    @Override
    public void save(Game game) {
        this.gameRepository.save(game);
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<Game> findByName(String name) {
        return (List<Game>) gameRepository.findByNameContaining(name);
    }

}
