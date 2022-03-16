package ParteGrafica;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErrorNoExisteCorreo {

	private JFrame frmError;

	public ErrorNoExisteCorreo() {
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

		JLabel lblError = new JLabel("ERROR, no existe el correo");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblError.setBounds(37, 42, 222, 76);
		frmError.getContentPane().add(lblError);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmError.dispose();
			}
		});
		btnNewButton.setBounds(81, 119, 111, 36);
		frmError.getContentPane().add(btnNewButton);
	}

}