/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.Heros;
import personnages.IPersonnage;

/**
 *
 * @author Nathan
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {

    Heros heros;
    private static final Image image = new Image("file:icons/link/LinkRunR3.gif");

    /**
     * Constructeur de HeroSprite.
     * @param hero IPersonnage correspondant au héros.
     * @param lab ILabyrinthe correspondant au labyrinthe joué.
     * @param salle ISalle correspondant à la position du sprite du héros.
     */
    public HerosSprite(IPersonnage hero, ILabyrinthe lab, ISalle salle) {
        super(hero, image, salle);
        heros = (Heros) hero;
    }

    /**
     * Méthode permettant de controlé le héros par le clavier.
     * @param event KeyEvent correspondant à la touche utilisée sur le clavier.
     */
    @Override
    public void handle(KeyEvent event) {
        Salle s;
        switch (event.getCode()) {
            case LEFT:
                System.out.println("gauche");
                s = new Salle(heros.getPosition().getX()-1, heros.getPosition().getY());
                heros.salleChoisie = s;
                break;
            case RIGHT:
                System.out.println("droite");
                s = new Salle(heros.getPosition().getX()+1, heros.getPosition().getY());
                heros.salleChoisie = s;
                break;
            case UP:
                System.out.println("haut");
                s = new Salle(heros.getPosition().getX(), heros.getPosition().getY()-1);
                heros.salleChoisie = s;
                break;
            case DOWN:
                System.out.println("bas");
                s = new Salle(heros.getPosition().getX(), heros.getPosition().getY()+1);
                heros.salleChoisie = s;
                break;
        }
    }
}
