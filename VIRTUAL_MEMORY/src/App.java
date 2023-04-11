import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.*;


public class App {
    public static void main(String[] args) throws Exception {

		System.out.println("Iniciando el Programa...");

        Map<String, String> tp = new HashMap<>();
        LRU alg = new LRU();
        TP tablaPaginas = new TP(tp, 4, alg);        

        alg.ActualizarRegistro(tablaPaginas, "A");
        alg.ActualizarRegistro(tablaPaginas, "B");
        alg.ActualizarRegistro(tablaPaginas, "C");
        alg.ActualizarRegistro(tablaPaginas, "D");
        alg.ActualizarRegistro(tablaPaginas, "A");
        alg.ActualizarRegistro(tablaPaginas, "F");
        		
        Scanner entrada = new Scanner(System.in);
		
		System.out.println("Indique el nombre del archivo de lectura: ");
		String archivo = entrada.next();
		
		System.out.println("Indique el nombre del archivo de escritura: ");
		String archivoSalida = entrada.next();
		
		entrada.close();

		FileReader fr = new FileReader ("VIRTUAL_MEMORY/data/"+archivo);
		BufferedReader br = new BufferedReader(fr);
		int TP =  Integer.parseInt(br.readLine());
		int NF =  Integer.parseInt(br.readLine());
		int NC =  Integer.parseInt(br.readLine());
		int TE =  Integer.parseInt(br.readLine());
		int MP =  Integer.parseInt(br.readLine());
		
		System.out.println(TP);
		System.out.println(NF);
		System.out.println(NC);
		System.out.println(TE);
		System.out.println(MP);
		
		int numeroPaginas = (NF*NC*TE*3)/TP;
		int exedente = (NF*NC*TE*3)%TP;
		
		FileWriter fichero = new FileWriter("VIRTUAL_MEMORY/data/"+archivoSalida);
		PrintWriter pw = new PrintWriter(fichero);
		
		pw.println("TP = " + TP);
		pw.println("NF = " + NF);
		pw.println("NC = " + NC);
		pw.println("NR = " + NF*NC*3);
	
	    if (exedente != 0) {
	    	numeroPaginas+=1;
	    }
	    
		String [][] paginas = new String[numeroPaginas][TP];
		
		

		for (int matriz = 1; matriz < 4; matriz++){
			for (int i =0; i < NF; i++) {
				for (int j =0; j < NC; j++) {
					int k = 0;
					boolean encontro = true;
					while (k<numeroPaginas && encontro) {
						int l = 0;
						while(l< TP && encontro){
							int n = 0;
							int contador = 0;
							while(n<TE && n+l< TP) {
								if(paginas[k][l+n] == null) {
									contador++;}
								n++;
							}
							
							if (contador == TE) {
								
								String referencia = "";
							    if (matriz == 1){
								    referencia = "[A-"+i+"-"+j+"],"+k+","+l;
								    }
							    if (matriz == 2){
								    referencia = "[B-"+i+"-"+j+"],"+k+","+l;
								    }  
							    if (matriz == 3){
								    referencia = "[C-"+i+"-"+j+"],"+k+","+l;
							    	} 
							    n = 0;
							    while(n<TE) {
								    paginas[k][l+n] = referencia;
								    n++;
								    }
							    pw.println(referencia);
							    encontro = false;
							}
							l++;
						}
						k++;
					}
				}
			}
			

		}
		
		
		
	
		fichero.close();
	
    }

    
}
