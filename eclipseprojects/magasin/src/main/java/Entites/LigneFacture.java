package Entites;

public class LigneFacture {


	private float prix;
	private Produit prod;
	private int quantite;
		
	public LigneFacture(float prix, Produit prod, int quantite) {
		this.prix = prix;
		this.prod = prod;
		this.quantite = quantite;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Produit getProd() {
		return prod;
	}

	public void setProd(Produit prod) {
		this.prod = prod;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "LigneFacture [prix=" + prix + ", prod=" + prod + ", quantite=" + quantite + "]";
	}
	
	
}
