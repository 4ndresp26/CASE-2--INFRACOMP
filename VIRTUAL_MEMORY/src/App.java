import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

		System.out.println("Iniciando el Programa...");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese la ruta del archivo con las referencias:   ");
		String nombreArchivo = scanner.nextLine();

		File doc = new File(nombreArchivo);
		Scanner obj;

        LRU tlb = new LRU(4);
        

        ///Prueba de la TLB
        String[] x = {"1", "2", "3", "4", "1", "2", "5", "1", "2", "3", "5", "5"};

        for (int i = 0; i < x.length; i++) {
            tlb.ActualizarRegistro(x[i]);
        }

        System.out.println(tlb.getRegistro());
        ///Fin de la prueba de la TLB
    }
}
