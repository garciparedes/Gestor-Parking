import java.util.GregorianCalendar;

/**
 * @author segarci, osferna, adrcalv
 */
public class Tarjeta {
	
	private GregorianCalendar fin_periodo = null;
	private String nombre, apellido, dni;
	private boolean fuera = true;

	public Tarjeta(GregorianCalendar fin_periodo, String nombre, String apellido, String dni){
		
		this.fin_periodo = fin_periodo;
		this.nombre = nombre;
		this.apellido = apellido;
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
}
