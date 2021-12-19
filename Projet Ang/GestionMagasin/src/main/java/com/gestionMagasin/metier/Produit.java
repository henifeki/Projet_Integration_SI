package com.gestionMagasin.metier;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produit implements Serializable {
	@Id
	String reference;
	String libelle;
	float prix;
	
	public Produit(String libelle, float prix, String reference) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.reference = reference;
	}
	
	public Produit() {
		super();
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(reference);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		return Objects.equals(reference, other.reference);
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	@Override
	public String toString() {
		return "Produit [libelle=" + libelle + ", prix=" + prix + ", reference=" + reference + "]";
	}
	
	
}
