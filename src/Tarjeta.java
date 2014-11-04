import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author segarci, osferna, adrcalv
 */
public class Tarjeta {
	
	private GregorianCalendar fin_periodo = null;
	private String nombre, apellido, dni;
	private boolean fuera = true;
	
	public static ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();

	public Tarjeta(GregorianCalendar fin_periodo, String nombre, String apellido, String dni){
		
		this.fin_periodo = fin_periodo;
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
	}
	
	public static Tarjeta nueva(GregorianCalendar fin_periodo, String nombre, String apellido, String dni){
		
		return new Tarjeta(fin_periodo, nombre, apellido, dni);
	}

	public boolean getFuera() {
		return fuera;
	}

	private void setFuera(boolean fuera) {
		this.fuera = fuera;
	}
	
	public void reset(){
		
		setFuera(true);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
