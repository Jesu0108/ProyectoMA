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

public class FrmListaPerfiles extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JTable tblResult;

	public FrmListaPerfiles() {
		createForm();
		controller.CtrlListaPerfiles.loadData();
		setVisible(true);
	}
	
	private void createForm() {
		setModal(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 300);
		setTitle("Listado");
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane panelDat = new JScrollPane();
		contentPane.add(panelDat, BorderLayout.CENTER);

		tblResult = new JTable();
		tblResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CtrlListaPerfiles.tableRowSelected();
			}
		});
		panelDat.setViewportView(tblResult);
		setVisible(true);
	}

}
