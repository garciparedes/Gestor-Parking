import java.util.ArrayList;


/**
 * @author segarci, osferna, adrcalv
 */
public class Aparcamiento {


    /**
     *
     */
	public Aparcamiento() {
		
	}


    /**
     *
     * @return ArrayList con objetos Tarjeta que estan dentro.
     */
    public  ArrayList<Tarjeta> getListaDentro(ArrayList<Tarjeta> listaTarjeta){

        ArrayList<Tarjeta> listaDentro = new ArrayList<Tarjeta>();

		for (int i = 0; i < listaTarjeta.size(); i++){
			
			if ( !listaTarjeta.get(i).getFuera()){
				
				listaDentro.add(listaTarjeta.get(i));
			}
		}

        return listaDentro;
    }


    /**
     * 
     * @param listaTarjeta lista de objetos Tarjeta
     * 
     * @return ArrayList tipo String con informacion sobre las tarjetas que estan dentro.
     */
	public ArrayList<String> infoTarjetas(ArrayList<Tarjeta> listaTarjeta) {

		ArrayList<String> info = new ArrayList<String>();

		for (int i = 0; i < getListaDentro(listaTarjeta).size(); i++) {

			info.add(getListaDentro(listaTarjeta).get(i).informacionToString());

		}
		return info;
	}


	/**
	 *
	 * @param tarjeta
	 */
	public void entrar(Tarjeta tarjeta){
		tarjeta.entrar();
	}


	/**
	 *
	 * @param tarjeta
	 */
	public void salir (Tarjeta tarjeta){
		tarjeta.salir();
	}

}