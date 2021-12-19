package com.gestionMagasin.metier;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Facture implements Serializable {
	@Id
	String numero;
	LocalDate datefacture;
	@OneToMany
	Collection<LigneFacture> lignes;
	@OneToOne
	Client client;
	public Facture(Client client, LocalDate datefacture, Collection<LigneFacture> lignes, String numero) {
		this.client = client;
		this.datefacture = datefacture;
		this.lignes = lignes;
		this.numero = numero;
	}
	
	public Facture() {
		super();
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public LocalDate getDatefacture() {
		return datefacture;
	}
	public void setDatefacture(LocalDate datefacture) {
		this.datefacture = datefacture;
	}
	public Collection<LigneFacture> getLignes() {
		return lignes;
	}
	public void setLignes(Collection<LigneFacture> lignes) {
		this.lignes = lignes;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facture other = (Facture) obj;
		return Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Facture [client=" + client + ", datefacture=" + datefacture + ", lignes=" + lignes + ", numero="
				+ numero + "]";
	}
	
	
	
	
	
}
