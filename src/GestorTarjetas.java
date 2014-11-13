import java.util.ArrayList;

/**
 * Created by garciparedes on 13/11/14.
 */
public class GestorTarjetas {

    private ArrayList<Tarjeta> listaTarjeta = new ArrayList<Tarjeta>();

    public GestorTarjetas(){
    }


    /**
     *
     * @param nombre
     * @param apellido
     * @param dni
     */
    public  void nuevaTarjeta(String nombre, String apellido, String dni){
        Tarjeta tarjeta = new Tarjeta(nombre, apellido, dni);
        listaTarjeta.add(tarjeta);
    }


    /**
     *
     * @param dni
     * @return
     */
    private int posicion(String dni){
        for (int i = 0; i < listaTarjeta.size(); i++) {
            if( listaTarjeta.get(i).getDni().equals(dni)){
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
    public Tarjeta getTarjeta(String dni){
        return listaTarjeta.get(posicion(dni));
    }

}
