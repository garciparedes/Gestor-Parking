import java.util.ArrayList;

/**
 * @author segarci, osferna, adrcalv
 */
public class Aparcamiento {
	
	private ArrayList<Tarjeta> tarjetas;
	
	/**
	 * 
	 */
	public boolean isDentro(String dni){
		
		Tarjeta tarjeta;
		
		for (int i = 0; i < tarjetas.size(); i++) {
			
			tarjeta = tarjetas.get(i);
			
			if(tarjeta.getDni().equals(dni) && !tarjeta.getFuera()){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Tarjeta> isDentro(ArrayList<Tarjeta> tarjetas){
			
		
		
		return null;
	}
}