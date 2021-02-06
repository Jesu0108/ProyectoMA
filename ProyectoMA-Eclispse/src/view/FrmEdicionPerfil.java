package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.EdicionPerfilCtrl;
import controller.ImagenesCtrl;

import java.awt.GridLayout;
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
	public static JTextField txtTipo;

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

	private Color colorFondo = new Color(250, 200, 107);
	private JPanel guarCambPanel;
	private JPanel CancelBorrPanel;


	public FrmEdicionPerfil() {
		createForm();
		EdicionPerfilCtrl.loadData();
		ImagenesCtrl.download();
	}

	public void createForm() {

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		imgPanel = new JPanel();
		imgPanel.setBackground(colorFondo);
		getContentPane().add(imgPanel, BorderLayout.NORTH);
		
		imgUsuario = new JLabel("");
		imgPanel.add(imgUsuario);
		contentPanel.setBackground(colorFondo);
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

		// Contraseņa
		lblContra = new JLabel("Contraseņa:");
		lblContra.setFont(lblFont);
		contentPanel.add(lblContra);

		txtContra = new JTextField();
		txtContra.setFont(txtFont);
		contentPanel.add(txtContra);

		// Tipo
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(lblFont);
		contentPanel.add(lblTipo);

		txtTipo = new JTextField();
		txtTipo.setFont(txtFont);
		contentPanel.add(txtTipo);

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
		CancelBorrPanel.setBackground(colorFondo);
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
		btnBorrarUser.setFont(btnFont);
		CancelBorrPanel.add(btnBorrarUser);

		guarCambPanel = new JPanel();
		guarCambPanel.setBackground(colorFondo);
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
