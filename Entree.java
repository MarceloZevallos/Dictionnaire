/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gg.sim.mzevallos.projet3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 *
 * @author X_Pet
 */
public class Entree {
    private String mot;
    private int deplacement;
    private int longueur;
    
    public Entree(String mot, int deplacement, int longueur){
        this.mot = mot;
        this.deplacement = deplacement;
        this.longueur = longueur;
    }
    
    public String toString(){
        String message = String.format(Locale.US, "Mot: %-15s    Deplacement: %-3s   Longueur: %-3s", mot, deplacement, longueur);
        return message;
    }
    
    public String lireDefinition(SeekableByteChannel sbc) throws IOException{
        StringBuilder sb = new StringBuilder();
        /*try{
                sbc.position(deplacement);
                ByteBuffer buffer = ByteBuffer.allocate(longueur);
                sbc.read(buffer);
                buffer.flip();
                byte[] data = new byte[longueur];
                buffer.get(data, 0 , longueur);
                sb.append(new String(data, StandardCharsets.UTF_8));
                System.out.print(sb.toString());
                return sb.toString();
            }catch(IOException e){
                e.printStackTrace();
                return "ERREUR";
            }*/
        
        try {
        sbc.position(deplacement);
        ByteBuffer buffer = ByteBuffer.allocate(longueur);
        sbc.read(buffer);
        buffer.flip();
        byte[] data = new byte[buffer.remaining()];
        buffer.get(data);
        sb.append(new String(data, StandardCharsets.UTF_8));
        System.out.println(sb.toString());
        return sb.toString();
    } catch (IOException e) {
        e.printStackTrace();
        return "ERREUR";
    }
    }

    
    public String getMot() {
        return mot;
    }

    public int getDeplacement() {
        return deplacement;
    }

    public int getLongueur() {
        return longueur;
    }
    
}// Entree
