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

import controller.CrearNuevoCtrl;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class FrmCrearNuevo extends JDialog {

	private static final long serialVersionUID = 1L;

	public static JTextField txtNewCorreo;
	public static JTextField txtNewContra;
	public static JTextField txtNewUsuario;
	public static JTextField txtNewLocalidad;
	public static JTextField txtNewPais;
	public static JTextField txtNewTelefono;
	public static JTextField txtNewPlato;
	public static JComboBox spTipo;

	private static JLabel lblNewCorreo;
	private static JLabel lblNewUsuario;
	private static JLabel lblNewContra;
	private static JLabel lblNewTipo;
	private static JLabel lblNewTelefono;
	private static JLabel lblNewPlato;
	private static JLabel lblNewLocalidad;
	private static JLabel lblNewPais;

	private Font lblFont;
	private Font txtFont;
	private Font btnFont;

	private Color colorFondo = new Color(250, 200, 107);;

	public static final JPanel contentPane = new JPanel();
	private JPanel crearPanel;
	private JPanel delCanPanel;

	public FrmCrearNuevo() {
		createForm();
		CrearNuevoCtrl.addTipos();
	}

	public void createForm() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Crear perfil");

		contentPane.setBackground(colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new GridLayout(8, 2, 0, 0));

		// Definimos las fuentes
		lblFont = new Font("Script MT Bold", Font.PLAIN, 16);
		txtFont = new Font("Times New Roman", Font.PLAIN, 14);
		btnFont = new Font("Times New Roman", Font.PLAIN, 13);
		
		// Correo
		lblNewCorreo = new JLabel("Correo:");
		lblNewCorreo.setFont(lblFont);
		contentPane.add(lblNewCorreo);

		txtNewCorreo = new JTextField();
		txtNewCorreo.setFont(txtFont);
		contentPane.add(txtNewCorreo);

		// Usuario
		lblNewUsuario = new JLabel("Usuario:");
		lblNewUsuario.setFont(lblFont);
		contentPane.add(lblNewUsuario);

		txtNewUsuario = new JTextField();
		txtNewUsuario.setFont(txtFont);
		contentPane.add(txtNewUsuario);

		// Contraseña
		lblNewContra = new JLabel("Contraseña:");
		lblNewContra.setFont(lblFont);
		contentPane.add(lblNewContra);

		txtNewContra = new JTextField();
		// txtContra.setFont(txtFont);
		contentPane.add(txtNewContra);

		// Tipo
		lblNewTipo = new JLabel("Tipo:");
		lblNewTipo.setFont(lblFont);
		contentPane.add(lblNewTipo);

		spTipo = new JComboBox();
		contentPane.add(spTipo);

		// Telefono
		lblNewTelefono = new JLabel("Telefono:");
		lblNewTelefono.setFont(lblFont);
		contentPane.add(lblNewTelefono);

		txtNewTelefono = new JTextField();
		txtNewTelefono.setFont(txtFont);
		contentPane.add(txtNewTelefono);

		// Plato
		lblNewPlato = new JLabel("Plato:");
		lblNewPlato.setFont(lblFont);
		contentPane.add(lblNewPlato);

		txtNewPlato = new JTextField();
		txtNewPlato.setFont(txtFont);
		contentPane.add(txtNewPlato);

		// Localidad
		lblNewLocalidad = new JLabel("Localidad:");
		lblNewLocalidad.setFont(lblFont);
		contentPane.add(lblNewLocalidad);

		txtNewLocalidad = new JTextField();
		txtNewLocalidad.setFont(txtFont);
		contentPane.add(txtNewLocalidad);

		// Pais
		lblNewPais = new JLabel("Pais:");
		lblNewPais.setFont(lblFont);
		contentPane.add(lblNewPais);

		txtNewPais = new JTextField();
		txtNewPais.setFont(txtFont);
		contentPane.add(txtNewPais);

		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new GridLayout(1, 2, 0, 0));

		delCanPanel = new JPanel();
		delCanPanel.setBackground(colorFondo);
		buttonPane.add(delCanPanel);

		JButton btnCancelar = new JButton("Cancelar");
		delCanPanel.add(btnCancelar);
		btnCancelar.setFont(btnFont);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FrmListaPerfiles();
			}
		});

		JButton borrarBtn = new JButton("Borrar campos");
		borrarBtn.setFont(btnFont);
		delCanPanel.add(borrarBtn);
		borrarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearNuevoCtrl.borrarCampos();
			}
		});

		crearPanel = new JPanel();
		crearPanel.setBackground(colorFondo);
		buttonPane.add(crearPanel);

		JButton btnCrear = new JButton("Crear");
		crearPanel.add(btnCrear);
		btnCrear.setFont(btnFont);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearNuevoCtrl.addPerfil();
				dispose();
				new FrmListaPerfiles();
			}
		});
		btnCrear.setActionCommand("OK");
		getRootPane().setDefaultButton(btnCrear);

	}

}
