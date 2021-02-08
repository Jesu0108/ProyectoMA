package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import controller.ListaPerfilesCtrl;
import model.Perfil;

public class FrmPie extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private static Color colorFondo = new Color(250, 200, 107);
	
	private final JPanel contentPanel = new JPanel();

	public FrmPie() {
		getContentPane().setBackground(colorFondo);
		setResizable(false);
		createForm();
	}

	public void createForm() {
		setBounds(100, 100, 320, 270);
		setTitle("Grafica por tipos");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(colorFondo);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setVisible(true);

		// Fuente de datos - Pie
		DefaultPieDataset data = new DefaultPieDataset();

		int iCatador = 0;
		int iCocinero = 0;
		int iEmpresa = 0;

		// Hacemos recuento de tipos
		for (Perfil p : ListaPerfilesCtrl.resultado) {
			if (p.getsTipo().equals("Catador")) {
				iCatador++;
			} else if (p.getsTipo().equals("Cocinero")) {
				iCocinero++;
			} else {
				iEmpresa++;
			}
		}

		// Los insertamos en la grafica
		data.setValue("Catador", iCatador);
		data.setValue("Cocinero", iCocinero);
		data.setValue("Empresa", iEmpresa);

		// Creamos grafico - Pie
		JFreeChart chart = ChartFactory.createPieChart("Tipos mas usados por los usuarios", data, true, true, false);
		chart.setBackgroundPaint(colorFondo);
		
		// Mostramos Grafico
		ChartPanel frameG = new ChartPanel(chart);
		frameG.setBounds(0, 0, 300, 250);
		contentPanel.add(frameG);

	}

}
