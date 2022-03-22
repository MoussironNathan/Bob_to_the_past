/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import personnages.Monstre;

/**
 *
 * @author Nathan
 */
public class MonstreSprite extends ASprite {
    
    Monstre monstres;
    private static final Image image = new Image("file:icons/monstre0.gif");
    
    /**
     * Constructeur de MonstreSprite.
     * @param monstre IPersonnage correspondant au monstre.
     * @param lab ILabyrinthe correspondant au labyrinthe joué.
     * @param salle ISalle correspondant à la position du sprite du monstre.
     */
    public MonstreSprite(IPersonnage monstre, ILabyrinthe lab, ISalle salle) {
        super(monstre, image, salle);
        monstres = (Monstre) monstre;
    }
    
}
