package ParteGrafica;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;

import ProyectoCrypto.Cifrar;
import ProyectoCrypto.Guarda;
import ProyectoCrypto.SuperUsuario;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class MenuDatosUsuario {

	private JFrame frmCambiarContrasena;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirmar;
	private SuperUsuario usuario;
	private JLabel lblContrasenasNoCoinciden = new JLabel("Las contrasenas no coinciden");
	private JLabel lblInstrucciones = new JLabel(
			"Las contrasenas deben tener minimo 8 caracteres, de los cuales minimo una minuscula, una mayuscula, un caracter especial y un numero.");

	public MenuDatosUsuario(SuperUsuario usser) {
		this.usuario = usser;
		initialize();
		frmCambiarContrasena.setVisible(true);
	}

	private void initialize() {
		frmCambiarContrasena = new JFrame();
		frmCambiarContrasena.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		frmCambiarContrasena.setTitle("Cambiar Contrasena");
		frmCambiarContrasena.setResizable(false);
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmCambiarContrasena.setBounds(dimensionesPantalla.width / 3, dimensionesPantalla.height / 3, 662, 386);
		frmCambiarContrasena.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCambiarContrasena.getContentPane().setLayout(null);

		JLabel lblCorreo = new JLabel("Correo: " + usuario.getCorreo());
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreo.setBounds(138, 59, 437, 33);
		frmCambiarContrasena.getContentPane().add(lblCorreo);

		JLabel lblContrasena = new JLabel("Nueva contrasena:");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasena.setBounds(61, 113, 131, 33);
		frmCambiarContrasena.getContentPane().add(lblContrasena);

		JLabel lblNewLabel = new JLabel("Confirmar contrasena:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(33, 175, 159, 26);
		frmCambiarContrasena.getContentPane().add(lblNewLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(235, 113, 319, 26);
		frmCambiarContrasena.getContentPane().add(passwordField);

		passwordFieldConfirmar = new JPasswordField();
		passwordFieldConfirmar.setBounds(235, 175, 319, 26);
		frmCambiarContrasena.getContentPane().add(passwordFieldConfirmar);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmCambiarContrasena.dispose();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtras.setBounds(82, 267, 110, 40);
		frmCambiarContrasena.getContentPane().add(btnAtras);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String contrasena = String.valueOf(passwordField.getPassword());
				String confirmacion = String.valueOf(passwordFieldConfirmar.getPassword());
				if (!contrasena.matches(confirmacion)) {
					lblContrasenasNoCoinciden.setVisible(true);
				} else {
					if (!SuperUsuario.confirmarPassword(contrasena) && !SuperUsuario.confirmarPassword(confirmacion)) {
						lblInstrucciones.setVisible(true);
					} else {
						usuario.setPassword(String.valueOf(Cifrar.cifrar(contrasena)));
						Guarda.datos(MenuPrincipal.usuarios);
						Guarda.fechaHoraIP();
						ExitoModificacionUsuario exito = new ExitoModificacionUsuario();
					}
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAceptar.setBounds(456, 254, 89, 53);
		frmCambiarContrasena.getContentPane().add(btnAceptar);
		lblContrasenasNoCoinciden.setVisible(false);
		lblContrasenasNoCoinciden.setForeground(Color.RED);
		lblContrasenasNoCoinciden.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContrasenasNoCoinciden.setBounds(395, 212, 159, 14);
		frmCambiarContrasena.getContentPane().add(lblContrasenasNoCoinciden);
		lblInstrucciones.setVisible(false);
		lblInstrucciones.setForeground(Color.RED);
		lblInstrucciones.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblInstrucciones.setBounds(10, 23, 636, 33);
		frmCambiarContrasena.getContentPane().add(lblInstrucciones);
	}
}