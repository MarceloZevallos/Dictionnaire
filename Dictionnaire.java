/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gg.sim.mzevallos.projet3;

//import gg.sim.mzevallos.projet3.index_v1.Index;
import gg.sim.mzevallos.projet3.index_v2.Index;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Iterator;

/**
 *
 * @author X_Pet
 */
public class Dictionnaire {

    private SeekableByteChannel sbc;
    private Index Index;
    private String Fichier;

    public Dictionnaire(String nomFichier) throws IOException {
        int len = 0;
        this.Fichier=nomFichier;
        sbc = Files.newByteChannel(Paths.get(nomFichier + ".sbc"), StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.READ, StandardOpenOption.WRITE);

        Index = new Index();

        try ( BufferedReader reader = Files.newBufferedReader(Paths.get(nomFichier))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                String mot = parts[0].trim().toLowerCase();
                String definition = parts[1];
                if(len<117){
                    Entree e = new Entree(mot, len, definition.length()+3);
                    Index.ajouterEntree(e);
                } else if(len>=117) {
                    Entree e = new Entree(mot, len+3, definition.length());
                    Index.ajouterEntree(e);
                }
                len = len + definition.length();
                
                sbc.write(ByteBuffer.wrap(definition.getBytes(Charset.forName("UTF-8"))));
                sbc.write(ByteBuffer.wrap("".getBytes(Charset.forName("UTF-8"))));
            }
        }
    }// constructeur

    public String trouverDefinition(String mot) throws IOException {
        Entree entree = Index.rechercheEntree(mot.toUpperCase());
        if (entree != null) {
            entree.lireDefinition(sbc);
        } else {
            return "mot inexistant dans le dictionnaire";
        }
        return null;
    }// trouver la definition

    public String ajouterMot(String mot, String definition) throws IOException {
        int deplacement = definition.length();
        try ( BufferedReader reader = Files.newBufferedReader(Paths.get(Fichier))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                String motp = parts[0].trim().toLowerCase();
                if (motp.contains(mot)) {
                    return "Le mot " + mot + " existe déjà dans le dictionnaire";
                }
            }
        }
        Entree en = new Entree(mot.toLowerCase(), (int) sbc.position(), deplacement);
        Index.ajouterEntree(en);
        BufferedWriter writer = null;

        writer = new BufferedWriter(new FileWriter(Fichier, true));
        writer.write("\n" + mot + ":" + definition);
        writer.close();

        sbc.write(ByteBuffer.wrap(definition.getBytes(Charset.forName("UTF-8"))));
        sbc.write(ByteBuffer.wrap("".getBytes(Charset.forName("UTF-8"))));
        return "Le mot " + mot + " a été ajouté au dictionnaire";
    }

    public void afficherMots() throws IOException {
        Iterator<Entree> iterator = Index.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }// afficherMots

    public void main() throws IOException {
        boolean continuer = true;
        while (true) {
            System.out.println("------------- Menu --------------------\n"
                    + "1) Afficher les mots\n"
                    + "2) Voir la définition d'un mot\n"
                    + "3) Ajouter un mot\n"
                    + "4) Quitter\n"
                    + "---------------------------------------");
            int choix = (int) Utilitaires.lireEntier("Choisissez un nombre de 1 à 4: ");

            switch (choix) {
                case 1:
                    afficherMots();
                    System.out.println("\n");
                    break;
                case 2:
                    String mot = Utilitaires.lireString("Entrer le mot: ");
                    System.out.print("Définition: ");
                    String def = trouverDefinition(mot);
                    System.out.println("\n");
                    break;
                case 3:
                    mot = Utilitaires.lireString("Entrer le mot: ");
                    def = Utilitaires.lireString("Entrer sa définition: " + trouverDefinition(mot));
                    System.out.println();
                    System.out.println(ajouterMot(mot, def));
                    System.out.println("\n");
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Veuilleur entrer une valeur entre 1 et 4.");
                    System.out.println();
                    break;
            }
        }
    }// main Dictionnaire

}// dictionnaire
