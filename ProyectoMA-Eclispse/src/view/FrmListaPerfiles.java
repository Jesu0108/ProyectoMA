package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import controller.ListaPerfilesCtrl;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;

public class FrmListaPerfiles extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTable tblResult;
	public static JPanel contentPane;
	private JLabel lblInfoEleccion;
	private JPanel panel;
	private JComboBox lstFiltros;

	private Color colorFondo;
	
	public FrmListaPerfiles() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ListaPerfilesCtrl.confirmExit();
			}
		});
		ListaPerfilesCtrl.loadData();
		createForm();
	}
	
	private void createForm() {
		setVisible(true);
		setModal(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 310, 300);
		setTitle("Listado");
		setResizable(false);
		
		colorFondo = new Color(250, 200, 107);
		
		contentPane = new JPanel();
		contentPane.setBackground(colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(colorFondo);
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblInfoEleccion = new JLabel("Seleccione el filtro:");
		lblInfoEleccion.setFont(new Font("Script MT Bold", Font.PLAIN, 14));
		panel.add(lblInfoEleccion);
		
		String[] filtros = {"Ninguno","Cocinero", "Catador", "Empresa"};
		lstFiltros = new JComboBox(filtros);
		lstFiltros.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel.add(lstFiltros);
		
		JScrollPane panelDat = new JScrollPane();
		panelDat.setBackground(colorFondo);
		contentPane.add(panelDat, BorderLayout.CENTER);

		tblResult = new JTable();
		tblResult.setBackground(colorFondo);
		tblResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.ListaPerfilesCtrl.tableRowSelected();
			}
		});
		panelDat.setViewportView(tblResult);
		setVisible(true);
	}

}
