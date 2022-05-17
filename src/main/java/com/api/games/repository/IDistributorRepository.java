package com.api.games.repository;

import com.api.games.model.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.api.games.model.Distributor;

import java.util.List;

public interface IDistributorRepository extends CrudRepository<Distributor, Integer> {;

    /**
     *
     * @param name
     * @return
     */
    @Query("From Distributor d where d.name like %?1% order by d.name")
    List<Distributor> findByNameContaining(String name);
}
