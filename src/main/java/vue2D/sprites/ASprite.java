/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import personnages.IPersonnage;

/**
 *
 * @author Nathan
 */
public abstract class ASprite implements ISprite {

    IPersonnage personnage;
    Image img;
    private final int unite = 15;
    private int xSprite, ySprite;

    /**
     * Constructeur de sprite.
     *
     * @param perso IPersonnage correspondant au sprite créée.
     * @param image Image correspondant au personnage.
     * @param salle ISalle correpondant à la position du sprite.
     */
    public ASprite(IPersonnage perso, Image image, ISalle salle) {
        personnage = perso;
        img = image;
        xSprite = salle.getX() * unite;
        ySprite = salle.getY() * unite;
    }

    /**
     * Méthode permettant de dessiner un sprite.
     *
     * @param g GraphicsContext permettant d'utiliser des méthodes d'affichage.
     */
    @Override
    public void dessiner(GraphicsContext g) {
        if(xSprite != getPosition().getX()*unite || ySprite != getPosition().getY()*unite){
            if(xSprite > getPosition().getX()*unite) xSprite--; g.drawImage(img, xSprite, ySprite, unite, unite);
            if(xSprite < getPosition().getX()*unite) xSprite++; g.drawImage(img, xSprite, ySprite, unite, unite);
            if(ySprite > getPosition().getY()*unite) ySprite--; g.drawImage(img, xSprite, ySprite, unite, unite);
            if(ySprite < getPosition().getY()*unite) ySprite++; g.drawImage(img, xSprite, ySprite, unite, unite);
        } else g.drawImage(img, xSprite, ySprite, unite, unite);
    }

    /**
     * Méthode permettant d'obtenir la position du sprite concerné.
     *
     * @return Retourne l'ISalle correspondant à la salle où se situe le
     * personnage lié au sprite.
     */
    @Override
    public ISalle getPosition() {
        return personnage.getPosition();
    }

    /**
     * Méthode permettant de modifier la position du personnage lié au sprite
     * concerné.
     *
     * @param s ISalle où l'on veux que le personnage lié au sprite concerné
     * aille.
     */
    @Override
    public void setPosition(ISalle s) {
        personnage.setPosition(s);
    }

    /**
     * Méthode permettant de modifier les coordonnées du sprite.
     *
     * @param xpix Coordonnée x du sprite.
     * @param ypix Coordonnée x du sprite.
     */
    @Override
    public void setCoordonnees(int xpix, int ypix) {
        xpix = xSprite;
        ypix = ySprite;
    }

    /**
     * Méthode permettant d'obtenir le choix fait par le personnage.
     *
     * @param sallesAccessibles Collection de ISalle contenant toutes les salles
     * où le personnage peut aller.
     * @return Retourne la prochaine salle du personnage.
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return personnage.faitSonChoix(sallesAccessibles);
    }

}
