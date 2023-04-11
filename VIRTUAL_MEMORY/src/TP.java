import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class TP {

	private Map<String, String> tablaPaginas = new HashMap<String, String>();

	private Integer Entradas;

	private LRU aa;

	private Integer fallos = 0;

	private Integer cupos = 0;

	public TP(Map<String, String> tabla, int tamaño, LRU aaa) {

		this.tablaPaginas = tabla;
		this.Entradas = tamaño;
		this.aa = aaa;
	}

	public Integer getEntradas(){
		return Entradas;
	}

	public Map<String, String> getTablaPaginas() {
		return tablaPaginas;
	}


	public void consultarReferencia(String referencia) {

		// caso en que no ente en la tp
		if (tablaPaginas.containsValue(referencia)) {

		} else {
			fallos = fallos + 1;
		}
		if (tablaPaginas.size() < Entradas) { /** Meter referencia si la TP no está llena */
			tablaPaginas.put(cupos.toString(), referencia);
			cupos++;
			System.out.println("Agrego"+tablaPaginas+referencia+"fallo numero:" + fallos);
		} else {
			/** Eliminar la referencía antigua y sustituirla si esta llena la TP */
			String referenciaAntigua = aa.aplicarAlgoritmo(tablaPaginas, referencia);
			tablaPaginas.replace(referenciaAntigua, referencia);
			System.out.println("CAmbio"+tablaPaginas+referencia+"fallo numero:" + fallos);
		}
	}

}
