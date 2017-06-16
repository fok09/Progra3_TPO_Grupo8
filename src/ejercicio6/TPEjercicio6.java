package ejercicio6;

import java.util.Arrays;

public class TPEjercicio6 {

	public static SolucionEjercicio6 Ejercicio6(int[] lista, int[] l1, int[] l2){
		int inst = 0;
		int[] nuevaLista;
		SolucionEjercicio6 sol = new SolucionEjercicio6(0, 0);
		SolucionEjercicio6 sol1 = new SolucionEjercicio6(0, 0);
		SolucionEjercicio6 sol2 = new SolucionEjercicio6(0, 0);
		SolucionEjercicio6 sol3 = new SolucionEjercicio6(0, 0);
		
		inst++;
		if (lista.length == 0){
			if (sumatoria(l1)==sumatoria(l2)){
				sol.setInstrucciones(inst);
				sol.setSolCorrectas(1);
			}
		}else{
			nuevaLista = Arrays.copyOfRange(lista, 1, lista.length);
			int[] added1 = new int[l1.length + 1];
			System.arraycopy(l1, 0, added1, 0, l1.length);
			System.arraycopy(lista, 0, added1, l1.length, 1);
			
			int[] added2 = new int[l2.length + 1];
			System.arraycopy(l2, 0, added2, 0, l2.length);
			System.arraycopy(lista, 0, added2, l2.length, 1);
			
			sol1 = Ejercicio6(nuevaLista, added1, l2);
			sol2 = Ejercicio6(nuevaLista, l1, added2);
			sol3 = Ejercicio6(nuevaLista, l1, l2);
			
			sol = new SolucionEjercicio6(sol1.getSolCorrectas() + sol2.getSolCorrectas() + sol3.getSolCorrectas(), 
					sol1.getInstrucciones()+sol2.getInstrucciones()+sol3.getInstrucciones());
			
		}
		
		
		return sol;
	}
	
	
	public static int sumatoria(int[] lista){
		int total = 0;
		for(int i=0; i<lista.length;i++){
			total = total + lista[i];
		}
		return total;
	}
	
}
