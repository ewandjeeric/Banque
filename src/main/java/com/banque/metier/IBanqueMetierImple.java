package com.banque.metier;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banque.entities.Compte;
import com.banque.entities.CompteCourant;
import com.banque.entities.Operation;
import com.banque.entities.Retrait;
import com.banque.entities.Versement;
import com.banque.repository.CompteRepository;
import com.banque.repository.OperationRepository;

@Service
@Transactional
public class IBanqueMetierImple implements IBanqueMetier {
	@Autowired
	private CompteRepository compterepository;
	@Autowired
	private OperationRepository operationrepository;

	@Override
	public Optional<Compte> consultecompte(String cm) {
		 return compterepository.findById(cm);
		
	}

	@Override
	public void verser(String cd1, double montant) {
		Compte cp =  consultecompte(cd1).get();
		Versement v = new Versement(new Date(), montant, cp);
		operationrepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compterepository.save(cp);
	}

	@Override
	public void retirer(String cd1, double montant) {
		Compte cp =  consultecompte(cd1).get();
		double f = 0;
		
		if(cp instanceof CompteCourant) {
			f = ((CompteCourant) cp).getDecouvert();
			
			if((f + cp.getSolde()) >= montant) {
		Retrait r = new Retrait(new Date(), montant, cp);
		operationrepository.save(r);
		cp.setSolde(cp.getSolde() - montant);
		compterepository.save(cp);
			}else {
				throw new RuntimeException("Solde insuffisant");
			}
		}
		
		
	}

	@Override
	public void virement(String cd1, String cd2, double montant) {
		retirer(cd1, montant);
		verser(cd2, montant);
		
	}

	@Override
	public Page<Operation> listOperation(String cd, int page, int size) {
		
		return operationrepository.listOperation(cd, PageRequest.of(page, size));
	}

}
