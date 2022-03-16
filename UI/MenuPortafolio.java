package ParteGrafica;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import ProyectoCrypto.Monedas;
import ProyectoCrypto.SuperUsuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPortafolio {

	private JFrame frmPortafolio;
	private SuperUsuario usuario;
	private JTextField textFieldCambiarSaldo;
	private TextArea textAreaCriptos2 = new TextArea();

	public MenuPortafolio(SuperUsuario uss) {
		this.usuario = uss;
		initialize();
		frmPortafolio.setVisible(true);
	}

	private void initialize() {

		frmPortafolio = new JFrame();
		frmPortafolio.setResizable(false);
		frmPortafolio.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		frmPortafolio.setTitle("Portafolio");
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmPortafolio.setBounds(dimensionesPantalla.width / 4, dimensionesPantalla.height / 4, 863, 458);
		frmPortafolio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPortafolio.getContentPane().setLayout(null);

		textAreaCriptos2.setEditable(false);
		textAreaCriptos2.setBounds(65, 169, 754, 232);
		frmPortafolio.getContentPane().add(textAreaCriptos2);

		JButton btnCompraVenta = new JButton("Compra/Venta");
		btnCompraVenta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmPortafolio.dispose();
				MenuCompraVenta compraVenta = new MenuCompraVenta(usuario);
			}
		});
		btnCompraVenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCompraVenta.setBounds(246, 47, 144, 68);
		frmPortafolio.getContentPane().add(btnCompraVenta);

		JButton btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MenuEstadisticas estadisticas = new MenuEstadisticas(usuario);
			}
		});
		btnEstadisticas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEstadisticas.setBounds(432, 47, 144, 68);
		frmPortafolio.getContentPane().add(btnEstadisticas);

		JLabel lblSaldo = new JLabel("Saldo USDT:" + usuario.getSaldo());
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSaldo.setBounds(10, 11, 186, 30);
		frmPortafolio.getContentPane().add(lblSaldo);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmPortafolio.dispose();
				MenuSuperUsuario superUsuario = new MenuSuperUsuario(usuario);
			}
		});
		btnAtras.setBounds(75, 127, 89, 23);
		frmPortafolio.getContentPane().add(btnAtras);

		textFieldCambiarSaldo = new JTextField();
		textFieldCambiarSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String saldo = textFieldCambiarSaldo.getText();
				if (!saldo.equalsIgnoreCase("")) {
					char[] numeros = saldo.toCharArray();
					int numero = 0;
					for (int cantidadNumeros = 0; cantidadNumeros < numeros.length; cantidadNumeros++) {
						if (Character.isDigit(numeros[cantidadNumeros])) {
							numero++;
						}
					}
					if (numero == numeros.length) {
						usuario.setSaldo(Double.parseDouble(saldo));
						lblSaldo.setText("Saldo: " + usuario.getSaldo());
					}
				}
			}
		});
		textFieldCambiarSaldo.setBounds(10, 47, 105, 23);
		frmPortafolio.getContentPane().add(textFieldCambiarSaldo);
		textFieldCambiarSaldo.setColumns(10);

		JButton btnAgregarMonedasPortafolio = new JButton("Agregar o eliminar monedas");
		btnAgregarMonedasPortafolio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MenuAgregarMonedasPortafolio agregar = new MenuAgregarMonedasPortafolio(usuario);
			}
		});
		btnAgregarMonedasPortafolio.setBounds(623, 47, 196, 68);
		frmPortafolio.getContentPane().add(btnAgregarMonedasPortafolio);

		JLabel lblNewLabel = new JLabel("Solo se puede comprar y vender en base a las monedas en tu portafolio.");
		lblNewLabel.setBounds(246, 11, 538, 24);
		frmPortafolio.getContentPane().add(lblNewLabel);
		TimerTask refrescarInformacion2 = new TimerTask() {
			public void run() {
				lblSaldo.setText("Saldo USDT:" + usuario.getSaldo());
				textAreaCriptos2.setText(null);
				for (int j = 0; j < usuario.getPortafolio().getMonedas().length; j++) {
					if (usuario.getPortafolio().getMonedas()[j] != null) {
						for (int i = 0; i < Monedas.criptomonedas.size(); i++) {
							if (usuario.getPortafolio().getMonedas()[j].getNombre()
									.matches(Monedas.criptomonedas.get(i).getSymbol())) {
								textAreaCriptos2.append(Monedas.criptomonedas.get(i).toString());
								break;
							}
						}
					}
				}
			}
		};
		try {
			Timer timer2 = new Timer();
			timer2.scheduleAtFixedRate(refrescarInformacion2, 0, 10000);
		} catch (IllegalStateException e) {
			e.getMessage();
		}
	}
}