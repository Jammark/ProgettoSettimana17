package com.progettosettimana17.progsett17.data;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progettosettimana17.progsett17.model.Postazione;
import com.progettosettimana17.progsett17.model.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	List<Postazione> findByEdificioId(Long id);

	List<Postazione> findByTipoAndEdificioCittà(TipoPostazione tipo, String città);

	Optional<Postazione> findByCodice(UUID codice);
}
