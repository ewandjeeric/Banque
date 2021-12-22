package com.banque.metier;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.banque.entities.Compte;
import com.banque.entities.Operation;

public interface IBanqueMetier {

	public Optional<Compte> consultecompte(String cm);
	public void verser(String cd1, double montant);
	public void retirer(String cd1, double montant);
	public void virement(String cd1, String cd2, double montant);
	public Page<Operation> listOperation(String cd, int page, int size);
}
