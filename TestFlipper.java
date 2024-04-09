

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestFlipper {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // D�tection des �crans
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice[] screens = ge.getScreenDevices();
            
            // V�rification que deux �crans sont bien connect�s
            if (screens.length < 2) {
                System.out.println("Deux �crans requis pour cette application.");
                return;
            }
            
            // Cr�ation de la fen�tre pour les images sur l'�cran 1
            JFrame imageFrame = new JFrame("Fen�tre images");
            imageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            imageFrame.setUndecorated(true); // Supprimer le titre et les bordures
            imageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiser la fen�tre
            imageFrame.setBounds(screens[0].getDefaultConfiguration().getBounds()); // D�finir les limites de la fen�tre en fonction de la r�solution de l'�cran 1
            
            // Ajout d'un composant pour afficher les images � la fen�tre
            imageFrame.add(new ImagePanel());
            imageFrame.setVisible(true);
            
            // Cr�ation de la fen�tre principale sur l'�cran 2
            JFrame mainFrame = new JFrame("Fen�tre principale");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setUndecorated(true); // Supprimer le titre et les bordures
            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiser la fen�tre
            mainFrame.setBounds(screens[1].getDefaultConfiguration().getBounds()); // D�finir les limites de la fen�tre en fonction de la r�solution de l'�cran 2
            
            // Ajout de l'interface utilisateur � la fen�tre principale
            mainFrame.add(new MainPanel(imageFrame));
            mainFrame.setVisible(true);
// Cr�ation du panneau principal avec une r�f�rence � la fen�tre d'image
            MainPanel mainPanel = new MainPanel(imageFrame);

// Ajout de l'interface utilisateur � la fen�tre principale
            mainFrame.add(mainPanel);
            mainFrame.setVisible(true);
        });
    }
    
    // pour le panneau d'affichage des images
    private static class ImagePanel
            extends JPanel {
        public ImagePanel() {
            // Ajouter des composants Swing pour afficher les images ici
        }
    }
}
