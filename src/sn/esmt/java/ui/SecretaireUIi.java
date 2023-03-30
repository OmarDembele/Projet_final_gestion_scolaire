package sn.esmt.java.ui;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import sn.esmt.java.dataBase.DBManager;
import sn.esmt.java.dataBase.EleveDaoImple;
import sn.esmt.java.dataBase.ModuleDaoImpl;
import sn.esmt.java.dataBase.NoteDaoImpl;
import sn.esmt.java.dataBase.PayementDaoImpl;
import sn.esmt.java.dataSource.Dao;
import sn.esmt.java.exception.DaoException;
import sn.esmt.java.model.EleveModel;
import sn.esmt.java.model.Eleves;
import sn.esmt.java.model.Module;
import sn.esmt.java.model.NoteModel;
import sn.esmt.java.model.Notes;
import sn.esmt.java.model.Payement;
import sn.esmt.java.utils.Utilitaire;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class SecretaireUIi extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel PANEL_TITRE;
	private JPanel PANEL_LIST_BTN;
	private JLabel label_titre;
	private JButton addStudent;
	private JButton listEtudiants;
	private JButton exit_button;
	private JButton classeButton;
	private JPanel panel_1;
	private JButton notes_button;
	private JPanel MENUTAB;
	private JTabbedPane tabbedPane;
	private JButton acceuilButton;
	private JPanel ACCEUILSE;
	private JPanel PANELADD;
	private JPanel LISTETU;
	private JPanel LISTCLASS;
	private JLabel label_logos;
	private JPanel panel_9;
	private JLabel label_titre_formulaire;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JLabel label_details_personnels;
	private JPanel panel_15;
	private JPanel panel_16;
	private JLabel label_nom_inscription;
	private JTextField textField_lieu_inscription;
	private JLabel label_date_inscription;
	private JTextField textField_nom_inscription;
	private JLabel label_prenom_inscription;
	private JDateChooser textField_date_inscription;
	private JLabel label_lieu_inscription;
	private JTextField textField_prenom_inscription;
	private JLabel label_genre_inscription;
	private JRadioButton radio_masculin;
	private JRadioButton radio_feminin;
	private JTextField textField_adresse_inscription;
	private JLabel label_adresse_inscription;
	private JLabel label_details_etablissement;
	private JButton addButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JLabel label_email_inscription;
	private JTextField textField_email_inscription;
	private JLabel label_identifiant_inscription;
	private JTextField textField_identifiant_inscription;
	private JTextField textField_obs_inscription;
	private JTable table;
	private Dao<Payement> dataSourcePayement;
	private EleveModel model;
	private JComboBox<String> comboBox_section_inscription;
	private JComboBox<String> comboBox_classe_inscription;
	private Dao<Eleves> dataSourceEleve;
	private Dao<Notes> dataSourceNotes;
	private Dao<Module> dataSourceModule;
	private JPanel panel_8;
	private JPanel panel_18;
	private JLabel lblNewLabel_14;
	private JPanel panel_19;
	private JPanel panel_20;
	private JLabel label_titre_classe;
	private JPanel panel_21;
	private JPanel panel_22;
	private JButton afficherButton_classe;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	DefaultTableModel comboBoxmodel;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25;
	private JScrollPane scrollPane_2;
	private JTable table_2;
	private JButton button_clear_liste;
	private JComboBox<String> comboBox_classe2_liste;
	private JButton deleteButton_liste;
	private JLabel label_titre_liste;
	private JButton clearButton_2;
	private JLabel label_insertion_note;
	private JPanel panel_31;
	private JPanel panel_32;
	private JPanel panel_33;
	private JScrollPane scrollPane_3;
	private JLabel label_valeur_module_eleve_note;
	private JLabel label_id_eleve_note;
	private JLabel label_nom_eleve_note;
	private JLabel label_prenom_eleve_note;
	private JLabel label_cycle_eleve_note;
	private JLabel label_classe_eleve_note;
	private JLabel label_module_eleve_note;
	private JTextField textField_identifiant_note;
	private JTextField textField_nom_note;
	private JTextField textField_prenom_note;
	private JComboBox<String> comboBox_classe_note;
	private JTextField textField_valeur_module_note;
	private JButton button_save_note;
	private JComboBox<String> comboBox_module_note;
	private JTable table_3;
	private JButton button_bulletin_notes ;
	private JButton button_modifier_note;
	private JButton button_delete_note;
	private JButton button_chercher_bulletins;
	private JPanel BULLETIN;
	private NoteModel modelNote;
	private JComboBox<String> comboBox_cycle_note;
	private JComboBox<String> comboBox_cycle_eleve_bulletin ;
	private JButton button_clear_note;
	private JPanel panel_35;
	private JLabel label_titre_bulletin;
	private JPanel panel_36;
	private JPanel panel_37;
	private JTextField textField_id_eleve_bulletin;
	private JLabel label_cycle_eleve_bulletin;
	private JLabel label_nom_eleve_bulletin;
	private JLabel label_value_nom_eleve_bulletin;
	private JLabel label_prenom_eleve_bulletin;
	private JLabel label_value_prenom_eleve_bulletin;
	private JLabel label_value_genre_eleve_bulletin;
	private JLabel label_classe_eleve_bulletin;
	private JLabel label_value_classe_eleve_bulletin;
	private JPanel panel_39;
	private JScrollPane scrollPane_4;
	private JTable table_4;
	private JLabel label_moyenne_bulletin;
	private JLabel label_valeur_moyenne_bulletin;
	private JButton button_actualiser_note;
	private JLabel label;
	private JLabel label_coeff_eleve_note;
	private JTextField textField_coeff_note_eleve;
	private JLabel label_logo;

	public SecretaireUIi() {
		setTitle("Secretaire");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(1300, 700));
		createInstanceComponent();
		initComponent();
	}
	
	public void createInstanceComponent() {
		PANEL_TITRE = new JPanel();
		PANEL_TITRE.setBounds(268, 0, 1015, 90);
		PANEL_TITRE.setBorder(new LineBorder(new Color(0, 100, 0), 2));
		PANEL_TITRE.setLayout(null);
		
		label_titre = new JLabel("Bienvenue sur le portail du sécretaire");
		label_titre.setBounds(266, 13, 639, 70);
		label_titre.setHorizontalAlignment(SwingConstants.LEFT);
		label_titre.setHorizontalTextPosition(SwingConstants.CENTER);
		label_titre.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label_titre.setAlignmentY(0.0f);
		label_titre.setPreferredSize(new Dimension(350, 30));
		PANEL_TITRE.add(label_titre);
		notes_button = new JButton("Notes");
		notes_button.setBorder(UIManager.getBorder("Button.border"));
		notes_button.setBounds(39, 457, 190, 55);
		label_logos = new JLabel("");
		label_logos.setBackground(new Color(47, 79, 79));
		acceuilButton = new JButton("Acceuil");
		acceuilButton.setBorder(UIManager.getBorder("Button.border"));
		acceuilButton.setBounds(39, 153, 190, 50);
		acceuilButton.setBackground(Color.LIGHT_GRAY);
		radio_masculin = new JRadioButton("Masculin");
		radio_masculin.setBackground(SystemColor.window);
		radio_feminin = new JRadioButton("Feminin");
		radio_feminin.setBackground(SystemColor.window);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radio_masculin);
		buttonGroup.add(radio_feminin);
		dataSourceEleve = new EleveDaoImple();
		dataSourceModule = new ModuleDaoImpl();
		dataSourceNotes = new NoteDaoImpl();
		dataSourcePayement = new PayementDaoImpl();
		model = new EleveModel();
		modelNote = new NoteModel();
		try {
			model.setEtudiants(dataSourceEleve.list());
			modelNote.setNotes(dataSourceNotes.list());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBackground(SystemColor.menu);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setPreferredSize(new Dimension(0, 190));
		table_2 = new JTable();
		table_2.setBorder(new LineBorder(new Color(47, 79, 79), 3));
		table_2.setBackground(SystemColor.menu);
		table_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_3 = new JTable();
		table_3.setBorder(new LineBorder(SystemColor.inactiveCaption));
		table_3.setPreferredScrollableViewportSize(new Dimension(400, 375));
		table_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_3.setBackground(SystemColor.menu);
		comboBox_section_inscription = new JComboBox<String>();
		comboBox_classe_inscription = new JComboBox<String>();
		addButton = new JButton("Ajouter");
		addButton.setBackground(SystemColor.menu);
		updateButton = new JButton("Modifier");
		updateButton.setBackground(SystemColor.menu);
		deleteButton = new JButton("Supprimer");
		deleteButton.setBackground(SystemColor.menu);
		comboBoxmodel= new DefaultTableModel();
		button_bulletin_notes = new JButton("Bulletin de notes");
		button_modifier_note = new JButton("Modifier");
		button_save_note = new JButton("Enregistrer");
		button_save_note.setBounds(109, 431, 159, 42);
		button_save_note.setBackground(SystemColor.activeCaption);
		button_delete_note = new JButton("Supprimer");
		deleteButton_liste = new JButton("Supprimer");
		deleteButton_liste.setBorder(new LineBorder(new Color(47, 79, 79)));
		deleteButton_liste.setBounds(10, 199, 107, 45);
		deleteButton_liste.setBackground(Color.WHITE);
		button_clear_note = new JButton("Clear");
		button_chercher_bulletins = new JButton("Chercher");
		button_chercher_bulletins.setBackground(SystemColor.activeCaption);
		button_actualiser_note = new JButton("Actualiser");
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox_classe_note = new JComboBox<String>();
		comboBox_classe_note.setBounds(175, 223, 174, 42);
		comboBox_classe_note.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_module_note = new JComboBox<String>();
		comboBox_module_note.setBounds(175, 275, 174, 42);
		comboBox_module_note.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_classe2_liste = new JComboBox<String>();
		comboBox_classe2_liste.setBorder(new LineBorder(new Color(47, 79, 79), 2));
		comboBox_classe2_liste.setBounds(10, 41, 107, 45);
		comboBox_classe2_liste.setBackground(new Color(255, 255, 255));
		comboBox_cycle_eleve_bulletin = new JComboBox<String>();
		textField_id_eleve_bulletin = new JTextField();
		label_cycle_eleve_bulletin = new JLabel("Cycle :");
		label_nom_eleve_bulletin = new JLabel("Nom :");
		label_value_nom_eleve_bulletin = new JLabel("");
		label_prenom_eleve_bulletin = new JLabel("Prenom :");
		label_value_prenom_eleve_bulletin = new JLabel("");
		label_value_genre_eleve_bulletin = new JLabel("");
		label_classe_eleve_bulletin = new JLabel("Classe :");
		label_value_classe_eleve_bulletin = new JLabel("");
	}
	
	public void initComponent() {
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, getSize());
		getContentPane().setLayout(null);
		
		
		PANEL_TITRE.setBackground(SystemColor.window);
		PANEL_TITRE.setPreferredSize(new Dimension(0, 90));
		getContentPane().add(PANEL_TITRE);
		
		PANEL_LIST_BTN = new JPanel();
		PANEL_LIST_BTN.setBounds(0, 0, 268, 663);
		PANEL_LIST_BTN.setBackground(new Color(211, 211, 211));
		PANEL_LIST_BTN.setPreferredSize(new Dimension(268, 10));
		getContentPane().add(PANEL_LIST_BTN);
		PANEL_LIST_BTN.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 268, 663);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setPreferredSize(new Dimension(268, 50));
		PANEL_LIST_BTN.add(panel_1);
		
		
		acceuilButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		acceuilButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onAcceuilClicked();
				
			}
		});
		panel_1.setLayout(null);
		acceuilButton.setPreferredSize(new Dimension(100, 50));
		panel_1.add(acceuilButton);
		
		addStudent = new JButton("Inscription");
		addStudent.setBorder(UIManager.getBorder("Button.border"));
		addStudent.setBounds(39, 223, 191, 55);
		addStudent.setBackground(Color.LIGHT_GRAY);
		addStudent.setForeground(new Color(0, 0, 0));
		addStudent.setMargin(new Insets(10, 14, 2, 14));
		addStudent.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_1.add(addStudent);
		addStudent.setPreferredSize(new Dimension(100, 50));
		addStudent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onRegisterClicked();
				
			}
		});
		addStudent.setIcon(null);
		
		listEtudiants = new JButton("Liste des Etudiants");
		listEtudiants.setBounds(39, 303, 190, 55);
		listEtudiants.setBackground(Color.LIGHT_GRAY);
		listEtudiants.setForeground(new Color(0, 0, 0));
		listEtudiants.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		panel_1.add(listEtudiants);
		listEtudiants.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onListClicked();
				
			}
		});
		listEtudiants.setIcon(null);
		classeButton = new JButton("Classes");
		classeButton.setBounds(39, 378, 190, 55);
		classeButton.setBackground(Color.LIGHT_GRAY);
		classeButton.setForeground(new Color(0, 0, 0));
		classeButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		classeButton.setPreferredSize(new Dimension(100, 50));
		panel_1.add(classeButton);
		
		
		classeButton.setIcon(null);
		classeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onclasseClicked();	
			}
		});
		
		
		notes_button.setBackground(Color.LIGHT_GRAY);
		notes_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onNoteClicked();
			}
		});
		
		notes_button.setForeground(new Color(0, 0, 0));
		notes_button.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		panel_1.add(notes_button);
		
		exit_button = new JButton("Deconnection");
		exit_button.setBounds(39, 534, 190, 55);
		exit_button.setBackground(Color.RED);
		exit_button.setForeground(new Color(0, 0, 0));
		exit_button.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(exit_button);
		exit_button.setIcon(null);
		
		label_logo = new JLabel("");
		label_logo.setHorizontalAlignment(SwingConstants.CENTER);
		label_logo.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\logo_secretariat.png"));
		label_logo.setBounds(6, 6, 241, 144);
		panel_1.add(label_logo);
		
		MENUTAB = new JPanel();
		MENUTAB.setBackground(new Color(0, 0, 0));
		MENUTAB.setBounds(268, 90, 1018, 573);
		MENUTAB.setBorder(null);
		getContentPane().add(MENUTAB);
		MENUTAB.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(47, 79, 79)));
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(2, -32, 1015, 603);
		tabbedPane.setPreferredSize(new Dimension(1015, 565));
		MENUTAB.add(tabbedPane);
		
		ACCEUILSE = new JPanel();
		ACCEUILSE.setBackground(new Color(244, 164, 96));
		ACCEUILSE.setPreferredSize(new Dimension(100, 100));
		tabbedPane.addTab(null, null, ACCEUILSE, null);
		ACCEUILSE.setLayout(null);
		
		label_logos.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\scolaire_gif.gif"));
		label_logos.setBounds(0, 0, 1007, 573);
		ACCEUILSE.add(label_logos);
		
		PANELADD = new JPanel();
		
		tabbedPane.addTab("", null, PANELADD, "");
		tabbedPane.setDisabledIconAt(1, null);
		PANELADD.setLayout(new BorderLayout(0, 0));
		
		panel_9 = new JPanel();
		panel_9.setBackground(new Color(47, 79, 79));
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setPreferredSize(new Dimension(10, 30));
		PANELADD.add(panel_9, BorderLayout.NORTH);
		
		label_titre_formulaire = new JLabel("Formulaire d'inscription");
		label_titre_formulaire.setForeground(new Color(255, 255, 255));
		label_titre_formulaire.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre_formulaire.setFont(new Font("Times New Roman", Font.BOLD, 23));
		label_titre_formulaire.setPreferredSize(new Dimension(300, 20));
		panel_9.add(label_titre_formulaire);
		
		panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.controlHighlight);
		panel_10.setPreferredSize(new Dimension(10, 220));
		PANELADD.add(panel_10, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.controlHighlight);
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setPreferredSize(new Dimension(1010, 219));
		panel_10.add(scrollPane);
		

		table.setModel(model);
		scrollPane.setColumnHeaderView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {				
				onValueChanged ();
			}
		});
		scrollPane.setViewportView(table);
		
		panel_11 = new JPanel();
		panel_11.setBackground(SystemColor.controlHighlight);
		PANELADD.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_12.setPreferredSize(new Dimension(150, 50));
		panel_11.add(panel_12, BorderLayout.WEST);
		panel_12.setLayout(new GridLayout(4, 1, 0, 0));
		
		
		addButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onAddClicked();
				
			}
		});
		panel_12.add(addButton);
		
		
		updateButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		updateButton.setEnabled(false);
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				onUpdateClicked();
				onUpdateClicked2();
				
			}
		});
		panel_12.add(updateButton);
		
		
		deleteButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onDeleteClicked();
			}
		});
		panel_12.add(deleteButton);
		
		clearButton_2 = new JButton("Clear");
		clearButton_2.setBackground(SystemColor.menu);
		clearButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClearClicked();
				
			}
		});
		clearButton_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		panel_12.add(clearButton_2);
		exit_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onExitClicked();
			}
		});
		
		panel_13 = new JPanel();
		panel_11.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		panel_14 = new JPanel();
		panel_14.setForeground(Color.WHITE);
		panel_14.setBackground(new Color(47, 79, 79));
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		FlowLayout flowLayout = (FlowLayout) panel_14.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_14.setPreferredSize(new Dimension(10, 25));
		panel_13.add(panel_14, BorderLayout.NORTH);
		
		label_details_personnels = new JLabel("Details Personnels");
		label_details_personnels.setForeground(new Color(255, 255, 255));
		label_details_personnels.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_details_personnels.setPreferredSize(new Dimension(150, 17));
		panel_14.add(label_details_personnels);
		
		panel_15 = new JPanel();
		panel_15.setBackground(new Color(47, 79, 79));
		panel_15.setBorder(new LineBorder(Color.GRAY));
		panel_15.setPreferredSize(new Dimension(10, 115));
		panel_13.add(panel_15, BorderLayout.SOUTH);
		panel_15.setLayout(null);
		
		label_details_etablissement = new JLabel("Details Etablissement");
		label_details_etablissement.setForeground(new Color(255, 255, 255));
		label_details_etablissement.setBackground(Color.WHITE);
		label_details_etablissement.setAlignmentY(5.0f);
		label_details_etablissement.setAlignmentX(3.0f);
		label_details_etablissement.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_details_etablissement.setBounds(0, 0, 510, 27);
		panel_15.add(label_details_etablissement);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_17.setBackground(SystemColor.menu);
		panel_17.setBounds(0, 27, 860, 88);
		panel_15.add(panel_17);
		panel_17.setLayout(null);
		
		JLabel label_section_inscription = new JLabel("Section :");
		label_section_inscription.setBackground(SystemColor.activeCaption);
		label_section_inscription.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_section_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		label_section_inscription.setBounds(0, 0, 215, 44);
		panel_17.add(label_section_inscription);
		
		
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Salle_Classe";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				comboBox_classe_inscription.addItem(rs.getString("nom_classe"));
				comboBox_classe2_liste.addItem(rs.getString("nom_classe"));
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Salle_Classe where nom_classe!='Creche' AND nom_classe!='TPS' AND nom_classe!='PS' AND nom_classe!='MS' AND nom_classe!='GS' ";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				comboBox_classe_note.addItem(rs.getString("nom_classe"));
				
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Section ";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				comboBox_section_inscription.addItem(rs.getString("nom_section"));
				
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Module";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				comboBox_module_note.addItem(rs.getString("nom_module"));
				
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		comboBox_section_inscription.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_section_inscription.setBounds(215, 0, 215, 44);
		panel_17.add(comboBox_section_inscription);
		
		JLabel label_classe_inscription = new JLabel("Classe :");
		label_classe_inscription.setBackground(SystemColor.inactiveCaption);
		label_classe_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		label_classe_inscription.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_classe_inscription.setBounds(430, 0, 215, 44);
		panel_17.add(label_classe_inscription);
		
		
		comboBox_classe_inscription.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_classe_inscription.setBounds(645, 0, 215, 44);
		panel_17.add(comboBox_classe_inscription);
		
		JLabel lblObservationInscription = new JLabel("Observation inscription");
		lblObservationInscription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblObservationInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservationInscription.setBounds(0, 44, 215, 44);
		panel_17.add(lblObservationInscription);
		
		textField_obs_inscription = new JTextField();
		textField_obs_inscription.setBackground(SystemColor.window);
		textField_obs_inscription.setEnabled(false);
		textField_obs_inscription.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_obs_inscription.setBounds(215, 44, 351, 44);
		panel_17.add(textField_obs_inscription);
		textField_obs_inscription.setColumns(10);
		
		panel_16 = new JPanel();
		panel_16.setBackground(SystemColor.menu);
		panel_16.setBorder(null);
		panel_13.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(null);
		
		label_nom_inscription = new JLabel("Nom :");
		label_nom_inscription.setBounds(2, 1, 214, 29);
		label_nom_inscription.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_nom_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		panel_16.add(label_nom_inscription);
		
		textField_nom_inscription = new JTextField();
		textField_nom_inscription.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_nom_inscription.setBounds(216, 1, 214, 29);
		panel_16.add(textField_nom_inscription);
		textField_nom_inscription.setColumns(10);
		
		label_prenom_inscription = new JLabel("Prenom :");
		label_prenom_inscription.setBackground(SystemColor.activeCaption);
		label_prenom_inscription.setBounds(430, 1, 214, 29);
		label_prenom_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		label_prenom_inscription.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_16.add(label_prenom_inscription);
		
		textField_prenom_inscription = new JTextField();
		textField_prenom_inscription.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_prenom_inscription.setBounds(644, 1, 214, 29);
		panel_16.add(textField_prenom_inscription);
		textField_prenom_inscription.setColumns(10);
		
		label_date_inscription = new JLabel("Date naissance :");
		label_date_inscription.setBounds(2, 30, 214, 29);
		label_date_inscription.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_date_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		panel_16.add(label_date_inscription);
		
		textField_date_inscription = new JDateChooser();
		textField_date_inscription.setDateFormatString("yyyy-MM-dd");
		textField_date_inscription.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_date_inscription.setBounds(216, 30, 214, 29);
		panel_16.add(textField_date_inscription);
		//textField_date_inscription.set;
		
		label_lieu_inscription = new JLabel("Lieu naissance :");
		label_lieu_inscription.setBounds(430, 30, 214, 29);
		label_lieu_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		label_lieu_inscription.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_16.add(label_lieu_inscription);
		
		textField_lieu_inscription = new JTextField();
		textField_lieu_inscription.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_lieu_inscription.setBounds(644, 30, 214, 29);
		panel_16.add(textField_lieu_inscription);
		textField_lieu_inscription.setColumns(10);
		
		label_email_inscription = new JLabel("Email :");
		label_email_inscription.setBounds(2, 59, 214, 29);
		label_email_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		label_email_inscription.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_16.add(label_email_inscription);
		
		textField_email_inscription = new JTextField();
		textField_email_inscription.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_email_inscription.setBounds(216, 59, 214, 29);
		panel_16.add(textField_email_inscription);
		textField_email_inscription.setColumns(10);
		
		label_identifiant_inscription = new JLabel("Identifiant :");
		label_identifiant_inscription.setBounds(430, 59, 214, 29);
		label_identifiant_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		label_identifiant_inscription.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_16.add(label_identifiant_inscription);
		
		textField_identifiant_inscription = new JTextField();
		textField_identifiant_inscription.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_identifiant_inscription.setBounds(644, 59, 214, 29);
		panel_16.add(textField_identifiant_inscription);
		textField_identifiant_inscription.setColumns(10);
		
		label_genre_inscription = new JLabel("Genre :");
		label_genre_inscription.setBounds(2, 88, 214, 29);
		label_genre_inscription.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label_genre_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		panel_16.add(label_genre_inscription);
		
		
		radio_masculin.setBounds(216, 88, 214, 29);
		radio_masculin.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_16.add(radio_masculin);
		
		
		radio_feminin.setBounds(430, 88, 214, 29);
		radio_feminin.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_16.add(radio_feminin);
		
		textField_adresse_inscription = new JTextField();
		textField_adresse_inscription.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_adresse_inscription.setBounds(216, 117, 318, 29);
		panel_16.add(textField_adresse_inscription);
		textField_adresse_inscription.setColumns(10);
		
		label_adresse_inscription = new JLabel("Adresse :");
		label_adresse_inscription.setBounds(2, 117, 214, 29);
		label_adresse_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		label_adresse_inscription.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_16.add(label_adresse_inscription);
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBackground(new Color(47, 79, 79));
		scrollPane_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		
		LISTETU = new JPanel();
		tabbedPane.addTab("New tab", null, LISTETU, null);
		LISTETU.setLayout(new BorderLayout(0, 0));
		
		panel_23 = new JPanel();
		panel_23.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_23.setBackground(new Color(47, 79, 79));
		panel_23.setPreferredSize(new Dimension(10, 45));
		LISTETU.add(panel_23, BorderLayout.NORTH);
		
		label_titre_liste = new JLabel("La liste des Eleves");
		label_titre_liste.setForeground(new Color(255, 255, 255));
		label_titre_liste.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre_liste.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label_titre_liste.setPreferredSize(new Dimension(400, 38));
		panel_23.add(label_titre_liste);
		
		panel_24 = new JPanel();
		panel_24.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_24.setBackground(SystemColor.menu);
		panel_24.setAlignmentY(5.0f);
		panel_24.setAlignmentX(5.0f);
		panel_24.setPreferredSize(new Dimension(125, 10));
		LISTETU.add(panel_24, BorderLayout.WEST);
		

		comboBox_classe2_liste.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_classe2_liste.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				onListClassClicked(arg0);
				
			}
		});
		panel_24.setLayout(null);
		comboBox_classe2_liste.setAlignmentY(5.0f);
		comboBox_classe2_liste.setAlignmentX(5.0f);
		panel_24.add(comboBox_classe2_liste);
		
		button_clear_liste = new JButton("Clear");
		button_clear_liste.setBorder(new LineBorder(new Color(47, 79, 79)));
		button_clear_liste.setBounds(10, 120, 107, 45);
		button_clear_liste.setBackground(Color.WHITE);
		button_clear_liste.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		panel_24.add(button_clear_liste);
		
		
		deleteButton_liste.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		deleteButton_liste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onDeleteClicked();
				
			}
		});
		panel_24.add(deleteButton_liste);
		
		panel_25 = new JPanel();
		panel_25.setBackground(SystemColor.menu);
		panel_25.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		LISTETU.add(panel_25, BorderLayout.CENTER);
		
		
		scrollPane_2.setPreferredSize(new Dimension(883, 487));
		panel_25.add(scrollPane_2);
		
		
		table_2.setPreferredSize(new Dimension(465, 463));
		table_2.setModel(model);
		scrollPane_2.setColumnHeaderView(table_2);
		table_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
		scrollPane_2.setViewportView(table_2);
		afficherButton_classe = new JButton("Afficher");
		afficherButton_classe.setBackground(Color.WHITE);
		scrollPane_1 = new JScrollPane();
		table_1 = new JTable();
		table_1.setFillsViewportHeight(true);
		table_1.setBackground(SystemColor.menu);
		
		LISTCLASS = new JPanel();
		LISTCLASS.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, LISTCLASS, null);
		LISTCLASS.setLayout(new BorderLayout(0, 0));
		
		panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(47, 79, 79), 0));
		panel_8.setBackground(SystemColor.menu);
		panel_8.setPreferredSize(new Dimension(505, 40));
		LISTCLASS.add(panel_8, BorderLayout.WEST);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		panel_19 = new JPanel();
		panel_19.setBackground(new Color(47, 79, 79));
		panel_19.setBorder(new LineBorder(Color.GRAY));
		panel_19.setPreferredSize(new Dimension(10, 425));
		panel_8.add(panel_19, BorderLayout.SOUTH);
		
	
		scrollPane_1.setPreferredSize(new Dimension(500, 420));
		panel_19.add(scrollPane_1);
		table_1.setPreferredSize(new Dimension(500, 420));
		scrollPane_1.setColumnHeaderView(table_1);
		
		panel_20 = new JPanel();
		panel_20.setPreferredSize(new Dimension(10, 112));
		panel_8.add(panel_20, BorderLayout.NORTH);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		panel_21 = new JPanel();
		panel_21.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_21.setBackground(new Color(47, 79, 79));
		panel_21.setPreferredSize(new Dimension(10, 50));
		panel_20.add(panel_21, BorderLayout.NORTH);
		
		label_titre_classe = new JLabel("La liste des classses");
		label_titre_classe.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre_classe.setForeground(new Color(255, 255, 255));
		panel_21.add(label_titre_classe);
		label_titre_classe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label_titre_classe.setPreferredSize(new Dimension(290, 40));
		
		panel_22 = new JPanel();
		panel_22.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_22.setBackground(SystemColor.menu);
		FlowLayout flowLayout_1 = (FlowLayout) panel_22.getLayout();
		flowLayout_1.setHgap(15);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_22.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_22.setPreferredSize(new Dimension(10, 61));
		panel_20.add(panel_22, BorderLayout.SOUTH);
		
		
		
		panel_22.add(afficherButton_classe);
		
		panel_18 = new JPanel();
		panel_18.setBorder(new LineBorder(new Color(47, 79, 79), 2));
		panel_18.setBackground(SystemColor.menu);
		panel_18.setPreferredSize(new Dimension(505, 10));
		LISTCLASS.add(panel_18, BorderLayout.EAST);
		panel_18.setLayout(null);
		
		lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setBackground(SystemColor.menu);
		lblNewLabel_14.setBounds(108, 5, 296, 533);
		lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\-school_90226.png"));
		lblNewLabel_14.setPreferredSize(new Dimension(500, 533));
		panel_18.add(lblNewLabel_14);
		
		table_1.setRowMargin(5);
		table_1.setPreferredSize(new Dimension(10, 10));
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane_1.setViewportView(table_1);
		
		afficherButton_classe.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		afficherButton_classe.setPreferredSize(new Dimension(95, 50));
		afficherButton_classe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onAfficherClicked(arg0);
				
			}
		});
		
		Object[] colums= {"id_classe", "nom_classe" };
		comboBoxmodel.setColumnIdentifiers(colums);
		
		
		// -----------------------------------------------------------------------------
		// Interface graphique des notes
		
		JPanel SAVENOTE = new JPanel();
		SAVENOTE.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("New tab", null, SAVENOTE, null);
		SAVENOTE.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_27 = new JPanel();
		panel_27.setBackground(new Color(47, 79, 79));
		panel_27.setBorder(new LineBorder(Color.GRAY));
		panel_27.setPreferredSize(new Dimension(10, 30));
		SAVENOTE.add(panel_27, BorderLayout.NORTH);
		
		JLabel label_titre_note = new JLabel("Enregistrement des notes");
		label_titre_note.setForeground(new Color(255, 255, 255));
		label_titre_note.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre_note.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_titre_note.setPreferredSize(new Dimension(450, 22));
		panel_27.add(label_titre_note);
		
		JPanel panel_28 = new JPanel();
		panel_28.setPreferredSize(new Dimension(350, 10));
		SAVENOTE.add(panel_28, BorderLayout.WEST);
		panel_28.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_29 = new JPanel();
		panel_29.setBackground(new Color(47, 79, 79));
		panel_29.setBorder(new LineBorder(Color.GRAY));
		panel_29.setPreferredSize(new Dimension(10, 400));
		panel_28.add(panel_29, BorderLayout.CENTER);
		panel_29.setLayout(null);
		
		label_id_eleve_note = new JLabel("Identifiant Eleve");
		label_id_eleve_note.setForeground(new Color(255, 255, 255));
		label_id_eleve_note.setBounds(1, 5, 174, 52);
		label_id_eleve_note.setHorizontalAlignment(SwingConstants.CENTER);
		label_id_eleve_note.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_29.add(label_id_eleve_note);
		
		textField_identifiant_note = new JTextField();
		textField_identifiant_note.setBounds(175, 10, 174, 47);
		textField_identifiant_note.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_29.add(textField_identifiant_note);
		textField_identifiant_note.setColumns(10);
		
		label_nom_eleve_note = new JLabel("Nom :");
		label_nom_eleve_note.setForeground(new Color(255, 255, 255));
		label_nom_eleve_note.setBounds(1, 57, 174, 52);
		label_nom_eleve_note.setHorizontalAlignment(SwingConstants.CENTER);
		label_nom_eleve_note.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_29.add(label_nom_eleve_note);
		
		textField_nom_note = new JTextField();
		textField_nom_note.setBounds(175, 67, 174, 42);
		textField_nom_note.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_29.add(textField_nom_note);
		textField_nom_note.setColumns(10);
		
		label_prenom_eleve_note = new JLabel("Prenom :");
		label_prenom_eleve_note.setForeground(new Color(255, 255, 255));
		label_prenom_eleve_note.setBounds(1, 109, 174, 52);
		label_prenom_eleve_note.setHorizontalAlignment(SwingConstants.CENTER);
		label_prenom_eleve_note.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_29.add(label_prenom_eleve_note);
		
		textField_prenom_note = new JTextField();
		textField_prenom_note.setBounds(175, 119, 174, 42);
		textField_prenom_note.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_29.add(textField_prenom_note);
		textField_prenom_note.setColumns(10);
		
		label_cycle_eleve_note = new JLabel("Cycle :");
		label_cycle_eleve_note.setForeground(new Color(255, 255, 255));
		label_cycle_eleve_note.setBounds(1, 161, 174, 52);
		label_cycle_eleve_note.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_cycle_eleve_note.setHorizontalAlignment(SwingConstants.CENTER);
		panel_29.add(label_cycle_eleve_note);
		comboBox_cycle_note = new JComboBox<String>();
		comboBox_cycle_note.setBounds(175, 166, 174, 47);
		
		
		comboBox_cycle_note.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBox_cycle_note.setModel(new DefaultComboBoxModel<String>(new String[] {"Semestre1", "Semestre2"}));
		panel_29.add(comboBox_cycle_note);
		
		label_classe_eleve_note = new JLabel("Classe :");
		label_classe_eleve_note.setForeground(new Color(255, 255, 255));
		label_classe_eleve_note.setBounds(1, 213, 174, 52);
		label_classe_eleve_note.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_classe_eleve_note.setHorizontalAlignment(SwingConstants.CENTER);
		panel_29.add(label_classe_eleve_note);
		panel_29.add(comboBox_classe_note);
		
		label_module_eleve_note = new JLabel("Module :");
		label_module_eleve_note.setForeground(new Color(255, 255, 255));
		label_module_eleve_note.setBounds(1, 265, 174, 52);
		label_module_eleve_note.setHorizontalAlignment(SwingConstants.CENTER);
		label_module_eleve_note.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_29.add(label_module_eleve_note);
		panel_29.add(comboBox_module_note);
		
		label_coeff_eleve_note = new JLabel("Coefficient");
		label_coeff_eleve_note.setForeground(new Color(255, 255, 255));
		label_coeff_eleve_note.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_coeff_eleve_note.setHorizontalAlignment(SwingConstants.CENTER);
		label_coeff_eleve_note.setBounds(1, 317, 174, 52);
		panel_29.add(label_coeff_eleve_note);
		
		label_valeur_module_eleve_note = new JLabel("Note module :");
		label_valeur_module_eleve_note.setForeground(new Color(255, 255, 255));
		label_valeur_module_eleve_note.setBounds(1, 369, 174, 52);
		label_valeur_module_eleve_note.setHorizontalAlignment(SwingConstants.CENTER);
		label_valeur_module_eleve_note.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_29.add(label_valeur_module_eleve_note);
		
		textField_valeur_module_note = new JTextField();
		textField_valeur_module_note.setBounds(175, 379, 174, 42);
		textField_valeur_module_note.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_29.add(textField_valeur_module_note);
		textField_valeur_module_note.setColumns(10);
		

		button_save_note.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_save_note.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					try {
						onSaveNoteClicked();
					} catch (DaoException e) {
						e.printStackTrace();
					}
			}
		});
		panel_29.add(button_save_note);
		
		label = new JLabel("");
		label.setBounds(175, 421, 174, 52);
		panel_29.add(label);
		
		textField_coeff_note_eleve = new JTextField();
		textField_coeff_note_eleve.setHorizontalAlignment(SwingConstants.LEFT);
		textField_coeff_note_eleve.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_coeff_note_eleve.setBounds(175, 327, 174, 42);
		panel_29.add(textField_coeff_note_eleve);
		textField_coeff_note_eleve.setColumns(10);
		
		JPanel panel_30 = new JPanel();
		panel_30.setBackground(new Color(47, 79, 79));
		panel_30.setBorder(new LineBorder(Color.GRAY));
		panel_30.setPreferredSize(new Dimension(10, 30));
		panel_28.add(panel_30, BorderLayout.NORTH);
		
		label_insertion_note = new JLabel("Formulaire d'insertion");
		label_insertion_note.setBackground(new Color(214, 217, 223));
		label_insertion_note.setForeground(new Color(255, 255, 255));
		label_insertion_note.setPreferredSize(new Dimension(250, 23));
		label_insertion_note.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_insertion_note.setHorizontalAlignment(SwingConstants.CENTER);
		panel_30.add(label_insertion_note);
		
		panel_31 = new JPanel();
		panel_31.setPreferredSize(new Dimension(660, 10));
		SAVENOTE.add(panel_31, BorderLayout.EAST);
		panel_31.setLayout(new BorderLayout(0, 0));
		
		panel_32 = new JPanel();
		panel_32.setBackground(SystemColor.menu);
		panel_32.setBorder(new LineBorder(Color.GRAY));
		panel_32.setPreferredSize(new Dimension(10, 60));
		panel_31.add(panel_32, BorderLayout.NORTH);
		panel_32.setLayout(null);
		
		
		button_bulletin_notes.setBounds(10, 5, 160, 40);
		button_bulletin_notes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onBulletinClicked();
				
			}
		});
		button_bulletin_notes.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_bulletin_notes.setPreferredSize(new Dimension(175, 50));
		panel_32.add(button_bulletin_notes);
		
		
		button_modifier_note.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_modifier_note.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onUpdateNoteClicked();
				
			}
		});
		button_modifier_note.setBounds(436, 5, 89, 40);
		button_modifier_note.setEnabled(false);
		button_modifier_note.setPreferredSize(new Dimension(85, 50));
		panel_32.add(button_modifier_note);
		
		
		button_delete_note.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_delete_note.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onDeleteClicked();
				
			}
		});
		button_delete_note.setBounds(540, 5, 90, 40);
		button_delete_note.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onDeleteNoteClicked();
				
			}
		});
		button_delete_note.setPreferredSize(new Dimension(85, 50));
		panel_32.add(button_delete_note);
		
		
		button_clear_note.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_clear_note.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClearNoteClicked();
				
			}
		});
		button_clear_note.setBounds(339, 5, 85, 40);
		panel_32.add(button_clear_note);
		
		panel_33 = new JPanel();
		panel_33.setBackground(SystemColor.menu);
		panel_33.setBorder(new LineBorder(Color.GRAY));
		panel_31.add(panel_33, BorderLayout.CENTER);
		
		scrollPane_3.setPreferredSize(new Dimension(659, 443));
		panel_33.add(scrollPane_3);
		
		table_3.setPreferredSize(new Dimension(0, 418));
		table_3.setModel(modelNote);
		table_3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {				
				onValueChanged1 ();
			}
		});
		scrollPane_3.setViewportView(table_3);
		//----------------------------------------------------------------------------
		// Interface graphique des bulletins de notes
		
		BULLETIN = new JPanel();
		tabbedPane.addTab("New tab", null, BULLETIN, null);
		BULLETIN.setLayout(new BorderLayout(0, 0));
		
		panel_35 = new JPanel();
		panel_35.setBackground(new Color(47, 79, 79));
		panel_35.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_35.setPreferredSize(new Dimension(10, 35));
		BULLETIN.add(panel_35, BorderLayout.NORTH);
		
		label_titre_bulletin = new JLabel("Bulletin de Notes");
		label_titre_bulletin.setForeground(Color.BLACK);
		label_titre_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre_bulletin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_titre_bulletin.setPreferredSize(new Dimension(350, 30));
		panel_35.add(label_titre_bulletin);
		
		panel_36 = new JPanel();
		panel_36.setPreferredSize(new Dimension(10, 350));
		BULLETIN.add(panel_36, BorderLayout.SOUTH);
		panel_36.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_38 = new JPanel();
		panel_38.setBackground(SystemColor.controlHighlight);
		FlowLayout flowLayout_2 = (FlowLayout) panel_38.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_38.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_38.setPreferredSize(new Dimension(10, 55));
		panel_36.add(panel_38, BorderLayout.SOUTH);
		
		label_moyenne_bulletin = new JLabel("Moyenne Generale :");
		label_moyenne_bulletin.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_moyenne_bulletin.setPreferredSize(new Dimension(300, 45));
		label_moyenne_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_38.add(label_moyenne_bulletin);
		
		label_valeur_moyenne_bulletin = new JLabel("");
		label_valeur_moyenne_bulletin.setForeground(new Color(255, 0, 0));
		label_valeur_moyenne_bulletin.setPreferredSize(new Dimension(150, 45));
		label_valeur_moyenne_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_valeur_moyenne_bulletin.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_38.add(label_valeur_moyenne_bulletin);
		
		panel_39 = new JPanel();
		panel_39.setBackground(new Color(47, 79, 79));
		panel_39.setBorder(new LineBorder(Color.GRAY));
		panel_36.add(panel_39, BorderLayout.CENTER);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane_4.setPreferredSize(new Dimension(1010, 289));
		panel_39.add(scrollPane_4);
		
		table_4 = new JTable();
		table_4.setBorder(new LineBorder(new Color(47, 79, 79)));
		table_4.setBackground(SystemColor.menu);
		table_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_4.setPreferredSize(new Dimension(0, 287));
		scrollPane_4.setViewportView(table_4);
		
		panel_37 = new JPanel();
		panel_37.setBackground(SystemColor.menu);
		panel_37.setBorder(new LineBorder(new Color(0, 0, 0)));
		BULLETIN.add(panel_37, BorderLayout.CENTER);
		panel_37.setLayout(null);
		
		JLabel label_id_eleve_bulletin = new JLabel("Identifiant Eleve :");
		label_id_eleve_bulletin.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_id_eleve_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_id_eleve_bulletin.setBounds(10, 10, 160, 42);
		panel_37.add(label_id_eleve_bulletin);
		

		textField_id_eleve_bulletin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_id_eleve_bulletin.setBounds(182, 10, 119, 42);
		panel_37.add(textField_id_eleve_bulletin);
		textField_id_eleve_bulletin.setColumns(10);
		

		
		label_cycle_eleve_bulletin.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_cycle_eleve_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_cycle_eleve_bulletin.setBounds(10, 62, 160, 37);
		panel_37.add(label_cycle_eleve_bulletin);
		

		comboBox_cycle_eleve_bulletin.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBox_cycle_eleve_bulletin.setModel(new DefaultComboBoxModel<String>(new String[] {"Semestre1", "Semestre2"}));
		comboBox_cycle_eleve_bulletin.setBounds(182, 62, 119, 37);
		panel_37.add(comboBox_cycle_eleve_bulletin);
		

		button_chercher_bulletins.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		button_chercher_bulletins.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onChercherIdClicked();
				} catch (DaoException e) {
					
				}
			}
		});
		button_chercher_bulletins.setBounds(116, 109, 128, 34);
		panel_37.add(button_chercher_bulletins);
		
		
		label_nom_eleve_bulletin.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_nom_eleve_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_nom_eleve_bulletin.setBounds(461, 10, 95, 42);
		panel_37.add(label_nom_eleve_bulletin);
		
		
		label_value_nom_eleve_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_value_nom_eleve_bulletin.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_value_nom_eleve_bulletin.setBounds(579, 10, 112, 42);
		panel_37.add(label_value_nom_eleve_bulletin);
		
		
		label_prenom_eleve_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_prenom_eleve_bulletin.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_prenom_eleve_bulletin.setBounds(735, 10, 95, 42);
		panel_37.add(label_prenom_eleve_bulletin);
		
		
		label_value_prenom_eleve_bulletin.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_value_prenom_eleve_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_value_prenom_eleve_bulletin.setBounds(862, 10, 119, 42);
		panel_37.add(label_value_prenom_eleve_bulletin);
		
		JLabel label_genre_eleve_bulletin = new JLabel("Genre :");
		label_genre_eleve_bulletin.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_genre_eleve_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_genre_eleve_bulletin.setBounds(461, 62, 95, 37);
		panel_37.add(label_genre_eleve_bulletin);
		
		
		label_value_genre_eleve_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_value_genre_eleve_bulletin.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_value_genre_eleve_bulletin.setBounds(579, 62, 128, 37);
		panel_37.add(label_value_genre_eleve_bulletin);
		

		label_classe_eleve_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_classe_eleve_bulletin.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_classe_eleve_bulletin.setBounds(461, 109, 95, 34);
		panel_37.add(label_classe_eleve_bulletin);
		

		label_value_classe_eleve_bulletin.setHorizontalAlignment(SwingConstants.CENTER);
		label_value_classe_eleve_bulletin.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_value_classe_eleve_bulletin.setBounds(579, 109, 112, 34);
		panel_37.add(label_value_classe_eleve_bulletin);
		
		
		button_actualiser_note.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button_actualiser_note.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onActualiserClicked();
				}
			});
		
		button_actualiser_note.setBounds(261, 109, 128, 34);
		panel_37.add(button_actualiser_note);
		
	}	

		private void onDeleteNoteClicked() {
			int row = table_3.getSelectedRow();
			if(row==-1) {
				JOptionPane.showMessageDialog(null, "Veuillez selectionner un eleve !");
			}
			else {
				int id=(int)modelNote.getValueAt(row, 0);
				try {
					dataSourceNotes.delete(id);
					modelNote.setNotes(dataSourceNotes.list());
				} catch (DaoException e) {
					JOptionPane.showMessageDialog(null, "Suppression non reussit");
				}
			}
		
	}

		private void onChercherIdClicked() throws DaoException {
			String id = textField_id_eleve_bulletin.getText();
			String cycle= (String) comboBox_cycle_eleve_bulletin.getSelectedItem();
			List<Notes> notes=dataSourceNotes.list();
			List<Eleves> eleves =dataSourceEleve.list();
			for(Eleves eleve : eleves) {
				for(Notes l: notes) {
					if(l.getIdentifiant().equals(id) && l.getCycle().equals(cycle)) {
						label_value_nom_eleve_bulletin.setText(l.getNom());
						label_value_prenom_eleve_bulletin.setText(l.getPrenom());
						label_value_genre_eleve_bulletin.setText(eleve.getGenre());
						label_value_classe_eleve_bulletin.setText(l.getClasse());
						onTableBulletin();
						moyenneGenerale();
					}
				}
			}	
	}
		private void onTableBulletin() {
			String id = textField_id_eleve_bulletin.getText();
			String sql= "Select * from Notes where identifiant_eleve= '"+id+"'";
            try(Connection connection = DBManager.getConnection()){
            PreparedStatement pst=connection.prepareStatement(sql);
            ResultSet rs=  pst.executeQuery();
            table_4.setModel(DbUtils.resultSetToTableModel(rs));

            }

            catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
	        }
		}
		
		private void moyenneGenerale() {
			String id = textField_id_eleve_bulletin.getText();
			String sql= "Select SUM(valeur_note*coeff)/SUM(coeff) as moyg from Notes where identifiant_eleve= '"+id+"'";
            try(Connection connection = DBManager.getConnection()){
            PreparedStatement pst=connection.prepareStatement(sql);
            ResultSet rs=  pst.executeQuery();
            while(rs.next()) {
            	label_valeur_moyenne_bulletin.setText(rs.getString("moyg"));
            }
            
            } catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erreur au niveau du calcul");
			}
		}
		

		private void onActualiserClicked() {
			textField_id_eleve_bulletin.setText(null);
			label_value_nom_eleve_bulletin.setText(null);
			label_value_prenom_eleve_bulletin.setText(null);
			label_value_genre_eleve_bulletin.setText(null);
			label_value_classe_eleve_bulletin.setText(null);
			label_valeur_moyenne_bulletin.setText(null);
			table_4.setModel(DbUtils.resultSetToTableModel(null));
	}

		private void onSaveNoteClicked() throws DaoException {
			String id = textField_identifiant_note.getText();
			String name = textField_nom_note.getText();
			String first = textField_prenom_note.getText();
			String coeff1 = textField_coeff_note_eleve.getText();
			int coeff= Integer.valueOf(coeff1);
			String cycle= (String) comboBox_cycle_note.getSelectedItem();
			String classe = (String) comboBox_classe_note.getSelectedItem();
           	String module = (String) comboBox_module_note.getSelectedItem();
   			Double value = Double.valueOf(textField_valeur_module_note.getText());
   			List<Module> modules= dataSourceModule.list();
			List<Eleves> eleve=dataSourceEleve.list();
			for(Module mod: modules) {
				for(Eleves l: eleve) {
					if(l.getIdentifiant().equals(id) && l.getNom_etudiant().equals(name) && l.getPrenom_etudiant().equals(first) && mod.getNom_module().equals(module) && mod.getCoeff()==Integer.valueOf(coeff1)) {
						try{
	                		Notes notes;
	                		notes = new Notes(id,name, first, value, module, classe, cycle, coeff);
	                		dataSourceNotes.create(notes);
	                		modelNote.setNotes(dataSourceNotes.list());
	                		reinitDetails();
	            			JOptionPane.showMessageDialog(null, "Enregistrer avec succes");
	            		}catch(Exception e) {
	            			JOptionPane.showMessageDialog(this,"Erreur au niveau de l'enregistrement");
	            		}
	                }
					else {
						JOptionPane.showMessageDialog(null, "Les informations saisit ne correspondent pas ");
					}
				}
			}
			}
		

		private void onListClassClicked(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED) {
	            String choice= (String) comboBox_classe2_liste.getSelectedItem();
	            if(choice.equals("")) {
	            	table_2.setModel(model);
	            }
	            else {
	            String sql= "select * from Eleve where classe= '" + choice + "'";
	            try(Connection connection = DBManager.getConnection()){
	            PreparedStatement pst=connection.prepareStatement(sql);
	            ResultSet rs=  pst.executeQuery();
	            table_2.setModel(DbUtils.resultSetToTableModel(rs));

	            }

	            catch(Exception ex){
	            JOptionPane.showMessageDialog(this,ex);
		        }
		    }
		}		
	}

		private void jTable1MouseClicked(MouseEvent evt) {
			int row = table_2.getSelectedRow();
			if(row==-1) {
				JOptionPane.showMessageDialog(null, "Veuillez selectionner un eleve !");
			}
			else {
				if(evt.getClickCount()==2){
		        try(Connection connection = DBManager.getConnection()){
		            
		            String table_click= table_2.getModel().getValueAt(row, 1).toString();
		            String sql= "select * from Eleve where nom_eleve= '" + table_click + "'";
		            PreparedStatement pst=connection.prepareStatement(sql);
		            ResultSet rs=  pst.executeQuery();
		            if(rs.next()){
		                String nom=rs.getString("nom_eleve");
		                textField_nom_inscription.setText(nom);
		                String prenom=rs.getString("prenom_eleve");
		                textField_prenom_inscription.setText(prenom);
		                Date date=rs.getDate("date_naissance");
		                textField_date_inscription.setDate(date);
		                String lieu=rs.getString("lieu_naissance");
		                textField_lieu_inscription.setText(lieu);
		                String email=rs.getString("email_eleve");
		                textField_email_inscription.setText(email);
		                String identifiant=rs.getString("identifiant_eleve");
		                textField_identifiant_inscription.setText(identifiant);
		                String adresse=rs.getString("adresse");
		                textField_adresse_inscription.setText(adresse);
		                String section = rs.getString("section");
		                this.comboBox_section_inscription.setSelectedItem(section);
		                String total=rs.getString("observation_inscription");
		                textField_obs_inscription.setText(total);
		                String classe = rs.getString("classe");
		                this.comboBox_classe_inscription.setSelectedItem(classe);
		                String genre=rs.getString("genre");
		                if(this.radio_masculin.getText().equals(genre)) {
		                	radio_masculin.setSelected(true);
		                }
		                else if(this.radio_feminin.getText().equals(genre)){
		                	radio_feminin.setSelected(true);
		                }
		                tabbedPane.setSelectedIndex(1);
		                addButton.setEnabled(false);
		                updateButton.setEnabled(true);   
		            }
		        }
		        catch(Exception ex){
	            JOptionPane.showMessageDialog(this, "Cliquer deux fois sur un element du tableau");
	        }
	    }
	}
		
}

		private void onAfficherClicked(ActionEvent e) {
            String sql= "select * from Salle_classe";
            try(Connection connection = DBManager.getConnection()){
            PreparedStatement pst=connection.prepareStatement(sql);
            ResultSet rs=  pst.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
	        }
     
		
	}

	private void onDeleteClicked() {
			int row = table.getSelectedRow();
			if(row==-1) {
				JOptionPane.showMessageDialog(null, "Veuillez selectionner un eleve !");
			}
			else {
				int id=(int)model.getValueAt(row, 0);
				try {
					dataSourceEleve.delete(id);
					model.setEtudiants(dataSourceEleve.list());
				} catch (DaoException e) {
					JOptionPane.showMessageDialog(null, "Suppression non reussit");
				}
			}
		}
		

	private void onAcceuilClicked() {
		tabbedPane.setSelectedIndex(0);
		
	}
	
	private void onRegisterClicked() {
		tabbedPane.setSelectedIndex(1);
		
	}
	
	private void onListClicked() {
		tabbedPane.setSelectedIndex(2);
	}
	
	private void onclasseClicked() {
		tabbedPane.setSelectedIndex(3);
	}

	private void onNoteClicked() {
		tabbedPane.setSelectedIndex(4);	
	}
	
	private void onBulletinClicked() {
		tabbedPane.setSelectedIndex(5);
		
	}

	private void onUpdateClicked() {
		int a=table.getSelectedRow();
		if (a==-1) return;
		
		int id = (int) table.getValueAt(a, 0);
		
		String name=textField_nom_inscription.getText();
		String first_name= textField_prenom_inscription.getText();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date_naissance= format.format(textField_date_inscription.getDate());
		String lieu_naissance= textField_lieu_inscription.getText();
		String email= textField_email_inscription.getText();
		String identifiant=textField_identifiant_inscription.getText(); 
		String adresse= textField_adresse_inscription.getText();
		String classe = (String) comboBox_classe_inscription.getSelectedItem();
		String section = (String) comboBox_section_inscription.getSelectedItem();
		if( identifiant.isEmpty() && name.isEmpty() && first_name.isEmpty() && date_naissance.equals(null) && lieu_naissance.isEmpty() && email.isEmpty() && adresse.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Il faut saisir tous les champs");
		}
		else if (identifiant.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ identifiant vide non saisit ");
		}
		else if (name.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ nom vide non saisit ");
		}
		else if (first_name.isEmpty()){
			JOptionPane.showMessageDialog(null, "IChamp prenom vide non saisit ");
		}
		else if (date_naissance.equals(null)){
			JOptionPane.showMessageDialog(null, "Champ date vide non saisit ");
		}
		else if (lieu_naissance.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ lieu vide non saisit ");
		}
		else if (email.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ email vide non saisit ");
		}
		else if (adresse.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ adresse vide non saisit ");
		}
		else {
		try {
			Eleves etudiants; 
			Payement payement;
			if (radio_masculin.isSelected()) { 
				String genre=radio_masculin.getText();
				etudiants = new Eleves(id ,name,first_name, date_naissance, lieu_naissance, email,identifiant, genre, adresse, section, "Non paye", classe );		
				payement = new Payement(identifiant, name, first_name, classe, 0, "null","null", 0, "Non paye");
			} else {
				String genre=radio_feminin.getText();
				etudiants = new Eleves(id ,name,first_name, date_naissance, lieu_naissance, email,identifiant, genre, adresse, section, "Non paye", classe );
				payement = new Payement(identifiant, name, first_name, classe, 0, "null","null", 0, "Non paye");
			}
			dataSourceEleve.update(etudiants);
			dataSourcePayement.update(payement);
			reinitDetailsForm();
			model.setEtudiants(dataSourceEleve.list());
		}catch (DaoException e) {
				JOptionPane.showMessageDialog(null,"Errr: "+e.getMessage(), e.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void onUpdateClicked2() {
		int a=table_2.getSelectedRow();
		if (a==-1) return;
		
		int id = (int) table_2.getValueAt(a, 0);
		
		String name=textField_nom_inscription.getText();
		String first_name= textField_prenom_inscription.getText();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date_naissance= format.format(textField_date_inscription.getDate());
		String lieu_naissance= textField_lieu_inscription.getText();
		String email= textField_email_inscription.getText();
		String identifiant=textField_identifiant_inscription.getText(); 
		String adresse= textField_adresse_inscription.getText();
		String classe = (String) comboBox_classe_inscription.getSelectedItem();
		String section = (String) comboBox_section_inscription.getSelectedItem();
		if( identifiant.isEmpty() && name.isEmpty() && first_name.isEmpty() && date_naissance.equals(null) && lieu_naissance.isEmpty() && email.isEmpty() && adresse.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Il faut saisir tous les champs");
		}
		else if (identifiant.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ identifiant vide non saisit ");
		}
		else if (name.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ nom vide non saisit ");
		}
		else if (first_name.isEmpty()){
			JOptionPane.showMessageDialog(null, "IChamp prenom vide non saisit ");
		}
		else if (date_naissance.equals(null)){
			JOptionPane.showMessageDialog(null, "Champ date vide non saisit ");
		}
		else if (lieu_naissance.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ lieu vide non saisit ");
		}
		else if (email.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ email vide non saisit ");
		}
		else if (adresse.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ adresse vide non saisit ");
		}
		else {
		try {
			Eleves etudiants; 
			Payement payement;
			if (radio_masculin.isSelected()) { 
				String genre=radio_masculin.getText();
				etudiants = new Eleves(id ,name,first_name, date_naissance, lieu_naissance, email,identifiant, genre, adresse, section, "Non paye", classe );
				payement = new Payement(identifiant, name, first_name, classe, 0, "null","null", 0, "Non paye");
			} else {
				String genre=radio_feminin.getText();
				etudiants = new Eleves(id ,name,first_name, date_naissance, lieu_naissance, email,identifiant, genre, adresse, section, "Non paye", classe );
				payement = new Payement(identifiant, name, first_name, classe, 0, "null","null", 0, "Non paye");
			}
			dataSourceEleve.update(etudiants);
			dataSourcePayement.update(payement);
			reinitDetailsForm();
			model.setEtudiants(dataSourceEleve.list());
		}catch (DaoException e) {
				JOptionPane.showMessageDialog(null,"Errr: "+e.getMessage(), e.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void onUpdateNoteClicked() {
		int a=table_3.getSelectedRow();
		if (a==-1) return;
		
		int id1 = (int) table_3.getValueAt(a, 0);
		String id = textField_identifiant_note.getText();
		String name = textField_nom_note.getText();
		String first = textField_prenom_note.getText();
		String cycle= (String) comboBox_cycle_note.getSelectedItem();
		String classe = (String) comboBox_classe_note.getSelectedItem();
       	String module = (String) comboBox_module_note.getSelectedItem();
		Double value = Double.valueOf(textField_valeur_module_note.getText());
		int coeff = Integer.valueOf(textField_coeff_note_eleve.getText());
		try {
			Notes note = new Notes(id1, id,name, first, value, module, classe, cycle, coeff);
    		dataSourceNotes.update(note);
    		modelNote.setNotes(dataSourceNotes.list());
    		reinitDetails();
			JOptionPane.showMessageDialog(null, "Modifier avec succes");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Modificatin non reussit");
		}
	}

	

	public void onExitClicked() {
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Voulez-vous Fermer la fenetre ?")) {
		Authentification auth = new Authentification();
		auth.lancer();
		this.dispose();
		}
	}

	public void onAddClicked() {
		String identifiant=textField_identifiant_inscription.getText(); 
		String name=textField_nom_inscription.getText();
		String first_name= textField_prenom_inscription.getText();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date_naissance= format.format(textField_date_inscription.getDate());
		String lieu_naissance= textField_lieu_inscription.getText();
		String email= textField_email_inscription.getText();
		String adresse= textField_adresse_inscription.getText();
		String section = (String) comboBox_section_inscription.getSelectedItem();
		String classe = (String) comboBox_classe_inscription.getSelectedItem();
		
		if( identifiant.isEmpty() && name.isEmpty() && first_name.isEmpty() && date_naissance.equals(null) && lieu_naissance.isEmpty() && email.isEmpty() && adresse.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Il faut saisir tous les champs");
		}
		else if (identifiant.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ identifiant vide non saisit ");
		}
		else if (name.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ nom vide non saisit ");
		}
		else if (first_name.isEmpty()){
			JOptionPane.showMessageDialog(null, "IChamp prenom vide non saisit ");
		}
		else if (date_naissance.equals(null)){
			JOptionPane.showMessageDialog(null, "Champ date vide non saisit ");
		}
		else if (lieu_naissance.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ lieu vide non saisit ");
		}
		else if (email.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ email vide non saisit ");
		}
		else if (adresse.isEmpty()){
			JOptionPane.showMessageDialog(null, "Champ adresse vide non saisit ");
		}
		else {
			try {
			Eleves etudiants;
			
			if(radio_masculin.isSelected()) {
				String genre=radio_masculin.getText();
				etudiants= new Eleves(name, first_name, date_naissance, lieu_naissance,email,identifiant, genre, adresse, section , "Nom paye", classe);
				Payement payement = new Payement(identifiant, name, first_name, classe, 0, "null","null", 0, "Non paye");
				dataSourceEleve.create(etudiants);
				dataSourcePayement.create(payement);
				model.setEtudiants(dataSourceEleve.list());
				reinitDetailsForm();
			}
			else {
				String genre=radio_feminin.getText();
				etudiants= new Eleves(name, first_name, date_naissance, lieu_naissance, email, identifiant,genre,  adresse,section , "Nom paye", classe);
				Payement payement = new Payement(identifiant, name, first_name, classe, 0, "null","null", 0, "Non paye");
					dataSourceEleve.create(etudiants);
					dataSourcePayement.create(payement);
					model.setEtudiants(dataSourceEleve.list());
					reinitDetailsForm();
				}
			
		} catch (DaoException | NumberFormatException | NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Inscription non reussit");
			}
		}
	}
	
	private void reinitDetailsForm() {
		this.textField_nom_inscription.setText(null);
		this.textField_prenom_inscription.setText(null);
		this.textField_date_inscription.setDate(null);
		this.textField_lieu_inscription.setText(null);
		this.textField_email_inscription.setText(null);
		this.textField_identifiant_inscription.setText(null);
		this.textField_adresse_inscription.setText(null);
		this.textField_obs_inscription.setText(null);
	}
	
	private void onValueChanged() {
		int row = table.getSelectedRow();
		if (row == -1) return;
		
		int id = (int) model.getValueAt(row, 0);
		try {
			Eleves eleve = dataSourceEleve.read(id);
			
			this.textField_nom_inscription.setText(eleve.getNom_etudiant());
			this.textField_prenom_inscription.setText(eleve.getPrenom_etudiant());
			((JTextField) this.textField_date_inscription.getDateEditor().getUiComponent()).setText(eleve.getDate_naissance());
			this.textField_lieu_inscription.setText(eleve.getLieu_naissance());
			this.textField_email_inscription.setText(eleve.getEmail_etudiant());
			this.textField_identifiant_inscription.setText(eleve.getIdentifiant());
			this.textField_adresse_inscription.setText(eleve.getAdresse());
			this.comboBox_section_inscription.setSelectedItem(eleve.getSection());
			this.comboBox_classe_inscription.setSelectedItem(eleve.getClasse());
			this.textField_obs_inscription.setText(eleve.getObservation_inscription());
			addButton.setEnabled(false);
			updateButton.setEnabled(true);
		}
		catch (DaoException e) {
			JOptionPane.showMessageDialog(null, "Selectionner un element dans le tableau");
		}	
	}
	
	private void onValueChanged1() {
		int row = table_3.getSelectedRow();
		if (row == -1) return;
		
		int id = (int) modelNote.getValueAt(row, 0);
		try {
			Notes note = dataSourceNotes.read(id);
			
			this.textField_identifiant_note.setText(note.getIdentifiant());
			this.textField_nom_note.setText(note.getNom());
			this.textField_prenom_note.setText(note.getPrenom());
			this.textField_coeff_note_eleve.setText(String.valueOf(note.getCoeff()));
			this.textField_valeur_module_note.setText(String.valueOf(note.getValeur_note()));
			button_save_note.setEnabled(false);
			button_modifier_note.setEnabled(true);
			textField_identifiant_note.setEnabled(false);
			textField_nom_note.setEnabled(false);
			textField_prenom_note.setEnabled(false);
			textField_coeff_note_eleve.setEnabled(false);
			comboBox_classe_note.setEnabled(false);
			textField_identifiant_note.setBackground(Color.lightGray);
			textField_nom_note.setBackground(Color.lightGray);
			textField_prenom_note.setBackground(Color.lightGray);
			textField_coeff_note_eleve.setBackground(Color.lightGray);
		}
		catch (DaoException e) {
			JOptionPane.showMessageDialog(null, "Selectionner un element dans le tableau");
		}
	}
	
	private void onClearClicked() {
		reinitDetailsForm();
		updateButton.setEnabled(false);
		addButton.setEnabled(true);
		button_save_note.setEnabled(false);
		button_modifier_note.setEnabled(true);
		
	}
	
	private void reinitDetails() {
		this.textField_identifiant_note.setText(null);
		this.textField_nom_note.setText(null);
		this.textField_prenom_note.setText(null);
		this.textField_valeur_module_note.setText(null);
		this.textField_coeff_note_eleve.setText(null);
	}
	
	private void onClearNoteClicked() {
		reinitDetailsForm();
		button_save_note.setEnabled(true);
		button_modifier_note.setEnabled(false);
		reinitDetails();
		textField_identifiant_note.setEnabled(true);
		textField_nom_note.setEnabled(true);
		textField_prenom_note.setEnabled(true);
		textField_coeff_note_eleve.setEnabled(true);
		comboBox_classe_note.setEnabled(true);
		textField_identifiant_note.setBackground(Color.white);
		textField_nom_note.setBackground(Color.white);
		textField_prenom_note.setBackground(Color.white);
		textField_coeff_note_eleve.setBackground(Color.white);
	}
	
	


	public void run() {
		this.setVisible(true);
	}
}
