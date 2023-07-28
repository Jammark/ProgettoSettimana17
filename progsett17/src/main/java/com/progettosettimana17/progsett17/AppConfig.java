package com.progettosettimana17.progsett17;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.progettosettimana17.progsett17.data.IEdificioDAO;
import com.progettosettimana17.progsett17.data.IPostazioneDAO;
import com.progettosettimana17.progsett17.data.IUserDAO;
import com.progettosettimana17.progsett17.model.Edificio;
import com.progettosettimana17.progsett17.model.Postazione;
import com.progettosettimana17.progsett17.model.TipoPostazione;
import com.progettosettimana17.progsett17.model.User;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Autowired
	private IEdificioDAO eDao;

	@Autowired
	private IUserDAO uDao;

	@Autowired
	private IPostazioneDAO pDao;

	@Bean
	public Faker getFaker() {
		return new Faker();
	}

	@Bean
	public Set<Edificio> getEdifici() {
		Set<Edificio> s = new HashSet<Edificio>();

		return s;
	}

	@Bean
	@Scope("prototype")
	public User getUtente() {
		User u = new User(getFaker().name().username(), getFaker().name().fullName(),
				getFaker().internet().emailAddress());
		if (!uDao.isPresent(u)) {
			uDao.save(u);
		} else {
			User persistentUser = uDao.findByUsername(u.getUsername());
			if (persistentUser != null) {
				return persistentUser;
			} else {
				throw new IllegalStateException();
			}
		}

		return u;
	}

	private Edificio getEdificio(Edificio e) {
		if (!eDao.isPresente(e)) {
			eDao.save(e);
			e = eDao.findByNome(e.getNome());
		} else {
			Edificio pe = eDao.findByNome(e.getNome());
			if (pe != null) {
				return pe;
			} else {
				throw new IllegalStateException();
			}
		}
		return e;
	}

	private Edificio getEdificio(String name) {
		Edificio e = new Edificio(getFaker().address().city(), getFaker().address().fullAddress(), name);
		return e;
	}

	@Bean
	public Edificio getEdificio1() {
		Edificio e = getEdificio("Edificio-1");
		return getEdificio(e);
	}

	@Bean
	public Edificio getEdificio2() {
		Edificio e = getEdificio("Edificio-2");
		return getEdificio(e);
	}

	@Bean
	@Scope("prototype")
	public TipoPostazione getTipoPostazione() {
		Random r = new Random();
		switch (r.nextInt(1, 4)) {
		case 1:
			return TipoPostazione.OPENSPACE;
		case 2:
			return TipoPostazione.PRIVATO;
		case 3:
			return TipoPostazione.SALA_RIUNIONI;
		default:
			throw new IllegalStateException("Errore nel codice");
		}
	}

	@Bean
	@Scope("prototype")
	public Postazione getPostazione() {
		Postazione p = new Postazione(getFaker().lorem().paragraph(), getTipoPostazione(), new Random().nextInt(2, 30));
		return p;
	}
}
