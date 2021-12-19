package com.gestionMagasin.metier;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client implements Serializable{
	@Id
	String code;
	String nom;
	
	public Client(String client, String nom) {
		super();
		this.code = client;
		this.nom = nom;
	}
	

	public Client() {
		super();
	}


	public String getCode() {
		return code;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(code, other.code);
	}

	@Override
	public String toString() {
		return "Client [code=" + code + ", nom=" + nom + "]";
	}
	
	
	
}

