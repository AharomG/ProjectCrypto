package ProyectoCrypto;

public class SuperUsuario {
	// atributos
	private String correo;
	private String password;
	private double saldo = 500;
	private Portafolio portafolio;

	// constructor
	public SuperUsuario(String correo, String password, Portafolio portafolio) {
		this.correo = correo;
		this.password = password;
		this.portafolio = portafolio;
	}

	// metodos
	public static boolean confirmarCorreo(String correo) {
		String gmail = "@gmail.com";
		String hotmail = "@hotmail.com";
		if (correo.contains(gmail) == true || correo.contains(hotmail) == true) {
			return true;
		}
		return false;
	}

	// para saber si la contrasena cumple con las caracteristicas deseadas
	public static boolean confirmarPassword(String password) {
		int tamano = password.length(), numeros = 0, mayus = 0, caracterEspecial = 0, caracteres = 0;
		for (int i = 0; i < tamano; i++) {
			if (Character.isDigit(password.charAt(i)) == true) {
				numeros++;
			}
			if (Character.isLetter(password.charAt(i)) == false && Character.isDigit(password.charAt(i)) == false) {
				caracterEspecial++;
			}
			if (Character.isUpperCase(password.charAt(i)) == true) {
				mayus++;
			}
			if (Character.isLetter(password.charAt(i)) == true) {
				caracteres = 1;
			}
		}
		if (tamano >= 8 && numeros >= 1 && caracteres >= 1 && mayus >= 1 && caracterEspecial >= 1) {
			return true;
		}
		return false;
	}

	// getter
	public String getCorreo() {
		return correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Portafolio getPortafolio() {
		return portafolio;
	}

	public void setPortafolio(Portafolio portafolio) {
		this.portafolio = portafolio;
	}
}
