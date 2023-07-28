package com.progettosettimana17.progsett17.data;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progettosettimana17.progsett17.model.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	Optional<Prenotazione> findByDataAndPostazioneId(LocalDate data, Long id);

	Optional<Prenotazione> findByUserIdAndData(Long id, LocalDate data);

}
