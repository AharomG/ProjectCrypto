package ParteGrafica;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import ProyectoCrypto.Crypto;
import ProyectoCrypto.Monedas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MenuConversion {

	private JFrame frmConversiones;
	private JLabel lblResultado;
	private Double precioMoneda1 = 0.0, precioMoneda2 = 0.0;

	public MenuConversion() {
		initialize();
		frmConversiones.setVisible(true);
	}

	private void initialize() {
		frmConversiones = new JFrame();
		frmConversiones.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		frmConversiones.setTitle("Conversiones");
		frmConversiones.setResizable(false);
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmConversiones.setBounds(dimensionesPantalla.width / 3, dimensionesPantalla.height / 3, 649, 274);
		frmConversiones.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConversiones.getContentPane().setLayout(null);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmConversiones.dispose();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtras.setBounds(40, 174, 112, 38);
		frmConversiones.getContentPane().add(btnAtras);

		JComboBox comboBox = new JComboBox();

		for (Crypto coin : Monedas.criptomonedas) {
			comboBox.addItem(coin.getSymbol());
		}
		comboBox.setBounds(140, 86, 76, 38);
		frmConversiones.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("A -->");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(247, 96, 52, 14);
		frmConversiones.getContentPane().add(lblNewLabel);

		JComboBox comboBox_1 = new JComboBox();

		for (Crypto coin : Monedas.criptomonedas) {
			comboBox_1.addItem(coin.getSymbol());
		}
		comboBox_1.setBounds(309, 86, 76, 38);
		frmConversiones.getContentPane().add(comboBox_1);

		JLabel lblIgual = new JLabel("=");
		lblIgual.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblIgual.setBounds(408, 86, 46, 26);
		frmConversiones.getContentPane().add(lblIgual);

		lblResultado = new JLabel();
		lblResultado.setBounds(448, 86, 155, 38);
		frmConversiones.getContentPane().add(lblResultado);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String moneda1 = (String) comboBox.getSelectedItem();
				String moneda2 = (String) comboBox_1.getSelectedItem();
				for (Crypto coin : Monedas.criptomonedas) {
					if (coin.getSymbol().matches(moneda1)) {
						precioMoneda1 = coin.getPrice();
						break;
					}
				}
				for (Crypto coin : Monedas.criptomonedas) {
					if (coin.getSymbol().matches(moneda2)) {
						precioMoneda2 = coin.getPrice();
						break;
					}
				}
				String total = String.format("$%,.15f", (precioMoneda1 / precioMoneda2));
				lblResultado.setText(total);
			}
		});
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String moneda1 = (String) comboBox.getSelectedItem();
				String moneda2 = (String) comboBox_1.getSelectedItem();
				for (Crypto coin : Monedas.criptomonedas) {
					if (coin.getSymbol().matches(moneda1)) {
						precioMoneda1 = coin.getPrice();
						break;
					}
				}
				for (Crypto coin : Monedas.criptomonedas) {
					if (coin.getSymbol().matches(moneda2)) {
						precioMoneda2 = coin.getPrice();
						break;
					}
				}
				String total = String.format("$%,.15f", (precioMoneda1 / precioMoneda2));
				lblResultado.setText(total);
			}
		});
	}
}