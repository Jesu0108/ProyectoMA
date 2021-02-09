package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import controller.ListaTiposCtrl;
import utils.Data;


public class FrmListaTipos extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTable tblResult = new JTable();
	public static JPanel contentPane;

	private static JLabel lblInfoEleccion;
	private static JPanel panel;
	private JButton btnVolver;
	private JButton btNuevo;

	public FrmListaTipos() {
		ListaTiposCtrl.loadData();
		createForm();
	}

	public void createForm() {
		setVisible(true);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 342, 300);
		setTitle("Listado");
		setResizable(false);
		setBackground(Data.colorFondo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Data.icono));

		contentPane = new JPanel();
		contentPane.setBackground(Data.colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(Data.colorFondo);
		contentPane.add(panel, BorderLayout.NORTH);

		lblInfoEleccion = new JLabel("Tipos de usuario");
		lblInfoEleccion.setFont(new Font("Script MT Bold", Font.PLAIN, 14));
		panel.add(lblInfoEleccion);

		JScrollPane panelDat = new JScrollPane();
		panelDat.setBackground(Data.colorFondo);
		contentPane.add(panelDat, BorderLayout.CENTER);

		tblResult.setBackground(Data.colorFondo);
		tblResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelDat.setViewportView(tblResult);
		setVisible(true);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Data.colorFondo);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPane.add(btnVolver);
		btnVolver.setFont(Data.btnFont);

		btNuevo = new JButton("Nuevo tipo");
		btNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCrearTipo();
			}
		});
		buttonPane.add(btNuevo);
		btNuevo.setFont(Data.btnFont);

	}

}
