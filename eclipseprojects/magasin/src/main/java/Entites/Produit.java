package Entites;

public class Produit {
	String libelle;
	float prix;
	String reference;
	public Produit(String libelle, float prix, String reference) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.reference = reference;
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
