import java.util.GregorianCalendar;

/**
 * @author segarci, osferna, adrcalv
 */
public class Main {
    /**
     *
     * @param Args
     */
    public static void main (String[] Args){
    	
    	Aparcamiento delibes = Aparcamiento.nuevaInstancia();
    	
    	delibes.nuevaTarjeta("Sergio", "Garcia", "69696969X");

        delibes.pagar("69696969X", new GregorianCalendar(2015, 6, 24));

        delibes.entrar("69696969X");

        delibes.nuevaTarjeta("Adri", "", "69696967X");

        delibes.pagar("69696967X", new GregorianCalendar(2015, 6, 24));

        delibes.entrar("69696967X");

        delibes.nuevaTarjeta("Oscar", "", "69696969");

        delibes.pagar("69696969", new GregorianCalendar(2015, 6, 24));

        delibes.entrar("69696969");

        System.out.println(delibes.infoTarjetas());
    }
}
