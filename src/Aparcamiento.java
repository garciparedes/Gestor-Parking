import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author segarci, osferna, adrcalv
 */
public class Aparcamiento {

	private ArrayList<Tarjeta> tarjetas;

	/**
	 * 
	 */

	public Aparcamiento() {

	}

	public boolean isDentro(String dni) {

		Tarjeta tarjeta;

		for (int i = 0; i < tarjetas.size(); i++) {

			tarjeta = tarjetas.get(i);

			if (tarjeta.getDni().equals(dni) && !tarjeta.getFuera()) {
				return true;
			}
		}
		return false;
	}

	public boolean existe(String dni) {

		Tarjeta tarjeta;

		for (int i = 0; i < tarjetas.size(); i++) {

			tarjeta = tarjetas.get(i);

			if (tarjeta.getDni().equals(dni)) {
				return true;
			}
		}
		return false;
	}

	public boolean nuevaTarjeta(String nombre,
			String apellido, String dni) {

		if (!existe(dni)) {

			tarjetas.add(Tarjeta.nuevaInstancia(nombre, apellido, dni));
			return true;

		} else {

			return false;
		}
	}

	public ArrayList<String> infoTarjetas() {

		ArrayList<String> info = new ArrayList<String>();

		for (int i = 0; i < tarjetas.size(); i++) {

			info.add(tarjetas.get(i).informacionToString());

		}
		return info;
	}

}