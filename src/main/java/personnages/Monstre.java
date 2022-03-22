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
public class Monstre extends APersonnage {

    int temp = 15;

    /**
     * Constructeur de monstres.
     *
     * @param salle ISalle correspondant à la salle de départ du monstre.
     */
    public Monstre(ISalle salle) {
        super(salle);
    }

    /**
     * Méthode permettant de donner la prochaine ISalle où va aller le monstre.
     *
     * @param sallesAccessibles Collection de ISalle contenant toutes les salles où le monstre peut aller.
     * @return Retourne une salle choisie aléatoirement.
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (temp == 0) {
            temp = 15;
            int i = (int) (Math.random() * (sallesAccessibles.size() - 0));
            int j = 0;
            for (ISalle s : sallesAccessibles) {
                if (j == i) return s;
                j++;
            }
        } else temp--;
        return getPosition();
    }

}
