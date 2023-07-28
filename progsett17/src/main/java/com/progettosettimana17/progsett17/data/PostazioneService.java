package com.progettosettimana17.progsett17.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progettosettimana17.progsett17.model.Edificio;
import com.progettosettimana17.progsett17.model.Postazione;
import com.progettosettimana17.progsett17.model.TipoPostazione;

@Service
public class PostazioneService implements IPostazioneDAO {

	@Autowired
	private PostazioneRepository repo;

	@Override
	public Postazione findById(Long id) {

		return repo.findById(id).orElseThrow();
	}

	@Override
	public boolean isPresente(Postazione p) {

		return false;
	}

	@Override
	public void save(Postazione p) {
		repo.save(p);

	}

	@Override
	public List<Postazione> findByEdificio(Edificio e) {
		if (e.getId() != null) {
			return repo.findByEdificioId(e.getId());
		} else {
			throw new IllegalArgumentException("Edificio passato non ha id:" + e);
		}
	}

	@Override
	public List<Postazione> findByCittà(String città, TipoPostazione tipo) {

		return repo.findByTipoAndEdificioCittà(tipo, città);
	}


}
