import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author segarci, osferna, adrcalv
 */
public class Main {


    /**
     *
     */
    public static ArrayList<Tarjeta> listaTarjeta = new ArrayList<Tarjeta>();


    /**
     *
     * @param nombre
     * @param apellido
     * @param dni
     */
    public static void nuevaTarjeta(String nombre, String apellido, String dni){
        Tarjeta tarjeta = new Tarjeta(nombre, apellido, dni);
        listaTarjeta.add(tarjeta);
    }


    /**
     *
     * @param dni
     * @return
     */
    private  static int posicion(String dni){
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
    public static Tarjeta getTarjeta(String dni){
        return listaTarjeta.get(posicion(dni));
    }


    /**
     *
     */
    public static void entrar(Aparcamiento aparcamiento, String dni){
        aparcamiento.entrar(dni);
    }


    /**
     *
     */
    public static void salir(Aparcamiento aparcamiento, String dni){
        aparcamiento.salir(dni);
    }


    /**
     *
     */
    public static void reiniciar(String dni){
        getTarjeta(dni).reiniciar();
    }


    /**
     *
     * @param dni
     * @param gregorianCalendar
     */
    public static void pagar(String dni, GregorianCalendar gregorianCalendar){
        getTarjeta(dni).pagar(gregorianCalendar);
    }


    /**
     *
     * @param Args
     */
    public static void main (String[] Args){
    	
    	Aparcamiento delibes = new Aparcamiento();
        nuevaTarjeta("Sergio", "Garcia", "69696969X");
        nuevaTarjeta("Adri", "", "69696967X");
        nuevaTarjeta("Oscar", "", "69696969");

        pagar("69696969X", new GregorianCalendar(2015, 6, 24));
        pagar("69696967X", new GregorianCalendar(2015, 6, 24));
        pagar("69696969", new GregorianCalendar(2015, 6, 24));



        entrar(delibes, "69696967X");
        entrar(delibes, "69696969");

        salir(delibes, "69696969");

        reiniciar("69696967X");


        System.out.println(delibes.infoTarjetas());
    }
    
}
