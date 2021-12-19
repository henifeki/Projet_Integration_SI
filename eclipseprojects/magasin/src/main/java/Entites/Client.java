package Entites;
public class Client{
	String code;
	String nom;
	
	public Client(String client, String nom) {
		super();
		this.code = client;
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Client [code=" + code + ", nom=" + nom + "]";
	}
	
	
	
}

