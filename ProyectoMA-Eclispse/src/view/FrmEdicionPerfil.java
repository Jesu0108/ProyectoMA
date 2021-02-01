package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.EdicionPerfilCtrl;
import controller.ImagenesCtrl;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmEdicionPerfil extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTextField txtCorreo;
	public static JTextField txtContra;
	
	private static JTextField txtUsuario;
	private static JTextField txtLocalidad;
	private static JTextField txtPais;
	private static JTextField txtTelefono;
	private static JTextField txtPlato;
	private static JTextField txtTipo;
	
	private JPanel imgPanel;
	public static JLabel imgUsuario;
	private JButton btnBorrar;
	
	private Font lblFont;
	private Font txtFont;
	
	private Color colorFondo;

	public FrmEdicionPerfil() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				EdicionPerfilCtrl.confirmExit();
			}
		});
		ImagenesCtrl.download();
		createForm();
	}
	
	public void createForm() {
		
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 339, 252);
		setTitle("Editar perfil");
		setVisible(true);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(colorFondo);
		
		//Definimos las fuentes 
		lblFont = new Font("Script MT Bold", Font.PLAIN, 16);
		txtFont = new Font("Times New Roman", Font.PLAIN, 14);
		
		colorFondo = new Color(250, 200, 107);
		
		imgPanel = new JPanel();
		imgPanel.setBackground(colorFondo);
		getContentPane().add(imgPanel, BorderLayout.NORTH);
		
		imgUsuario = new JLabel("");
		imgPanel.add(imgUsuario);
		contentPane.setBackground(colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new GridLayout(8, 2, 0, 0));

		//Correo
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(lblFont);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(txtFont);
		contentPane.add(txtCorreo);
		
		//Usuario
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(lblFont);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(txtFont);
		contentPane.add(txtUsuario);

		//Contraseña
		JLabel lblContra = new JLabel("Contraseña:");
		lblContra.setFont(lblFont);
		contentPane.add(lblContra);
		
		txtContra = new JTextField();
		txtContra.setFont(txtFont);
		contentPane.add(txtContra);

		//Tipo
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(lblFont);
		contentPane.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setFont(txtFont);
		contentPane.add(txtTipo);
		
		//Telefono
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(lblFont);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(txtFont);
		contentPane.add(txtTelefono);
		
		//Plato
		JLabel lblPlato = new JLabel("Plato:");
		lblPlato.setFont(lblFont);
		contentPane.add(lblPlato);
		
		txtPlato = new JTextField();
		txtPlato.setFont(txtFont);
		contentPane.add(txtPlato);
		
		//Localidad
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(lblFont);
		contentPane.add(lblLocalidad);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setFont(txtFont);
		contentPane.add(txtLocalidad);
		
		//Pais
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setFont(lblFont);
		contentPane.add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setFont(txtFont);
		contentPane.add(txtPais);		

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(colorFondo);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Guardar cambios");
		okButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.CtrlDetalleCoche.saveData();
				//controller.CtrlListaCoches.loadData();
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnBorrar = new JButton("Borrar usuario");
		btnBorrar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		buttonPane.add(btnBorrar);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}

}
