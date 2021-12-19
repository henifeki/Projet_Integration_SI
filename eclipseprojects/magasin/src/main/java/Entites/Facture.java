package Entites;

import java.time.LocalDate;
import java.util.Collection;

public class Facture {
	Client client;
	LocalDate datefacture;
	Collection<LigneFacture> lignes;
	String numero;
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
	public String toString() {
		return "Facture [client=" + client + ", datefacture=" + datefacture + ", lignes=" + lignes + ", numero="
				+ numero + "]";
	}
	
	
	
	
	
}
