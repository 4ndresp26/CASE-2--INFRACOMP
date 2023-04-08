import java.util.LinkedList;
import java.util.Queue;

public class LRU{
	
    private Queue<String> registro = new LinkedList<String>();
    private int tamaño;

    public LRU(int tamaño) {
        this.tamaño = tamaño;
    }

    public Queue getRegistro() {
        return registro;
    }

    private void AgregarNuevoRegistro(String marcoPagina) {
        registro.add(marcoPagina);
    }

    private void EliminarRegistro() {
        registro.remove();
    }

    public void ActualizarRegistro( String marcoPagina) {
        if (registro.size() < tamaño) {
            registro.add(marcoPagina);
        } else {
            if (!registro.contains(marcoPagina)) {
                EliminarRegistro();
                AgregarNuevoRegistro(marcoPagina);
                //System.out.println("clave=" + marcoPagina + ", valor=" + );
            }
            else {
                registro.remove(marcoPagina);
                registro.add(marcoPagina);              
            }
        }
        
    }
}