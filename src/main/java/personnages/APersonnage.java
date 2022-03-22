/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import labyrinthe.ISalle;
import labyrinthe.Salle;

/**
 *
 * @author Nathan
 */
public abstract class APersonnage implements IPersonnage{
    
    public int x, y;
    
    /**
     * Constructeur d'un APersonnage
     * @param salle ISalle correspondant à la salle de départ du APersonnage.
     */
    public APersonnage(ISalle salle){
        x = salle.getX();
        y = salle.getY();
    }

    /**
     * Méthode permettant d'obtenir la position actuelle du APersonnage concerné.
     * @return Retourne une ISalle où se situe le APersonnage.
     */
    @Override
    public ISalle getPosition(){
        ISalle pos = new Salle(x, y);
        return pos;
    }
    
    /**
     * Méthode permettant de modifier la position du APersonnage concerné.
     * @param s ISalle où l'on veux que le personnage aille.
     */
    @Override
    public void setPosition(ISalle s){
        x = s.getX();
        y = s.getY();
    }
    
}
