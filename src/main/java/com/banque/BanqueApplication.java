package com.banque;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.banque.entities.Client;
import com.banque.entities.Compte;
import com.banque.entities.CompteCourant;
import com.banque.entities.CompteEpargne;
import com.banque.entities.Operation;
import com.banque.entities.Retrait;
import com.banque.entities.Versement;
import com.banque.metier.IBanqueMetier;
import com.banque.repository.ClientRepository;
import com.banque.repository.CompteRepository;
import com.banque.repository.OperationRepository;

@SpringBootApplication
public class BanqueApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(BanqueApplication.class, args);
		
		
		
		/*
		 * ClientRepository clientR = ctx.getBean(ClientRepository.class);
		 * CompteRepository compteR = ctx.getBean(CompteRepository.class);
		 * OperationRepository operationR = ctx.getBean(OperationRepository.class);
		 */
		 
		 
		IBanqueMetier metier = ctx.getBean(IBanqueMetier.class);
		
		
		
		/*
		 * Client c1 = clientR.save(new Client("Ewandje Eric",
		 * "ewandjeeric@gmail.com")); Client c2 = clientR.save(new
		 * Client("Giress Delphin", "giressdelphin@gmail.com"));
		 * 
		 * Compte cr1 = compteR.save(new CompteCourant("cr1", new Date(), 90000.00, c1,
		 * 6000)); Compte cr2 = compteR.save(new CompteEpargne("cr2", new Date(),
		 * 75000.00, c2, 5.5));
		 * 
		 * Operation op1 = operationR.save(new Versement(new Date(), 150000.00, cr1));
		 * Operation op2 = operationR.save(new Versement(new Date(), 65800.00, cr1));
		 * Operation op3 = operationR.save(new Versement(new Date(), 5900.00, cr1));
		 * Operation op4 = operationR.save(new Retrait(new Date(), 5900.00, cr1));
		 * 
		 * Operation op5 = operationR.save(new Versement(new Date(), 80000.00, cr2));
		 * Operation op6 = operationR.save(new Versement(new Date(), 89800.00, cr2));
		 * Operation op7 = operationR.save(new Versement(new Date(), 100900.00, cr2));
		 * Operation op8 = operationR.save(new Retrait(new Date(), 12300.00, cr2));
		 */
		 
			//metier.verser("cr1", 100000.0); 
			//metier.virement("cr1", "cr2", 30000);

			 
	}

}
