/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package gg.sim.mzevallos.projet3;

import java.io.IOException;

/**
 *
 * @author X_Pet
 */
public class Projet3 {

    public static void main(String[] args) throws IOException {
        System.out.println("Projet 3 fait par Marcelo Zevallos!");
        
        boolean continuer = true;
        while(continuer){
            Dictionnaire d = new Dictionnaire("definitions.txt");
            d.main();
        }
        
        //Source pour les définitions: Dictionnaire Larousse.
    }
}
