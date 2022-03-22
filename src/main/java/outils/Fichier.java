package outils;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import labyrinthe.Salle;

/**
 *
 * @author INFO Professors team
 */
public class Fichier {
    Scanner sc=null;
    
    public Fichier(String nomFichier){
        try{
	    sc = new Scanner(new File(nomFichier));
	}
	catch(Exception e){ System.out.println(e); }     
    }
    
    /**
     * Méthode permettant de lire le fichier utilisé.
     * @return Retourne un nombre correspondant au prochain entier dans le fichier ou -1 s'il n'y en a pas
     */
    public int lireNombre(){
        if (sc.hasNextInt()) return sc.nextInt();
        return -1;
    }
    
    /**
     * Méthode permettant de savoir si un fichier est utilisable pour créer un labyrinthe.
     * @param fichier Le fichier testé.
     * @return Retourne vrai si le fichier est utilisable et faux sinon.
     */
    public static boolean testValide(String fichier){
        Fichier file = new Fichier(fichier);
        return pasDeCaseEnDouble(file) && coordonneesSallesFichier(file);
    }
    
    /**
     * Méthode permettant de tester si dans le fichier il y a plusieurs fois les mêmes coordonnées pour des salles différentes.
     * @param f Le fichier testé.
     * @return Retourne vrai si il n'y a pas de case en double et faux sinon.
     */
    private static boolean pasDeCaseEnDouble(Fichier f){
        ArrayList<Salle> salles = new ArrayList<>();
        boolean res = true;
        while(f.lireNombre() != -1){
            int x = f.lireNombre();
            int y = f.lireNombre();
            Salle s = new Salle(x, y);
            salles.add(s);
        }
        for(int i = 0; i < salles.size(); i++){
            Salle s = salles.get(i);
            for(int j = i+1; j < salles.size(); j++) res = !s.equals(salles.get(j));
        }
        return res;
    }
    
    /**
     * Méthode permettant de tester si dans le fichier il y a des cases avec des coordonnées non valides.
     * @param f Le fichier testé.
     * @return Retourne vrai les cases ont des coordonnées valides et faux sinon.
     */
    private static boolean coordonneesSallesFichier(Fichier f){
        int largeur = f.lireNombre();
        int hauteur = f.lireNombre();
        int i = 3;
        while(f.lireNombre() != -1){
            if(i%2 == 1 && f.lireNombre() >= largeur && f.lireNombre() < 0)return false;
            else if(i%2 == 0 && f.lireNombre() >= hauteur && f.lireNombre() < 0) return false;
        }
        return true;
    }
}
