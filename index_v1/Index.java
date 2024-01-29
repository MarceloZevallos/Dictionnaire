/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gg.sim.mzevallos.projet3.index_v1;

import gg.sim.mzevallos.projet3.Entree;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author X_Pet
 */
 public class Index implements Iterable<Entree> {
    
    public static HashMap<String, Entree> tableIndex = new HashMap<String, Entree>();
    
    public Index(){
        System.out.println("========= index avec HashMap =========");
    }
    
    public void ajouterEntree(Entree e){
        tableIndex.put(e.getMot().toUpperCase(), e);
    }
    
    public Entree rechercheEntree(String mot){
        return tableIndex.get(mot.toUpperCase());
    }// recherche l'entrée avec un String

    public Iterator<Entree> iterator() {
        return new IterateurIndex();
    }
    
}// Index 1

class IterateurIndex implements Iterator<Entree> {
   
    private Iterator<Entree> it =  Index.tableIndex.values().iterator();

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

