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

public class FrmEdicionPerfil extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane = new JPanel();
	public static JTextField txtCorreo;
	public static JTextField txtContra;
	private static JTextField txtUsuario;
	private static JTextField txtEstrellas;
	private static JTextField txtPlato;
	private static JTextField txtTipo;

	public FrmEdicionPerfil() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 220);
		setTitle("Editar perfil");
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new GridLayout(6, 2, 0, 0));

		contentPane.add(new JLabel("Correo:"));
		txtCorreo = new JTextField();
		contentPane.add(txtCorreo);
		
		contentPane.add(new JLabel("Usuario:"));
		txtUsuario = new JTextField();
		contentPane.add(txtUsuario);

		contentPane.add(new JLabel("Contraseña:"));
		txtContra = new JTextField();
		contentPane.add(txtContra);

		contentPane.add(new JLabel("Tipo:"));
		txtTipo = new JTextField();
		contentPane.add(txtTipo);
		
		contentPane.add(new JLabel("Plato:"));
		txtPlato = new JTextField();
		contentPane.add(txtPlato);
		
		contentPane.add(new JLabel("Estrellas:"));
		txtEstrellas = new JTextField();
		contentPane.add(txtEstrellas);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("GUARDAR");
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

		JButton cancelButton = new JButton("CANCELAR");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}

}
