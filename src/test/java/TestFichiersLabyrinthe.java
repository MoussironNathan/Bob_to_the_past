
import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import labyrinthe.Salle;
import org.junit.Test;
import outils.Fichier;

/**
 *
 * @author INFO Professors team
 */
public class TestFichiersLabyrinthe {

    private File[] getFiles(File repertoire) {
        if (!repertoire.isDirectory()) {
            fail("testCoordonneesSalles - les tests ne concernent pas un répertoire");
        }
        File[] fichiers = repertoire.listFiles();
        return fichiers;
    }

    @Test
    public void testCoordonneesSalles() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for (File f : fichiers) {
            if (!f.getPath().startsWith("labys\\levelInvalide")) {
                assertTrue(testCoordonneesSallesFichier(f));
            } else if (f.getPath().equals("labys\\levelInvalide1.txt") || f.getPath().equals("labys\\levelInvalide2.txt")) {
                assertFalse(testCoordonneesSallesFichier(f));
            }
        }
    }

    public boolean testCoordonneesSallesFichier(File f) {
        Fichier file = new Fichier(f.getPath());
        int largeur = file.lireNombre();
        int hauteur = file.lireNombre();
        int i = 2;
        int x = file.lireNombre();
        while (x != -1) {
            if (i % 2 == 0 && x >= largeur || x < 0) {
                return false;
            } else if (i % 2 == 1 && x >= hauteur || x < 0) {
                return false;
            }
            x = file.lireNombre();
            i++;
        }
        return true;
    }

    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for (File f : fichiers) {
            if (!f.getPath().contains("labys/levelInvalid*")) {
                assertTrue(testPasDeCaseEnDouble(f));
            } else {
                assertFalse(testPasDeCaseEnDouble(f));
            }
        }
    }

    public boolean testPasDeCaseEnDouble(File f) {
        Fichier file = new Fichier(f.getPath());
        ArrayList<Salle> salles = new ArrayList<>();
        boolean res = true;
        int x = file.lireNombre();
        int y = file.lireNombre();
        while (x != -1 || y != -1) {
            Salle s = new Salle(x, y);
            salles.add(s);
            x = file.lireNombre();
            y = file.lireNombre();
        }
        for (int i = 0; i < salles.size(); i++) {
            Salle s = salles.get(i);
            for (int j = i + 1; j < salles.size(); j++) {
                res = !s.equals(salles.get(j));
            }
        }
        return res;
    }

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }
}
