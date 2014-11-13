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
     * @return listaDentro ArrayList con objetos Tarjeta que estan dentro.
     */
    public  ArrayList<Tarjeta> getListaDentro(){

        ArrayList<Tarjeta> listaDentro = new ArrayList<Tarjeta>();

		/*
        for (int i = 0; i < getTarjetaList().size(); i++){
            if (getTarjetaList().get(i).getFuera()){
                listaDentro.add(getTarjetaList().get(i));
            }
        }
        */

		for (int i = 0; i < Main.listaTarjeta.size(); i++){
			if ( !Main.listaTarjeta.get(i).getFuera()){
				listaDentro.add(Main.listaTarjeta.get(i));
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
	 * @param dni
	 */
	public void entrar(String dni){
		Main.getTarjeta(dni).entrar();
	}


	/**
	 *
	 * @param dni
	 */
	public void salir(String dni){
		Main.getTarjeta(dni).salir();
	}

}