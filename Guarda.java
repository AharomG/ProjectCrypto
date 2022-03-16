package ProyectoCrypto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Guarda {
	// guarda los datos en archivo Json
	public static void datos(ArrayList<SuperUsuario> usuarios) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			FileWriter salida = new FileWriter("Usuarios.json");
			String data = gson.toJson(usuarios);
			salida.write(data, 0, data.length());
			salida.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	// guarda la fecha, hora y el IP local del dispostivo
	public static void fechaHoraIP() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String horaActual = dtf.format(LocalDateTime.now());
		try {
			String localIpAddress = InetAddress.getLocalHost().getHostAddress();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			try {
				File existe = new File("FechaHoraIP.json");
				if (!existe.exists()) {
					FileWriter salida = new FileWriter("FechaHoraIP.json");
					String data = gson.toJson(horaActual) + " " + gson.toJson(localIpAddress) + "\n";
					salida.write(data, 0, data.length());
					salida.close();
				} else {
					FileWriter salida = new FileWriter("FechaHoraIP.json", true);
					BufferedWriter escribir = new BufferedWriter(salida);
					String data = gson.toJson(horaActual) + " " + gson.toJson(localIpAddress) + "\n";
					escribir.write(data);
					escribir.close();
				}
			} catch (IOException e) {
				e.getMessage();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
