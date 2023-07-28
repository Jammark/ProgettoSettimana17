package com.progettosettimana17.progsett17.data;

import java.time.LocalDate;

import com.progettosettimana17.progsett17.model.Postazione;
import com.progettosettimana17.progsett17.model.Prenotazione;
import com.progettosettimana17.progsett17.model.User;

public interface IPrenotazioneDAO {

	public void save(Prenotazione p);

	public boolean isPresente(Prenotazione p);

	public Prenotazione findById(Long id);

	public boolean isOccupata(Postazione p, LocalDate data);

	public boolean isPuòPrenotare(User u, LocalDate data);

}
