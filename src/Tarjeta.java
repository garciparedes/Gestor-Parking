import java.util.GregorianCalendar;

/**
 * @author segarci, osferna, adrcalv
 */
public class Tarjeta {

	private GregorianCalendar fin_periodo;
	private String nombre, apellido, dni;
	private boolean fuera = true;

	/**
	 * Crea un instancia de Tarjeta con los datos del usuario. Al crear una nueva
	 * Tarjeta la fecha de fin del periodo se inicializa a null.
	 * 
	 * @param nombre
	 * @param apellido
	 * @param dni
	 */
	public Tarjeta(String nombre, String apellido, String dni) {

		this.fin_periodo = null;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	/**
	 * @return true la tarjeta esta "Fuera", false esta "Dentro"
	 */
	public boolean getFuera() {

		return fuera;
	}

	/**
	 * Dada una fecha, cambia la fecha del fin de periodo de pago.
	 * La fecha introducida debe ser posterior a la actual.
	 * 
	 * @param nueva_fecha
	 */
	public void pagar(GregorianCalendar nueva_fecha) {

		if (fin_periodo == null) {

			fin_periodo = nueva_fecha;

		} else {

			if (fin_periodo.before(nueva_fecha)) {

				fin_periodo = nueva_fecha;
			}
		}
	}

	/**
	 *
	 * @return Devuelve el DNI del usuario de la tarjeta.
	 */
	public String getDni() {

		return dni;
	}

	/**
	 *
	 * @return Cadena con el DNI, nombre y apellidos del usuario de la tarjeta.
	 */
	public String informacionToString() {

		String info = "DNI: " + dni + ", Nombre: " + nombre + ", Apellidos: "
				+ apellido;

		return info;
	}

	/**
     * Cambia el estado de una Tarjeta a "Dentro". Dicha Tarjeta debe estar al corriente de pago, 
     * es decir, la fecha de fin de periodo no puede ser null ni tampoco debe ser anterior a la fecha actual.
     */
	public void entrar() {

		if (fuera && (fin_periodo != null)
				&& (fin_periodo.after(new GregorianCalendar()))) {

			fuera = false;

		} else {

		}
	}

	/**
     *	Cambia el estado de la Tarjeta a "Fuera".
     */
	public void salir() {

		if (!fuera) {

			fuera = true;
		}
	}

	/**
	 * Resetea el estado de la Tarjeta a "Fuera" sin hacer comprobaciones.
	 */
	public void reiniciar() {

		fuera = true;
	}

}
