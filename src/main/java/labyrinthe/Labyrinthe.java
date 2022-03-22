package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;
import outils.Fichier;
import personnages.IPersonnage;

/**
 *
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    protected ISalle entree, sortie;
    private int largeur, hauteur;

    /**
     * Méthode qui vérifie si un fichier est valide avant d'en extraire le labyrinthe contenu.
     * @param file Nom du fichier utilisé.
     * @throws ExceptionInvalidFile Exception qui peut être relevée lors du test de validité du fichier.
     */
    @Override
    public void creerLabyrinthe(String file) throws ExceptionInvalidFile {
        try {
            if (!Fichier.testValide(file)) {
                throw new ExceptionInvalidFile("\n Ce fichier ne peut-être validé, en conséquence le labyrinthe 'level7' "
                                                    + "sera chargé.");
            }
            creationLaby(file);
        } catch (ExceptionInvalidFile e) {
            if (!Fichier.testValide("labys/level7.txt")) {
                System.exit(0);
            }
            creationLaby("labys/level7.txt");
        }
    }

    /**
     * Méthode qui créée un labyrinthe à partir du fichier donné.
     * @param file Fichier contenant le labyrinthe.
     */
    private void creationLaby(String file) {
        Fichier f = new Fichier(file);
        // dimensions
        largeur = f.lireNombre();
        hauteur = f.lireNombre();
        // coorddonnées de l'entree
        int entreeX = f.lireNombre();
        int entreeY = f.lireNombre();
        entree = new Salle(entreeX, entreeY);
        add(entree);
        // coorddonnées de la sortie
        int sortieX = f.lireNombre();
        int sortieY = f.lireNombre();
        sortie = new Salle(sortieX, sortieY);
        add(sortie);
        // liste des salles
        int x = f.lireNombre();
        while (x != -1) {
            int y = f.lireNombre();
            Salle nouvelleSalle = new Salle(x, y);
            add(nouvelleSalle);
            x = f.lireNombre();
        }
    }

    /**
     * Méthode qui retourne toutes les salles qui sont adjacentes à la position du personnage donné.
     * @param bob IPersonnage dont on va prendre les coordonnées pour trouver les cases adjacentes.
     * @return Retourne une collection de ISalle contenant toutes les salles accessibles pour le personnage.
     */
    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        Collection<ISalle> sallesAdjacentes = new ArrayList<>();
        ISalle pos = bob.getPosition();
        for(ISalle s : this) if(pos.estAdjacente(s)) sallesAdjacentes.add(s);
        return sallesAdjacentes;
    }

    /**
     * Méthode permettant d'obtenir la salle qui correspond à l'entrée du labyrinthe.
     * @return Retourne la salle correspondant à l'entrée du labyrinthe.
     */
    @Override
    public ISalle getEntree() {
        return entree;
    }

    /**
     * Méthode permettant d'obtenir la salle qui correspond à la sortie du labyrinthe.
     * @return Retourne la salle correspondant à la sortie du labyrinthe.
     */
    @Override
    public ISalle getSortie() {
        return sortie;
    }

    /**
     * 
     * @param u
     * @param v
     * @return 
     */
    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    /**
     * Méthode permettant d'obtenir la largeur du labyrinthe.
     * @return Retourne un entier qui correspond à la largeur du labyrinthe.
     */
    @Override
    public int getLargeur() {
        return largeur;
    }

    /**
     * Méthode permettant d'obtenir la hauteur du labyrinthe.
     * @return Retourne un entier qui correspond à la hauteur du labyrinthe.
     */
    @Override
    public int getHauteur() {
        return hauteur;
    }

}
