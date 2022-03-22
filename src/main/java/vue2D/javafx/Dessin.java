package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import vue2D.sprites.ISprite;

/**
 *
 * @author INFO Professors team
 */
public class Dessin extends Canvas {

    private final Collection<ISprite> sprite;
    private final ILabyrinthe laby;
    private final int unite = 15;
    private final GraphicsContext tampon;
    private Image solImage, salleImage, imageEntree, imageSortie;
    private ISprite hero;

    /**
     * Constructeur permettant les affichages graphique.
     * @param labyrinthe ILabyrinthe contenant le labyrinthe joué.
     * @param sprites Collection de ISprite contenant tous les sprites du jeu.
     */
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        sprite = sprites;
        laby = labyrinthe;
        setWidth(labyrinthe.getLargeur() * unite);
        setHeight(labyrinthe.getHauteur() * unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
    }

    /**
     * Méthode permettant d'initialiser les images.
     */
    public void chargementImages() {
        solImage = new Image("file:icons/pyramide.jpg");
        salleImage = new Image("file:icons/ground.gif");
        imageEntree = new Image("file:icons/mur0.gif");
        imageSortie = new Image("file:icons/sortie.gif");
    }

    /**
     * Méthode permettant d'afficher l'image de fond.
     */
    public void dessinFond() {
        tampon.drawImage(solImage, 0, 0, unite * laby.getLargeur(), unite * laby.getHauteur());
    }

    /**
     * Méthode permettant d'afficher le labyrinthe.
     */
    public void dessinLaby() {
        if (sprite.size() > 0) hero = (ISprite) sprite.toArray()[0];
        laby.forEach(s -> {
            int i = calculDistanceLumiere(hero.getPosition().getX(), hero.getPosition().getY(), s.getX(), s.getY());
            if (i < 6) {
                if (laby.getEntree().equals(s)) tampon.drawImage(imageEntree, s.getX() * unite, s.getY() * unite, unite, unite);
                else if (laby.getSortie().equals(s)) tampon.drawImage(imageSortie, s.getX() * unite, s.getY() * unite, unite, unite);
                else tampon.drawImage(salleImage, s.getX() * unite, s.getY() * unite, unite, unite);
            }
        });
    }

    /**
     * Méthode permettant d'afficher les sprites.
     */
    public void dessinSprites() {
        sprite.forEach(s -> {
            if(s.equals(hero)) s.dessiner(tampon);
            int i = calculDistanceLumiere(hero.getPosition().getX(), hero.getPosition().getY(),
                    s.getPosition().getX(), s.getPosition().getY());
            if (i < 6) s.dessiner(tampon);
        });
    }

    /**
     * Méthode permettant de calculer la distance entre la position du héros et celle d'une salle.
     * @param xPerso Coordonnée x du personnage.
     * @param yPerso Coordonnée y du personnage.
     * @param xSalle Coordonnée x de la salle.
     * @param ySalle Coordonnée y de la salle.
     * @return Retourne un entier correspondant au résultat du calcul.
     */
    private int calculDistanceLumiere(int xPerso, int yPerso, int xSalle, int ySalle) {
        return (int) Math.sqrt((ySalle - yPerso) * (ySalle - yPerso) + (xSalle - xPerso) * (xSalle - xPerso));
    }
}
