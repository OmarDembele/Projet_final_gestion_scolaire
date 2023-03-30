package sn.esmt.java.ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import sn.esmt.java.dataBase.DBUsers;
import sn.esmt.java.dataSource.Dao;
import sn.esmt.java.exception.DaoException;
import sn.esmt.java.model.Administrateur;
import sn.esmt.java.model.Caissier;
import sn.esmt.java.model.Personne;
import sn.esmt.java.model.Secretaire;
import sn.esmt.java.utils.Utilitaire;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;


import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Authentification extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel labelAuth;
	private JLabel ImageLabel;
	private JLabel labelLogin;
	private JLabel label_message;
	private JTextField textFieldLogin;
	private JLabel passwordLabel;
	private JButton buttonConnect;
	private JPasswordField passwordField;
	private JButton buttonQuitter;
	private Dao<Personne> dataSourceUser;

	public Authentification() {
		setTitle("authentification");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(600, 500));
		setResizable(false);
		createInstanceComponent();
		initComponent();
	}

	public void createInstanceComponent() {
		labelAuth = new JLabel("Authentification");
		labelAuth.setFont(new Font("Tahoma", Font.BOLD, 26));
		ImageLabel = new JLabel("");
		ImageLabel.setBackground(new Color(222, 156, 97));
		
	}

	public void initComponent() {
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, getSize());
	
		labelAuth.setBounds(193, 34, 244, 50);
		getContentPane().add(labelAuth);
		
		dataSourceUser = new DBUsers();
		
		labelLogin = new JLabel("Login :");
		labelLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		labelLogin.setBounds(99, 124, 145, 43);
		getContentPane().add(labelLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBackground(new Color(255, 255, 255));
		textFieldLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldLogin.setBounds(287, 124, 267, 37);
		getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		passwordLabel = new JLabel("Password :");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		passwordLabel.setBounds(99, 241, 138, 37);
		getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField.setBounds(287, 241, 267, 34);
		getContentPane().add(passwordField);
		
		buttonConnect = new JButton("Se Connecter");
		buttonConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					onConnectClicked();
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
		});
		buttonConnect.setBackground(new Color(255, 153, 51));
		buttonConnect.setAlignmentY(0.0f);
		buttonConnect.setForeground(new Color(0, 0, 0));
		buttonConnect.setFont(new Font("Tahoma", Font.BOLD, 20));
		buttonConnect.setBounds(99, 343, 177, 43);
		getContentPane().add(buttonConnect);
		
		buttonQuitter = new JButton("Quitter");
		buttonQuitter.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int retour=JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment quitter?","Quitter",JOptionPane.YES_NO_OPTION);			 	
				if (retour==0) {
					System.exit(0);
				}
			}
		});
		buttonQuitter.setBackground(new Color(255, 128, 0));
		buttonQuitter.setFont(new Font("Tahoma", Font.BOLD, 20));
		buttonQuitter.setAlignmentY(0.0f);
		buttonQuitter.setBounds(359, 343, 121, 43);
		getContentPane().add(buttonQuitter);
		
		
		ImageLabel.setBounds(0, 0, 586, 463);
		ImageLabel.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\scolaire_gif.gif"));
		ImageLabel.setPreferredSize(new Dimension(500, 450));
		getContentPane().add(ImageLabel);
		
		label_message = new JLabel("");
		label_message.setBounds(141, 407, 359, 37);
		getContentPane().add(label_message);
		
		}
	
	private void onConnectClicked() throws DaoException {		
		String username = textFieldLogin.getText();
		char [] tabPassword = passwordField.getPassword();
		String password=String.valueOf(tabPassword);
		
		List<Personne> log=dataSourceUser.list(); 
		for(Personne l: log) {
			if(username.equals(l.getLogin()) && password.equals(l.getPassword())) {
				if(l instanceof Secretaire && l.getRole().equals("SECRETAIRE")) {
					this.passwordField.setForeground(Color.green);
					this.textFieldLogin.setForeground(Color.green);
					this.label_message.setForeground(Color.green);
					SecretaireUIi secretaire = new SecretaireUIi();
					secretaire.run();
				    this.dispose();
			    }
				else if(l instanceof Caissier && l.getRole().equals("CAISSIER")){
					this.passwordField.setForeground(Color.green);
					this.textFieldLogin.setForeground(Color.green);
					this.label_message.setForeground(Color.green);
					ChoixCaissier caissier = new ChoixCaissier();
					caissier.show3();
					this.dispose();
			    }
				
				else if(l instanceof Administrateur && l.getRole().equals("ADMIN")){
					this.passwordField.setForeground(Color.green);
					this.textFieldLogin.setForeground(Color.green);
					this.label_message.setForeground(Color.green);
					ChoixAdmin admin = new ChoixAdmin();
					admin.show2();
					this.dispose();
				};
		}
			else {
				this.label_message.setForeground(Color.red);
				this.textFieldLogin.setBackground(Color.red);
				this.passwordField.setForeground(Color.white);
				this.textFieldLogin.setForeground(Color.white);
				this.label_message.setText("Erreur d'authentification");
			    }
		}
	}

	public void lancer() {
		this.setVisible(true);
	}
}
