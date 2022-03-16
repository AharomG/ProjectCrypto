package ProyectoCrypto;

public class Cifrar {
	private static String minus = "qazwsxedcrfvtgbyhnujmikolp";
	private static String mayus = "QAZWSXEDCRFVTGBYHNUJMIKOLP";

	public static char[] cifrar(String password) {
		char[] cifrado = password.toCharArray();
		for (int i = 0; i < password.length(); i++) {
			for (int j = 0; j < minus.length(); j++) {
				if (password.charAt(i) == minus.charAt(j)) {
					if (j != minus.length() - 1) {
						cifrado[i] = minus.charAt(j + 1);
						break;
					} else {
						cifrado[i] = minus.charAt(0);
					}
				}
			}
		}
		for (int i = 0; i < password.length(); i++) {
			for (int j = 0; j < mayus.length(); j++) {
				if (password.charAt(i) == mayus.charAt(j)) {
					if (j != mayus.length() - 1) {
						cifrado[i] = mayus.charAt(j + 1);
						break;
					} else {
						cifrado[i] = mayus.charAt(0);
					}
				}
			}
		}
		return cifrado;
	}

	public static char[] desCifrar(String password) {
		char[] cifrado = password.toCharArray();
		for (int i = 0; i < password.length(); i++) {
			for (int j = 0; j < minus.length(); j++) {
				if (password.charAt(i) == minus.charAt(j)) {
					if (j != 0) {
						cifrado[i] = minus.charAt(j - 1);
						break;
					} else {
						cifrado[i] = minus.charAt(minus.length() - 1);
					}
				}
			}
		}
		for (int i = 0; i < password.length(); i++) {
			for (int j = 0; j < mayus.length(); j++) {
				if (password.charAt(i) == mayus.charAt(j)) {
					if (j != 0) {
						cifrado[i] = mayus.charAt(j - 1);
						break;
					} else {
						cifrado[i] = mayus.charAt(mayus.length() - 1);
					}
				}
			}
		}
		return cifrado;
	}
}
