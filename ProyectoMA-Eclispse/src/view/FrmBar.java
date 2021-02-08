package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import controller.ListaPerfilesCtrl;
import model.Perfil;
import utils.Data;

public class FrmBar extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	public FrmBar() {
		createForm();
	}

	public void createForm() {
		setBounds(100, 100, 320, 270);
		setTitle("Grafica por localidades");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Data.icono));

		int iSevilla = 0;
		int iHuelva = 0;
		int iOtros = 0;

		// Fuente de datos - Bar
		DefaultCategoryDataset data2 = new DefaultCategoryDataset();
		
		// Hacemos recuento de tipos
		for (Perfil p : ListaPerfilesCtrl.resultado) {
			if (p.getsLocalidad().equals("Sevilla")) {
				iSevilla++;
				data2.setValue(iSevilla, "Sevilla", "Sevilla");
			} else if (p.getsLocalidad().equals("Huelva")) {
				iHuelva++;
				data2.setValue(iHuelva, "Huelva", "Huelva");
			} else {
				iOtros++;
				data2.setValue(iOtros, "Otros", "Otros");
			}
		}

		// Creando grafico - Bar
		JFreeChart gra = ChartFactory.createBarChart("Localidades mas usadas", "Localidades", "Veces usadas", data2,
				PlotOrientation.VERTICAL, true, true, false);

		// Personalizar el grafico
		gra.setBackgroundPaint(Data.colorFondo);
		gra.getTitle().setPaint(Color.BLACK);

		// Mostrar Grafico
		ChartPanel frameG2 = new ChartPanel(gra);
		frameG2.setBounds(0, 0, 300, 250);
		contentPanel.add(frameG2);
	}

}
