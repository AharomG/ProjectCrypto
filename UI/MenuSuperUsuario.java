package ParteGrafica;

import javax.swing.JFrame;
import ProyectoCrypto.SuperUsuario;
import ProyectoCrypto.Monedas;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;

public class MenuSuperUsuario {

	private SuperUsuario usuario;
	private JFrame frmMenuSuperUsuario;

	public MenuSuperUsuario(SuperUsuario usuario) {
		this.usuario = usuario;
		initialize();
	}

	private void initialize() {
		frmMenuSuperUsuario = new JFrame();
		frmMenuSuperUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		frmMenuSuperUsuario.setResizable(false);
		frmMenuSuperUsuario.setTitle("Menu Principal");
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmMenuSuperUsuario.setBounds(dimensionesPantalla.width / 4, dimensionesPantalla.height / 4, 824, 495);
		frmMenuSuperUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuSuperUsuario.getContentPane().setLayout(null);

		JButton btnPortafolio = new JButton("Portafolio");
		btnPortafolio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPortafolio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmMenuSuperUsuario.dispose();
				MenuPortafolio portafolio = new MenuPortafolio(usuario);
			}
		});
		btnPortafolio.setBounds(396, 57, 118, 89);
		frmMenuSuperUsuario.getContentPane().add(btnPortafolio);

		JButton btnDatosDeUsuario = new JButton("Cambiar Contrasena");
		btnDatosDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDatosDeUsuario.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MenuDatosUsuario DatosUsuario = new MenuDatosUsuario(usuario);
			}
		});
		btnDatosDeUsuario.setBounds(64, 57, 215, 89);
		frmMenuSuperUsuario.getContentPane().add(btnDatosDeUsuario);

		JButton btnConversion = new JButton("Conversion");
		btnConversion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConversion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MenuConversion conversion = new MenuConversion();
			}
		});
		btnConversion.setBounds(618, 57, 118, 89);
		frmMenuSuperUsuario.getContentPane().add(btnConversion);

		TextArea textAreaCriptos3 = new TextArea();
		textAreaCriptos3.setEditable(false);
		textAreaCriptos3.setBounds(64, 183, 680, 229);
		frmMenuSuperUsuario.getContentPane().add(textAreaCriptos3);
		for (int i = 0; i < 30; i++) {
			textAreaCriptos3.append(Monedas.criptomonedas.get(i).toString());
		}
		TimerTask refrescarInformacion3 = new TimerTask() {
			public void run() {
				textAreaCriptos3.setText(null);
				for (int i = 0; i < 30; i++) {
					textAreaCriptos3.append(Monedas.criptomonedas.get(i).toString());
				}
			}
		};
		try {
			Timer timer3 = new Timer();
			timer3.scheduleAtFixedRate(refrescarInformacion3, 0, 60500);
		} catch (IllegalStateException e) {
			e.getMessage();
		}
		frmMenuSuperUsuario.setVisible(true);
	}
}