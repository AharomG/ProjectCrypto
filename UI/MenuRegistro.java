package ParteGrafica;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextField;
import ProyectoCrypto.Cifrar;
import ProyectoCrypto.Guarda;
import ProyectoCrypto.Portafolio;
import ProyectoCrypto.SuperUsuario;
import ProyectoCrypto.Verificacion;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class MenuRegistro {

	private JFrame frmRegistrarse;
	private JTextField textFieldCorreo;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirmar;
	private JLabel lblErrorContrasenas = new JLabel("Las contrasenas no coinciden");
	private JLabel lblCorreoInvalido = new JLabel("El correo es invalido");
	private JLabel lblInstruccionContrasena = new JLabel(
			"Las contrasenas deben tener minimo 8 caracteres, de los cuales minimo una minuscula, una mayuscula, un caracter especial y un numero.");

	public MenuRegistro() {
		initialize();
		frmRegistrarse.setVisible(true);
	}

	private void initialize() {
		frmRegistrarse = new JFrame();
		frmRegistrarse.setResizable(false);
		frmRegistrarse.setTitle("Registrarse");
		frmRegistrarse.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmRegistrarse.setBounds(dimensionesPantalla.width / 3, dimensionesPantalla.height / 3, 638, 400);
		frmRegistrarse.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrarse.getContentPane().setLayout(null);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(219, 50, 338, 32);
		frmRegistrarse.getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmRegistrarse.dispose();
			}
		});
		btnNewButton.setBounds(69, 260, 107, 56);
		frmRegistrarse.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("El correo ya existe.");
		lblNewLabel.setVisible(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(219, 25, 129, 14);
		frmRegistrarse.getContentPane().add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String correo = textFieldCorreo.getText();
				String contrasena = String.valueOf(passwordField.getPassword());
				String confirmacion = String.valueOf(passwordFieldConfirmar.getPassword());
				if (correo.equalsIgnoreCase("") || contrasena == null || confirmacion == null) {
					ErrorCamposVacios error = new ErrorCamposVacios();
				} else {
					if (!contrasena.matches(confirmacion)) {
						lblErrorContrasenas.setVisible(true);
					} else {
						if (SuperUsuario.confirmarCorreo(correo) == false) {
							lblCorreoInvalido.setVisible(true);
						} else {
							if (!SuperUsuario.confirmarPassword(contrasena)
									&& !SuperUsuario.confirmarPassword(confirmacion)) {
								lblInstruccionContrasena.setForeground(Color.RED);
							} else if (Verificacion.correo(correo, MenuPrincipal.usuarios)) {
								lblNewLabel.setVisible(true);
							} else {
								SuperUsuario usuario = new SuperUsuario(correo,
										String.valueOf(Cifrar.cifrar(contrasena)), new Portafolio());
								MenuPrincipal.usuarios.add(usuario);
								Guarda.datos(MenuPrincipal.usuarios);
								Guarda.fechaHoraIP();
								ExitoCreacionUsuario exito = new ExitoCreacionUsuario();
							}
						}
					}
				}
			}
		});
		btnNewButton_1.setBounds(446, 260, 107, 56);
		frmRegistrarse.getContentPane().add(btnNewButton_1);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreo.setBounds(113, 48, 107, 32);
		frmRegistrarse.getContentPane().add(lblCorreo);

		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasena.setBounds(83, 115, 93, 43);
		frmRegistrarse.getContentPane().add(lblContrasena);

		JLabel lblConfirmarContrasena = new JLabel("Confirmar contrasena:");
		lblConfirmarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmarContrasena.setBounds(20, 184, 168, 32);
		frmRegistrarse.getContentPane().add(lblConfirmarContrasena);

		passwordField = new JPasswordField();
		passwordField.setBounds(219, 123, 338, 30);
		frmRegistrarse.getContentPane().add(passwordField);

		passwordFieldConfirmar = new JPasswordField();
		passwordFieldConfirmar.setBounds(219, 188, 338, 28);
		frmRegistrarse.getContentPane().add(passwordFieldConfirmar);
		lblErrorContrasenas.setVisible(false);
		lblErrorContrasenas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorContrasenas.setForeground(Color.RED);
		lblErrorContrasenas.setBounds(398, 221, 159, 14);
		frmRegistrarse.getContentPane().add(lblErrorContrasenas);

		lblCorreoInvalido.setVisible(false);
		lblCorreoInvalido.setForeground(Color.RED);
		lblCorreoInvalido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorreoInvalido.setBounds(446, 25, 111, 14);
		frmRegistrarse.getContentPane().add(lblCorreoInvalido);

		lblInstruccionContrasena.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblInstruccionContrasena.setBounds(20, 93, 572, 19);
		frmRegistrarse.getContentPane().add(lblInstruccionContrasena);

	}
}