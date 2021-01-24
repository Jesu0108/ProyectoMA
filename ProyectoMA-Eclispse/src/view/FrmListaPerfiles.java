package view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class FrmListaPerfiles extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTable tblResult;
	public static JPanel contentPane;
	private JLabel lblInfoEleccion;
	private JPanel panel;
	private JList lstFiltro;

	public FrmListaPerfiles() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				controller.ListaPerfilesCtrl.confirmExit();
			}
		});
		
		controller.ListaPerfilesCtrl.loadData();
		createForm();
		setVisible(true);
	}
	
	private void createForm() {
		setModal(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 310, 300);
		setTitle("Listado");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblInfoEleccion = new JLabel("Seleccione el filtro:");
		panel.add(lblInfoEleccion);
		
		lstFiltro = new JList();
		lstFiltro.setVisibleRowCount(1);
		lstFiltro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstFiltro.setModel(new AbstractListModel() {
			String[] values = new String[] {"Correo", "Usuario", "Contrasenia", "Plato"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(lstFiltro);
		
		JScrollPane panelDat = new JScrollPane();
		contentPane.add(panelDat, BorderLayout.CENTER);

		tblResult = new JTable();
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
