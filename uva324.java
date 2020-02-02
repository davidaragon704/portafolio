import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =-1;
		while((n =sc.nextInt())!=0) {
			BigInteger result = new BigInteger("1");
			for(int i=1;i<=n;i++)
				result =result.multiply(BigInteger.valueOf(i));
			ArrayList<BigInteger> vector = new ArrayList<BigInteger>();
			ArrayList<BigInteger> verificador = new ArrayList<BigInteger>();
			for(BigInteger p = BigInteger.valueOf(2);(p.multiply(p)).compareTo(result)==-1 || ((p.multiply(p)).compareTo(result)==0);p=p.add(BigInteger.ONE)) {
				while(result.mod(p).equals(BigInteger.ZERO)) {
					if(!verificador.contains(p)) {
						verificador.add(p);
					}
					vector.add(p);
					result = result.divide(p);
				}
			}
			if(!result.equals(BigInteger.ONE)) {
				vector.add(result);
				if(!verificador.contains(result)) {
					verificador.add(result);
				}
			}
			int contador=0;
			String primos ="";
			StringBuilder resultado = new StringBuilder();
			for(int j=0;j<verificador.size();j++) {
				int primo=0;
				while(contador<vector.size()) {
					if(verificador.get(j).equals(vector.get(contador))) {
						primo++;
						contador++;
					}else {
						break;
					}
				}
				if(j%15==0 && j!=0) {
					resultado.append("\n"+String.format("%9d",primo));
				}else {
					resultado.append(String.format("%3d",primo));
				}
			}

			System.out.printf("%3d! =%s\n",n,resultado);
		}
	}

}