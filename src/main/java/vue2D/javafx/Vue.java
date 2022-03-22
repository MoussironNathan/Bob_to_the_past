package vue2D.javafx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import labyrinthe.ILabyrinthe;
import vue2D.IVue;
import vue2D.AVue;
import vue2D.sprites.ISprite;

/**
 *
 * @author INFO Professors team
 */
public class Vue extends AVue implements IVue {

    Dessin dessin;
    ILabyrinthe labyrinthe;
    public Scene scene;

    /**
     * Constructeur de Vue.
     * @param labyrinthe ILabyrinthe correspondant au labyrinthe joué.
     */
    public Vue(ILabyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        dessin = new Dessin(labyrinthe, this);
        Group root = new Group();
        this.scene = new Scene(root);
        root.getChildren().add(dessin);
    }

    /**
     * Méthode permettant d'appeler toutes les méthodes d'affichage.
     */
    @Override
    public void dessiner() {
        dessin.dessinFond();
        dessin.dessinLaby();
        dessin.dessinSprites();
    }

    /**
     * Méthode qui ajoute un sprite dans la liste AVue et associe les sprites jouable à l'écouteur du clavier.
     * @param sprite ISprite que l'on souhaite ajouter à la liste AVue.
     * @return Retourne vrai lorsque la méthode a été executer.
     */
    @Override
    public boolean add(ISprite sprite) {
        super.add(sprite);
        // si le sprite est controle par le clavier
        if (sprite instanceof EventHandler) {
            System.out.println("registering keylistener");
            // association de l'ecouteur sur le clavier avec le composant graphique principal
            this.scene.setOnKeyPressed((EventHandler) sprite);
        }
        return true;
    }
}
