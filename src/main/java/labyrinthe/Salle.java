/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

/**
 *
 * @author Nathan
 */
public class Salle implements ISalle{
    
    public int x, y;
    
    /**
     * Constructeur de Salle.
     * @param posX Entier correspondant à la position en x de la salle.
     * @param posY Entier correspondant à la position en y de la salle.
     */
    public Salle(int posX, int posY){
        x = posX;
        y = posY;
    }
    
    /**
     * Méthode permettant d'obtenir la position en x de la salle actuelle.
     * @return Retourne un entier correspondant à la position en x de la salle.
     */
    @Override
    public int getX(){
        return x;
    }
    
    /**
     * Méthode permettant d'obtenir la position en y de la salle actuelle.
     * @return Retourne un entier correspondant à la position en y de la salle.
     */
    @Override
    public int getY(){
        return y;
    }
    
    /**
     * Méthode permettant de savoir si une salle est adjacente à la position actuelle.
     * @param autre ISalle correspondant à une potentielle salle adjacente.
     * @return Retourne vrai si la salle en paramètre est adjacente et faux sinon.
     */
    @Override
    public boolean estAdjacente(ISalle autre){
        return (autre.getX()-x == 1 && autre.getY()-y == 0) || (autre.getY()-y == 1 && x-autre.getX() == 0)
                || (x-autre.getX() == 1 && autre.getY()-y == 0) || (y-autre.getY() == 1 && x-autre.getX() == 0)
                && !autre.equals(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.x;
        hash = 97 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
}
