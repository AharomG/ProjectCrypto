package ProyectoCrypto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Monedas {

	public static ArrayList<Crypto> criptomonedas = new ArrayList<Crypto>();

	public static void llamada() {
		URL url;
		String ids = "";
		try {
			url = new URL("https://api.paaksing.com/crypto/v1/info");
			BufferedReader lector = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			for (String linea; (linea = lector.readLine()) != null;) {
				ids = ids + linea;
			}
			JSONArray id = new JSONArray(ids);
			String precios = "";
			for (int i = 0; i < 91; i++) {
				url = new URL("https://api.paaksing.com/crypto/v1/market/" + id.getJSONObject(i).getInt("id"));
				BufferedReader lector2 = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				for (String linea; (linea = lector2.readLine()) != null;) {
					precios = precios + linea + ",";
				}
			}
			lector.close();
			precios = "[" + precios + "]";
			JSONArray numero = new JSONArray(precios);
			for (int i = 0; i < (numero.length() - 1); i++) {
				Crypto monedas = new Crypto(id.getJSONObject(i).getString("name"),
						id.getJSONObject(i).getString("symbol"), numero.getJSONObject(i).getDouble("circulatingSupply"),
						numero.getJSONObject(i).getDouble("price"), numero.getJSONObject(i).getDouble("volume24hpc"),
						numero.getJSONObject(i).getDouble("price1hpc"), numero.getJSONObject(i).getDouble("price24hpc"),
						numero.getJSONObject(i).getDouble("price7dpc"));
				criptomonedas.add(monedas);
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (MalformedURLException e) {
			e.getMessage();
		} catch (UnsupportedEncodingException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static double obtenerUSDT() {
		URL url;
		String usdt = "";
		double precioUSDT = 0;
		try {
			url = new URL("https://api.paaksing.com/crypto/v1/market/825");
			BufferedReader lector = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			for (String linea; (linea = lector.readLine()) != null;) {
				usdt = usdt + linea;
			}
			JSONObject filtro = new JSONObject(usdt);
			precioUSDT = filtro.getDouble("price");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return precioUSDT;
	}
}