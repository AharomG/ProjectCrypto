package ProyectoCrypto;

public class Venta {
	private double precioVenta = 0;
	private double cantidadVendida = 0;

	public Venta(double precio, double cantidad) {
		this.precioVenta = precio;
		this.cantidadVendida = cantidad;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(double cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

}
