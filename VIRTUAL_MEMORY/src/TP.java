import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class TP {

	private Map<String, String> tablaPaginas = new HashMap<String, String>();

	private Long time_carga = (long) 0;

	private Long time_direcc = (long) 0;

    private Integer fallos = 0;

	private Integer cupos = 0;

	private Integer Entradas;

	private LRU aa;

	public TP(Map<String, String> tabla, int tamaño, LRU aaa) {

		this.tablaPaginas = tabla;
		this.Entradas = tamaño;
		this.aa = aaa;
	}

	public Map<String, String> getTablaPaginas() {
		return tablaPaginas;
	}

	public Long get_carga(){
		return time_carga;
	}

	public Long get_direc(){
		return time_direcc;
	}

	public void consultarReferencia(String referencia) {

		// casos si esta o no en la TP
		if (tablaPaginas.containsValue(referencia)) {
			time_direcc+=0;
			time_carga+=0;
		} else {
			time_direcc+=0;
			time_carga+=0;
			fallos = fallos + 1;
            if (tablaPaginas.size() < Entradas) { 
                //Meter referencia si la TP no está llena */
                tablaPaginas.put(cupos.toString(), referencia);
                cupos++;
                System.out.println("Agrego"+tablaPaginas+referencia+"fallo numero:" + fallos);
            } else {
                // Eliminar la referencía antigua y sustituirla por la nueva
                String referenciaAntigua = aa.aplicarAlgoritmo(tablaPaginas, referencia);
                tablaPaginas.replace(referenciaAntigua, referencia);
                System.out.println("CAmbio"+tablaPaginas+referencia+"fallo numero:" + fallos);
            }
		}
		
	}

}
