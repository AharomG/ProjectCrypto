package ProyectoCrypto;

public class Compra {
	private double precioCompra = 0;
	private double cantidadComprada = 0;

	public Compra(double precio, double cantidad) {
		this.precioCompra = precio;
		this.cantidadComprada = cantidad;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(double cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}
}
