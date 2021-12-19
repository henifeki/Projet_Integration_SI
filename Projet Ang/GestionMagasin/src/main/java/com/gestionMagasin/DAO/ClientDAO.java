package com.gestionMagasin.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionMagasin.metier.Client;

public interface ClientDAO extends JpaRepository<Client, String> {

}
