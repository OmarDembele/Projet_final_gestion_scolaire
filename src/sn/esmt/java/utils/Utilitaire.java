package sn.esmt.java.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UnsupportedLookAndFeelException;

import sn.esmt.java.ui.SecretaireUIi;

public class Utilitaire {
	
	public static void setLookAndFeel (Component component) {
		
		 try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     try {
						javax.swing.UIManager.setLookAndFeel(info.getClassName());
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger(SecretaireUIi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		 java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 new SecretaireUIi().setVisible(true);
             }
         });
         }
//		try { 
//		   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		   // force chaque composant de la fen�tre à appeler sa m�thode updateUI 
//		   SwingUtilities.updateComponentTreeUI(component);
//		   //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//		} catch (InstantiationException | ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException ignored) {}
	}
	
	/**
	 * @param component
	 * @param dimension
	 * Cette fonction positionne le composant au centre de l'�cran.
	 */
	public static void center (Component component, Dimension dimension) {
		component.setSize(dimension);
		
		// getScreenSize() method returns the size of the screen(ecran) in pixels
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// getSize() method returns the size of the component in pixels
		Dimension frameSize = component.getSize();

		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;

		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;

		component.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
	}
}
