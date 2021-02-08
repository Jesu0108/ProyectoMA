package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CrearNuevoCtrl;
import controller.ListaPerfilesCtrl;
import utils.Data;

import java.awt.GridLayout;
import java.awt.Toolkit;
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
	@SuppressWarnings("rawtypes")
	public static JComboBox spTipo;

	private static JLabel lblNewCorreo;
	private static JLabel lblNewUsuario;
	private static JLabel lblNewContra;
	private static JLabel lblNewTipo;
	private static JLabel lblNewTelefono;
	private static JLabel lblNewPlato;
	private static JLabel lblNewLocalidad;
	private static JLabel lblNewPais;

	private Font txtFont;

	public static final JPanel contentPane = new JPanel();
	private JPanel crearPanel;
	private JPanel delCanPanel;

	public FrmCrearNuevo() {
		createForm();
		CrearNuevoCtrl.addTipos();
		CrearNuevoCtrl.borrarCampos();
	}

	@SuppressWarnings("rawtypes")
	public void createForm() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Crear perfil");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Data.icono));

		contentPane.setBackground(Data.colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new GridLayout(8, 2, 0, 0));

		// Correo
		lblNewCorreo = new JLabel("Correo:");
		lblNewCorreo.setFont(Data.lblFont);
		contentPane.add(lblNewCorreo);

		txtNewCorreo = new JTextField();
		txtNewCorreo.setFont(txtFont);
		contentPane.add(txtNewCorreo);

		// Usuario
		lblNewUsuario = new JLabel("Usuario:");
		lblNewUsuario.setFont(Data.lblFont);
		contentPane.add(lblNewUsuario);

		txtNewUsuario = new JTextField();
		txtNewUsuario.setFont(txtFont);
		contentPane.add(txtNewUsuario);

		// Contraseña
		lblNewContra = new JLabel("Contraseña:");
		lblNewContra.setFont(Data.lblFont);
		contentPane.add(lblNewContra);

		txtNewContra = new JTextField();
		// txtContra.setFont(txtFont);
		contentPane.add(txtNewContra);

		// Tipo
		lblNewTipo = new JLabel("Tipo:");
		lblNewTipo.setFont(Data.lblFont);
		contentPane.add(lblNewTipo);

		spTipo = new JComboBox();
		contentPane.add(spTipo);

		// Telefono
		lblNewTelefono = new JLabel("Telefono:");
		lblNewTelefono.setFont(Data.lblFont);
		contentPane.add(lblNewTelefono);

		txtNewTelefono = new JTextField();
		txtNewTelefono.setFont(txtFont);
		contentPane.add(txtNewTelefono);

		// Plato
		lblNewPlato = new JLabel("Plato:");
		lblNewPlato.setFont(Data.lblFont);
		contentPane.add(lblNewPlato);

		txtNewPlato = new JTextField();
		txtNewPlato.setFont(txtFont);
		contentPane.add(txtNewPlato);

		// Localidad
		lblNewLocalidad = new JLabel("Localidad:");
		lblNewLocalidad.setFont(Data.lblFont);
		contentPane.add(lblNewLocalidad);

		txtNewLocalidad = new JTextField();
		txtNewLocalidad.setFont(txtFont);
		contentPane.add(txtNewLocalidad);

		// Pais
		lblNewPais = new JLabel("Pais:");
		lblNewPais.setFont(Data.lblFont);
		contentPane.add(lblNewPais);

		txtNewPais = new JTextField();
		txtNewPais.setFont(txtFont);
		contentPane.add(txtNewPais);

		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new GridLayout(1, 2, 0, 0));

		delCanPanel = new JPanel();
		delCanPanel.setBackground(Data.colorFondo);
		buttonPane.add(delCanPanel);

		JButton btnCancelar = new JButton("Cancelar");
		delCanPanel.add(btnCancelar);
		btnCancelar.setFont(Data.btnFont);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FrmListaPerfiles();
			}
		});

		JButton borrarBtn = new JButton("Borrar campos");
		borrarBtn.setFont(Data.btnFont);
		delCanPanel.add(borrarBtn);
		borrarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearNuevoCtrl.borrarCampos();
			}
		});

		crearPanel = new JPanel();
		crearPanel.setBackground(Data.colorFondo);
		buttonPane.add(crearPanel);

		JButton btnCrear = new JButton("Crear");
		crearPanel.add(btnCrear);
		btnCrear.setFont(Data.btnFont);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearNuevoCtrl.addPerfil();
				dispose();
				ListaPerfilesCtrl.loadData();
			}
		});
	}

}
