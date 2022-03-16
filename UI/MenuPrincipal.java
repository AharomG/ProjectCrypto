package ParteGrafica;

import java.awt.EventQueue;
import ProyectoCrypto.Carga;
import ProyectoCrypto.Cifrar;
import ProyectoCrypto.Guarda;
import ProyectoCrypto.Monedas;
import ProyectoCrypto.Refrescar;
import ProyectoCrypto.SuperUsuario;
import ProyectoCrypto.Verificacion;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.TextArea;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MenuPrincipal {

	protected static ArrayList<SuperUsuario> usuarios = new ArrayList<SuperUsuario>();
	private JFrame frmMenuPrincipal;
	private JTextField textFieldCorreo;
	private JPasswordField passwordFieldContrasena;
	private String correo;
	private String contrasena;
	private static TextArea textAreaCriptos = new TextArea();

	public static void main(String[] args) {
		TimerTask refrescarInformacion = new TimerTask() {
			public void run() {
				textAreaCriptos.setText(null);
				textAreaCriptos.append(Monedas.criptomonedas.get(0).formato());
				for (int i = 0; i < 30; i++) {
					textAreaCriptos.append(Monedas.criptomonedas.get(i).toString());
				}
			}
		};
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monedas.llamada();
					try {
						Timer timer = new Timer();
						timer.scheduleAtFixedRate(Refrescar.refrescarPrecios, 0, 8000);
						timer.scheduleAtFixedRate(refrescarInformacion, 0, 60500);
					} catch (IllegalStateException e) {
						e.getMessage();
					}
					MenuPrincipal window = new MenuPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {
		initialize();
		usuarios = Carga.datos();
		frmMenuPrincipal.setVisible(true);
	}

	private void initialize() {
		usuarios = Carga.datos();
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setResizable(false);
		frmMenuPrincipal.setTitle("Menu Principal");
		frmMenuPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmMenuPrincipal.setBounds(dimensionesPantalla.width / 4, dimensionesPantalla.height / 4, 805, 466);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(91, 164, 105, 32);
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					MenuRegistro window = new MenuRegistro();
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		frmMenuPrincipal.getContentPane().setLayout(null);
		frmMenuPrincipal.getContentPane().add(btnRegistrarse);

		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.setBounds(622, 164, 89, 32);
		btnAcceder.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				correo = textFieldCorreo.getText();
				contrasena = String.valueOf(passwordFieldContrasena.getPassword());
				if (correo.equals("") || contrasena == null) {
					ErrorCamposVacios error = new ErrorCamposVacios();
				} else {
					if (usuarios != null) {
						if (Verificacion.correo(correo, usuarios) == true) {
							for (int i = 0; i <= usuarios.size(); i++) {
								if (i == usuarios.size()) {
									ErrorContrasena error = new ErrorContrasena();
									break;
								}
								if (String.valueOf(Cifrar.desCifrar(usuarios.get(i).getPassword()))
										.equals(contrasena)) {
									frmMenuPrincipal.dispose();
									Guarda.fechaHoraIP();
									MenuSuperUsuario superUsuario = new MenuSuperUsuario(usuarios.get(i));
									break;
								}
							}
						} else {
							ErrorNoExisteCorreo error = new ErrorNoExisteCorreo();
						}
					} else {
						ErrorNoHayUsuarios error = new ErrorNoHayUsuarios();
					}
				}
			}
		});
		frmMenuPrincipal.getContentPane().add(btnAcceder);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(290, 40, 344, 32);
		frmMenuPrincipal.getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);

		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setBounds(290, 83, 344, 34);
		frmMenuPrincipal.getContentPane().add(passwordFieldContrasena);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(198, 38, 54, 32);
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmMenuPrincipal.getContentPane().add(lblCorreo);

		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setBounds(167, 81, 85, 34);
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmMenuPrincipal.getContentPane().add(lblContrasena);

		textAreaCriptos.setEditable(false);
		textAreaCriptos.setBounds(91, 221, 620, 188);
		frmMenuPrincipal.getContentPane().add(textAreaCriptos);

		JButton btnConversiones = new JButton("Conversion");
		btnConversiones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MenuConversion conversion = new MenuConversion();
			}
		});
		btnConversiones.setBounds(341, 164, 112, 32);
		frmMenuPrincipal.getContentPane().add(btnConversiones);
	}
}