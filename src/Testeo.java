import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * @author Sergio Garcia Prado
 * @author Adrian Calvo Rojo
 * @author Oscar Fernández Angulo
 */
public class Testeo {

	/* ArrayList con las tarjetas que se van creando. */
	private static ArrayList<Tarjeta> listaTarjeta = new ArrayList<Tarjeta>();

	/* Mensajes de informacio de cara al usuario */
	private static final String[] MSJ_INFO = {
		"No se ha realizado el pago.",				//MSJ_INFO[0]
		"La tarjeta se ha reiniciado, DNI: ",		//MSJ_INFO[1]
		"Se ha creado la tarjeta con DNI: ",		//MSJ_INFO[2]
		"Su pago se ha realizado correctamente.",	//MSJ_INFO[3]
		"Ha entrado, DNI: ",						//MSJ_INFO[4]
		"Error al entrar, DNI: ",					//MSJ_INFO[5]
		"Ha salido, DNI: ",							//MSJ_INFO[6]
		"Error al salir, DNI: "						//MSJ_INFO[7]
	};

	/**
	 * Añade una tarjeta a la lista. Recibe los parametros: Nombre, Apellidos y
	 * DNI del usuario al que pertenece la tarjeta.
	 *
	 * @param nombre
	 * @param apellido
	 * @param dni
	 */
	private static void nuevaTarjeta(String nombre, String apellido, String dni) {
		Tarjeta tarjeta = new Tarjeta(nombre, apellido, dni);
		listaTarjeta.add(tarjeta);

		System.out.println(MSJ_INFO[2] + dni);
	}

	/**
	 * Dado un DNI devuelve como int la posicion de la tarjeta en la lista.
	 * 
	 * @param dni
	 * @return
	 */
	private static int posicion(String dni) {
		for (int i = 0; i < listaTarjeta.size(); i++) {
			if (listaTarjeta.get(i).getDni().equals(dni)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Metodo que busca una tarjeta en el ArrayList de tarjetas.
	 * 
	 * @param dni
	 * @return Un objeto de la clase Tarjeta.
	 */
	private static Tarjeta getTarjeta(String dni) {

		return listaTarjeta.get(posicion(dni));
	}

	/**
     * Reinicia la tarjeta dado un DNI.
     * 
     * @param dni
     */
	private static void reiniciar(String dni) {

		getTarjeta(dni).reiniciar();

		System.out.println(MSJ_INFO[1] + dni);
	}

	/**
	 * Gestiona el pago de una tarjeta, si la fecha no se ha cambiado
	 * imprime un mensaje de error.
	 * 
	 * @param dni
	 * @param gregorianCalendar
	 */
	private static void pagar(String dni, GregorianCalendar gregorianCalendar) {
		getTarjeta(dni).pagar(gregorianCalendar);

		if (getTarjeta(dni).getFin_periodo().equals(gregorianCalendar)) {
			System.out.println(MSJ_INFO[3]);
		} else {
			System.err.println(MSJ_INFO[0]);
		}

	}

	/**
	 * Gestiona la entrada de la tarjeta, imprime un mensaje de error
	 * en caso de que no pueda entrar.
	 * 
	 * @param aparcamiento
	 * @param dni
	 */
	private static void entrar(Aparcamiento aparcamiento, String dni) {

		aparcamiento.entrar(listaTarjeta.get(posicion(dni)));

		if (!getTarjeta(dni).getFuera()) {
			System.out.println(MSJ_INFO[4] + dni);
		} else {
			System.err.println(MSJ_INFO[5] + dni);

		}
	}

	/**
	 * Gestiona la salida de la tarjeta, imprime un mensaje de error
	 * en caso de que no pueda salir
	 * 
	 * @param aparcamiento
	 * @param dni
	 */
	private static void salir(Aparcamiento aparcamiento, String dni) {

		aparcamiento.salir(listaTarjeta.get(posicion(dni)));
		if (getTarjeta(dni).getFuera()) {
			System.out.println(MSJ_INFO[6] + dni);
		} else {
			System.err.println(MSJ_INFO[7] + dni);

		}

	}

	/**
     * Imprime las tarjetas que se encuentra dentro del aparcamiento usando el
     * metodo infoTarjetas() de la clase Aparcamiento.
     */
	public static void infoTarjeta(Aparcamiento aparcamiento) {

		ArrayList<String> infoList = aparcamiento.infoTarjetas(listaTarjeta);
		System.out.println("\nLista de tarjetas del aparcamiento: ");
		for (int i = 0; i < infoList.size(); i++) {
			System.out.println("\t"+infoList.get(i));
		}
		System.out.println();
	}

	/**
	 *
	 * @param Args
	 */
	public static void main(String[] Args) {

		/* Creacion de un objeto Aparcamiento */
		Aparcamiento delibes = new Aparcamiento();
		
		/* Creacion de tres nuevas tarjetas que seran añadidas al ArrayList */
		nuevaTarjeta("Sergio", "Garcia", "12345678A");
		nuevaTarjeta("Adri", "Calvo", "12345678B");
		nuevaTarjeta("Oscar", "Fernandez", "12345678C");

		/* Pago para cada tarjeta */
		pagar("12345678A", new GregorianCalendar(2015, 6, 24));
		pagar("12345678C", new GregorianCalendar(2015, 6, 24));

		/* Entramos con la primera, deberia ir todo bien */
		entrar(delibes, "12345678A");

		/* Entramos con la segunda, deberia dar fallo ya que no se ha pagado */
		entrar(delibes, "12345678B");
		
		/* Entramos con la tercera, deberia ir todo bien */
		entrar(delibes, "12345678C");

		/* Imprime las que hay dentro */
		infoTarjeta(delibes);
		
		/* Reiniciamos la tercera */
		reiniciar("12345678C");

		/* Imprime las que hay dentro */
		infoTarjeta(delibes);

		/* Salimos con la primera tarjeta, que es la unica que queda */
		salir(delibes, "12345678A");
	}
}
