import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author segarci, osferna, adrcalv
 */
public class Tarjeta {

	private GregorianCalendar fin_periodo;
	private String nombre, apellido, dni;
	private boolean fuera = true;

	public static ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();

    /**
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
     *
     * @param nombre
     * @param apellido
     * @param dni
     * @return Tarjeta
     */
	public static Tarjeta nuevaInstancia(String nombre, String apellido,String dni) {

		return new Tarjeta(nombre, apellido, dni);
	}

	/**
	 *
	 * @param fuera
	 */
	public void setFuera(boolean fuera) {
		this.fuera = fuera;
	}

	/**
	 *
	 * @param nueva_fecha
	 */
	public void setFin_periodo(GregorianCalendar nueva_fecha) {

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
     * @return
     */
	public boolean getFuera() {
		return fuera;
	}




    /**
     *
     * @return dni
     */
	public String getDni() {
		return dni;
	}

    /**
     *
     * @return nombre
     */
	public String getNombre() {
		return nombre;
	}

    /**
     *
     * @return apellido
     */
	public String getApellido() {
		return apellido;
	}

	/**
	 *
	 * @return
	 */
	public GregorianCalendar getFin_periodo() {

		return fin_periodo;
	}


	/**
     *
     * @return informacion
     */
	public String informacionToString() {
		
		String info = "DNI: " + this.getDni()
				+ ", Nombre: " + this.getNombre()
				+ ", Apellidos: " + this.getApellido();
		
		return info;
	}

	public void entrar(){
		setFuera(false);
	}

	public void salir(){
		setFuera(true);
	}

	public void reiniciar(){
		setFuera(true);
	}

}
