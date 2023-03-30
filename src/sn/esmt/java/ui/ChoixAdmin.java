package sn.esmt.java.ui;

import javax.swing.*;
import sn.esmt.java.utils.Utilitaire;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;


public class ChoixAdmin extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel panel_choice;
	private JLabel label_logo;
	private JButton btnAdmin;
	private JButton btnCaissier;
	
	 public ChoixAdmin() {
	 		setSize(new Dimension(450, 300));
		 	setTitle("Choix Admin");
	    	getContentPane().setLayout(null);
	    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	setResizable(false);
	    	createInstance();
	    	initComponent();    
	    } 

		private void createInstance() {
			panel_choice = new JPanel();
			panel_choice.setBorder(new LineBorder(new Color(47, 79, 79), 2));
			panel_choice.setLayout(null);
			label_logo = new JLabel("");
			btnAdmin = new JButton("Admin");
			btnAdmin.setBackground(new Color(50, 205, 50));
			btnAdmin.setFont(new Font("SansSerif", Font.BOLD, 15));
			btnCaissier = new JButton("Caissier");
			btnCaissier.setBackground(new Color(255, 0, 0));
			btnCaissier.setFont(new Font("SansSerif", Font.BOLD, 15));
			
			
		}
		
		private void initComponent() {
	    	
	    	panel_choice.setBounds(0, 0, 436, 263);
	    	panel_choice.setBackground(Color.WHITE);
	    	getContentPane().add(panel_choice);
	    	Utilitaire.setLookAndFeel(this);
			Utilitaire.center(this, getSize());
			
			label_logo.setHorizontalAlignment(SwingConstants.CENTER);
			label_logo.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\decision.png"));
			label_logo.setBounds(142, 59, 178, 183);
			panel_choice.add(label_logo);
			
			btnAdmin.setBounds(20, 85, 113, 52);
			btnAdmin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onAdminClicked();
				}
			});
			panel_choice.add(btnAdmin);
			
			btnCaissier.setBounds(317, 85, 113, 52);
			btnCaissier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onCaissierClicked();
				}
			});
			panel_choice.add(btnCaissier);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(47, 79, 79));
			panel.setBounds(6, 6, 420, 42);
			panel_choice.add(panel);
			
			JLabel label_titre = new JLabel("Sur quelle fenetre voulez-vous etre redirigé ?");
			label_titre.setForeground(new Color(255, 255, 255));
			label_titre.setHorizontalAlignment(SwingConstants.CENTER);
			label_titre.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
			panel.add(label_titre);
			
		}

		private void onCaissierClicked() {
			CaissierUI caissier = new CaissierUI();
			caissier.run();
			this.dispose();
		}

		private void onAdminClicked() {
			AdminUi admin = new AdminUi();
			admin.lancer1();
			this.dispose();
		}

		public void show2() {
	    	this.setVisible(true); 
	    }
}