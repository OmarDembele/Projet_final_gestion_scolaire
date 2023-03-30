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
import sn.esmt.java.dataBase.PayementDaoImpl;
import sn.esmt.java.dataBase.RubriqueDaoImpl;
import sn.esmt.java.dataSource.Dao;
import sn.esmt.java.exception.DaoException;
import sn.esmt.java.model.Eleves;
import sn.esmt.java.model.Payement;
import sn.esmt.java.model.PayementModel;
import sn.esmt.java.model.Rubrique;
import sn.esmt.java.model.RubriqueModel;
import sn.esmt.java.utils.Utilitaire;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CaissierUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel_titre;
	private JLabel lblBienvenueSurLe;
	private JPanel panel_tabbedPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_acceuil_tabbed;
	private JPanel panel_search_payement_tabbed;
	private JLabel label_logos;
	private JLabel label_img;
	DefaultTableModel comboBoxmodel;
	private JPanel panel_payement_tabbed;
	private JPanel panel_titre_payement;
	private JLabel label_titre_formulaire_1;
	private JTextField textfield_nom_scolarite;
	private JTextField textfield_montant_scolarite;
	private JTextField textfield_identifiant_pay;
	private JPanel panel_titre_search;
	private JLabel label_recherche;
	private JComboBox<String> comboBoxClasse_pay;
	private JPanel panel_liste_payement_tabbed;
	private JTable table1;
	private JPanel panel_recherche;
	private JLabel lblNewLabel_2;
	private JPanel panel_formulaire;
	private JPanel panel_titre_form_search;
	private JLabel lblNewLabel;
	private JPanel panel_form_search;
	private JLabel label_identifiant;
	private JTextField textField_identifiant_search;
	private JLabel label_prenom_pay;
	private JTextField textField_prenom_pay;
	private JLabel label_num_recu;
	private JTextField textField_num_recu;
	private JLabel label_montant_ins;
	private JTextField textField_montant_ins;
	private JLabel label_observation;
	private JTextField textField_observation;
	private JPanel panel_boutton_add_update;
	private JButton btn_modifier_pay;
	private JButton btn_valider_pay;
	private JComboBox<String> combo_section;
	private JComboBox<String> comboBox_classe_search;
	private JPanel panel_liste_button;
	private JButton acceuilButton;
	private JButton payementButton;
	private JButton liste;
	private JButton choiceButton;
	private JButton exit_button;
	private JLabel lblNewLabel_9;
	private JLabel label_nom_value;
	private RubriqueModel model;
	private JLabel lblDate;
	private Dao<Payement> dataSourcePayement;
	private Dao<Eleves> dataSourceEleve;
	private Dao<Rubrique> dataSourceRubrique;
	private PayementModel modelPay; 
	@SuppressWarnings("unused")
	private RubriqueModel modelRub;
	private JPanel panel_titre_liste_paiement;
	private JPanel panel_button_liste;
	private JPanel panel_7;
	private JPanel panel_recue;
	private JPanel RECU;
	private JLabel lblNewLabel_5;
	private JPanel panel_tableau_liste_paiement;
	private JTable table;
	private JButton button;
	private JLabel filtrer;
	private JDateChooser textField;
	private JDateChooser textField_1;
	private JButton btnNewButton_1;
	private JButton btnRecue;
	private JPanel panel_logo;
	private JLabel label_logo;
	private JPanel panel_date;
	private JLabel label_date_value;
	private JTextField textField_num_recue;
	private JLabel label_somme_value;
	private JLabel label_classe_value;
	private JLabel label_obs_value;

	public CaissierUI() {
		setTitle("Caissier");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(1300, 700));
		createInstanceComponent();
		initComponent();
	}
	
	public void createInstanceComponent() {
		panel_titre = new JPanel();
		panel_titre.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_titre.setBounds(268, 0, 1018, 90);
		panel_titre.setLayout(null);
		
		lblBienvenueSurLe = new JLabel("Bienvenue sur le portail de la comptabilité");
		lblBienvenueSurLe.setBackground(SystemColor.window);
		lblBienvenueSurLe.setBounds(20, 10, 896, 70);
		lblBienvenueSurLe.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenueSurLe.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBienvenueSurLe.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblBienvenueSurLe.setAlignmentY(0.0f);
		lblBienvenueSurLe.setPreferredSize(new Dimension(350, 30));
		panel_titre.add(lblBienvenueSurLe);
		label_img = new JLabel("");
		label_img.setBounds(310, 10, 100, 70);
		ImageIcon img = new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet-java-gestion-scolaire\\src\\sn\\esmt\\java\\image\\Sans_titre.gif");
		label_img.setIcon(img);
		panel_titre.add(label_img);
		label_logos = new JLabel("");
		label_logos.setBackground(new Color(233, 150, 122));
		comboBoxClasse_pay = new JComboBox<String>();
		table1 = new JTable();
	}

	
	public void initComponent() {
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, getSize());
		getContentPane().setLayout(null);
		
		panel_titre.setBackground(SystemColor.window);
		panel_titre.setPreferredSize(new Dimension(0, 90));
		getContentPane().add(panel_titre);
		
		panel_tabbedPane = new JPanel();
		panel_tabbedPane.setBounds(268, 90, 1018, 573);
		panel_tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_tabbedPane);
		panel_tabbedPane.setLayout(null);
		
		model =new RubriqueModel();
		modelPay = new PayementModel();
		modelRub = new RubriqueModel();
		
		dataSourcePayement = new PayementDaoImpl();
		dataSourceEleve = new EleveDaoImple();
		dataSourceRubrique = new RubriqueDaoImpl();
		try {
			model.setRub(dataSourceRubrique.list());
			modelPay.setPayements(dataSourcePayement.list());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(2, -28, 1015, 599);
		tabbedPane.setPreferredSize(new Dimension(1015, 565));
		panel_tabbedPane.add(tabbedPane);
		
		panel_acceuil_tabbed = new JPanel();
		panel_acceuil_tabbed.setBackground(new Color(244, 164, 96));
		panel_acceuil_tabbed.setPreferredSize(new Dimension(100, 100));
		tabbedPane.addTab("Acceuil", null, panel_acceuil_tabbed, null);
		panel_acceuil_tabbed.setLayout(null);
		
		label_logos.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\scolaire_gif.gif"));
		label_logos.setBounds(0, 0, 1015, 569);
		panel_acceuil_tabbed.add(label_logos);
		
		panel_payement_tabbed = new JPanel();
		tabbedPane.addTab("Maternelle", null, panel_payement_tabbed, null);
		panel_payement_tabbed.setLayout(null);
		
		panel_titre_payement = new JPanel();
		panel_titre_payement.setBounds(0, 0, 1015, 36);
		panel_titre_payement.setPreferredSize(new Dimension(10, 30));
		panel_titre_payement.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_titre_payement.setBackground(new Color(47, 79, 79));
		panel_payement_tabbed.add(panel_titre_payement);
		panel_titre_payement.setLayout(null);
		
		label_titre_formulaire_1 = new JLabel("Paiement de scolarité");
		label_titre_formulaire_1.setForeground(Color.WHITE);
		label_titre_formulaire_1.setBounds(357, 6, 300, 30);
		label_titre_formulaire_1.setPreferredSize(new Dimension(300, 20));
		label_titre_formulaire_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre_formulaire_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_titre_payement.add(label_titre_formulaire_1);
		
		JPanel panel_tableau_rubrique = new JPanel();
		panel_tableau_rubrique.setBounds(0, 259, 1010, 278);
		panel_payement_tabbed.add(panel_tableau_rubrique);
		panel_tableau_rubrique.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_tableau_rubrique.add(scrollPane, BorderLayout.CENTER);
		
		table1.setModel(model);
		table1.getColumnModel().getColumn(0).setPreferredWidth(70);
		table1.getColumnModel().getColumn(1).setPreferredWidth(82);
		table1.getColumnModel().getColumn(2).setPreferredWidth(59);
		table1.getColumnModel().getColumn(3).setPreferredWidth(92);
		table1.getColumnModel().getColumn(4).setPreferredWidth(92);
		table1.getColumnModel().getColumn(5).setPreferredWidth(92);
		scrollPane.setViewportView(table1);
		
		JPanel panel_info_payement = new JPanel();
		panel_info_payement.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_info_payement.setBounds(0, 36, 798, 224);
		panel_payement_tabbed.add(panel_info_payement);
		panel_info_payement.setLayout(null);
		
		JLabel label_nom_pay = new JLabel("Nom :");
		label_nom_pay.setBounds(259, 28, 120, 41);
		label_nom_pay.setHorizontalAlignment(SwingConstants.CENTER);
		label_nom_pay.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_info_payement.add(label_nom_pay);
		
		textfield_nom_scolarite = new JTextField();
		textfield_nom_scolarite.setBounds(391, 31, 120, 36);
		textfield_nom_scolarite.setFont(new Font("Tahoma", Font.BOLD, 13));
		textfield_nom_scolarite.setColumns(10);
		panel_info_payement.add(textfield_nom_scolarite);
		
		JLabel lblMontantScolarite = new JLabel("Montant Scolarite :");
		lblMontantScolarite.setBounds(244, 81, 150, 36);
		lblMontantScolarite.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontantScolarite.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_info_payement.add(lblMontantScolarite);
		
		textfield_montant_scolarite = new JTextField();
		textfield_montant_scolarite.setBounds(391, 79, 120, 38);
		textfield_montant_scolarite.setFont(new Font("Tahoma", Font.BOLD, 13));
		textfield_montant_scolarite.setColumns(10);
		panel_info_payement.add(textfield_montant_scolarite);
		
		JLabel label_identifiant_pay = new JLabel("Identifiant :");
		label_identifiant_pay.setBounds(6, 28, 91, 41);
		label_identifiant_pay.setHorizontalAlignment(SwingConstants.CENTER);
		label_identifiant_pay.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_info_payement.add(label_identifiant_pay);
		
		textfield_identifiant_pay = new JTextField();
		textfield_identifiant_pay.setBounds(109, 28, 136, 41);
		textfield_identifiant_pay.setFont(new Font("Tahoma", Font.BOLD, 13));
		textfield_identifiant_pay.setColumns(10);
		panel_info_payement.add(textfield_identifiant_pay);
		
		JLabel label_classe_pay = new JLabel("Classe :");
		label_classe_pay.setBounds(6, 81, 67, 36);
		label_classe_pay.setHorizontalAlignment(SwingConstants.CENTER);
		label_classe_pay.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_info_payement.add(label_classe_pay);
		
		comboBoxClasse_pay.setBounds(109, 82, 136, 37);
		comboBoxClasse_pay.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_info_payement.add(comboBoxClasse_pay);
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Salle_Classe";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				comboBoxClasse_pay.addItem(rs.getString("nom_classe"));
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		JLabel label_details_personnels_1 = new JLabel("Details Personnels");
		label_details_personnels_1.setBounds(10, 5, 150, 17);
		label_details_personnels_1.setPreferredSize(new Dimension(150, 17));
		label_details_personnels_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_info_payement.add(label_details_personnels_1);
		
		label_prenom_pay = new JLabel("Prenom :");
		label_prenom_pay.setHorizontalAlignment(SwingConstants.CENTER);
		label_prenom_pay.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_prenom_pay.setBounds(534, 28, 120, 41);
		panel_info_payement.add(label_prenom_pay);
		
		textField_prenom_pay = new JTextField();
		textField_prenom_pay.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_prenom_pay.setBounds(666, 29, 112, 41);
		panel_info_payement.add(textField_prenom_pay);
		textField_prenom_pay.setColumns(10);
		
		label_num_recu = new JLabel("Numero recue:");
		label_num_recu.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_num_recu.setHorizontalAlignment(SwingConstants.CENTER);
		label_num_recu.setBounds(529, 81, 125, 36);
		panel_info_payement.add(label_num_recu);
		
		textField_num_recu = new JTextField();
		textField_num_recu.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_num_recu.setBounds(666, 81, 112, 36);
		panel_info_payement.add(textField_num_recu);
		textField_num_recu.setColumns(10);
		
		label_montant_ins = new JLabel("Montant Ins :");
		label_montant_ins.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_montant_ins.setHorizontalAlignment(SwingConstants.CENTER);
		label_montant_ins.setBounds(296, 135, 103, 32);
		panel_info_payement.add(label_montant_ins);
		
		textField_montant_ins = new JTextField();
		textField_montant_ins.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_montant_ins.setBounds(401, 129, 136, 38);
		panel_info_payement.add(textField_montant_ins);
		textField_montant_ins.setColumns(10);
		
		label_observation = new JLabel("Observation :");
		label_observation.setHorizontalAlignment(SwingConstants.CENTER);
		label_observation.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_observation.setBounds(539, 129, 115, 38);
		panel_info_payement.add(label_observation);
		
		textField_observation = new JTextField();
		textField_observation.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_observation.setBounds(666, 129, 112, 38);
		panel_info_payement.add(textField_observation);
		textField_observation.setColumns(10);
		
		lblDate = new JLabel("Date :");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(6, 138, 87, 26);
		panel_info_payement.add(lblDate);
		
		textField_1 = new JDateChooser();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setBounds(98, 129, 186, 41);
		panel_info_payement.add(textField_1);
		
		panel_boutton_add_update = new JPanel();
		panel_boutton_add_update.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_boutton_add_update.setBounds(799, 36, 216, 224);
		panel_payement_tabbed.add(panel_boutton_add_update);
		panel_boutton_add_update.setLayout(null);
		
		btn_modifier_pay = new JButton("Modifier");
		btn_modifier_pay.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onModifierClicked();
				} catch (DaoException e) {
					e.printStackTrace();
				}
				
			}
		});
		btn_modifier_pay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_modifier_pay.setBounds(70, 83, 107, 51);
		panel_boutton_add_update.add(btn_modifier_pay);
		
		btn_valider_pay = new JButton("Valider");
		btn_valider_pay.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onValidateClicked();
				} catch (DaoException e) {
					e.printStackTrace();
				}
				
			}
		});
		btn_valider_pay.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_valider_pay.setBounds(70, 20, 107, 51);
		panel_boutton_add_update.add(btn_valider_pay);
		
		combo_section = new JComboBox<String>();
		combo_section.setFont(new Font("Tahoma", Font.BOLD, 13));
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Section";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				combo_section.addItem(rs.getString("nom_section"));
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		combo_section.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				onListPayClicked(arg0);
				
			}
		});
		combo_section.setBounds(70, 146, 107, 58);
		panel_boutton_add_update.add(combo_section);
		
		
		panel_search_payement_tabbed = new JPanel();
		
		tabbedPane.addTab("Elémentaire", null, panel_search_payement_tabbed, "");
		panel_search_payement_tabbed.setLayout(null);
		
		panel_titre_search = new JPanel();
		panel_titre_search.setPreferredSize(new Dimension(10, 30));
		panel_titre_search.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_titre_search.setBackground(new Color(47, 79, 79));
		panel_titre_search.setBounds(0, 0, 1015, 30);
		panel_search_payement_tabbed.add(panel_titre_search);
		
		label_recherche = new JLabel("Rechercher un eleve ");
		label_recherche.setForeground(Color.WHITE);
		label_recherche.setPreferredSize(new Dimension(300, 20));
		label_recherche.setHorizontalAlignment(SwingConstants.CENTER);
		label_recherche.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		panel_titre_search.add(label_recherche);
		
		panel_recherche = new JPanel();
		panel_recherche.setBorder(new LineBorder(new Color(47, 79, 79), 2));
		panel_recherche.setBounds(0, 31, 1015, 506);
		panel_search_payement_tabbed.add(panel_recherche);
		panel_recherche.setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\website.png"));
		lblNewLabel_2.setBounds(444, 0, 565, 500);
		panel_recherche.add(lblNewLabel_2);
		
		panel_formulaire = new JPanel();
		panel_formulaire.setBounds(0, 0, 432, 500);
		panel_recherche.add(panel_formulaire);
		panel_formulaire.setLayout(null);
		
		panel_titre_form_search = new JPanel();
		panel_titre_form_search.setBorder(new LineBorder(new Color(47, 79, 79), 2));
		panel_titre_form_search.setBounds(0, 0, 426, 500);
		panel_formulaire.add(panel_titre_form_search);
		panel_titre_form_search.setLayout(null);
		
		lblNewLabel = new JLabel("Recherche");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 420, 41);
		panel_titre_form_search.add(lblNewLabel);
		
		panel_form_search = new JPanel();
		panel_form_search.setBackground(new Color(47, 79, 79));
		panel_form_search.setBounds(0, 43, 420, 457);
		panel_titre_form_search.add(panel_form_search);
		panel_form_search.setLayout(null);
		
		label_identifiant = new JLabel("Identifiant :");
		label_identifiant.setForeground(new Color(255, 255, 255));
		label_identifiant.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_identifiant.setHorizontalAlignment(SwingConstants.CENTER);
		label_identifiant.setBounds(6, 48, 204, 50);
		panel_form_search.add(label_identifiant);
		
		textField_identifiant_search = new JTextField();
		textField_identifiant_search.setBounds(222, 48, 166, 50);
		panel_form_search.add(textField_identifiant_search);
		textField_identifiant_search.setColumns(10);
		
		JLabel label_classe = new JLabel("Classe :");
		label_classe.setForeground(new Color(255, 255, 255));
		label_classe.setHorizontalAlignment(SwingConstants.CENTER);
		label_classe.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_classe.setBounds(6, 149, 204, 50);
		panel_form_search.add(label_classe);
		
		comboBox_classe_search = new JComboBox<String>();
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Salle_Classe";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				comboBox_classe_search.addItem(rs.getString("nom_classe"));
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		comboBox_classe_search.setBounds(222, 149, 166, 50);
		panel_form_search.add(comboBox_classe_search);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onSerchClicked();
				} catch (DaoException e) {
					JOptionPane.showMessageDialog(null, "Les informations saisit ne correspondent pas ");
				}
				
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnValider.setBounds(166, 259, 145, 43);
		panel_form_search.add(btnValider);
		
		tabbedPane.setDisabledIconAt(2, null);
		
		
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Salle_Classe";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				comboBoxClasse_pay.addItem(rs.getString("nom_classe"));
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		panel_liste_payement_tabbed = new JPanel();
		panel_liste_payement_tabbed.setLayout(null);
		tabbedPane.addTab("Liste des paiements", null, panel_liste_payement_tabbed, null);
		
		panel_titre_liste_paiement = new JPanel();
		panel_titre_liste_paiement.setBounds(0, 6, 1015, 563);
		panel_liste_payement_tabbed.add(panel_titre_liste_paiement);
		panel_titre_liste_paiement.setLayout(null);
		
		panel_button_liste = new JPanel();
		panel_button_liste.setBounds(0, 5, 1015, 119);
		panel_titre_liste_paiement.add(panel_button_liste);
		panel_button_liste.setLayout(null);
		
		panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBackground(new Color(47, 79, 79));
		panel_7.setBounds(0, 0, 1015, 43);
		panel_button_liste.add(panel_7);
		panel_7.setLayout(null);
		
		lblNewLabel_5 = new JLabel("La liste des Paiements");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_5.setBounds(253, 0, 512, 37);
		panel_7.add(lblNewLabel_5);
		
		filtrer = new JLabel("Filtrer le payement des eleves :");
		filtrer.setFont(new Font("Tahoma", Font.BOLD, 14));
		filtrer.setHorizontalAlignment(SwingConstants.CENTER);
		filtrer.setBounds(17, 55, 226, 46);
		panel_button_liste.add(filtrer);
		
		textField = new JDateChooser();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(264, 55, 192, 46);
		panel_button_liste.add(textField);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onGoClicked();
			}
		});
		btnNewButton.setBounds(468, 55, 86, 46);
		panel_button_liste.add(btnNewButton);
		
		btnNewButton_1 = new JButton("List");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					onListClicked();
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(823, 55, 86, 46);
		panel_button_liste.add(btnNewButton_1);
		
		
		panel_tableau_liste_paiement = new JPanel();
		panel_tableau_liste_paiement.setBounds(0, 124, 1015, 439);
		panel_titre_liste_paiement.add(panel_tableau_liste_paiement);
		panel_tableau_liste_paiement.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 1015, 439);
		panel_tableau_liste_paiement.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
		table.setPreferredScrollableViewportSize(new Dimension(400, 375));
		table.setFont(new Font("SansSerif", Font.BOLD, 12));
		table.setModel(modelPay);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(82);
		table.getColumnModel().getColumn(3).setPreferredWidth(59);
		table.getColumnModel().getColumn(4).setPreferredWidth(92);
		table.getColumnModel().getColumn(5).setPreferredWidth(92);
		table.getColumnModel().getColumn(6).setPreferredWidth(92);
		table.getColumnModel().getColumn(7).setPreferredWidth(70);
		table.getColumnModel().getColumn(8).setPreferredWidth(82);
		table.getColumnModel().getColumn(9).setPreferredWidth(59);
		table.setPreferredSize(new Dimension(0, 410));
		scrollPane_1.setColumnHeaderView(table);
		scrollPane_1.setViewportView(table);
		
		button = new JButton("New button");
		scrollPane_1.setColumnHeaderView(button);
		
		panel_liste_button = new JPanel();
		panel_liste_button.setLayout(null);
		panel_liste_button.setPreferredSize(new Dimension(268, 520));
		panel_liste_button.setBackground(new Color(47, 79, 79));
		panel_liste_button.setBounds(0, 0, 268, 663);
		getContentPane().add(panel_liste_button);
		
		acceuilButton = new JButton("Acceuil");
		acceuilButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onAcceuilClicked();
				
			}
		});
		acceuilButton.setPreferredSize(new Dimension(100, 50));
		acceuilButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		acceuilButton.setBackground(SystemColor.activeCaption);
		acceuilButton.setBounds(38, 181, 186, 51);
		panel_liste_button.add(acceuilButton);
		
		payementButton = new JButton("Paiement");
		payementButton.setPreferredSize(new Dimension(100, 50));
		payementButton.setMinimumSize(new Dimension(67, 28));
		payementButton.setMaximumSize(new Dimension(67, 28));
		payementButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onPayementClicked();
				
			}
		});
		payementButton.setForeground(Color.BLACK);
		payementButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		payementButton.setBackground(SystemColor.activeCaption);
		payementButton.setBounds(38, 256, 186, 56);
		panel_liste_button.add(payementButton);
		
		choiceButton = new JButton("Changer de fenetre");
		choiceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onSecretariatClicked();
			}
		});
		choiceButton.setPreferredSize(new Dimension(100, 50));
		choiceButton.setForeground(Color.BLACK);
		choiceButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		choiceButton.setBackground(SystemColor.activeCaption);
		choiceButton.setBounds(34, 490, 190, 56);
		panel_liste_button.add(choiceButton);
		
		exit_button = new JButton("Deconnection");
		exit_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onExitClicked();
			}
		});
		exit_button.setForeground(Color.BLACK);
		exit_button.setFont(new Font("Tahoma", Font.BOLD, 20));
		exit_button.setBackground(Color.RED);
		exit_button.setBounds(38, 571, 190, 64);
		panel_liste_button.add(exit_button);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\cashier (2).png"));
		lblNewLabel_9.setBounds(38, 0, 186, 169);
		panel_liste_button.add(lblNewLabel_9);
		
		liste = new JButton("Liste des paiements");
		liste.setMinimumSize(new Dimension(67, 28));
		liste.setMaximumSize(new Dimension(67, 28));
		liste.setBounds(38, 335, 190, 64);
		panel_liste_button.add(liste);
		liste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onListeClicked();
				
			}
		});
		liste.setPreferredSize(new Dimension(100, 50));
		liste.setForeground(Color.BLACK);
		liste.setFont(new Font("Tahoma", Font.BOLD, 16));
		liste.setBackground(SystemColor.activeCaption);
		
		btnRecue = new JButton("Reçu");
		btnRecue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onRecuebtnClicked();
			}
		});
		btnRecue.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnRecue.setBackground(SystemColor.activeCaption);
		btnRecue.setPreferredSize(new Dimension(100, 50));
		btnRecue.setMinimumSize(new Dimension(67, 28));
		btnRecue.setMaximumSize(new Dimension(67, 28));
		btnRecue.setBounds(38, 417, 186, 51);
		panel_liste_button.add(btnRecue);
		////////////////////////////////////////////////////////////////////////////////
		
		RECU = new JPanel();
		RECU.setBorder(new LineBorder(Color.GRAY));
		RECU.setBackground(SystemColor.window);
		tabbedPane.addTab("New tab", null, RECU, null);
		RECU.setLayout(null);
		
		panel_recue = new JPanel();
		panel_recue.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_recue.setBackground(Color.WHITE);
		panel_recue.setBounds(6, 119, 511, 450);
		RECU.add(panel_recue);
		panel_recue.setLayout(null);
		tabbedPane.addTab("Acceuil", null, RECU, null);
		panel_acceuil_tabbed.setLayout(null);
		
		JPanel panel_faire_recue = new JPanel();
		panel_faire_recue.setBackground(new Color(47, 79, 79));
		panel_faire_recue.setBounds(6, 6, 499, 82);
		panel_recue.add(panel_faire_recue);
		panel_faire_recue.setLayout(null);
		
		JLabel label_recue = new JLabel("Numéro reçu :");
		label_recue.setForeground(new Color(255, 255, 255));
		label_recue.setBounds(6, 27, 134, 35);
		panel_faire_recue.add(label_recue);
		label_recue.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		label_recue.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(152, 27, 204, 35);
		panel_faire_recue.add(panel_5);
		panel_5.setBackground(Color.WHITE);
		panel_5.setLayout(null);
		
		textField_num_recue = new JTextField();
		textField_num_recue.setFont(new Font("SansSerif", Font.BOLD, 14));
		textField_num_recue.setBounds(0, 0, 204, 34);
		panel_5.add(textField_num_recue);
		textField_num_recue.setColumns(10);
		
		JButton btnFaireRecue = new JButton("Faire Reçu");
		btnFaireRecue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onRecueClicked();
			}
		});
		btnFaireRecue.setBounds(368, 28, 125, 37);
		panel_faire_recue.add(btnFaireRecue);
		btnFaireRecue.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		
		JPanel panel_nom = new JPanel();
		panel_nom.setBounds(203, 133, 231, 35);
		panel_recue.add(panel_nom);
		panel_nom.setLayout(null);
		
		label_nom_value = new JLabel("");
		label_nom_value.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_nom_value.setBounds(0, 0, 231, 35);
		panel_nom.add(label_nom_value);
		label_nom_value.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_somme = new JPanel();
		panel_somme.setBounds(203, 233, 171, 35);
		panel_recue.add(panel_somme);
		panel_somme.setLayout(null);
		
		label_somme_value = new JLabel("");
		label_somme_value.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_somme_value.setBounds(0, 0, 171, 35);
		panel_somme.add(label_somme_value);
		label_somme_value.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_classe = new JPanel();
		panel_classe.setBounds(203, 186, 171, 35);
		panel_recue.add(panel_classe);
		panel_classe.setLayout(null);
		
		label_classe_value = new JLabel("");
		label_classe_value.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_classe_value.setBounds(0, 0, 171, 35);
		panel_classe.add(label_classe_value);
		label_classe_value.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_observation = new JPanel();
		panel_observation.setBounds(203, 280, 171, 35);
		panel_recue.add(panel_observation);
		panel_observation.setLayout(null);
		
		label_obs_value = new JLabel("");
		label_obs_value.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_obs_value.setBounds(0, 0, 171, 35);
		panel_observation.add(label_obs_value);
		label_obs_value.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_mr = new JLabel("Reçu de Mr ou Mme :");
		label_mr.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_mr.setHorizontalAlignment(SwingConstants.CENTER);
		label_mr.setBounds(6, 133, 171, 35);
		panel_recue.add(label_mr);
		
		JLabel label_somme = new JLabel("La somme de :");
		label_somme.setHorizontalAlignment(SwingConstants.CENTER);
		label_somme.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_somme.setBounds(6, 233, 159, 35);
		panel_recue.add(label_somme);
		
		JLabel label_obs = new JLabel("Observation :");
		label_obs.setHorizontalAlignment(SwingConstants.CENTER);
		label_obs.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_obs.setBounds(6, 280, 159, 35);
		panel_recue.add(label_obs);
		
		JLabel label_classe_paiement = new JLabel("Classe de :");
		label_classe_paiement.setHorizontalAlignment(SwingConstants.CENTER);
		label_classe_paiement.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_classe_paiement.setBounds(16, 186, 149, 35);
		panel_recue.add(label_classe_paiement);
		
		JPanel panel_caisse = new JPanel();
		panel_caisse.setBounds(6, 378, 187, 48);
		panel_recue.add(panel_caisse);
		panel_caisse.setLayout(null);
		
		JLabel label_caisse = new JLabel("LA CAISSE");
		label_caisse.setForeground(new Color(47, 79, 79));
		label_caisse.setBounds(6, 6, 175, 37);
		panel_caisse.add(label_caisse);
		label_caisse.setHorizontalAlignment(SwingConstants.CENTER);
		label_caisse.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		
		JLabel label_date = new JLabel("Date Paiement :");
		label_date.setBounds(7, 331, 158, 35);
		panel_recue.add(label_date);
		label_date.setHorizontalAlignment(SwingConstants.CENTER);
		label_date.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		
		panel_date = new JPanel();
		panel_date.setBounds(203, 327, 171, 39);
		panel_recue.add(panel_date);
		panel_date.setLayout(null);
		
		label_date_value = new JLabel("");
		label_date_value.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_date_value.setHorizontalAlignment(SwingConstants.CENTER);
		label_date_value.setBounds(0, 0, 171, 39);
		panel_date.add(label_date_value);
		
		JPanel panel_titre_recue = new JPanel();
		panel_titre_recue.setBounds(6, 17, 1003, 101);
		RECU.add(panel_titre_recue);
		panel_titre_recue.setLayout(null);
		
		JPanel panel_titre_recue_2 = new JPanel();
		panel_titre_recue_2.setBounds(0, 0, 1003, 100);
		panel_titre_recue.add(panel_titre_recue_2);
		panel_titre_recue_2.setBackground(new Color(47, 79, 79));
		panel_titre_recue_2.setLayout(null);
		
		JLabel label_titre = new JLabel("REÇU DE PAIEMENT");
		label_titre.setForeground(Color.WHITE);
		label_titre.setBounds(299, 6, 418, 88);
		panel_titre_recue_2.add(label_titre);
		label_titre.setBackground(Color.DARK_GRAY);
		label_titre.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label_titre.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre.setHorizontalTextPosition(SwingConstants.CENTER);
		
		panel_logo = new JPanel();
		panel_logo.setBounds(519, 119, 490, 444);
		RECU.add(panel_logo);
		panel_logo.setLayout(null);
		
		label_logo = new JLabel("");
		label_logo.setBackground(new Color(255, 255, 255));
		label_logo.setHorizontalAlignment(SwingConstants.CENTER);
		label_logo.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\bill.png"));
		label_logo.setBounds(6, 5, 478, 433);
		panel_logo.add(label_logo);

	}

	private void onListClicked() throws DaoException {
		 String sql= "select * from Paiement";
         try(Connection connection = DBManager.getConnection()){
         PreparedStatement pst=connection.prepareStatement(sql);
         ResultSet rs=  pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }

     catch(Exception ex){
     JOptionPane.showMessageDialog(this,ex);
	     }
	}

	private void onGoClicked() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date_naissance= format.format(textField.getDate());
		String sql= "select * from Paiement where date_paiement='" + date_naissance + "'";
        try(Connection connection = DBManager.getConnection()){
        PreparedStatement pst=connection.prepareStatement(sql);
        ResultSet rs=  pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
        }
	    catch(Exception ex){
	    JOptionPane.showMessageDialog(this,ex);
        }
		
	}

	private void onAcceuilClicked() {
		tabbedPane.setSelectedIndex(0);
	}
	
	protected void onPayementClicked() {
		tabbedPane.setSelectedIndex(2);
	}
	
	private void onListeClicked() {
		tabbedPane.setSelectedIndex(3);
	}

	protected void onRecuebtnClicked() {
		tabbedPane.setSelectedIndex(4);
	}

	
	private void onSecretariatClicked() {
		ChoixCaissier caissier = new ChoixCaissier();
		caissier.show3();
		this.dispose();
	}
	
	private void onRecueClicked() {
		String id = textField_num_recue.getText();
		List<Payement> payement;
		try {
			payement = dataSourcePayement.list();
			for (Payement pay : payement) {
				if (pay.getNumero_recue().equals(id)) {
						this.label_nom_value.setText(pay.getNom()+" "+pay.getPrenom());
						this.label_classe_value.setText(pay.getClasse());
						this.label_somme_value.setText(String.valueOf(pay.getMontant_scolarite()));
						this.label_obs_value.setText(pay.getObservation());
						this.label_date_value.setText(pay.getDate_paiement());
					}
				}
			} catch (DaoException e) {
		}
	}

	private void onSerchClicked() throws DaoException {
		String id = textField_identifiant_search.getText();
		String classe = (String) comboBox_classe_search.getSelectedItem();
		List<Eleves> eleve=dataSourceEleve.list();
			for(Eleves l: eleve) {
				if(l.getIdentifiant().equals(id) && l.getClasse().equals(classe)){
					Payement payement =dataSourcePayement.read2(id);
					this.textfield_identifiant_pay.setText(id);
					this.textfield_identifiant_pay.setEnabled(false);
					this.textfield_nom_scolarite.setText(payement.getNom());
					this.textfield_nom_scolarite.setEnabled(false);
					this.textField_prenom_pay.setText(payement.getPrenom());
					this.textField_prenom_pay.setEnabled(false);
					this.comboBoxClasse_pay.setSelectedItem(classe);
					this.comboBoxClasse_pay.setEnabled(false);
					this.textfield_montant_scolarite.setText(String.valueOf(payement.getMontant_scolarite()));
					this.textField_num_recu.setText(payement.getNumero_recue());
					this.textField_montant_ins.setText(String.valueOf(payement.getMontant_inscription()));
					this.textField_observation.setText(payement.getObservation());
					this.textField_montant_ins.setEnabled(false);
					this.textField_observation.setEnabled(false);
					tabbedPane.setSelectedIndex(1);
					btn_valider_pay.setEnabled(true);
					btn_modifier_pay.setEnabled(false);
				}
			}
	}

	private void onValidateClicked() throws DaoException {
		String id = textfield_identifiant_pay.getText();
		String name = textfield_nom_scolarite.getText();
		String first = textField_prenom_pay.getText();
		String classe = (String) comboBoxClasse_pay.getSelectedItem();
		Double value_scolarite = Double.valueOf(textfield_montant_scolarite.getText());
		String recue = textField_num_recu.getText();
		Double value_ins = Double.valueOf(textField_montant_ins.getText());
		String obs = textField_observation.getText();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date_naissance= format.format(textField_1.getDate());
		
		List<Eleves> eleve=dataSourceEleve.list();
			for(Eleves l: eleve) {
				if(l.getIdentifiant().equals(id) && l.getNom_etudiant().equals(name) && l.getPrenom_etudiant().equals(first) && l.getClasse().equals(classe)){
					try{
                		Payement payement;
                		payement = new Payement(id, name, first, classe, value_scolarite, recue,date_naissance, value_ins, obs);
                		dataSourcePayement.create(payement);
                		modelPay.setPayements(dataSourcePayement.list());
            			JOptionPane.showMessageDialog(null, "Enregistrer avec succes");
            		}catch(Exception e) {
            			JOptionPane.showMessageDialog(this,"Erreur au niveau de l'enregistrement");
            		}
                }
			}
		}
	
	private void onModifierClicked() throws DaoException {
		int a=table.getSelectedRow();
		if (a==-1) return;
		
		int id = (int) table.getValueAt(a, 0);
		String identifiant = textfield_identifiant_pay.getText();
		String name = textfield_nom_scolarite.getText();
		String first = textField_prenom_pay.getText();
		String classe = (String) comboBoxClasse_pay.getSelectedItem();
		Double value_scolarite = Double.valueOf(textfield_montant_scolarite.getText());
		String recue = textField_num_recu.getText();
		Double value_ins = Double.valueOf(textField_montant_ins.getText());
		String obs = textField_observation.getText();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date_naissance= format.format(textField_1.getDate());
		
		List<Eleves> eleve=dataSourceEleve.list();
			for(Eleves l: eleve) {
				if(l.getIdentifiant().equals(identifiant) && l.getNom_etudiant().equals(name) && l.getPrenom_etudiant().equals(first) && l.getClasse().equals(classe)){
					try{
                		Payement payement;
                		Eleves eleves;
                		payement = new Payement(id,identifiant, name, first, classe, value_scolarite, recue,date_naissance, value_ins, obs);
                		dataSourcePayement.update(payement);
                		eleves = new Eleves(identifiant,obs);
                		dataSourceEleve.update2(eleves);
                		modelPay.setPayements(dataSourcePayement.list());
            			JOptionPane.showMessageDialog(null, "Enregistrer avec succes");
            		}catch(Exception e) {
            			JOptionPane.showMessageDialog(this,"Erreur au niveau de l'enregistrement");
            		}
                }
			}
		}
	
	private void jTable1MouseClicked(MouseEvent evt) {
		int row = table.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(null, "Veuillez selectionner une ligne !");
		}
		else {
			if(evt.getClickCount()==2){
	        try(Connection connection = DBManager.getConnection()){
	            
	            String table_click= table.getModel().getValueAt(row, 1).toString();
	            String sql= "select identifiant,nom,prenom,classe,montant_scolarite,numero_recue, date_paiement,montant_inscription,observation_inscription from Paiement where identifiant= '" + table_click + "'";
	            PreparedStatement pst=connection.prepareStatement(sql);
	            ResultSet rs=  pst.executeQuery();
	            if(rs.next()){
	                String identifiant = rs.getString("identifiant");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					String classe = rs.getString("classe");
					Double montant_scol = rs.getDouble("montant_scolarite");
					String num = rs.getString("numero_recue");
					Date date=rs.getDate("date_paiement");
					Double ins= rs.getDouble("montant_inscription");
					String obs= rs.getString("observation_inscription");
					this.textfield_identifiant_pay.setText(identifiant);
					this.textfield_identifiant_pay.setEnabled(false);
					this.textfield_nom_scolarite.setText(nom);
					this.textfield_nom_scolarite.setEnabled(false);
					this.textField_prenom_pay.setText(prenom);
					this.textField_prenom_pay.setEnabled(false);
					this.textfield_montant_scolarite.setText(String.valueOf(montant_scol));
					this.textField_num_recu.setText(num);
					this.textField_1.setDate(date);
					this.comboBoxClasse_pay.setSelectedItem(classe);
					this.comboBoxClasse_pay.setEnabled(false);
					this.textField_montant_ins.setText(String.valueOf(ins));
					this.textField_observation.setText(obs);
					tabbedPane.setSelectedIndex(1);
					btn_valider_pay.setEnabled(false);
					btn_modifier_pay.setEnabled(true);
					this.textField_montant_ins.setEnabled(true);
					this.textField_observation.setEnabled(true);
	            }
	        }
	        catch(Exception ex){
	            JOptionPane.showMessageDialog(this, "Cliquer deux fois sur un element du tableau");
	        }
	    }
	}	
}
	
	private void onListPayClicked(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
            String choice= (String) combo_section.getSelectedItem();
            if(choice.equals("")) {
            	table1.setModel(model);
            }
            else {
	            String sql= "select * from Rubrique where section= '" + choice + "'";
	            try(Connection connection = DBManager.getConnection()){
	            PreparedStatement pst=connection.prepareStatement(sql);
	            ResultSet rs=  pst.executeQuery();
	            table1.setModel(DbUtils.resultSetToTableModel(rs));
       }

            catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
		        }
		    }
		}			
	}
		

	private void onExitClicked() {
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Voulez-vous Fermer la fenetre ?")) {
			Authentification auth = new Authentification();
			auth.lancer();
			this.dispose();
			}
	}

	

	public void run() {
		this.setVisible(true);
	}
}
