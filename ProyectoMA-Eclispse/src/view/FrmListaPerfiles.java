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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import controller.ListaPerfilesCtrl;
import utils.Data;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class FrmListaPerfiles extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTable tblResult = new JTable();
	public static JPanel contentPane;
	
	private static JLabel lblInfoEleccion;
	private static JPanel panel;

	private static Color colorFondo;
	private static JMenuBar menuBar;
	private static JMenu mnPerfiles;
	private static JMenuItem mntmNuevo;
	private static JMenu mnGraficas;
	private static JMenuItem mntmPorLocalidad;
	private static JMenuItem mntmPorTipo;
	private static JMenuItem mntmSalir;
	private static JSeparator separator;
	
	private DefaultPieDataset data;
	private JFreeChart chart;
	
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
		setBounds(100, 100, 639, 300);
		setTitle("Listado");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Data.icono));
		
		colorFondo = new Color(250, 200, 107);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPerfiles = new JMenu("Archivo");
		menuBar.add(mnPerfiles);
		
		mntmNuevo = new JMenuItem("Nuevo perfil");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCrearNuevo();
			}
		});
		mnPerfiles.add(mntmNuevo);
		
		separator = new JSeparator();
		mnPerfiles.add(separator);
		
		mntmSalir = new JMenuItem("Cerrar sesion");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPerfilesCtrl.confirmExit();
			}
		});
		mnPerfiles.add(mntmSalir);
		
		mnGraficas = new JMenu("Graficas");
		menuBar.add(mnGraficas);
		
		mntmPorLocalidad = new JMenuItem("Por localidad");
		mntmPorLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new FrmBar();
			}
		});
		mnGraficas.add(mntmPorLocalidad);
		
		mntmPorTipo = new JMenuItem("Por tipo");
		mntmPorTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmPie();
			}
		});
		mnGraficas.add(mntmPorTipo);
		
		contentPane = new JPanel();
		contentPane.setBackground(colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(colorFondo);
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblInfoEleccion = new JLabel("Seleccione el perfil a editar");
		lblInfoEleccion.setFont(new Font("Script MT Bold", Font.PLAIN, 14));
		panel.add(lblInfoEleccion);
				
		JScrollPane panelDat = new JScrollPane();
		panelDat.setBackground(colorFondo);
		contentPane.add(panelDat, BorderLayout.CENTER);

		tblResult.setBackground(colorFondo);
		tblResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FrmEdicionPerfil();;
			}
		});
		panelDat.setViewportView(tblResult);
		setVisible(true);
	}

}
