package sn.esmt.java.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JTable;
import sn.esmt.java.model.UserModel;
import sn.esmt.java.model.RubriqueModel;
import sn.esmt.java.utils.Utilitaire;
import javax.swing.JScrollPane;
import sn.esmt.java.model.Administrateur;
import sn.esmt.java.model.Caissier;
import sn.esmt.java.model.EleveModel;
import sn.esmt.java.model.Eleves;
import sn.esmt.java.model.ModuleModel;
import sn.esmt.java.model.Personne;
import sn.esmt.java.model.Secretaire;
import sn.esmt.java.model.Rubrique;
import sn.esmt.java.dataBase.DBManager;
import sn.esmt.java.dataBase.DBUsers;
import sn.esmt.java.dataBase.RubriqueDaoImpl;
import sn.esmt.java.dataBase.EleveDaoImple;
import sn.esmt.java.dataBase.ModuleDaoImpl;
import sn.esmt.java.dataSource.Dao;
import sn.esmt.java.model.Module;
import sn.esmt.java.exception.DaoException;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class AdminUi extends JFrame {

	private static final long serialVersionUID = -7746339546004926889L;
	private JTextField PrenomTF;
	private JTextField IdTF;
	private JTextField NomTF;
	private JTextField EmailTF;
	private JTextField ConfPassTF;
	private JTextField NumeroTF;
	private JTextField LoginTF;
	private JTextField PasswordTF;
	private UserModel modeluser;
	private RubriqueModel rubModel ;
	private JButton btnSave;
	private JButton AddUser;
	private JButton Remplir;
	private JButton Rubrique;
	private JButton btnList;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnExit;
	private JTabbedPane tabbedPane;
	private JPanel PANELADDUSER;
	private JComboBox<String> comboBox_1;
	private JTable table;
	private int rows1;
	private JTextField textField_id_eleve;
	private JTable table_1;
	private JTextField TFClasse;
	private JTextField TFScolarite;
	private JTextField TFNom_Rubrique;
	private JTextField TFDate_limite;
	private JTextField textField_nom_module;
	private JTextField textField_coeff;
	private JTable table_2;
	private Dao<Personne> dataSourceU;
	private Dao<Eleves> dataSourceEleve;
	private EleveModel model;
	private Dao<Rubrique> dataSourceRurique;
	private Dao<Module> dataSourceModule;
	private ModuleModel modelModule;
	private JButton btnAddModule;
	private JButton btnModifierModule;
	private JButton btnSuppModule;
	private JButton btnClearModule;
	private JButton btnDeconnexion;
	private JButton btnAAcceuil;
	private JButton ButtonModule;
	private JTextField TFSectionRubrique;
	private JComboBox<String> comboBox_rubrique;
	private JButton btnValider;
	private JButton bnModifier;

	public int getRows1() {
		return rows1;
	}

	public void setRows1(int rows1) {
		this.rows1 = rows1;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdminUi() {
		getContentPane().setForeground(SystemColor.window);
		setSize(new Dimension(1015, 671));
		setPreferredSize(new Dimension(1200, 550));
		setResizable(false);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		dataSourceU = new DBUsers();
		rubModel = new RubriqueModel();
		dataSourceRurique = new RubriqueDaoImpl();
		modelModule = new ModuleModel();
		dataSourceModule = new ModuleDaoImpl();
		JPanel panelTitre = new JPanel();
		panelTitre.setBorder(new LineBorder(new Color(47, 79, 79), 2));
		panelTitre.setBackground(SystemColor.window);
		panelTitre.setBounds(242, 0, 744, 101);
		getContentPane().add(panelTitre);
		panelTitre.setLayout(null);

		JLabel label_titre = new JLabel("Administrateur");
		label_titre.setAlignmentY(0.0f);
		label_titre.setBackground(Color.WHITE);
		label_titre.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre.setFont(new Font("Bahnschrift", label_titre.getFont().getStyle(), 35));
		model = new EleveModel();
		label_titre.setBounds(225, 11, 324, 58);
		panelTitre.add(label_titre);

		JLabel label_logo_titre = new JLabel("");
		label_logo_titre.setForeground(SystemColor.activeCaption);
		label_logo_titre.setBackground(SystemColor.activeCaption);
		label_logo_titre
				.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\school_icon (2).png"));
		label_logo_titre.setBounds(641, 11, 103, 58);
		panelTitre.add(label_logo_titre);

		JPanel panel_NU = new JPanel();
		panel_NU.setBackground(new Color(47, 79, 79));
		panel_NU.setBounds(10, 208, 222, 53);
		getContentPane().add(panel_NU);
		panel_NU.setLayout(null);
		
				JLabel label_new_utlilisateur = new JLabel("");
				label_new_utlilisateur.setBackground(Color.DARK_GRAY);
				label_new_utlilisateur.setBounds(0, 0, 216, 53);
				panel_NU.add(label_new_utlilisateur);
				label_new_utlilisateur.setFont(new Font("Tahoma", Font.BOLD, 13));
				label_new_utlilisateur.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\216490_add_user_icon.png"));
				
						AddUser = new JButton("Nouveau utilisateur");
						AddUser.setBounds(52, 0, 170, 53);
						panel_NU.add(AddUser);
						AddUser.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								onAddClicked();
							}

							
						});
						AddUser.setBackground(Color.LIGHT_GRAY);
						AddUser.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		
		try {
			rubModel.setRub(dataSourceRurique.list());
			modelModule.setModule(dataSourceModule.list());
		} catch (DaoException e2) {
			e2.printStackTrace();
		}
				
		JPanel panel_Certif = new JPanel();
		panel_Certif.setBackground(new Color(47, 79, 79));
		panel_Certif.setLayout(null);
		panel_Certif.setBounds(10, 354, 222, 53);
		getContentPane().add(panel_Certif);
		
				JLabel label_certificat = new JLabel("");
				label_certificat.setBackground(Color.DARK_GRAY);
				label_certificat.setBounds(0, 0, 221, 53);
				panel_Certif.add(label_certificat);
				label_certificat.setIcon(
						new ImageIcon("C:\\Users\\HP\\Downloads\\7076580_bill_invoice_receipt_signature_contract_icon.png"));
				
						JButton CertificatDS = new JButton("Certificat de Scolarité");
						CertificatDS.setBounds(52, 0, 170, 53);
						panel_Certif.add(CertificatDS);
						CertificatDS.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								onCertifClicked();
							}
						});
						CertificatDS.setBackground(Color.LIGHT_GRAY);
						CertificatDS.setFont(new Font("Trebuchet MS", Font.BOLD, 14));

		JPanel panel_ActiviteCai = new JPanel();
		panel_ActiviteCai.setBackground(new Color(47, 79, 79));
		panel_ActiviteCai.setLayout(null);
		panel_ActiviteCai.setBounds(10, 282, 222, 53);
		getContentPane().add(panel_ActiviteCai);
		
				JLabel label_module_2 = new JLabel("");
				label_module_2.setBackground(Color.DARK_GRAY);
				label_module_2.setBounds(0, 0, 223, 53);
				panel_ActiviteCai.add(label_module_2);
				label_module_2.setIcon(
						new ImageIcon("C:\\Users\\HP\\Downloads\\3643772_folder_archive_open_archives_document_icon.png"));
				label_module_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
				
						Rubrique = new JButton("Rubrique");
						Rubrique.setBounds(52, 0, 170, 53);
						panel_ActiviteCai.add(Rubrique);
						Rubrique.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								onRubriqueClicked();
								
							}
						});
						
								Rubrique.setBackground(Color.LIGHT_GRAY);
								Rubrique.setFont(new Font("Trebuchet MS", Font.BOLD, 18));

		JPanel panel_Rubrique = new JPanel();
		panel_Rubrique.setBackground(new Color(47, 79, 79));
		panel_Rubrique.setLayout(null);
		panel_Rubrique.setBounds(10, 490, 222, 53);
		getContentPane().add(panel_Rubrique);
		
		JLabel label_choix = new JLabel("");
		label_choix.setBackground(Color.WHITE);
		label_choix.setBounds(0, 0, 222, 53);
		panel_Rubrique.add(label_choix);
		
				JButton operationSecretaire = new JButton("Changer de fenetre");
				operationSecretaire.setBounds(52, 0, 170, 53);
				panel_Rubrique.add(operationSecretaire);
				operationSecretaire.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						onOpSecrClicked();
						
					}
				});
				operationSecretaire.setBackground(Color.LIGHT_GRAY);
				operationSecretaire.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		modeluser = new UserModel();
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, getSize());

		JPanel panel_acceuil_certif = new JPanel();
		panel_acceuil_certif.setBorder(null);
		panel_acceuil_certif.setBounds(242, 83, 744, 538);
		getContentPane().add(panel_acceuil_certif);
		panel_acceuil_certif.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(SystemColor.window);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(0, -31, 744, 569);
		tabbedPane.setPreferredSize(new Dimension(5, 520));
		panel_acceuil_certif.add(tabbedPane);
		
		JPanel PANELACCEUIL = new JPanel();
		PANELACCEUIL.setBorder(null);
		tabbedPane.addTab("New tab", null, PANELACCEUIL, null);
		PANELACCEUIL.setLayout(null);
		
		JPanel panel_acceuil = new JPanel();
		panel_acceuil.setBackground(new Color(244, 164, 96));
		panel_acceuil.setBounds(0, 20, 744, 519);
		PANELACCEUIL.add(panel_acceuil);
		panel_acceuil.setLayout(null);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setBackground(SystemColor.window);
		labelLogo.setBorder(new LineBorder(new Color(47, 79, 79), 3));
		labelLogo.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\pexels-pixabay-301926 (2).jpg"));
		labelLogo.setBounds(0, -20, 744, 539);
		panel_acceuil.add(labelLogo);

		PANELADDUSER = new JPanel();
		PANELADDUSER.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		tabbedPane.addTab("New tab", null, PANELADDUSER, null);
		PANELADDUSER.setForeground(SystemColor.desktop);
		PANELADDUSER.setBackground(Color.WHITE);
		PANELADDUSER.setLayout(null);

		JLabel label_titre_formulaire = new JLabel("Formulaire D'inscription");
		label_titre_formulaire.setForeground(new Color(255, 255, 255));
		label_titre_formulaire.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_titre_formulaire.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre_formulaire.setBounds(147, 11, 441, 34);
		PANELADDUSER.add(label_titre_formulaire);

		JPanel panel_TF = new JPanel();
		panel_TF.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_TF.setBackground(new Color(47, 79, 79));
		panel_TF.setBounds(94, 47, 139, 373);
		PANELADDUSER.add(panel_TF);
		panel_TF.setLayout(null);

		IdTF = new JTextField();
		IdTF.setBounds(6, 10, 129, 27);
		IdTF.setMinimumSize(new Dimension(7, 25));
		IdTF.setColumns(10);
		panel_TF.add(IdTF);

		NomTF = new JTextField();
		NomTF.setBounds(6, 42, 129, 32);
		NomTF.setColumns(10);
		panel_TF.add(NomTF);

		PrenomTF = new JTextField();
		PrenomTF.setBounds(6, 79, 129, 32);
		panel_TF.add(PrenomTF);
		PrenomTF.setColumns(10);

		EmailTF = new JTextField();
		EmailTF.setBounds(6, 163, 129, 32);
		EmailTF.setColumns(10);
		panel_TF.add(EmailTF);

		NumeroTF = new JTextField();
		NumeroTF.setBounds(6, 205, 129, 32);
		NumeroTF.setColumns(10);
		panel_TF.add(NumeroTF);

		LoginTF = new JTextField();
		LoginTF.setBounds(6, 247, 129, 32);
		LoginTF.setColumns(10);
		panel_TF.add(LoginTF);

		PasswordTF = new JTextField();
		PasswordTF.setBounds(6, 289, 129, 32);
		PasswordTF.setColumns(10);
		panel_TF.add(PasswordTF);

		ConfPassTF = new JTextField();
		ConfPassTF.setBounds(6, 331, 129, 32);
		ConfPassTF.setColumns(10);
		panel_TF.add(ConfPassTF);

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(6, 121, 129, 32);
		panel_TF.add(comboBox_1);
		comboBox_1.addItem("ADMIN");
		comboBox_1.addItem("SECRETAIRE");
		comboBox_1.addItem("CAISSIER");

		JPanel panel_lab = new JPanel();
		panel_lab.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_lab.setBackground(new Color(47, 79, 79));
		panel_lab.setBounds(0, 48, 93, 372);
		PANELADDUSER.add(panel_lab);
		panel_lab.setLayout(null);

		JLabel Idlab = new JLabel("Id");
		Idlab.setForeground(new Color(255, 255, 255));
		Idlab.setHorizontalAlignment(SwingConstants.CENTER);
		Idlab.setBounds(0, 10, 93, 30);
		Idlab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_lab.add(Idlab);

		JLabel Nomlab = new JLabel("Nom");
		Nomlab.setForeground(new Color(255, 255, 255));
		Nomlab.setHorizontalAlignment(SwingConstants.CENTER);
		Nomlab.setBounds(0, 50, 93, 26);
		Nomlab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_lab.add(Nomlab);

		JLabel Prenomlab = new JLabel("Prenom");
		Prenomlab.setForeground(new Color(255, 255, 255));
		Prenomlab.setHorizontalAlignment(SwingConstants.CENTER);
		Prenomlab.setBounds(0, 86, 93, 26);
		Prenomlab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_lab.add(Prenomlab);

		JLabel Rolelab = new JLabel("Role");
		Rolelab.setForeground(new Color(255, 255, 255));
		Rolelab.setHorizontalAlignment(SwingConstants.CENTER);
		Rolelab.setBounds(0, 122, 93, 26);
		Rolelab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_lab.add(Rolelab);

		JLabel Emaillab = new JLabel("Email");
		Emaillab.setForeground(new Color(255, 255, 255));
		Emaillab.setHorizontalAlignment(SwingConstants.CENTER);
		Emaillab.setBounds(0, 166, 93, 30);
		Emaillab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_lab.add(Emaillab);

		JLabel Numerolab = new JLabel("Numéro");
		Numerolab.setForeground(new Color(255, 255, 255));
		Numerolab.setHorizontalAlignment(SwingConstants.CENTER);
		Numerolab.setBounds(0, 206, 93, 30);
		Numerolab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_lab.add(Numerolab);

		JLabel Loginlab = new JLabel("Login");
		Loginlab.setForeground(new Color(255, 255, 255));
		Loginlab.setHorizontalAlignment(SwingConstants.CENTER);
		Loginlab.setBounds(0, 246, 93, 30);
		Loginlab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_lab.add(Loginlab);

		JLabel Passwordlab = new JLabel("Password");
		Passwordlab.setForeground(new Color(255, 255, 255));
		Passwordlab.setHorizontalAlignment(SwingConstants.CENTER);
		Passwordlab.setBounds(0, 292, 93, 30);
		Passwordlab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_lab.add(Passwordlab);

		JLabel ConfPasslab = new JLabel("Confirmation");
		ConfPasslab.setForeground(new Color(255, 255, 255));
		ConfPasslab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ConfPasslab.setBounds(7, 332, 86, 30);
		panel_lab.add(ConfPasslab);

		JPanel panelE = new JPanel();
		panelE.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelE.setBounds(232, 47, 507, 401);
		PANELADDUSER.add(panelE);
		panelE.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 487, 390);
		panelE.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(265, 120));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		table = new JTable();
		table.setBorder(new LineBorder(new Color(47, 79, 79)));
		table.setPreferredSize(new Dimension(0, 360));
		table.setModel(modeluser);

		table.getSelectionModel();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if (i != -1) {

					IdTF.setText(modeluser.getValueAt(i, 0).toString());
					NomTF.setText(modeluser.getValueAt(i, 2).toString());
					PrenomTF.setText(modeluser.getValueAt(i, 3).toString());
					EmailTF.setText(modeluser.getValueAt(i, 4).toString());
					NumeroTF.setText(modeluser.getValueAt(i, 5).toString());
					LoginTF.setText(modeluser.getValueAt(i, 6).toString());
					PasswordTF.setText(modeluser.getValueAt(i, 7).toString());

				}
			}
		});
		scrollPane.setViewportView(table);

		JPanel panel_list_button = new JPanel();
		panel_list_button.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_list_button.setBackground(new Color(47, 79, 79));
		panel_list_button.setAlignmentY(10.0f);
		panel_list_button.setAlignmentX(20.0f);
		panel_list_button.setBounds(232, 449, 507, 52);
		PANELADDUSER.add(panel_list_button);
		panel_list_button.setLayout(null);
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnSave.setBounds(100, 10, 71, 32);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onAjouterClicked();
			}
		});
		panel_list_button.add(btnSave);

		btnList = new JButton("List");
		btnList.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnList.setBounds(181, 10, 71, 32);
		btnList.addActionListener(e -> {
			try {
				onListClicked();
			} catch (DaoException e1) {
				e1.printStackTrace();
			}
		});

		panel_list_button.add(btnList);

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnDelete.setBounds(262, 10, 71, 32);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onSupprimerClicked();
			}

		});
		panel_list_button.add(btnDelete);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnClear.setBounds(343, 10, 71, 32);
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClearClicked();
			}

		});
		panel_list_button.add(btnClear);

		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnExit.setBounds(426, 10, 71, 32);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onExitClicked();

			}

		});
		panel_list_button.add(btnExit);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnUpdate.setBounds(10, 10, 80, 32);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onUpdateClicked();

			}

		});
		panel_list_button.add(btnUpdate);
		table.getColumnModel().getColumn(0).setPreferredWidth(23);
		table.getColumnModel().getColumn(1).setPreferredWidth(42);
		table.getColumnModel().getColumn(2).setPreferredWidth(48);
		table.getColumnModel().getColumn(3).setPreferredWidth(96);
		scrollPane.setViewportView(table);
		
		JPanel panel_titre_formulaire = new JPanel();
		panel_titre_formulaire.setBackground(new Color(47, 79, 79));
		panel_titre_formulaire.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_titre_formulaire.setBounds(0, 0, 739, 45);
		PANELADDUSER.add(panel_titre_formulaire);

		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, getSize());
		
				JPanel PANELRUBRIQUE = new JPanel();
				PANELRUBRIQUE.setLayout(null);
				PANELRUBRIQUE.setForeground(Color.WHITE);
				PANELRUBRIQUE.setBackground(Color.WHITE);
				tabbedPane.addTab("New tab", null, PANELRUBRIQUE, null);
						
								JPanel panelE_rubrique = new JPanel();
								panelE_rubrique.setBorder(null);
								panelE_rubrique.setBackground(SystemColor.window);
								panelE_rubrique.setLayout(null);
								panelE_rubrique.setBounds(0, 0, 739, 549);
								PANELRUBRIQUE.add(panelE_rubrique);
								
										JScrollPane scrollPane_1 = new JScrollPane();
										scrollPane_1.setBorder(new LineBorder(new Color(47, 79, 79), 2));
										scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
										scrollPane_1.setPreferredSize(new Dimension(265, 150));
										scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
										scrollPane_1.setBounds(0, 203, 733, 340);
										
										
										table_1 = new JTable();
										table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
										table_1.setBackground(SystemColor.window);
										table_1.setPreferredSize(new Dimension(100, 315));
										table_1.setModel(rubModel);
										table_1.addMouseListener(new java.awt.event.MouseAdapter() {
								            public void mouseClicked(MouseEvent evt) {
								            	onValueChange(evt);
								            }
								        });
						
										
												//table_1.getSelectionModel();
										
												scrollPane_1.setViewportView(table_1);
												panelE_rubrique.add(scrollPane_1);
												
												JPanel panel_2_2 = new JPanel();
												panel_2_2.setBorder(new LineBorder(new Color(47, 79, 79), 2));
												panel_2_2.setBackground(SystemColor.window);
												panel_2_2.setBounds(426, 48, 148, 58);
												panelE_rubrique.add(panel_2_2);
												panel_2_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
												
												JLabel lblNewLabel_4_2 = new JLabel("Classe");
												panel_2_2.add(lblNewLabel_4_2);
												lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
												lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 11));
												
												TFClasse = new JTextField();
												TFClasse.setFont(new Font("Tahoma", Font.BOLD, 12));
												panel_2_2.add(TFClasse);
												TFClasse.setColumns(10);
												
												JPanel panel_2_3 = new JPanel();
												panel_2_3.setBorder(new LineBorder(new Color(47, 79, 79), 2));
												panel_2_3.setBackground(SystemColor.window);
												panel_2_3.setBounds(22, 120, 172, 58);
												panelE_rubrique.add(panel_2_3);
												panel_2_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
												
												JLabel label_scolarite = new JLabel("Scolarite");
												panel_2_3.add(label_scolarite);
												label_scolarite.setHorizontalAlignment(SwingConstants.CENTER);
												label_scolarite.setFont(new Font("Tahoma", Font.BOLD, 11));
												
												TFScolarite = new JTextField();
												TFScolarite.setFont(new Font("Tahoma", Font.BOLD, 12));
												panel_2_3.add(TFScolarite);
												TFScolarite.setColumns(10);
												
												JPanel panel_2_4 = new JPanel();
												panel_2_4.setBorder(new LineBorder(new Color(47, 79, 79), 2));
												panel_2_4.setBackground(SystemColor.window);
												panel_2_4.setBounds(222, 48, 172, 58);
												panelE_rubrique.add(panel_2_4);
												panel_2_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
												
												JLabel label_nom_rubrique = new JLabel("Nom Rubrique ");
												panel_2_4.add(label_nom_rubrique);
												label_nom_rubrique.setHorizontalAlignment(SwingConstants.CENTER);
												label_nom_rubrique.setFont(new Font("Tahoma", Font.BOLD, 11));
												
												TFNom_Rubrique = new JTextField();
												TFNom_Rubrique.setFont(new Font("Tahoma", Font.BOLD, 12));
												panel_2_4.add(TFNom_Rubrique);
												TFNom_Rubrique.setColumns(10);
												
												JPanel panel_2_5 = new JPanel();
												panel_2_5.setBorder(new LineBorder(new Color(47, 79, 79), 2));
												panel_2_5.setBackground(SystemColor.window);
												panel_2_5.setBounds(222, 120, 172, 58);
												panelE_rubrique.add(panel_2_5);
												panel_2_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
												
												JLabel label_date_limite = new JLabel("Date limite");
												panel_2_5.add(label_date_limite);
												label_date_limite.setHorizontalAlignment(SwingConstants.CENTER);
												label_date_limite.setFont(new Font("Tahoma", Font.BOLD, 11));
												
												TFDate_limite = new JTextField();
												TFDate_limite.setFont(new Font("Tahoma", Font.BOLD, 12));
												TFDate_limite.setColumns(10);
												panel_2_5.add(TFDate_limite);
												
												JPanel panel_2 = new JPanel();
												panel_2.setBorder(new LineBorder(new Color(47, 79, 79), 2));
												panel_2.setBackground(SystemColor.window);
												panel_2.setBounds(22, 48, 172, 58);
												panelE_rubrique.add(panel_2);
												panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
												
												JLabel lblSection = new JLabel("Section");
												lblSection.setHorizontalAlignment(SwingConstants.CENTER);
												lblSection.setFont(new Font("Tahoma", Font.BOLD, 13));
												panel_2.add(lblSection);
												
												TFSectionRubrique = new JTextField();
												TFSectionRubrique.setFont(new Font("Tahoma", Font.BOLD, 12));
												panel_2.add(TFSectionRubrique);
												TFSectionRubrique.setColumns(10);
												
												comboBox_rubrique = new JComboBox<String>();
												comboBox_rubrique.setModel(new DefaultComboBoxModel(new String[] {"Selectionner"}));
												comboBox_rubrique.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
												comboBox_rubrique.addItemListener(new ItemListener() {
													
													@Override
													public void itemStateChanged(ItemEvent arg0) {
														onListRubriqueClicked(arg0);
														
													}
												});
												comboBox_rubrique.setBounds(605, 158, 103, 30);
												panelE_rubrique.add(comboBox_rubrique);
												
												JPanel panel_16 = new JPanel();
												panel_16.setBackground(SystemColor.window);
												panel_16.setBorder(new LineBorder(new Color(47, 79, 79), 2));
												panel_16.setBounds(0, 6, 583, 197);
												panelE_rubrique.add(panel_16);
												
												JPanel panel_17 = new JPanel();
												panel_17.setBackground(new Color(47, 79, 79));
												panel_17.setBorder(new LineBorder(new Color(47, 79, 79), 2));
												panel_17.setBounds(585, 24, 148, 184);
												panelE_rubrique.add(panel_17);
												panel_17.setLayout(null);
												
												JButton btnClearRubrique = new JButton("Clear");
												btnClearRubrique.addActionListener(new ActionListener() {
													
													@Override
													public void actionPerformed(ActionEvent arg0) {
														onClearRubriqueClicked();
														
													}
												});
												btnClearRubrique.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
												btnClearRubrique.setBounds(82, 16, 60, 37);
												panel_17.add(btnClearRubrique);
												
												bnModifier = new JButton("Modifier");
												this.bnModifier.setEnabled(false);
												bnModifier.setBounds(19, 59, 104, 30);
												panel_17.add(bnModifier);
												bnModifier.addActionListener(new ActionListener() {
													
													@Override
													public void actionPerformed(ActionEvent arg0) {
														onModifierClicked();
														
													}
												});
												bnModifier.setFont(new Font("Times New Roman", Font.BOLD, 13));
												
												JButton btnSupprimer = new JButton("Supprimer");
												btnSupprimer.setBounds(19, 98, 104, 30);
												panel_17.add(btnSupprimer);
												btnSupprimer.addActionListener(new ActionListener() {
													
													@Override
													public void actionPerformed(ActionEvent arg0) {
														onSupClicked();
														
													}
												});
												btnSupprimer.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
												
												btnValider = new JButton("Valider");
												btnValider.setBounds(6, 16, 64, 37);
												panel_17.add(btnValider);
												btnValider.addActionListener(new ActionListener() {
													@Override
													public void actionPerformed(ActionEvent e) {
														onValiderClicked();
													}
												});
												btnValider.setFont(new Font("Trebuchet MS", Font.BOLD, 13));

		JPanel PANELCERTIFICAT = new JPanel();
		PANELCERTIFICAT.setBorder(null);
		tabbedPane.addTab("New tab", null, PANELCERTIFICAT, null);
		PANELCERTIFICAT.setForeground(Color.WHITE);
		PANELCERTIFICAT.setBackground(Color.WHITE);
		PANELCERTIFICAT.setLayout(null);

		JPanel panel_attestation_ins = new JPanel();
		panel_attestation_ins.setBackground(SystemColor.window);
		panel_attestation_ins.setBorder(new LineBorder(new Color(47, 79, 79), 3));
		panel_attestation_ins.setBounds(-1, 89, 745, 450);
		PANELCERTIFICAT.add(panel_attestation_ins);
		panel_attestation_ins.setLayout(null);

		JLabel label_titre_cerificat = new JLabel(
				"Je soussigné M Diop Moustapha.Directeur de l'Enseignement , de la formation et de ");
		label_titre_cerificat.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre_cerificat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_titre_cerificat.setVerticalAlignment(SwingConstants.TOP);
		label_titre_cerificat.setBounds(10, 43, 689, 23);
		panel_attestation_ins.add(label_titre_cerificat);

		JLabel label_Mr_Mme = new JLabel("Mme,M ");
		label_Mr_Mme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_Mr_Mme.setVerticalAlignment(SwingConstants.TOP);
		label_Mr_Mme.setBounds(154, 109, 57, 23);
		panel_attestation_ins.add(label_Mr_Mme);

		JLabel label_titre_attestation = new JLabel("ATTESTATION D'INSCRIPTION");
		label_titre_attestation.setBorder(new LineBorder(SystemColor.desktop, 2));
		label_titre_attestation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_titre_attestation.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre_attestation.setBounds(154, 10, 382, 29);
		panel_attestation_ins.add(label_titre_attestation);

		JLabel label_date = new JLabel("Né(e) le ");
		label_date.setVerticalAlignment(SwingConstants.TOP);
		label_date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_date.setBounds(154, 142, 73, 23);
		panel_attestation_ins.add(label_date);

		JLabel label_info = new JLabel("est régulairement inscrit(e) en ");
		label_info.setVerticalAlignment(SwingConstants.TOP);
		label_info.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_info.setBounds(10, 187, 220, 29);
		panel_attestation_ins.add(label_info);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.window);
		panel_6.setBounds(231, 182, 100, 29);
		panel_attestation_ins.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JLabel AffClasse = new JLabel("");
		AffClasse.setHorizontalAlignment(SwingConstants.CENTER);
		AffClasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(AffClasse);

		JLabel label_cycle = new JLabel("pour le cycle de ");
		label_cycle.setVerticalAlignment(SwingConstants.TOP);
		label_cycle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_cycle.setBounds(341, 187, 122, 29);
		panel_attestation_ins.add(label_cycle);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(SystemColor.window);
		panel_6_1.setBounds(463, 187, 100, 23);
		panel_attestation_ins.add(panel_6_1);
		panel_6_1.setLayout(null);
		
		JLabel AffSession = new JLabel("");
		AffSession.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AffSession.setBounds(0, 0, 100, 23);
		panel_6_1.add(AffSession);

		JLabel label_recherche = new JLabel("la Recherche de Elite School ,atteste que:");
		label_recherche.setVerticalAlignment(SwingConstants.TOP);
		label_recherche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_recherche.setBounds(58, 70, 583, 29);
		panel_attestation_ins.add(label_recherche);

		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBackground(SystemColor.window);
		panel_6_2.setBounds(237, 109, 100, 23);
		panel_attestation_ins.add(panel_6_2);
		panel_6_2.setLayout(null);

		JLabel AffNom = new JLabel("");
		AffNom.setBackground(SystemColor.controlShadow);
		AffNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AffNom.setBounds(0, 0, 100, 23);
		panel_6_2.add(AffNom);

		JPanel panel_6_3 = new JPanel();
		panel_6_3.setBackground(SystemColor.window);
		panel_6_3.setBounds(237, 142, 100, 23);
		panel_attestation_ins.add(panel_6_3);
		panel_6_3.setLayout(null);

		JLabel AffDDN = new JLabel("");
		AffDDN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AffDDN.setBounds(0, 0, 100, 23);
		panel_6_3.add(AffDDN);

		JLabel label_annee = new JLabel("Année Scolaire 2022-2023");
		label_annee.setVerticalAlignment(SwingConstants.TOP);
		label_annee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_annee.setBounds(10, 242, 220, 38);
		panel_attestation_ins.add(label_annee);

		JPanel panel_6_2_1 = new JPanel();
		panel_6_2_1.setBackground(SystemColor.window);
		panel_6_2_1.setLayout(null);
		panel_6_2_1.setBounds(341, 109, 122, 23);
		panel_attestation_ins.add(panel_6_2_1);

		JLabel AffPrenom = new JLabel("");
		AffPrenom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AffPrenom.setBounds(0, 0, 122, 23);
		panel_6_2_1.add(AffPrenom);

		JLabel label_lieu = new JLabel("à");
		label_lieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_lieu.setBounds(349, 141, 30, 23);
		panel_attestation_ins.add(label_lieu);

		JPanel panel_6_3_1 = new JPanel();
		panel_6_3_1.setBackground(SystemColor.window);
		panel_6_3_1.setLayout(null);
		panel_6_3_1.setBounds(396, 142, 122, 23);
		panel_attestation_ins.add(panel_6_3_1);

		JLabel Afflieu = new JLabel("");
		Afflieu.setBackground(SystemColor.window);
		Afflieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Afflieu.setBounds(0, 0, 122, 23);
		panel_6_3_1.add(Afflieu);

		JPanel panel_search_eleve = new JPanel();
		panel_search_eleve.setBackground(SystemColor.window);
		panel_search_eleve.setBorder(null);
		panel_search_eleve.setBounds(0, -11, 744, 102);
		PANELCERTIFICAT.add(panel_search_eleve);
		panel_search_eleve.setLayout(null);
		
				textField_id_eleve = new JTextField();
				textField_id_eleve.setBounds(234, 36, 146, 41);
				panel_search_eleve.add(textField_id_eleve);
				textField_id_eleve.setColumns(10);
				Remplir = new JButton("GO");
				Remplir.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
				Remplir.setBounds(390, 36, 88, 41);
				panel_search_eleve.add(Remplir);
				
				JLabel label_search_ = new JLabel("Rechercher :");
				label_search_.setFont(new Font("Tahoma", Font.BOLD, 15));
				label_search_.setHorizontalAlignment(SwingConstants.CENTER);
				label_search_.setBounds(10, 36, 214, 41);
				panel_search_eleve.add(label_search_);
				Remplir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							onChercherIdClicked();
						} catch (DaoException e) {

						}
					}

					private void onChercherIdClicked() throws DaoException {
						String id = textField_id_eleve.getText();
						List<Eleves> eleves = dataSourceEleve.list();
						for (Eleves eleve : eleves) {

							if (eleve.getIdentifiant().equals(id)) {
								AffNom.setText(eleve.getNom_etudiant());
								AffPrenom.setText(eleve.getPrenom_etudiant());
								AffDDN.setText(eleve.getDate_naissance());
								Afflieu.setText(eleve.getLieu_naissance());
								AffClasse.setText(eleve.getClasse());
								AffSession.setText(eleve.getSection());
							}
						}
					}
				});
				
			dataSourceEleve = new EleveDaoImple();
			model = new EleveModel();
			try {
				model.setEtudiants(dataSourceEleve.list());
	
			} catch (DaoException e) {
				e.printStackTrace();
		}
		
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Section ";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				comboBox_rubrique.addItem(rs.getString("nom_section"));
				
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		JPanel PANELMODULE = new JPanel();
		PANELMODULE.setBorder(new LineBorder(new Color(47, 79, 79), 2));
		PANELMODULE.setBackground(SystemColor.window);
		tabbedPane.addTab("New tab", null, PANELMODULE, null);
		PANELMODULE.setLayout(null);
		
		JPanel panel_module = new JPanel();
		panel_module.setBackground(SystemColor.window);
		panel_module.setBorder(null);
		panel_module.setBounds(0, 5, 739, 506);
		PANELMODULE.add(panel_module);
		panel_module.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(47, 79, 79));
		panel_9.setBorder(null);
		panel_9.setBounds(0, 0, 739, 31);
		panel_module.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel label_add_module = new JLabel("Ajouter des modules");
		label_add_module.setForeground(new Color(255, 255, 255));
		label_add_module.setHorizontalAlignment(SwingConstants.CENTER);
		label_add_module.setFont(new Font("Times New Roman", Font.BOLD, 19));
		label_add_module.setBounds(159, 6, 370, 26);
		panel_9.add(label_add_module);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.window);
		panel_10.setBorder(new LineBorder(new Color(47, 79, 79), 2));
		panel_10.setBounds(10, 34, 285, 366);
		panel_module.add(panel_10);
		panel_10.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(47, 79, 79));
		panel_11.setBorder(new LineBorder(new Color(47, 79, 79), 2));
		panel_11.setBounds(0, 5, 285, 41);
		panel_10.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel label_titre_formulaire_module = new JLabel("Formulaire");
		label_titre_formulaire_module.setForeground(new Color(255, 255, 255));
		label_titre_formulaire_module.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_titre_formulaire_module.setHorizontalAlignment(SwingConstants.CENTER);
		label_titre_formulaire_module.setBounds(10, 0, 265, 41);
		panel_11.add(label_titre_formulaire_module);
		
		JLabel label_module = new JLabel("Nom module :");
		label_module.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_module.setHorizontalAlignment(SwingConstants.CENTER);
		label_module.setBounds(10, 56, 111, 41);
		panel_10.add(label_module);
		
		JLabel label_coef = new JLabel("Coefficient :");
		label_coef.setHorizontalAlignment(SwingConstants.CENTER);
		label_coef.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_coef.setBounds(10, 129, 111, 41);
		panel_10.add(label_coef);
		
		textField_nom_module = new JTextField();
		textField_nom_module.setBounds(139, 56, 136, 41);
		panel_10.add(textField_nom_module);
		textField_nom_module.setColumns(10);
		
		textField_coeff = new JTextField();
		textField_coeff.setBounds(137, 129, 138, 41);
		panel_10.add(textField_coeff);
		textField_coeff.setColumns(10);
		
		btnAddModule = new JButton("Ajouter");
		btnAddModule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onModuleClicked();
				
			}
		});
		btnAddModule.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnAddModule.setBounds(36, 227, 96, 41);
		panel_10.add(btnAddModule);
		
		btnModifierModule = new JButton("Modifier");
		btnModifierModule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onModifierModuleClicked();
				
			}
		});
		btnModifierModule.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnModifierModule.setEnabled(false);
		btnModifierModule.setBounds(162, 227, 113, 41);
		panel_10.add(btnModifierModule);
		
		btnSuppModule = new JButton("Supprimer");
		btnSuppModule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onDeleteModuleClicked();
				
			}
		});
		btnSuppModule.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnSuppModule.setBounds(162, 301, 113, 41);
		panel_10.add(btnSuppModule);
		
		btnClearModule = new JButton("Clear");
		btnClearModule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClearModuleClicked();
				
			}
		});
		btnClearModule.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnClearModule.setBounds(36, 301, 96, 41);
		panel_10.add(btnClearModule);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(47, 79, 79), 2));
		panel_12.setBounds(305, 34, 434, 366);
		panel_module.add(panel_12);
		panel_12.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 5, 434, 361);
		panel_12.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setBackground(SystemColor.window);
		table_2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {				
				onValueChanged3();
			}
		});
		table_2.setModel(modelModule);
		table_2.setPreferredSize(new Dimension(0, 335));
		scrollPane_2.setColumnHeaderView(table_2);
		scrollPane_2.setViewportView(table_2);
		
		JPanel panel_btn_deconnexion = new JPanel();
		panel_btn_deconnexion.setBackground(new Color(47, 79, 79));
		
		panel_btn_deconnexion.setBounds(10, 555, 222, 53);
		getContentPane().add(panel_btn_deconnexion);
				panel_btn_deconnexion.setLayout(null);
				
				JLabel labeldeconnexion = new JLabel("");
				labeldeconnexion.setBackground(Color.DARK_GRAY);
				labeldeconnexion.setBounds(0, 0, 222, 53);
				panel_btn_deconnexion.add(labeldeconnexion);
				
				btnDeconnexion = new JButton("Deconnexion");
				btnDeconnexion.setBackground(new Color(178, 34, 34));
				btnDeconnexion.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						onExitClicked();
						
					}
				});
				btnDeconnexion.setBounds(52, 0, 170, 53);
				panel_btn_deconnexion.add(btnDeconnexion);
				btnDeconnexion.setFont(new Font("Tahoma", Font.BOLD, 13));
				
						JPanel panel_PaiETS = new JPanel();
						panel_PaiETS.setBackground(new Color(47, 79, 79));
						panel_PaiETS.setBounds(10, 419, 222, 59);
						getContentPane().add(panel_PaiETS);
						panel_PaiETS.setLayout(null);
						
						ButtonModule = new JButton("Module");
						ButtonModule.setBackground(Color.LIGHT_GRAY);
						ButtonModule.setBounds(52, 0, 170, 53);
						panel_PaiETS.add(ButtonModule);
						ButtonModule.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								onModulelClicked();
								
							}
						});
						ButtonModule.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
						
						JPanel panel_acceuil_btn = new JPanel();
						panel_acceuil_btn.setBackground(new Color(47, 79, 79));
						panel_acceuil_btn.setBounds(10, 135, 222, 53);
						getContentPane().add(panel_acceuil_btn);
						panel_acceuil_btn.setLayout(null);
						
						JLabel label_btn_acceuil = new JLabel("");
						label_btn_acceuil.setBackground(Color.DARK_GRAY);
						label_btn_acceuil.setBounds(0, 0, 222, 53);
						panel_acceuil_btn.add(label_btn_acceuil);
						
						btnAAcceuil = new JButton("Acceuil");
						btnAAcceuil.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								onAcceuillClicked();
								
							}
						});
						btnAAcceuil.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
						btnAAcceuil.setBounds(52, 0, 170, 53);
						panel_acceuil_btn.add(btnAAcceuil);
						
						JPanel panel_button_acceuil = new JPanel();
						panel_button_acceuil.setBorder(new LineBorder(new Color(0, 0, 0), 3));
						panel_button_acceuil.setBackground(new Color(47, 79, 79));
						panel_button_acceuil.setBounds(0, 0, 240, 631);
						getContentPane().add(panel_button_acceuil);
						panel_button_acceuil.setLayout(null);
						
						JLabel label_logo = new JLabel("");
						label_logo.setHorizontalAlignment(SwingConstants.CENTER);
						label_logo.setIcon(new ImageIcon("C:\\Users\\rokya\\Documents\\java\\projet java\\projet_final_gestion_scolaire\\src\\sn\\esmt\\java\\image\\admin_icon.png"));
						label_logo.setBounds(43, 6, 173, 120);
						panel_button_acceuil.add(label_logo);
	}

	
	private void onClearRubriqueClicked() {
		this.TFSectionRubrique.setText(null);
		this.TFNom_Rubrique.setText(null);
		this.TFClasse.setText(null);
		this.TFScolarite.setText(null);
		this.TFDate_limite.setText(null);
		this.bnModifier.setEnabled(false);
		this.btnValider.setEnabled(true);
	}

	private void onAcceuillClicked() {
		tabbedPane.setSelectedIndex(0);
	}

	private void onAddClicked() {
		tabbedPane.setSelectedIndex(1);

	}
	
	private void onRubriqueClicked() {
		tabbedPane.setSelectedIndex(2);
	}
	
	private void onCertifClicked() {
		tabbedPane.setSelectedIndex(3);

	}
	
	private void onModulelClicked() {
		tabbedPane.setSelectedIndex(4);
	}
	
	
	private void onOpSecrClicked() {
		ChoixAdmin admin = new ChoixAdmin();
		admin.show2();
		this.dispose();
	}
	
	

	private void onExitClicked() {
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Fermer l'application ?")) {
			Authentification authentification = new Authentification();
			authentification.lancer();
			this.dispose();

		}
	}
	
	private void onListRubriqueClicked(ItemEvent arg0) {
		String value = (String) comboBox_rubrique.getSelectedItem();
			String sql= "Select * from Rubrique where section='"+value+"' ";
	        try(Connection connection = DBManager.getConnection()){
	        PreparedStatement pst=connection.prepareStatement(sql);
	        ResultSet rs=  pst.executeQuery();
	        table_1.setModel(DbUtils.resultSetToTableModel(rs));
	        } catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	
	private void onValiderClicked() {
		String section = TFSectionRubrique.getText();
		String nom =TFNom_Rubrique.getText();
		String classe = TFClasse.getText();
		double montant = Double.valueOf(TFScolarite.getText());
		String date= TFDate_limite.getText();
		Rubrique rubrique;
		rubrique= new Rubrique(section, nom, classe,montant,date);
		
		try {
			dataSourceRurique.create(rubrique);
			rubModel.setRub(dataSourceRurique.list());
			reinitRubrique();
		} catch (DaoException e) {
			e.printStackTrace();
			}
		}
		
	

	private void onListClicked() throws DaoException {
		modeluser.setUsers(dataSourceU.list());
	}

	private void onAjouterClicked() {
		String id = IdTF.getText();
		Integer id1 = Integer.valueOf(id);
		String nom = NomTF.getText();
		String prenom = PrenomTF.getText();
		String rol = (String) comboBox_1.getSelectedItem();
		String email = EmailTF.getText();
		String numero = NumeroTF.getText();
		String log = LoginTF.getText();
		String pwd = PasswordTF.getText();
		String pwdC = ConfPassTF.getText();
		if (log.isEmpty() && pwd.isEmpty() && nom.isEmpty() && prenom.isEmpty() && email.isEmpty()
				&& numero.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Veuiller remplire toute les sections");

		} else if (log.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Veuiller bien remplire la section login");
			System.out.println(log.getClass().getName());
		} else if (pwd.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Veuiller bien remplire la section password");

		} else if (nom.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Veuiller bien remplire la section nom");

		} else if (prenom.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Veuiller bien remplire la section prenom");

		} else if (email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Veuiller bien remplire la section email");

		} else if (numero.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Veuiller bien remplire la section numero");

		}

		else {
			try {
				Personne user;
				if (pwd.equals(pwdC) && rol.equals("ADMIN")) {
					user = new Administrateur(id1, nom, prenom, log, pwd, rol, email, numero);
					dataSourceU.create(user);
				} else if (pwd.equals(pwdC) && rol.equals("SECRETAIRE")) {
					user = new Secretaire(id1, nom, prenom, log, pwd, rol, email, numero);
					dataSourceU.create(user);

				} else if (pwd.equals(pwdC) && rol.equals("CAISSIER")) {
					user = new Caissier(id1, nom, prenom, log, pwd, rol, email, numero);
					dataSourceU.create(user);

				} else {
					JOptionPane.showMessageDialog(null, "MOTS DE PASSE PAS IDENTIQUES");
				}
				modeluser.setUsers(dataSourceU.list());
				reinitUsersDetailsForm();
			} catch (DaoException e) {
				JOptionPane.showMessageDialog(null, "Err: " + e.getMessage(), e.getClass().getSimpleName(),
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	
	private void onSupClicked() {
		int row = table_1.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(null, "Veuillez selectionner un eleve !");
		}
		else {
			int id=(int)rubModel.getValueAt(row, 0);
			try {
				dataSourceRurique.delete(id);
				rubModel.setRub(dataSourceRurique.list());
			} catch (DaoException e) {
				JOptionPane.showMessageDialog(null, "Suppression non reussit");
			}
		}
		
	}
	
	private void onValueChange(MouseEvent evt) {
		int row = table_1.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(null, "Veuillez selectionner un eleve !");
		}
		else {
	        try(Connection connection = DBManager.getConnection()){
	            
	            int table_click= (int) table_1.getModel().getValueAt(row, 0);
	            String sql= "select * from Rubrique where id= '" + table_click + "'";
	            PreparedStatement pst=connection.prepareStatement(sql);
	            ResultSet rs=  pst.executeQuery();
	            if(rs.next()){
	            	String section=rs.getString("section");
					this.TFSectionRubrique.setText(section);
					String nom=rs.getString("nom_rubrique");
					this.TFNom_Rubrique.setText(nom);
					String classe=rs.getString("classe");
					this.TFClasse.setText(classe);
					double montant=rs.getDouble("montant");
					this.TFScolarite.setText(String.valueOf(montant));
					String date=rs.getString("date_limite");
					this.TFDate_limite.setText(date);
					this.bnModifier.setEnabled(true);
					this.btnValider.setEnabled(false);
	            }
	        }
	        catch(Exception ex){
	            JOptionPane.showMessageDialog(this, "Cliquer deux fois sur un element du tableau");
				}
			}
		}
	
	
	private void onValueChanged3() {
		int row = table_2.getSelectedRow();
		if (row == -1) return;
		
		int id = (int) modelModule.getValueAt(row, 0);
		try {
			Module mod = dataSourceModule.read(id);
			this.textField_nom_module.setText(mod.getNom_module());
			this.textField_coeff.setText(String.valueOf(mod.getCoeff()));
			this.btnAddModule.setEnabled(false);
			this.btnModifierModule.setEnabled(true);
		}
		catch (DaoException e) {
			JOptionPane.showMessageDialog(null, "Selectionner un element dans le tableau");
		}
		
	}
	
	private void onModuleClicked() {
			String nom =textField_nom_module.getText();
			int coeff=Integer.valueOf(textField_coeff.getText());
			Module mod;
			mod= new Module(nom, coeff);
			try {
				dataSourceModule.create(mod);
				modelModule.setModule(dataSourceModule.list());
				this.textField_coeff.setText(null);
				this.textField_nom_module.setText(null);
			} catch (DaoException e) {
				e.printStackTrace();
			}
		
	}
	
	private void onModifierModuleClicked() {
		int a=table_1.getSelectedRow();
		if (a==-1) return;
		
		String nom =textField_nom_module.getText();
		int coeff=Integer.valueOf(textField_coeff.getText());
		Module mod;
		mod= new Module(nom, coeff);
		try {
			dataSourceModule.update(mod);
			modelModule.setModule(dataSourceModule.list());
			this.textField_coeff.setText(null);
			this.textField_nom_module.setText(null);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}


	private void onModifierClicked() {
		int a=table_1.getSelectedRow();
		if (a==-1) return;
		
		String section = TFSectionRubrique.getText();
		String nom =TFNom_Rubrique.getText();
		String classe = TFClasse.getText();
		double montant = Double.valueOf(TFScolarite.getText());
		String date= TFDate_limite.getText();
		Rubrique rubrique;
		rubrique= new Rubrique(section,nom, classe,montant,date);
		try {
			dataSourceRurique.update(rubrique);
			rubModel.setRub(dataSourceRurique.list());
			reinitRubrique();
			JOptionPane.showMessageDialog(null, "Modifier avec succes");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Modificatin non reussit");
		}		
	}

	private void reinitUsersDetailsForm() {
		this.IdTF.setText(null);
		this.LoginTF.setText(null);
		this.ConfPassTF.setText(null);
		this.NomTF.setText(null);
		this.PrenomTF.setText(null);
		this.EmailTF.setText(null);
		this.NumeroTF.setText(null);
		this.PasswordTF.setText(null);

	}
	
	private void reinitRubrique() {
		this.TFSectionRubrique.setText(null);
		this.TFNom_Rubrique.setText(null);
		this.TFClasse.setText(null);
		this.TFScolarite.setText(null);
		this.TFDate_limite.setText(null);
	}

	@SuppressWarnings("unused")
	private void onRowSelected() {
		int row = table.getSelectedRow();

		int id = (int) modeluser.getValueAt(row, 0);
		try {
			Personne user = dataSourceU.read(id);

			this.LoginTF.setText(user.getLogin());
			this.PasswordTF.setText(user.getPassword());
			this.NomTF.setText(user.getNom());
			this.PrenomTF.setText(user.getPrenom());
			this.NomTF.setText(user.getNom());
			this.EmailTF.setText(user.getEmail());
			this.NumeroTF.setText(user.getNuméro());

		} catch (DaoException e) {
		}
	}

	private void onUpdateClicked() {

		int i = table.getSelectedRow();
		if (i == -1)
			return;

		int id = (int) table.getValueAt(i, 0);

		Integer iden = Integer.valueOf(id);
		String nom = NomTF.getText();
		String prenom = PrenomTF.getText();
		String rol = (String) comboBox_1.getSelectedItem();
		String email = EmailTF.getText();
		String numero = NumeroTF.getText();
		String log = LoginTF.getText();
		String pwd = PasswordTF.getText();

		try {
			Personne newUser;

			newUser = new Personne(iden, nom, prenom, log, pwd, rol, email, numero);

			dataSourceU.update(newUser);
			reinitUsersDetailsForm();
			modeluser.setUsers(dataSourceU.list());

			reinitUsersDetailsForm();
		} catch (DaoException e) {
			JOptionPane.showMessageDialog(null, "Err: " + e.getMessage(), e.getClass().getSimpleName(),
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void onSupprimerClicked() {
		int row = table.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur !");
		} else {
			int id = (int) modeluser.getValueAt(row, 0);
			try {
				dataSourceU.delete(id);
				modeluser.setUsers(dataSourceU.list());
				reinitUsersDetailsForm();

			} catch (DaoException e) {
			}
		}
	}
	
	private void onDeleteModuleClicked() {
		int row = table_2.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur !");
		} else {
			int id = (int) modeluser.getValueAt(row, 0);
			try {
				dataSourceModule.delete(id);
				modelModule.setModule(dataSourceModule.list());
				this.textField_coeff.setText(null);
				this.textField_nom_module.setText(null);

			} catch (DaoException e) {
			}
		}
		
	}
	
	private void onClearModuleClicked() {
		this.btnAddModule.setEnabled(true);
		this.btnModifierModule.setEnabled(false);
		this.textField_coeff.setText(null);
		this.textField_nom_module.setText(null);
		
	}

	private void onClearClicked() {
		reinitUsersDetailsForm();
		this.modeluser.clear();

	}

	public void lancer1() {
		this.setVisible(true);
	}
}
