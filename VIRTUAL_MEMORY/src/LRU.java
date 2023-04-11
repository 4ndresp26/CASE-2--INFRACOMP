import java.util.HashMap;
import java.util.Map;

public class LRU {
	
	private Map<String, Integer> registro = new HashMap<>();
	 
	public LRU() {
				
			}
	
	public Map<String, Integer> getRegistro() {
        return registro;
    }
	
	private void AgregarNuevoRegistro(String marcoPagina) {
		registro.put(marcoPagina, 128);
	}

	public void ActualizarRegistro(TP tablaPaginas, String marcoPagina) {

		 Map<String, String> tp = tablaPaginas.getTablaPaginas();
		 int nuevoNumero;
		 
		 for (Map.Entry<String, Integer> entry : registro.entrySet()) {
			 	nuevoNumero = registro.get(entry.getKey()) >> 1;
			    registro.replace(entry.getKey(), nuevoNumero);
			    System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
		 }
		 
		 if (!registro.containsKey(marcoPagina)) {
            if (getRegistro().size() == tablaPaginas.getEntradas()){
                aplicarAlgoritmo(tp, marcoPagina);
            } else {
                AgregarNuevoRegistro(marcoPagina);
                System.out.println("No existe  ----  clave=" + marcoPagina + ", valor=" + 128);
            }
			}
		 
		 else {
				    nuevoNumero = registro.get(marcoPagina) + 128;
				    registro.replace(marcoPagina, nuevoNumero);
				    System.out.println("Ya exitia ----   clave=" + marcoPagina + ", valor=" + nuevoNumero);
				    nuevoNumero = 0;
				}
	}
	
	public String aplicarAlgoritmo(Map<String, String> map, String referencia) {
		
		int menor = 255;
		String llaveMenor = "";
		
		for (Map.Entry<String, Integer> entry : registro.entrySet()) {
		    if(entry.getValue() <= menor ) {
		    	menor = entry.getValue();
		    	llaveMenor = entry.getKey();
		    	//System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
		    }
		}
		 System.out.println(llaveMenor);
		 registro.replace(llaveMenor, 128); 
		 return llaveMenor;

	}

}
