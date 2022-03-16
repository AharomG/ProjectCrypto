package ProyectoCrypto;

public class Crypto {
	// atributos
	private String name, symbol;
	private double volume_24h, circulating_supply, price, percent_change_1h, percent_change_24h, percent_change_7d;

	// constructor
	public Crypto(String name, String symbol, double circulating_supply, double price, double volume_24h,
			double percent_change_1h, double percent_change_24h, double percent_change_7d) {
		this.name = name;
		this.symbol = symbol;
		this.volume_24h = volume_24h;
		this.circulating_supply = circulating_supply;
		this.price = price;
		this.percent_change_1h = percent_change_1h;
		this.percent_change_24h = percent_change_24h;
		this.percent_change_7d = percent_change_7d;
	}

	// getters
	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public double getVolume_24h() {
		return volume_24h;
	}

	public double getCirculating_supply() {
		return circulating_supply;
	}

	public double getPrice() {
		return price;
	}

	public double getPercent_change_1h() {
		return percent_change_1h;
	}

	public double getPercent_change_24h() {
		return percent_change_24h;
	}

	public double getPercent_change_7d() {
		return percent_change_7d;
	}

	public String formato() {
		return String.format("%-18s", "Nombre") + String.format("%7s", "ID") + String.format("%24s", "Volumen 24H")
				+ String.format("%16s", "Cantidad en Circulacion") + String.format("%24s", "Precio en $")
				+ String.format("%30s", "% de cambio 1H ") + String.format("%30s", "% de cambio 24H ")
				+ String.format("%30s", "% de cambio 7 Dias  ") + "\n";

	}

	/*
	 * public String toString() { return String.format("%-18s",name)+
	 * String.format("%5s", symbol)+String.format("%24s",volume_24h) +
	 * String.format("%16s",circulating_supply)+ String.format("%24s",price)+
	 * String.format("%30s",percent_change_1h)+
	 * String.format("%30s",percent_change_24h)
	 * +String.format("%30s",percent_change_7d)+ "\n"; }
	 */
	public String toString() {
		return "Nombre=" + name + ", ID=" + symbol + ", Volumen 24h=" + volume_24h + ", Cantidad en circulacion="
				+ circulating_supply + ", precio en $=" + price + ", porcentaje de cambio en 1h=" + percent_change_1h
				+ "%" + ", porcentaje de cambio en 24h=" + percent_change_24h + "%" + ", porcentaje de cambio en 7d="
				+ percent_change_7d + "%" + "\n";
	}
}
