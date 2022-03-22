/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 *
 * @author Nathan
 */
public class Heros extends APersonnage{
    
    public ISalle salleChoisie;
    
    /**
     * Constructeur de héros.
     * @param salle ISalle correspondant à la salle de départ du héros.
     */
    public Heros(ISalle salle){
        super(salle);
    }
    
    /**
     * Méthode permettant de donner la prochaine ISalle où va aller le héros.
     * @param sallesAccessibles Collection de ISalle contenant toutes les salles où le héros peut aller.
     * @return Retourne la salle choisie par le joueur si elle est accessible sinon retourne la salle actuelle.
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles){
        if(sallesAccessibles.contains(salleChoisie)) return salleChoisie;
        return getPosition();
    }
}