package ParteGrafica;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErrorContrasena {

	private JFrame frmError;

	public ErrorContrasena() {
		initialize();
		frmError.setVisible(true);
	}

	private void initialize() {
		frmError = new JFrame();
		frmError.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		frmError.setTitle("Error");
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmError.setBounds(dimensionesPantalla.width / 3, dimensionesPantalla.height / 3, 298, 242);
		frmError.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmError.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ERROR, contrasena equivocada");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(27, 61, 245, 55);
		frmError.getContentPane().add(lblNewLabel);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmError.dispose();
			}
		});
		btnAceptar.setBounds(86, 127, 99, 32);
		frmError.getContentPane().add(btnAceptar);
	}
}