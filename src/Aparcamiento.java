import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author segarci, osferna, adrcalv
 */
public class Aparcamiento {

	private ArrayList<Tarjeta> tarjetaList = new ArrayList<Tarjeta>();

    /**
     *
     */
	public Aparcamiento() {
	}

    public ArrayList<Tarjeta> getTarjetaList() {
        return tarjetaList;
    }

	/**
	 * Funcion estatica que devuelve un nuevo objeto Aparcamiento.
	 * @return Aparcamiento
	 */
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

		for (int i = 0; i < tarjetaList.size(); i++) {

			tarjeta = tarjetaList.get(i);

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
		return posicion(dni) >= 0;
	}

	/**
	 *
	 * @param dni
	 * @return
	 */
	private int posicion(String dni){
		for (int i = 0; i < tarjetaList.size(); i++) {
			if( tarjetaList.get(i).getDni().equals(dni)){
				return i;
			}
		}
		return -1;
	}

	/**
	 *
	 * @param dni
	 * @return
	 */
	private Tarjeta getTarjeta(String dni){
		return this.tarjetaList.get(posicion(dni));
	}

    /**
     *
     * @return listaDentro ArrayList con objetos Tarjeta que estan dentro.
     */
    public  ArrayList<Tarjeta> getListaDentro(){

        ArrayList<Tarjeta> listaDentro = new ArrayList<Tarjeta>();

        for (int i = 0; i < this.getTarjetaList().size(); i++){
            if (this.getTarjetaList().get(i).getFuera()){
                listaDentro.add(this.getTarjetaList().get(i));
            }
        }
        return listaDentro;
    }

    /**
     *
     * @return info ArrayList con un String con informacion sobre las tarjetas que estan dentro.
     */
	public ArrayList<String> infoTarjetas() {

		ArrayList<String> info = new ArrayList<String>();

		for (int i = 0; i < getListaDentro().size(); i++) {

			info.add(getListaDentro().get(i).informacionToString());

		}
		return info;
	}

	/**
	 *
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @return
	 */
	public boolean nuevaTarjeta(String nombre, String apellido, String dni) {

		if (!existe(dni)) {

			tarjetaList.add(Tarjeta.nuevaInstancia(nombre, apellido, dni));
			return true;

		} else {

			return false;
		}
	}

	/**
	 *
	 * @param dni
	 * @param fecha
	 */
	public void pagar(String dni, GregorianCalendar fecha){
		this.getTarjeta(dni).setFin_periodo(fecha);
	}

	public void entrar(String dni){

		if ( this.getTarjeta(dni).getFuera()
				&& ( this.getTarjeta(dni).getFin_periodo() != null )
				&& ( this.getTarjeta(dni).getFin_periodo().after(new Date()) )
				){
			this.getTarjeta(dni).entrar();
		} else {
				//ToDo
		}

	}

	public void salir(String dni){

		if (!this.getTarjeta(dni).getFuera()){
			this.getTarjeta(dni).salir();
		}
	}

	public void reiniciar(String dni){
		this.getTarjeta(dni).reiniciar();
		;
	}
}