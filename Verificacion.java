package ProyectoCrypto;

import java.util.ArrayList;

public class Verificacion {
	// verifica que el correo indicado no este registrado
	public static boolean correo(String correo, ArrayList<SuperUsuario> usuarios) {
		for (SuperUsuario correos : usuarios) {
			if (correo.matches(correos.getCorreo()))
				return true;
		}
		return false;
	}
}
