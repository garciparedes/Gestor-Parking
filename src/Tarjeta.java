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
     * @return
     */
	public boolean getFuera() {
		return fuera;
	}

	/**
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
     * @return dni
     */
	public String getDni() {
		return dni;
	}


	/**
     *
     * @return informacion
     */
	public String informacionToString() {
		
		String info = "DNI: " + dni
				+ ", Nombre: " + nombre
				+ ", Apellidos: " + apellido;
		
		return info;
	}


    /**
     *
     */
    public void entrar(){

        if ( fuera
				&& ( fin_periodo != null )
				&& ( fin_periodo.after(new Date()) )
				){
            fuera = false;
        } else {

		}
    }


    /**
     *
     */
    public void salir(){
        if (!fuera){
            fuera = true;
        }
    }


	/**
	 *
	 */
	public void reiniciar() {
		fuera = true;
	}

}
