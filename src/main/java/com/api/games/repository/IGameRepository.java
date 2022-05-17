package com.api.games.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.api.games.model.Game;

public interface IGameRepository extends CrudRepository<Game, Integer> {

    /**
     * Find all games ordered by name
     * 
     * @return
     */
    // @Query(value = "SELECT * FROM Game order by name", nativeQuery = true)
    @Query("FROM Game g order by g.name")
    List<Game> findAllGames();

    /**
     * 
     * @param name
     * @return
     */
    @Query("From Game g where g.name like %?1% order by g.name")
    List<Game> findByNameContaining(String name);

}
