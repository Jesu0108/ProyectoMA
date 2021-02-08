package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.EdicionPerfilCtrl;
import controller.ImagenesCtrl;
import controller.ListaPerfilesCtrl;
import utils.Data;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEdicionPerfil extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	public static JTextField txtCorreo;
	public static JTextField txtContra;
	public static JTextField txtUsuario;
	public static JTextField txtLocalidad;
	public static JTextField txtPais;
	public static JTextField txtTelefono;
	public static JTextField txtPlato;
	@SuppressWarnings("rawtypes")
	public static JComboBox spTipo;
	
	private static JLabel lblCorreo;
	private static JLabel lblUsuario;
	private static JLabel lblContra;
	private static JLabel lblTipo;
	private static JLabel lblTelefono;
	private static JLabel lblPlato;
	private static JLabel lblLocalidad;
	private static JLabel lblPais;

	private JPanel imgPanel;
	public static JLabel imgUsuario;

	private JButton btnBorrarUser;
	private JButton btnGuardarCamb;
	private JButton btnCancelar;

	private Font lblFont;
	private Font txtFont;
	private Font btnFont;

	private JPanel guarCambPanel;
	private JPanel CancelBorrPanel;


	public FrmEdicionPerfil() {
		createForm();
		EdicionPerfilCtrl.addTipos();
		EdicionPerfilCtrl.loadData();
		ImagenesCtrl.download();
	}

	@SuppressWarnings("rawtypes")
	public void createForm() {

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("Edicion");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Data.icono));

		setBounds(100, 100, 450, 430);
		getContentPane().setLayout(new BorderLayout());
		
		imgPanel = new JPanel();
		imgPanel.setBackground(Data.colorFondo);
		getContentPane().add(imgPanel, BorderLayout.NORTH);
		
		imgUsuario = new JLabel("");
		imgPanel.add(imgUsuario);
		contentPanel.setBackground(Data.colorFondo);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(8, 2, 0, 0));

		// Definimos las fuentes
		lblFont = new Font("Script MT Bold", Font.PLAIN, 16);
		txtFont = new Font("Times New Roman", Font.PLAIN, 14);
		btnFont = new Font("Times New Roman", Font.PLAIN, 13);
		
		// Correo
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(lblFont);
		contentPanel.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setFont(txtFont);
		contentPanel.add(txtCorreo);

		// Usuario
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(lblFont);
		contentPanel.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setFont(txtFont);
		contentPanel.add(txtUsuario);

		// Contraseña
		lblContra = new JLabel("Contraseña:");
		lblContra.setFont(lblFont);
		contentPanel.add(lblContra);

		txtContra = new JTextField();
		txtContra.setFont(txtFont);
		contentPanel.add(txtContra);

		// Tipo
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(lblFont);
		contentPanel.add(lblTipo);

		spTipo = new JComboBox();
		spTipo.setFont(txtFont);
		contentPanel.add(spTipo);

		// Telefono
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(lblFont);
		contentPanel.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFont(txtFont);
		contentPanel.add(txtTelefono);

		// Plato
		lblPlato = new JLabel("Plato:");
		lblPlato.setFont(lblFont);
		contentPanel.add(lblPlato);

		txtPlato = new JTextField();
		txtPlato.setFont(txtFont);
		contentPanel.add(txtPlato);

		// Localidad
		lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(lblFont);
		contentPanel.add(lblLocalidad);

		txtLocalidad = new JTextField();
		txtLocalidad.setFont(txtFont);
		contentPanel.add(txtLocalidad);

		// Pais
		lblPais = new JLabel("Pais:");
		lblPais.setFont(lblFont);
		contentPanel.add(lblPais);

		txtPais = new JTextField();
		txtPais.setFont(txtFont);
		contentPanel.add(txtPais);

		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new GridLayout(1, 2, 0, 0));

		CancelBorrPanel = new JPanel();
		CancelBorrPanel.setBackground(Data.colorFondo);
		buttonPane.add(CancelBorrPanel);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(btnFont);
		CancelBorrPanel.add(btnCancelar);
		btnCancelar.setActionCommand("Cancel");

		btnBorrarUser = new JButton("Borrar usuario");
		btnBorrarUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EdicionPerfilCtrl.confirmDelete()) {
					dispose();
					EdicionPerfilCtrl.deleteUSer();
					ListaPerfilesCtrl.loadData();
				}else {
					dispose();
				}
			}
		});
		btnBorrarUser.setFont(btnFont);
		CancelBorrPanel.add(btnBorrarUser);

		guarCambPanel = new JPanel();
		guarCambPanel.setBackground(Data.colorFondo);
		buttonPane.add(guarCambPanel);

		btnGuardarCamb = new JButton("Guardar cambios");
		btnGuardarCamb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EdicionPerfilCtrl.saveData();
			}
		});
		btnGuardarCamb.setFont(btnFont);
		guarCambPanel.add(btnGuardarCamb);
	}
}
