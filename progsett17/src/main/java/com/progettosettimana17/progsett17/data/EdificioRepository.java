package com.progettosettimana17.progsett17.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progettosettimana17.progsett17.model.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

	Optional<Edificio> findByNome(String nome);

}
