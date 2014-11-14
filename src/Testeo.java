import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author segarci, osferna, adrcalv
 */
public class Testeo {


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

        System.out.println("Se ha creado la tarjeta con DNI " + dni );
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
    public static void reiniciar(String dni){

        getTarjeta(dni).reiniciar();

        System.out.println("La tarjeta con Dni: "
                        + dni
                        + " se ha reiniciado."
        );
    }


    /**
     *
     * @param dni
     * @param gregorianCalendar
     */
    public static void pagar(String dni, GregorianCalendar gregorianCalendar){
        getTarjeta(dni).pagar(gregorianCalendar);

        if (getTarjeta(dni).getFin_periodo().equals(gregorianCalendar)) {
           System.out.println("Su pago se ha realizado correctamente");
        } else {
            System.out.println("No se ha realizado el pago");
        }


    }


    /**
     *
     */
    public static void entrar(Aparcamiento aparcamiento, String dni){

        aparcamiento.entrar(listaTarjeta.get(posicion(dni)));

        if (!getTarjeta(dni).getFuera()){
            System.out.println("Ha entrado");
        } else {
            System.out.println("Ha salido");

        }
    }


    /**
     *
     */
    public static void salir(Aparcamiento aparcamiento, String dni){

        aparcamiento.salir(listaTarjeta.get(posicion(dni)));
        if (getTarjeta(dni).getFuera()){
            System.out.println("Ha entrado");
        } else {
            System.out.println("Ha salido");

        }

    }


    /**
     *
     */
    public static void infoTarjeta(Aparcamiento aparcamiento){

        ArrayList<String> infoList = aparcamiento.infoTarjetas(listaTarjeta);

        for (int i = 0 ; i < infoList.size() ; i++ ){
            System.out.println(infoList.get(i));
        }
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
        
        entrar(delibes, "69696969X");
        //salir(delibes, "69696969X");

        reiniciar("69696967X");

        entrar(delibes, "69696967X");


        infoTarjeta(delibes);

        salir(delibes, "69696967X");

        infoTarjeta(delibes);

    }
}
