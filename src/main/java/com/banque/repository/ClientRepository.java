package com.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
