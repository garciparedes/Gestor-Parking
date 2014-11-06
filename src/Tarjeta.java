import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author segarci, osferna, adrcalv
 */
public class Tarjeta {

	private GregorianCalendar fin_periodo;
	private String nombre, apellido, dni;
	private boolean fuera = true;

	public static ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();

	public Tarjeta(String nombre, String apellido, String dni) {

		this.fin_periodo = null;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public static Tarjeta nuevaInstancia(String nombre, String apellido,
			String dni) {

		return new Tarjeta(nombre, apellido, dni);
	}

	public boolean getFuera() {
		return fuera;
	}

	private void setFuera(boolean fuera) {
		this.fuera = fuera;
	}

	public void reset() {

		setFuera(true);
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String informacionToString() {
		
		String info = "DNI: " + this.getDni()
				+ ", Nombre: " + this.getNombre()
				+ ", Apellidos: " + this.getApellido();
		
		return info;
	}

	public GregorianCalendar getFin_periodo() {
		
		return fin_periodo;
	}

	public void setFin_periodo(GregorianCalendar nueva_fecha) {

		if (fin_periodo == null) {

			fin_periodo = nueva_fecha;
			
		} else {
			
			if (fin_periodo.before(nueva_fecha)) {

				fin_periodo = nueva_fecha;
			}
		}
	}
}
