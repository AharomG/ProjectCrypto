package ProyectoCrypto;

import java.util.LinkedList;

public class MonedaPortafolio {
	private String nombre = "";
	private double cantidadTotal = 0;
	private LinkedList<Compra> compras = new LinkedList<Compra>();
	private LinkedList<Venta> ventas = new LinkedList<Venta>();

	public MonedaPortafolio(String nombre) {
		this.nombre = nombre;
	}

	public void agregarCompra(Compra compra) {
		compras.add(compra);
	}

	public void agregarVenta(Venta venta) {
		ventas.add(venta);
	}

	public void cantidadTotalMonedas() {
		double cantidadComprada = 0, cantidadVendida = 0;
		for (int i = 0; i < compras.size(); i++) {
			cantidadComprada = cantidadComprada + compras.get(i).getCantidadComprada();
		}
		for (int i = 0; i < ventas.size(); i++) {
			cantidadVendida = cantidadVendida + ventas.get(i).getCantidadVendida();
		}
		this.cantidadTotal = cantidadComprada - cantidadVendida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(double cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public LinkedList<Compra> getCompras() {
		return compras;
	}

	public LinkedList<Venta> getVentas() {
		return ventas;
	}

}
