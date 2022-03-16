package ParteGrafica;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;

import ProyectoCrypto.Compra;
import ProyectoCrypto.Crypto;
import ProyectoCrypto.Guarda;
import ProyectoCrypto.Monedas;
import ProyectoCrypto.Refrescar;
import ProyectoCrypto.SuperUsuario;
import ProyectoCrypto.Venta;

import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuCompraVenta {

	private JFrame frameCompraVenta;
	private SuperUsuario usuario;
	private JTextField textField;
	private JTextField textField_1;
	private double precioAPagar = 0;
	private double precioMoneda = 0;
	private double cantidadCompra = 0;
	private double cantidadVenta = 0;
	private double precioARecibir = 0;

	public MenuCompraVenta(SuperUsuario usser) {
		this.usuario = usser;
		initialize();
		frameCompraVenta.setVisible(true);
	}

	private void initialize() {
		frameCompraVenta = new JFrame();
		frameCompraVenta.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		frameCompraVenta.setTitle("Compra/venta");
		frameCompraVenta.setResizable(false);
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frameCompraVenta.setBounds(dimensionesPantalla.width / 4, dimensionesPantalla.height / 4, 792, 435);
		frameCompraVenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCompraVenta.getContentPane().setLayout(null);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frameCompraVenta.dispose();
				MenuPortafolio portafolio = new MenuPortafolio(usuario);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtras.setBounds(23, 328, 111, 46);
		frameCompraVenta.getContentPane().add(btnAtras);

		JLabel lblNewLabel = new JLabel("Saldo USDT:" + usuario.getSaldo());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 141, 38);
		frameCompraVenta.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(158, 0, 628, 406);
		frameCompraVenta.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 0, 314, 406);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnComprar.setBounds(0, 368, 314, 38);
		panel_1.add(btnComprar);

		JLabel lblNewLabel_1 = new JLabel("Costo de la moneda: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(22, 47, 117, 30);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cantidad en posesi\u00F3n: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(22, 88, 124, 30);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Cantidad a comprar:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(78, 151, 136, 38);
		panel_1.add(lblNewLabel_3);

		textField = new JTextField();

		textField.setBounds(22, 200, 254, 30);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Total a pagar en USDT:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(22, 282, 148, 38);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Nombre:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(22, 23, 47, 14);
		panel_1.add(lblNewLabel_5);

		JLabel lblPrecio = new JLabel("");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(145, 55, 169, 14);
		panel_1.add(lblPrecio);

		JLabel lblNombreCompleto = new JLabel("");
		lblNombreCompleto.setForeground(Color.WHITE);
		lblNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreCompleto.setBounds(78, 23, 169, 14);
		panel_1.add(lblNombreCompleto);

		JLabel lblCantidadPoseida = new JLabel("");
		lblCantidadPoseida.setForeground(Color.WHITE);
		lblCantidadPoseida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidadPoseida.setBounds(145, 96, 169, 14);
		panel_1.add(lblCantidadPoseida);

		JLabel lblPagar = new JLabel("");
		lblPagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPagar.setForeground(Color.WHITE);
		lblPagar.setBounds(166, 286, 124, 30);
		panel_1.add(lblPagar);

		JLabel lblNewLabel_7 = new JLabel("Indique cantidad");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setVisible(false);
		lblNewLabel_7.setBounds(22, 241, 105, 14);
		panel_1.add(lblNewLabel_7);

		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBounds(314, 0, 314, 406);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnVender = new JButton("Vender");

		btnVender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnVender.setBounds(0, 368, 314, 38);
		panel_2.add(btnVender);

		JLabel lblNewLabel_1_1 = new JLabel("Costo de la moneda: ");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 49, 117, 30);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Cantidad en posesi\u00F3n: ");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(10, 90, 124, 30);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("Cantidad a vender:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(85, 149, 136, 38);
		panel_2.add(lblNewLabel_3_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(29, 198, 254, 30);
		panel_2.add(textField_1);

		JLabel lblNewLabel_4_1 = new JLabel("Total a recibir en USDT:");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(10, 281, 144, 38);
		panel_2.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5_1 = new JLabel("Nombre:");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1.setBounds(10, 24, 52, 14);
		panel_2.add(lblNewLabel_5_1);

		JLabel lblPrecioVenta = new JLabel("");
		lblPrecioVenta.setForeground(Color.WHITE);
		lblPrecioVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecioVenta.setBounds(135, 57, 169, 14);
		panel_2.add(lblPrecioVenta);

		JLabel lblNombreCompletoVenta = new JLabel("");
		lblNombreCompletoVenta.setForeground(Color.WHITE);
		lblNombreCompletoVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreCompletoVenta.setBounds(59, 24, 169, 14);
		panel_2.add(lblNombreCompletoVenta);

		JLabel lblCantidadPoseidaVenta = new JLabel("");
		lblCantidadPoseidaVenta.setForeground(Color.WHITE);
		lblCantidadPoseidaVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidadPoseidaVenta.setBounds(144, 98, 169, 14);
		panel_2.add(lblCantidadPoseidaVenta);

		JLabel lblRecibir = new JLabel("");
		lblRecibir.setForeground(Color.WHITE);
		lblRecibir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRecibir.setBounds(164, 293, 169, 14);
		panel_2.add(lblRecibir);

		JLabel lblNewLabel_8 = new JLabel("Indique cantidad.");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setVisible(false);
		lblNewLabel_8.setBounds(29, 239, 105, 14);
		panel_2.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("No posees cantidad de venta suficiente.");
		lblNewLabel_9.setVisible(false);
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(10, 118, 273, 14);
		panel_2.add(lblNewLabel_9);

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String abrevicion = (String) comboBox.getSelectedItem();
				if (abrevicion != null) {
					for (int i = 0; i < 30; i++) {
						if (abrevicion.equalsIgnoreCase(Monedas.criptomonedas.get(i).getSymbol())) {
							lblNombreCompleto.setText(Monedas.criptomonedas.get(i).getName());
							lblNombreCompletoVenta.setText(Monedas.criptomonedas.get(i).getName());
							lblPrecio.setText(Double.toString(Monedas.criptomonedas.get(i).getPrice()));
							lblPrecioVenta.setText(Double.toString(Monedas.criptomonedas.get(i).getPrice()));
							for (int j = 0; j < 10; j++) {
								if (usuario.getPortafolio().getMonedas()[j] != null && abrevicion
										.equalsIgnoreCase(usuario.getPortafolio().getMonedas()[j].getNombre())) {
									lblCantidadPoseida.setText(Double
											.toString(usuario.getPortafolio().getMonedas()[j].getCantidadTotal()));
									lblCantidadPoseidaVenta.setText(Double
											.toString(usuario.getPortafolio().getMonedas()[j].getCantidadTotal()));
									break;
								}
							}
							break;
						}
					}
				}
			}
		});
		comboBox.setBounds(23, 170, 99, 33);
		frameCompraVenta.getContentPane().add(comboBox);

		JLabel lblNewLabel_6 = new JLabel("Saldo insuficiente.");
		lblNewLabel_6.setVisible(false);
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 49, 124, 23);
		frameCompraVenta.getContentPane().add(lblNewLabel_6);
		for (int i = 0; i < 10; i++) {
			if (usuario.getPortafolio().getMonedas()[i] != null)
				comboBox.addItem(usuario.getPortafolio().getMonedas()[i].getNombre());
		}
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String saldo = textField.getText();
				if (!saldo.equalsIgnoreCase("") && (String) comboBox.getSelectedItem() != null) {
					char[] numeros = saldo.toCharArray();
					int numero = 0;
					for (int cantidadNumeros = 0; cantidadNumeros < numeros.length; cantidadNumeros++) {
						if (Character.isDigit(numeros[cantidadNumeros])) {
							numero++;
						}
					}
					if (numero == numeros.length) {
						double precioUSDT = Monedas.obtenerUSDT();
						String abrevicion = (String) comboBox.getSelectedItem();
						for (int i = 0; i < 30; i++) {
							if (abrevicion.equalsIgnoreCase(Monedas.criptomonedas.get(i).getSymbol())) {
								precioMoneda = Monedas.criptomonedas.get(i).getPrice();
								cantidadCompra = Double.parseDouble(saldo);
								precioAPagar = cantidadCompra * precioMoneda;
								String total = String.format("$%,.3f", (precioAPagar / precioUSDT));
								lblPagar.setText(total);
								break;
							}
						}
					}
				}
			}
		});
		btnComprar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (usuario.getSaldo() < precioAPagar) {
					lblNewLabel_6.setVisible(true);
				} else if (precioAPagar == 0) {
					lblNewLabel_7.setVisible(true);
				} else {
					if ((String) comboBox.getSelectedItem() != null) {
						Compra compra = new Compra(precioMoneda, cantidadCompra);
						for (int i = 0; i < 10; i++) {
							if (usuario.getPortafolio().getMonedas()[i] != null
									&& usuario.getPortafolio().getMonedas()[i].getNombre()
											.equalsIgnoreCase((String) comboBox.getSelectedItem())) {
								usuario.getPortafolio().getMonedas()[i].agregarCompra(compra);
								usuario.getPortafolio().getMonedas()[i].cantidadTotalMonedas();
								break;
							}
						}
						usuario.setSaldo(usuario.getSaldo() - precioAPagar);
						lblNewLabel.setText("Saldo USDT:" + usuario.getSaldo());
						CompraExitosa compraExito = new CompraExitosa();
						Guarda.datos(MenuPrincipal.usuarios);
						Guarda.fechaHoraIP();
					}
				}
			}
		});
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String saldo = textField_1.getText();
				if (!saldo.equalsIgnoreCase("")) {
					char[] numeros = saldo.toCharArray();
					int numero = 0;
					for (int cantidadNumeros = 0; cantidadNumeros < numeros.length; cantidadNumeros++) {
						if (Character.isDigit(numeros[cantidadNumeros])) {
							numero++;
						}
					}
					if (numero == numeros.length) {
						double precioUSDT = Monedas.obtenerUSDT();
						String abrevicion = (String) comboBox.getSelectedItem();
						for (int i = 0; i < 30; i++) {
							if (abrevicion.equalsIgnoreCase(Monedas.criptomonedas.get(i).getSymbol())) {
								precioMoneda = Monedas.criptomonedas.get(i).getPrice();
								cantidadVenta = Double.parseDouble(saldo);
								precioARecibir = cantidadVenta * precioMoneda;
								String total = String.format("$%,.3f", (precioARecibir / precioUSDT));
								lblRecibir.setText(total);
								break;
							}
						}
					}
				}
			}
		});
		btnVender.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (cantidadVenta != 0 && (String) comboBox.getSelectedItem() != null) {
					for (int i = 0; i < 10; i++) {
						if (usuario.getPortafolio().getMonedas()[i] != null && usuario.getPortafolio().getMonedas()[i]
								.getNombre().equalsIgnoreCase((String) comboBox.getSelectedItem())) {
							if (usuario.getPortafolio().getMonedas()[i].getCantidadTotal() > 0) {
								Venta venta = new Venta(precioARecibir, cantidadVenta);
								usuario.getPortafolio().getMonedas()[i].agregarVenta(venta);
								usuario.getPortafolio().getMonedas()[i].cantidadTotalMonedas();
								usuario.setSaldo(usuario.getSaldo() + precioARecibir);
								lblNewLabel.setText("Saldo USDT:" + usuario.getSaldo());
								Guarda.datos(MenuPrincipal.usuarios);
								Guarda.fechaHoraIP();
								ExitoVenta exito = new ExitoVenta();
								break;
							} else {
								lblNewLabel_9.setVisible(true);
								break;
							}
						}
					}
				} else {
					lblNewLabel_8.setVisible(true);
				}
			}
		});
		TimerTask refrescarInformacion = new TimerTask() {
			public void run() {
				String abrevicion = (String) comboBox.getSelectedItem();
				if (abrevicion != null) {
					for (int j = 0; j < 10; j++) {
						if (usuario.getPortafolio().getMonedas()[j] != null
								&& abrevicion.equalsIgnoreCase(usuario.getPortafolio().getMonedas()[j].getNombre())) {
							lblCantidadPoseida.setText(
									Double.toString(usuario.getPortafolio().getMonedas()[j].getCantidadTotal()));
							lblCantidadPoseidaVenta.setText(
									Double.toString(usuario.getPortafolio().getMonedas()[j].getCantidadTotal()));
							break;
						}
					}
					for (int i = 0; i < 30; i++) {
						if (abrevicion.equalsIgnoreCase(Monedas.criptomonedas.get(i).getSymbol())) {
							lblPrecio.setText(Double.toString(Monedas.criptomonedas.get(i).getPrice()));
							lblPrecioVenta.setText(Double.toString(Monedas.criptomonedas.get(i).getPrice()));
							break;
						}
					}
				}
			}
		};
		try {
			Timer timer4 = new Timer();
			timer4.scheduleAtFixedRate(refrescarInformacion, 0, 10000);
		} catch (IllegalStateException f) {
			System.out.println(f.getMessage());
		}
	}
}