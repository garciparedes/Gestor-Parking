import java.util.ArrayList;

/**
 * @author Sergio Garcia Prado
 * @author Adrian Calvo Rojo
 * @author Oscar Fernández Angulo
 */
public class Aparcamiento {

	/**
     * Constructor de la clase Aparcamiento
     */
	public Aparcamiento() {

	}

	/**
	 * Del ArrayList recibido busca las tarjetas que se encuentran dentro de un
	 * aparcamiento.
	 * 
	 * @return ArrayList con objetos Tarjeta que estan dentro.
	 */
	public ArrayList<Tarjeta> getListaDentro(ArrayList<Tarjeta> listaTarjeta) {

		ArrayList<Tarjeta> listaDentro = new ArrayList<Tarjeta>();

		for (int i = 0; i < listaTarjeta.size(); i++) {

			if (!listaTarjeta.get(i).getFuera()) {

				listaDentro.add(listaTarjeta.get(i));
			}
		}

		return listaDentro;
	}

	/**
	 * Busca las tarjetas que estan dentro e introduce su informacion dentro de
	 * otra lista.
	 * 
	 * @param listaTarjeta
	 *            lista de objetos Tarjeta
	 * 
	 * @return ArrayList tipo String con informacion sobre las tarjetas que
	 *         estan dentro.
	 */
	public ArrayList<String> infoTarjetas(ArrayList<Tarjeta> listaTarjeta) {

		ArrayList<String> info = new ArrayList<String>();

		for (int i = 0; i < getListaDentro(listaTarjeta).size(); i++) {

			info.add(getListaDentro(listaTarjeta).get(i).informacionToString());

		}
		return info;
	}

	/**
	 * Se encarga de cambiar el estado de una tarjeta a "Dentro"
	 *
	 * @param tarjeta
	 */
	public void entrar(Tarjeta tarjeta) {
		tarjeta.entrar();
	}

	/**
	 * Se encarga de cambiar el estado de una tarjeta a "Fuera"
	 *
	 * @param tarjeta
	 */
	public void salir(Tarjeta tarjeta) {
		tarjeta.salir();
	}

}