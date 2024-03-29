package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.PrincipalCtrl;
import utils.Data;
import utils.EdicionFch;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private static JLabel lblContrasenia;
	private static JLabel lblCorreo;

	public static JTextField txtUsuario;
	public static JPasswordField txtContra;

	public static String correo;
	public static String pass;

	public static JPanel contentPane;

	public FrmPrincipal() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				PrincipalCtrl.confirmExit();
			}
		});
		createForm();

	}

	public void createForm() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Inicio");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\chef_color_fondo.png"));

		contentPane = new JPanel();
		contentPane.setBackground(Data.colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelSup = new JPanel();
		panelSup.setBackground(Data.colorFondo);
		contentPane.add(panelSup, BorderLayout.NORTH);

		JLabel lblBienvenido = new JLabel("Bienvenido/a !!");
		lblBienvenido.setFont(new Font("Script MT Bold", Font.PLAIN, 24));
		panelSup.add(lblBienvenido);

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(Data.colorFondo);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Script MT Bold", Font.PLAIN, 16));
		lblCorreo.setBounds(112, 70, 65, 14);
		panelCentral.add(lblCorreo);

		lblContrasenia = new JLabel("Contraseņa:");
		lblContrasenia.setFont(new Font("Script MT Bold", Font.PLAIN, 16));
		lblContrasenia.setBounds(112, 93, 99, 14);
		panelCentral.add(lblContrasenia);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(221, 67, 148, 20);
		panelCentral.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContra = new JPasswordField();
		txtContra.setBounds(221, 92, 148, 20);
		panelCentral.add(txtContra);
		txtContra.setColumns(10);

		JLabel lblInfo = new JLabel("Por favor introduzca sus credenciales para poder acceder:");
		lblInfo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblInfo.setBounds(61, 24, 340, 14);
		panelCentral.add(lblInfo);

		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Data.colorFondo);
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnConecta = new JButton("Conectar");
		btnConecta.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnConecta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logueo();
			}
		});
		panelBotones.add(btnConecta);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalCtrl.borrarCampos();
			}
		});
		panelBotones.add(btnBorrar);
	}

	@SuppressWarnings("deprecation")
	public void logueo() {

		correo = txtUsuario.getText().toString();
		pass = txtContra.getText().toString();

		if (correo.equals("") || pass.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Por favor, rellene todos los campos para continuar");
		} else {
			// Comprobamos si los datos existen en la DB
			if (PrincipalCtrl.checkLogin()) {
				dispose();
				// Generamos las preferencias
				EdicionFch.genBinario(correo, pass);
				// Mandamos al usuario a la lista de perfiles
				new FrmListaPerfiles();
			} else {
				JOptionPane.showMessageDialog(contentPane, "Correo o contraseņa incorrectos");
			}
		}
	}
}
