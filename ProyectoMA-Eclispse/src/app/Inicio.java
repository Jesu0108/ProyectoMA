package app;

import view.FrmPrincipal;

public class Inicio {
	public static void main(String[] args) {

		try {
			FrmPrincipal frame = new FrmPrincipal();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
