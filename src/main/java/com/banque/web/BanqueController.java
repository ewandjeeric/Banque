package com.banque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banque.metier.IBanqueMetier;

@Configuration
@Controller
public class BanqueController {
    
	@Autowired
	private IBanqueMetier metier;
	
	@RequestMapping(value = "/operations")
	public String index() {
		return "comptes";
	}
}
