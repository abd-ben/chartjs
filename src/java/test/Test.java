/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Etudiant;
import beans.Filiere;
import service.EtudiantService;
import service.FiliereService;

/**
 *
 * @author root
 */
public class Test {
    
    public static void main(String[] args) {
        Filiere filiere = new Filiere("Informatique", "GI", "Genie informatique");
        FiliereService fs = new FiliereService();
        
        Filiere f = fs.findById(3);
        f.setNom("RSO");
        fs.update(f);
        
        /*fs.create(filiere);
        
        Etudiant etudiant = new Etudiant("ben khouya", "abderrahmane", "I708090", fs.findById(1));
        EtudiantService es = new EtudiantService();
        
        es.create(etudiant);
        */
    }
    
}
