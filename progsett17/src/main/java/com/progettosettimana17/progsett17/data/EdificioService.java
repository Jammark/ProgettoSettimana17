package com.progettosettimana17.progsett17.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progettosettimana17.progsett17.model.Edificio;

@Service
public class EdificioService implements IEdificioDAO {

	@Autowired
	private EdificioRepository repo;

	@Override
	public Edificio findById(Long id) {

		return repo.findById(id).orElseThrow();
	}

	@Override
	public boolean isPresente(Edificio e) {

		return repo.findByNome(e.getNome()).isPresent();
	}

	@Override
	public void save(Edificio e) {
		repo.save(e);

	}

	@Override
	public Edificio findByNome(String nome) {

		return repo.findByNome(nome).orElse(null);
	}

}
