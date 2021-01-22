package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PrincipalCtrl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JLabel lblContrasenia;
	private static JLabel lblCorreo;
	public static JTextField txtUsuario;
	public static JTextField txtContra;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\chef_color_fondo.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelSup = new JPanel();
		contentPane.add(panelSup, BorderLayout.NORTH);

		JLabel lblBienvenido = new JLabel("Bienvenido/a !!");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panelSup.add(lblBienvenido);

		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreo.setBounds(112, 70, 65, 14);
		panelCentral.add(lblCorreo);

		lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasenia.setBounds(112, 93, 99, 14);
		panelCentral.add(lblContrasenia);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(221, 67, 148, 20);
		panelCentral.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContra = new JTextField();
		txtContra.setBounds(221, 92, 148, 20);
		panelCentral.add(txtContra);
		txtContra.setColumns(10);

		JLabel lblInfo = new JLabel("Por favor introduzca sus credenciales para poder acceder:");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfo.setBounds(54, 24, 334, 14);
		panelCentral.add(lblInfo);

		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnConecta = new JButton("Conectar");
		btnConecta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logueo();
			}
		});
		panelBotones.add(btnConecta);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalCtrl.borrarCampos();
			}
		});
		panelBotones.add(btnBorrar);
	}

	public void logueo() {
		if (txtUsuario.getText().toString().length() > 0 || txtContra.getText().toString().length() > 0) {
			if (PrincipalCtrl.checkLogin()) {
				new FrmListaPerfiles();
			} else {
				JOptionPane.showMessageDialog(contentPane, "Correo o contraseña incorrectos");
			}
		} else {
			JOptionPane.showMessageDialog(contentPane, "Por favor, rellene todos los campos para continuar");
		}
	}
}
