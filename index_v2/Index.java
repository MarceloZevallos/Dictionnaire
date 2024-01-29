/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gg.sim.mzevallos.projet3.index_v2;

import gg.sim.mzevallos.projet3.Entree;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author X_Pet
 */
public class Index implements Iterable<Entree> {
    private ArrayList<String> cles = new ArrayList<String>();
    private ArrayList<Entree> valeurs = new ArrayList<Entree>();
    
    public Index(){
        System.out.println("====== index avec ArrayList ======");
    }
    
   public void ajouterEntree(Entree e){
        cles.add(e.getMot().toUpperCase());
        valeurs.add(e);
    }
    
    public Entree rechercheEntree(String mot){
        for(int i = 0; i < cles.size(); i++){
            if(cles.get(i).equals(mot)){
                return valeurs.get(i);
            }
        }
        return null;
    }// recherche l'entrée avec un String
    
    public Iterator<Entree> iterator() {
        return new IterateurIndex(valeurs.iterator());
    }
    

}// Index V2

class IterateurIndex implements Iterator<Entree>{
    
    private Iterator<Entree> it;
    
    public IterateurIndex(Iterator<Entree> it){
        this.it = it;
    }

    public boolean hasNext() {
        return it.hasNext();
    }

    public Entree next() {
        return it.next();
    }
    
    public void remove(){
        it.remove();
    }
}
