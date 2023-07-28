package com.progettosettimana17.progsett17.data;

import java.util.List;
import java.util.UUID;

import com.progettosettimana17.progsett17.model.Edificio;
import com.progettosettimana17.progsett17.model.Postazione;
import com.progettosettimana17.progsett17.model.TipoPostazione;

public interface IPostazioneDAO {

	public Postazione findById(Long id);

	public boolean isPresente(Postazione p);

	public void save(Postazione p);

	public List<Postazione> findByEdificio(Edificio e);

	public List<Postazione> findByCittà(String città, TipoPostazione tipo);

	public Postazione findByCodice(UUID codice);

}
