package com.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {


}
