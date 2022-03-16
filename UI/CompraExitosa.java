package ParteGrafica;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CompraExitosa {

	private JFrame frmCompraExitosa;

	public CompraExitosa() {
		initialize();
		frmCompraExitosa.setVisible(true);
	}

	private void initialize() {
		frmCompraExitosa = new JFrame();
		frmCompraExitosa.setResizable(false);
		frmCompraExitosa.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		frmCompraExitosa.setTitle("Compra Exitosa");
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmCompraExitosa.setBounds(dimensionesPantalla.width / 3, dimensionesPantalla.height / 3, 395, 236);
		frmCompraExitosa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCompraExitosa.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("COMPRA EXITOSA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(92, 39, 205, 46);
		frmCompraExitosa.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmCompraExitosa.dispose();
			}
		});
		btnNewButton.setBounds(133, 109, 105, 30);
		frmCompraExitosa.getContentPane().add(btnNewButton);
	}
}