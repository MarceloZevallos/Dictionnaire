/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gg.sim.mzevallos.projet3;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author X_Pet
 */
public class Utilitaires {
    public static long lireEntier(String invite){
        Scanner sc = new Scanner(System.in);
        
        boolean lire = true;
        long l = 0;
        
        while (lire) {
            //https://www.w3schools.com/java/java_try_catch.asp
            System.out.print(invite);
            try {
               l = sc.nextInt();
               lire = false;
            }
            catch(Exception e) {
               System.out.println("ERREUR! Le format du nombre entier entré est invalide (exemple 123).");
               //effacer la valeur entrée par l'utilisateur
               sc.next(); 
               
            }
        }
        return l;
    }
    public static double lireReel(String invite){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        boolean lire = true;
        double d = 0.0f;
        
        while (lire) {
            //https://www.w3schools.com/java/java_try_catch.asp
            System.out.print(invite);
            try {
               d = sc.nextDouble();
               lire = false;
            }
            catch(Exception e) {
               System.out.println("ERREUR! Le format du nombre réel entré est invalide (exemple 3.75).");
               //effacer la valeur entrée par l'utilisateur
               sc.next(); 
               
            }
        }
        return d;
    }
    
    public static int genererAleatoire(int nb, int min){
        // référence: https://www.w3schools.com/java/java_math.asp
        // Cette methode génère nb nombre(s) entier(s) entre min et (min+nb-1)
        return min + (int)(Math.random() * nb);
        
    }
    
    public static char lireChar(String invite){
        
        Scanner sc = new Scanner(System.in);
        
        boolean lire = true;
        char c ='0';
        
        while (lire) {
            System.out.print(invite);
            try {
               c = sc.next().charAt(0);
               lire = false;
            }
            catch(Exception e) {
               System.out.println("ERREUR! Le format du nombre entier entré est invalide (exemple: o).");
               sc.next(); 
               
            }
        }
        
        return c;
    }
    
    public static String lireString(String invite){
        
        Scanner sc = new Scanner(System.in);
        
        boolean lire = true;
        String c = "0";
        
        while (lire) {
            System.out.print(invite);
            try {
               c = sc.next().toString();
               lire = false;
            }
            catch(Exception e) {
               System.out.println("ERREUR! Le format du nombre entier entré est invalide (exemple: o).");
               sc.next(); 
               
            }
        }
        
        return c;
    }
    
    public static String lireChaine(String invite){
        Scanner sc = new Scanner(System.in);
        System.out.print(invite);
        String s = sc.nextLine();
        return s;
    }
    
    public static int deStringVersInt (String s){
        int retour;
        try{
            retour = Integer.parseInt(s);
        }
        catch(Exception e){
            retour = 1;
        }
        return retour;
    }
    
    public static String deIntVersString (int s){
        String retour;
        try{
            retour = Integer.toString(s);
        }
        catch(Exception e){
            retour = "";
        }
        return retour;
    }
    
    public static String deDoubleVersString (double s){
        String retour;
        try{
            retour = Double.toString(s);
        }
        catch(Exception e){
            retour = "";
        }
        return retour;
    }
    
    public static char deStringVersChar (String s){
        char retour;
        try{
            retour = s.charAt(0);
        }
        catch(Exception e){
            retour = ' ';
        }
        return retour;
    }
}
