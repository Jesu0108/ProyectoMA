package controller;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import utils.Data;
import view.FrmEdicionPerfil;
import view.FrmListaPerfiles;

public class ImagenesCtrl {

	public static void download() {

		int idSelected = Integer.parseInt(
				FrmListaPerfiles.tblResult.getValueAt(FrmListaPerfiles.tblResult.getSelectedRow(), 0).toString());

		String fileName = "" + idSelected;
		String path = Data.URL + "/imagen/" + fileName + ".jpg";

		try {
			URL url = new URL(path);
			Image image = ImageIO.read(url);
			FrmEdicionPerfil.imgUsuario.setIcon(new ImageIcon(image.getScaledInstance(90, 125, Image.SCALE_SMOOTH)));

		} catch (Exception e) {
			try {
				
				imgPorDefecto();

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e2.getMessage(), "Error de DOWNLOAD",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public static void imgPorDefecto() {
		try { 
			Image image = ImageIO.read(new File("img\\interrogante.png"));
			
			FrmEdicionPerfil.imgUsuario.setIcon(new ImageIcon(image.getScaledInstance(90, 125, Image.SCALE_SMOOTH)));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Error de imgPorDefecto",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
