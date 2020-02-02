import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Uva13257 {
	// License Plates
	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		int casos = Integer.parseInt(br.readLine());
		String [] separador;
		String palabra;
		String x;
		for(int i=0;i<casos;i++){
			palabra =br.readLine();
			separador = palabra.split("");
			PriorityQueue<String> verificador = new PriorityQueue<String>();
			for (int j = 0; j < separador.length; j++) {
				for (int j2 =j+1; j2 < separador.length; j2++) {
					for (int k = j2+1; k < separador.length; k++) {
						x=separador[j]+separador[j2]+separador[k];
						if(!verificador.contains(x)){
							verificador.add(x);
						}
					}
				}
			}
			System.out.println(verificador.size());
		
		}
	}
}
