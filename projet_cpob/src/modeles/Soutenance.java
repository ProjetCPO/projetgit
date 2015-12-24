package modeles;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.Document;


public class Soutenance {
	protected Date dateSout;
	protected Personne etudiant;
	protected ArrayList<Personne> jury;
	protected Salle salleSout;
	protected ArrayList<Document> documents;
	
	public Soutenance() {
		this.dateSout = null ; 
		this.etudiant = null ; 
		this.jury = null ; 
		this.salleSout = null ; 
		this.documents = null ; 
	}

	public Soutenance(Date date, Personne etudiant, ArrayList<Personne> jury,
					Salle salleSout, ArrayList<Document> documents) {
		this.dateSout = date;
		this.etudiant = etudiant;
		this.jury = jury;
		this.salleSout = salleSout;
		this.documents = documents;
	}
	
	public void afficher() {
		System.err.println(this.dateSout.toString()) ; 
		System.err.println(this.etudiant.getNom() + " " + this.etudiant.getPrenom()) ; 
		for (int i = 0 ; i < this.jury.size() ; ++i)
			System.err.println(this.jury.get(i).getNom() + " " + this.jury.get(i).getPrenom()) ; 
		System.err.println(this.salleSout.getNom()) ; 
		if (this.documents.size() < 1)
			System.err.println("0 document") ; 
		else {
			for (int i = 0 ; i < this.documents.size() ; ++i)
				System.err.println("Document " + i + " : ") ; 
		}
	}

	public Date getDateSout() {
		return dateSout;
	}

	public void setDateSout(Date dateSout) {
		this.dateSout = dateSout;
	}

	public Personne getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Personne etudiant) {
		this.etudiant = etudiant;
	}

	public ArrayList<Personne> getJury() {
		return jury;
	}

	public void setJury(ArrayList<Personne> jury) {
		this.jury = jury;
	}

	public Salle getSalleSout() {
		return salleSout;
	}

	public void setSalleSout(Salle salleSout) {
		this.salleSout = salleSout;
	}

	public ArrayList<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}
	
	public void ajoutJury(Personne jury) {
		this.jury.add(jury) ; 
	}
	
	public void ajoutDocument(Document document) {
		this.documents.add(document) ; 
	}
	
}
