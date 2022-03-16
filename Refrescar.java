package ProyectoCrypto;

import java.util.TimerTask;

public class Refrescar {
	// metodos llamados para ir refrescando la informacion cada 'x' tiempo
	public static TimerTask refrescarPrecios = new TimerTask() {
		public void run() {
			Monedas.llamada();
		}
	};
}