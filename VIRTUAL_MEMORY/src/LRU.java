
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LRU {
	
	private Queue registro = new Queue();
	 
	public LRU() {
				
			}
	
	public Queue getRegistro() {
        return registro;
    }
	
	private void AgregarNuevoRegistro(String marcoPagina) {
		registro.add(marcoPagina);
	}

	public void ActualizarRegistro(TP tablaPaginas, String marcoPagina) {

		 Map<String, String> tp = tablaPaginas.getTablaPaginas();
		 int nuevoNumero;
		 
		 for (Map.Entry<String, Integer> entry : registro.entrySet()) {
			 	nuevoNumero = registro.get(entry.getKey()) >> 1;
			    registro.replace(entry.getKey(), nuevoNumero);
			    //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
		 }
		 
		 if (!registro.containsKey(marcoPagina)) {
			 AgregarNuevoRegistro(marcoPagina);
			 //System.out.println("clave=" + marcoPagina + ", valor=" + );
			}
		 
		 else {
				    nuevoNumero = registro.get(marcoPagina) + 0;
				    registro.replace(marcoPagina, nuevoNumero);
				    //System.out.println("clave=" + marcoPagina + ", valor=" + nuevoNumero);
				    nuevoNumero = 0;
				}
	}
	
	public String aplicarAlgoritmo(Map<String, String> tablaPaginas, String referencia) {
		
		int menor = 0;
		String llaveMenor = "";
		
		for (Map.Entry<String, Integer> entry : registro.entrySet()) {
		    if(entry.getValue() <= menor ) {
		    	menor = entry.getValue();
		    	llaveMenor = entry.getKey();
		    	//System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
		    }
		}
		 //System.out.println(llaveMenor);
		 registro.replace(llaveMenor, 128); 
		 return llaveMenor;

	}

}