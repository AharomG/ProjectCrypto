package ParteGrafica;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import ProyectoCrypto.Guarda;
import ProyectoCrypto.Monedas;
import ProyectoCrypto.Portafolio;
import ProyectoCrypto.SuperUsuario;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuAgregarMonedasPortafolio {

	private JFrame frmAgregarMonedas;
	private SuperUsuario usuario;

	public MenuAgregarMonedasPortafolio(SuperUsuario usser) {
		this.usuario = usser;
		initialize();
		frmAgregarMonedas.setVisible(true);
	}

	private void initialize() {
		frmAgregarMonedas = new JFrame();
		frmAgregarMonedas.setIconImage(Toolkit.getDefaultToolkit().getImage("UCAB.png"));
		frmAgregarMonedas.setTitle("Agregar o eliminar monedas");
		Dimension dimensionesPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmAgregarMonedas.setBounds(dimensionesPantalla.width / 3, dimensionesPantalla.height / 3, 442, 251);
		frmAgregarMonedas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAgregarMonedas.getContentPane().setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(159, 111, 73, 33);
		frmAgregarMonedas.getContentPane().add(comboBox);
		for (int i = 0; i < 30; i++) {
			comboBox.addItem(Monedas.criptomonedas.get(i).getSymbol());
		}

		JLabel lblLimite = new JLabel("Solo se pueden poseer 10 monedas en el portafolio.");
		lblLimite.setBounds(10, 23, 386, 14);
		frmAgregarMonedas.getContentPane().add(lblLimite);

		JLabel lblEliminar = new JLabel("Eliminar una moneda EN POSESION la vendera automaticamente.");
		lblEliminar.setForeground(Color.RED);
		lblEliminar.setBounds(10, 48, 386, 14);
		frmAgregarMonedas.getContentPane().add(lblEliminar);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String nombre = (String) comboBox.getSelectedItem();
				if (usuario.getPortafolio() == null)
					usuario.setPortafolio(new Portafolio());
				else {
					usuario.getPortafolio().agregarMoneda(nombre);
					Guarda.datos(MenuPrincipal.usuarios);
				}
			}
		});
		btnAgregar.setBounds(279, 89, 102, 33);
		frmAgregarMonedas.getContentPane().add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String nombre = (String) comboBox.getSelectedItem();
				for (int i = 0; i < 10; i++) {
					if (usuario.getPortafolio().getMonedas()[i].getNombre().equalsIgnoreCase(nombre)) {
						double precioMoneda = 0;
						for (int j = 0; j < 30; j++) {
							if (Monedas.criptomonedas.get(j).getSymbol().equalsIgnoreCase(nombre)) {
								precioMoneda = Monedas.criptomonedas.get(j).getPrice();
								break;
							}
						}
						usuario.setSaldo(usuario.getSaldo()
								+ (precioMoneda * usuario.getPortafolio().getMonedas()[i].getCantidadTotal()));
						break;
					}
				}
				usuario.getPortafolio().eliminarMoneda(nombre);
				Guarda.datos(MenuPrincipal.usuarios);
			}
		});
		btnEliminar.setBounds(279, 155, 102, 33);
		frmAgregarMonedas.getContentPane().add(btnEliminar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frmAgregarMonedas.dispose();
			}
		});
		btnSalir.setBounds(27, 165, 89, 23);
		frmAgregarMonedas.getContentPane().add(btnSalir);
	}
}
