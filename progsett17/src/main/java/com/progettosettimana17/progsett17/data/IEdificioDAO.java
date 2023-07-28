package com.progettosettimana17.progsett17.data;

import com.progettosettimana17.progsett17.model.Edificio;

public interface IEdificioDAO {

	public Edificio findById(Long id);

	public boolean isPresente(Edificio e);

	public void save(Edificio e);

	public Edificio findByNome(String nome);
}
