/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author root
 */
@Entity
public class Filiere implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String code;
    private String description;
    
    
    @OneToMany
    @JoinColumn(name = "id_filiere")
    @Transient
    private List<Etudiant> etudiants;

    public Filiere(){
        
    }
    
    public Filiere(String nom, String code, String description) {
        this.nom = nom;
        this.code = code;
        this.description = description;
    }
    
    public Filiere(String nom, String code, String description, List<Etudiant> etudiants) {
        this.nom = nom;
        this.code = code;
        this.description = description;
        this.etudiants = etudiants;
    }
    
    public Filiere(int id, String nom, String code, String description, List<Etudiant> etudiants) {
        this.id = id;
        this.nom = nom;
        this.code = code;
        this.description = description;
        this.etudiants = etudiants;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
    
    
}
