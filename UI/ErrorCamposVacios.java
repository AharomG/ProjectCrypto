package ParteGrafica;

import java.awt.Dimension;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErrorCamposVacios {

	private JFrame frmError;

	public ErrorCamposVacios() {
		initialize();
		frmError.setVisible(true);
	}

	private void initialize() {
		frmError = new JFrame();
		frmError.setResizable(false);
		frmError.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		frmError.setTitle("Error");
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmError.setBounds(dimensionesPantalla.width / 3, dimensionesPantalla.height / 3, 298, 242);
		frmError.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmError.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ERROR, campos vacios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(28, 31, 244, 67);
		frmError.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmError.dispose();
			}
		});
		btnNewButton.setBounds(92, 109, 109, 29);
		frmError.getContentPane().add(btnNewButton);
	}
}