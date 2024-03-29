package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import controller.ListaPerfilesCtrl;
import utils.Data;

public class FrmListaPerfiles extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTable tblResult = new JTable();
	public static JPanel contentPane;

	private static JLabel lblInfoEleccion;
	private static JPanel panel;

	private static JMenuBar menuBar;
	private static JMenu mnPerfiles;
	private static JMenuItem mntmNuevo;
	private static JMenu mnGraficas;
	private static JMenuItem mntmPorLocalidad;
	private static JMenuItem mntmPorTipo;
	private static JMenuItem mntmSalir;
	private static JSeparator separator;

	private JMenu mnAyuda;
	private JMenuItem mntmAyuda;
	private JMenuItem mntmAcercaDe;
	private JMenuItem mnuGestionTipos;

	public FrmListaPerfiles() {
		setResizable(false);
		
		
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
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 639, 300);
		setTitle("Listado");
		setBackground(Data.colorFondo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Data.icono));

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
		
		mnuGestionTipos = new JMenuItem("Gestionar tipos");
		mnuGestionTipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmListaTipos();
			}
		});
		mnPerfiles.add(mnuGestionTipos);
		
		separator = new JSeparator();
		mnPerfiles.add(separator);
		
		mntmSalir = new JMenuItem("Cerrar sesion");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ListaPerfilesCtrl.LogOut();
				new FrmPrincipal();
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
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPerfilesCtrl.textoAyuda();
			}
		});
		mnAyuda.add(mntmAyuda);
		
		mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPerfilesCtrl.textoAcercaDe();
			}
		});
		mnAyuda.add(mntmAcercaDe);
		
		contentPane = new JPanel();
		contentPane.setBackground(Data.colorFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(Data.colorFondo);
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblInfoEleccion = new JLabel("Seleccione el perfil a editar");
		lblInfoEleccion.setFont(new Font("Script MT Bold", Font.PLAIN, 14));
		panel.add(lblInfoEleccion);
				
		JScrollPane panelDat = new JScrollPane();
		panelDat.setBackground(Data.colorFondo);
		contentPane.add(panelDat, BorderLayout.CENTER);

		tblResult.setBackground(Data.colorFondo);
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
