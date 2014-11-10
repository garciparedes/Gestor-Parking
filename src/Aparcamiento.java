import java.util.ArrayList;

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

		Tarjeta tarjeta;

		for (int i = 0; i < tarjetaList.size(); i++) {

			tarjeta = tarjetaList.get(i);

			if (tarjeta.getDni().equals(dni)) {
				return true;
			}
		}
		return false;
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
     * @return listaDentro ArrayList con objetos Tarjeta que estan dentro.
     */
    public  ArrayList<Tarjeta> listaDentro(){

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

		for (int i = 0; i < listaDentro().size(); i++) {

			info.add(listaDentro().get(i).informacionToString());

		}
		return info;
	}

}