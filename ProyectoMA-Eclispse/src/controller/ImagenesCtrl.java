package controller;

import java.awt.Image;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import utils.Data;
import view.FrmEdicionPerfil;
import view.FrmListaPerfiles;

public class ImagenesCtrl {

	private static File archivo;

	public static void seleccionarFichero() {
		JFileChooser selectorArchivos = new JFileChooser();
		selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectorArchivos.showOpenDialog(null);
		try {
			archivo = selectorArchivos.getSelectedFile();
			Image image = ImageIO.read(archivo);
			FrmEdicionPerfil.imgUsuario.setIcon(new ImageIcon(image));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.getMessage(), "Error seleccionando archivo", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void download() {
		
		int idSelected = Integer.parseInt(
				FrmListaPerfiles.tblResult.getValueAt(FrmListaPerfiles.tblResult.getSelectedRow(), 0).toString());
		
		//String imgPrueba = "img\\interrogante.png";
		
		String fileName = ""+idSelected;
		String path = Data.URL+"/imagen/" + fileName + ".jpg";

		try {
			URL url = new URL(path);
			Image image = ImageIO.read(url);
			FrmEdicionPerfil.imgUsuario.setIcon(new ImageIcon(image.getScaledInstance(90, 125, Image.SCALE_SMOOTH)));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.getMessage(), "Error de DOWNLOAD", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void upload() {
		try {
			String filePath = archivo.getAbsolutePath();
			String fileName = archivo.getName();
			String fileNameWithOutExt = fileName.replaceFirst("[.][^.]+$", "");

			String path = Data.URL+"/imagen/imagen.php";

			// Establecemos la conexion...
			URL url = new URL(path);
			URLConnection conn = url.openConnection();
			HttpURLConnection http = (HttpURLConnection) conn;
			http.setRequestMethod("POST");
			http.setDoOutput(true);

			// Parametros de envio
			Map<String, String> params = new HashMap<>();
			params.put("imgName", fileNameWithOutExt);
			params.put("imgData", encodeFileToBase64(filePath));

			// Array de Bytes de envio
			StringJoiner sj = new StringJoiner("&");
			for (Map.Entry<String, String> entry : params.entrySet()) {
				sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
			}
			byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);

			// Enviar el array de bytes hacia el path (URL del Web-Service)
			http.setFixedLengthStreamingMode(out.length);
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			http.connect();
			http.getOutputStream().write(out);

			JOptionPane.showMessageDialog(null, "La imagen ha sido subida correctamente", "UPLOAD",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.getMessage(), "Error de UPLOAD", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static String encodeFileToBase64(String filePath) {
		String base64Image = "";
		File file = new File(filePath);
		try (FileImageInputStream imageInFile = new FileImageInputStream(file)) {
			byte[] imageData = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.getMessage(), "Error de ENCODE TO BASE64", JOptionPane.ERROR_MESSAGE);
		}

		return base64Image;
	}

}
