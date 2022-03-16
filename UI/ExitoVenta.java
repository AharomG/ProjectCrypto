package ParteGrafica;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExitoVenta {

	private JFrame frmVentaExitosa;

	public ExitoVenta() {
		initialize();
		frmVentaExitosa.setVisible(true);
	}

	private void initialize() {
		frmVentaExitosa = new JFrame();
		frmVentaExitosa.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		frmVentaExitosa.setTitle("Venta exitosa");
		frmVentaExitosa.setResizable(false);
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmVentaExitosa.setBounds(dimensionesPantalla.width / 3, dimensionesPantalla.height / 3, 377, 236);
		frmVentaExitosa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVentaExitosa.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Venta realizada con exito.");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(76, 50, 234, 66);
		frmVentaExitosa.getContentPane().add(lblNewLabel);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmVentaExitosa.dispose();
			}
		});
		btnAceptar.setBounds(136, 127, 100, 30);
		frmVentaExitosa.getContentPane().add(btnAceptar);
	}
}
