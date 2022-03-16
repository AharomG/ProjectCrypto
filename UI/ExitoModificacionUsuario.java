package ParteGrafica;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExitoModificacionUsuario {

	private JFrame frmExito;

	public ExitoModificacionUsuario() {
		initialize();
		frmExito.setVisible(true);
	}

	private void initialize() {
		frmExito = new JFrame();
		frmExito.setTitle("Exito");
		frmExito.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmExito.setBounds(dimensionesPantalla.width / 3, dimensionesPantalla.height / 3, 378, 256);
		frmExito.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmExito.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Exito en la modificacion de usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(58, 61, 247, 28);
		frmExito.getContentPane().add(lblNewLabel);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmExito.dispose();
			}
		});
		btnAceptar.setBounds(124, 127, 99, 28);
		frmExito.getContentPane().add(btnAceptar);
	}
}