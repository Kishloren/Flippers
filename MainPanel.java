

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel
        extends JPanel {
    private JButton button1;
    private JButton button2;
    private JButton quitButton;
    private JFrame imageFrame;
    private JLabel imageLabel;
    
    public MainPanel(JFrame imageFrame) {
        this.imageFrame = imageFrame;
        this.imageLabel = new JLabel();
        
        // Cr�ation des boutons
        button1 = new JButton("Afficher image 1");
        button2 = new JButton("Afficher image 2");
        quitButton = new JButton("Quitter");
        
        // Ajout des �couteurs d'�v�nements aux boutons
        button1.addActionListener(e -> showImage("c:\\images\\image1.jpg"));
        button2.addActionListener(e -> showImage("c:\\images\\image2.jpg"));
        quitButton.addActionListener(e -> System.exit(0));
        
        // Ajout des boutons au panneau
        add(button1);
        add(button2);
        add(quitButton);
    }
    
    // M�thode pour afficher une image en plein �cran sur l'�cran secondaire
    private void showImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        imageLabel.setIcon(icon);
        imageFrame.getContentPane().removeAll();
        imageFrame.getContentPane().add(imageLabel, BorderLayout.CENTER);
        imageFrame.revalidate();
        imageFrame.repaint();
    }
}
