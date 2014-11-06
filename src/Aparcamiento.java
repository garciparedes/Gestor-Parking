import java.util.ArrayList;

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
	
	public static Aparcamiento nuevaInstancia(){
		
		return new Aparcamiento();
	}

    /**
     *
     * @param dni
     * @return
     */
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

    /**
     *
     * @param dni
     * @return
     */
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

    /**
     *
     * @param nombre
     * @param apellido
     * @param dni
     * @return
     */
	public boolean nuevaTarjeta(String nombre,
			String apellido, String dni) {

		if (!existe(dni)) {

			tarjetas.add(Tarjeta.nuevaInstancia(nombre, apellido, dni));
			return true;

		} else {

			return false;
		}
	}

    /**
     *
     * @return
     */
	public ArrayList<String> infoTarjetas() {

		ArrayList<String> info = new ArrayList<String>();

		for (int i = 0; i < tarjetas.size(); i++) {

			info.add(tarjetas.get(i).informacionToString());

		}
		return info;
	}

}