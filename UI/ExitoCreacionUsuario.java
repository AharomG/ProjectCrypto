package ParteGrafica;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExitoCreacionUsuario {

	private JFrame frmExito;

	public ExitoCreacionUsuario() {
		initialize();
		frmExito.setVisible(true);
	}

	private void initialize() {
		frmExito = new JFrame();
		frmExito.setTitle("Exito");
		frmExito.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmExito.setBounds(dimensionesPantalla.width / 3, dimensionesPantalla.height / 3, 450, 300);
		frmExito.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmExito.getContentPane().setLayout(null);

		JLabel lblExito = new JLabel("Exito en la creacion del nuevo usuario");
		lblExito.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExito.setBounds(82, 71, 274, 69);
		frmExito.getContentPane().add(lblExito);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmExito.dispose();
			}
		});
		btnAceptar.setBounds(153, 165, 111, 37);
		frmExito.getContentPane().add(btnAceptar);
	}
}