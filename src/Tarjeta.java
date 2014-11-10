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
	public static Tarjeta nuevaInstancia(String nombre, String apellido,
			String dni) {

		return new Tarjeta(nombre, apellido, dni);
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
     * @param fuera
     */
	private void setFuera(boolean fuera) {
		this.fuera = fuera;
	}

    /**
     *
     */
	public void reset() {

		setFuera(true);
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
     * @return informacion
     */
	public String informacionToString() {
		
		String info = "DNI: " + this.getDni()
				+ ", Nombre: " + this.getNombre()
				+ ", Apellidos: " + this.getApellido();
		
		return info;
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
     */
    public void entrar(){

        if ( this.getFuera() && (this.fin_periodo != null)  && (this.fin_periodo.after(new Date())) ){
            this.setFuera(false);
        }
    }

    /**
     *
     */
    public void salir(){
        if (!this.getFuera()){
            this.setFuera(true);
        }
    }


}
