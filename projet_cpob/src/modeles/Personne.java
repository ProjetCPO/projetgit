package modeles;

public class Personne {
	
	private String nom ; 
	private String prenom ; 
	
	public Personne() {
		this.nom = "anonyme" ; 
		this.prenom = "anonyme" ; 
	}
	
	public Personne(String nom, String prenom) {
		this.nom = nom ; 
		this.prenom = prenom ; 
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
}
