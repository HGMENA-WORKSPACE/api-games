package com.api.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.games.model.Distributor;
import com.api.games.repository.IDistributorRepository;

@Service
public class DistributorService implements IDistributorService {

    @Autowired
    private IDistributorRepository distributorRepository;

    @Override
    public List<Distributor> getAll() {
        return (List<Distributor>) distributorRepository.findAll();
    }

    @Override
    public Distributor getById(int id) {
        return (Distributor) distributorRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Distributor distributor) {
        distributorRepository.save(distributor);
    }

    @Override
    public List<Distributor> findByName(String name) {
        return distributorRepository.findByNameContaining(name);
    }

}
