package sn.esmt.java.ui;

import javax.swing.*;
import sn.esmt.java.utils.Utilitaire;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;


public class ChoixCaissier extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_logo;
	private JLabel label_logo;
	private JLabel label_titre;
	private JButton btn_secretaire;
	private JButton btn_caissier;
	
	public ChoixCaissier() {
		setSize(new Dimension(450, 300));
	 	setTitle("Choix Secretaire");
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setResizable(false);
    	getContentPane().setLayout(new BorderLayout(0, 0));
	        createInstance();
	        initComponent();
	    } 
	  
	  private void createInstance() {
		  panel = new JPanel();
	      panel_logo = new JPanel();
	      panel_logo.setBorder(new LineBorder(new Color(47, 79, 79), 2));
	      label_titre = new JLabel("Sur quelle fenetre voulez-vous etre redirigé ?");
	      label_titre.setForeground(new Color(255, 255, 255));
	      label_logo = new JLabel("");
	      btn_secretaire = new JButton("Secretaire");
	      btn_secretaire.setBackground(new Color(50, 205, 50));
	      btn_caissier = new JButton("Caissier");
	      btn_caissier.setBackground(new Color(255, 0, 0));
	}
	  
	    private void initComponent(){
	        Utilitaire.setLookAndFeel(this);
			Utilitaire.center(this, getSize());
			
			panel.setBackground(new Color(47, 79, 79));
	    	panel.setPreferredSize(new Dimension(10, 50));
	    	getContentPane().add(panel, BorderLayout.NORTH);
	    	panel.setLayout(null);
	    	
	    	
	    	label_titre.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	    	label_titre.setHorizontalAlignment(SwingConstants.CENTER);
	    	label_titre.setBounds(6, 5, 424, 39);
	    	panel.add(label_titre);
	    	
	    	panel_logo.setBackground(new Color(255, 255, 255));
	    	getContentPane().add(panel_logo, BorderLayout.CENTER);
	    	panel_logo.setLayout(null);
	    	
	    	
	    	label_logo.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\decision.png"));
	    	label_logo.setHorizontalAlignment(SwingConstants.CENTER);
	    	label_logo.setBounds(128, 23, 182, 180);
	    	panel_logo.add(label_logo);
	    	
	    	
	    	btn_secretaire.setFont(new Font("SansSerif", Font.BOLD, 14));
	    	btn_secretaire.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		onSecretaireClicked();
		      	}
		      });
	    	btn_secretaire.setBounds(5, 57, 113, 52);
	    	panel_logo.add(btn_secretaire);
	    	
	    	
	    	btn_caissier.setFont(new Font("SansSerif", Font.BOLD, 14));
	    	btn_caissier.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent arg0) {
		      		onCaissierClicked();
		      	}
		      });
	    	btn_caissier.setBounds(313, 57, 113, 52);
	    	panel_logo.add(btn_caissier);
		
	    }
		
		private void onCaissierClicked() {
			CaissierUI caissier = new CaissierUI();
			caissier.run();
			this.dispose();
		}

		private void onSecretaireClicked() {
			SecretaireUIi secretaire = new SecretaireUIi();
			secretaire.run();
			this.dispose();
		}

		public void show3() {
	    	this.setVisible(true); 
	    }
}