package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CrearTipoCtrl;
import controller.ListaTiposCtrl;
import utils.Data;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCrearTipo extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	public static JTextField txtNuevoTipo;
	
	public static JButton btnCancelar;
	public static JButton btnCrear;

	public FrmCrearTipo() {
		
		createForm();
		setVisible(true);
	}

	public void createForm() {
		setBounds(100, 100, 284, 138);
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Nuevo tipo");
		setResizable(false);
		setBackground(Data.colorFondo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Data.icono));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setBackground(Data.colorFondo);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
		JLabel lblNuevoTipo = new JLabel("Nuevo tipo:");
		lblNuevoTipo.setFont(Data.lblFont);
		lblNuevoTipo.setBounds(53, 24, 76, 20);
		contentPanel.add(lblNuevoTipo);

		txtNuevoTipo = new JTextField();
		txtNuevoTipo.setBounds(139, 26, 86, 20);
		txtNuevoTipo.setColumns(10);
		contentPanel.add(txtNuevoTipo);

		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel cancPanel = new JPanel();
		cancPanel.setBackground(Data.colorFondo);
		buttonPane.add(cancPanel);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(Data.btnFont);
		cancPanel.add(btnCancelar);

		JPanel crearPanel = new JPanel();
		crearPanel.setBackground(Data.colorFondo);
		buttonPane.add(crearPanel);

		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CrearTipoCtrl.addTipo();
				ListaTiposCtrl.loadData();
			}
		});
		btnCrear.setFont(Data.btnFont);
		crearPanel.add(btnCrear);

	}
}
