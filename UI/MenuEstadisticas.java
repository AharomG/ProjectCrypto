package ParteGrafica;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import ProyectoCrypto.Compra;
import ProyectoCrypto.Monedas;
import ProyectoCrypto.SuperUsuario;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MenuEstadisticas {

	private JFrame frmEstadisticas;
	private SuperUsuario usuario;

	public MenuEstadisticas(SuperUsuario usser) {
		this.usuario = usser;
		initialize();
		frmEstadisticas.setVisible(true);
	}

	private void initialize() {
		frmEstadisticas = new JFrame();
		frmEstadisticas.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		frmEstadisticas.setTitle("Estadisticas");
		frmEstadisticas.setResizable(false);
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmEstadisticas.setBounds(dimensionesPantalla.width / 3, dimensionesPantalla.height / 3, 466, 231);
		frmEstadisticas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEstadisticas.getContentPane().setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(295, 92, 81, 22);
		frmEstadisticas.getContentPane().add(comboBox);
		for (int i = 0; i < 10; i++) {
			if (usuario.getPortafolio().getMonedas()[i] != null)
				comboBox.addItem(usuario.getPortafolio().getMonedas()[i].getNombre());
		}

		JLabel lblNewLabel = new JLabel("En total:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(67, 34, 93, 48);
		frmEstadisticas.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Por criptomoneda:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(257, 47, 193, 22);
		frmEstadisticas.getContentPane().add(lblNewLabel_1);

		JLabel lblEstadisticaTotal = new JLabel(calcularGananciaTotal() + "%");
		lblEstadisticaTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstadisticaTotal.setBounds(44, 81, 154, 40);
		frmEstadisticas.getContentPane().add(lblEstadisticaTotal);

		JLabel lblEstadisticaCriptomoneda = new JLabel("");
		lblEstadisticaCriptomoneda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstadisticaCriptomoneda.setBounds(276, 125, 162, 48);
		frmEstadisticas.getContentPane().add(lblEstadisticaCriptomoneda);

		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblEstadisticaTotal.setText(calcularGananciaTotal() + "%");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(44, 150, 112, 23);
		frmEstadisticas.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("No posee inversion.");
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(257, 136, 154, 37);
		frmEstadisticas.getContentPane().add(lblNewLabel_2);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String simbolo = (String) comboBox.getSelectedItem();
				for (int i = 0; i < 10; i++) {
					if (usuario.getPortafolio().getMonedas()[i] != null
							&& simbolo.equalsIgnoreCase(usuario.getPortafolio().getMonedas()[i].getNombre())) {
						if (usuario.getPortafolio().getMonedas()[i].getCantidadTotal() > 0) {
							lblNewLabel_2.setVisible(false);
							double cantidadMonedas = usuario.getPortafolio().getMonedas()[i].getCantidadTotal();
							double cantidad = 0;
							double inversion = 0;
							double precioActual = 0;
							for (int j = (usuario.getPortafolio().getMonedas()[i].getCompras().size()
									- 1); j >= 0; j--) {
								inversion = usuario.getPortafolio().getMonedas()[i].getCompras().get(j)
										.getPrecioCompra()
										* usuario.getPortafolio().getMonedas()[i].getCompras().get(j)
												.getCantidadComprada();
								cantidad = cantidad + usuario.getPortafolio().getMonedas()[i].getCompras().get(j)
										.getCantidadComprada();
								if (cantidad == cantidadMonedas)
									break;
							}
							for (int l = 0; l < 30; l++) {
								if (usuario.getPortafolio().getMonedas()[i].getNombre()
										.equalsIgnoreCase(Monedas.criptomonedas.get(l).getSymbol())) {
									precioActual = cantidadMonedas * Monedas.criptomonedas.get(l).getPrice();
									break;
								}
							}
							lblEstadisticaCriptomoneda
									.setText(String.format("%.7f", ((precioActual * 100 / inversion) - 100)));
							lblEstadisticaCriptomoneda.setVisible(true);
							break;
						} else {
							lblEstadisticaCriptomoneda.setVisible(false);
							lblNewLabel_2.setVisible(true);
							break;
						}
					}
				}
			}
		});
	}

	private String calcularGananciaTotal() {
		String gananciaTotal = "";
		double ganancia = 0;
		for (int i = 0; i < 10; i++) {
			if (usuario.getPortafolio().getMonedas()[i] != null
					&& usuario.getPortafolio().getMonedas()[i].getCantidadTotal() > 0) {
				double cantidadMonedas = usuario.getPortafolio().getMonedas()[i].getCantidadTotal();
				double cantidad = 0;
				double inversion = 0;
				double precioActual = 0;
				for (int j = (usuario.getPortafolio().getMonedas()[i].getCompras().size() - 1); j >= 0; j--) {
					inversion = usuario.getPortafolio().getMonedas()[i].getCompras().get(j).getPrecioCompra()
							* usuario.getPortafolio().getMonedas()[i].getCompras().get(j).getCantidadComprada();
					cantidad = cantidad
							+ usuario.getPortafolio().getMonedas()[i].getCompras().get(j).getCantidadComprada();
					if (cantidad == cantidadMonedas)
						break;
				}
				for (int l = 0; l < 30; l++) {
					if (usuario.getPortafolio().getMonedas()[i].getNombre()
							.equalsIgnoreCase(Monedas.criptomonedas.get(l).getSymbol())) {
						precioActual = cantidadMonedas * Monedas.criptomonedas.get(l).getPrice();
						break;
					}
				}
				ganancia = ganancia + ((precioActual * 100 / inversion) - 100);
			}
			gananciaTotal = String.format("%.10f", ganancia);
		}
		return gananciaTotal;
	}
}