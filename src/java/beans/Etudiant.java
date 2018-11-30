/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class Etudiant implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String cin;
    
    @ManyToOne
    @JoinColumn(name = "id_filiere")
    private Filiere filiere;

    public Etudiant(){
        
    }
    
    public Etudiant(String nom, String prenom, String cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
    }
    
    public Etudiant(String nom, String prenom, String cin, Filiere filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.filiere = filiere;
    }
    
    public Etudiant(int id, String nom, String prenom, String cin, Filiere filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.filiere = filiere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    
    
}
