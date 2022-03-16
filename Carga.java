package ProyectoCrypto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Carga { // carga de datos a usuario
	public static ArrayList<SuperUsuario> datos() {
		ArrayList<SuperUsuario> usuarios = new ArrayList<SuperUsuario>();
		Gson gson = new Gson();
		String info = new String();
		try {
			File camino = new File("Usuarios.json");
			String path = camino.getCanonicalPath();
			FileReader in = new FileReader(path);
			int c = in.read();
			while (c != -1) {
				char caracter = (char) c;
				info = info + caracter;
				c = in.read();
			}
			in.close();
		} catch (IOException e) {
		}
		usuarios = gson.fromJson(info, new TypeToken<ArrayList<SuperUsuario>>() {
		}.getType());
		return usuarios;
	}
}
