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
			
			if(tarjeta.getDni().equals(dni)){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<String> infoTarjetas(){		
	
		ArrayList<String> info = new ArrayList<String>();
		
		for (int i = 0; i < tarjetas.size(); i++) {
			
			info.add("DNI: " + tarjetas.get(i).getDni() 
					+ ", Nombre: " + tarjetas.get(i).getNombre() 
					+ ", Apellidos: " + tarjetas.get(i).getApellido()
			);
		}
		
		return info;
	}

}