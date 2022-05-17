package com.api.games.service;

import java.util.List;

import com.api.games.model.Distributor;

public interface IDistributorService {
	public List<Distributor> getAll();
	public Distributor getById(int id);
	public void save(Distributor distributor);
	public List<Distributor> findByName(String name);
}
