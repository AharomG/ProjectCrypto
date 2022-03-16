package ProyectoCrypto;

public class Portafolio {

	private MonedaPortafolio[] monedas = new MonedaPortafolio[10];

	public void agregarMoneda(String nombre) {
		for (int i = 0; i < monedas.length; i++) {
			if (monedas[i] == null) {
				MonedaPortafolio moneda = new MonedaPortafolio(nombre);
				monedas[i] = moneda;
				break;
			}
			if (monedas[i].getNombre().equalsIgnoreCase(nombre)) {
				break;
			}
		}
	}

	public void eliminarMoneda(String nombre) {
		for (int i = 0; i < monedas.length; i++) {
			if (monedas[i] != null) {
				if (monedas[i].getNombre().equalsIgnoreCase(nombre)) {
					monedas[i] = null;
				}
			}
		}
	}

	public MonedaPortafolio[] getMonedas() {
		return monedas;
	}

	public void setMonedas(MonedaPortafolio[] monedas) {
		this.monedas = monedas;
	}
}