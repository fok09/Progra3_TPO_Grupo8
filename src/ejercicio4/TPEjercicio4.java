package ejercicio4;

import java.util.Arrays;

public class TPEjercicio4 {

	public static SolucionEjercicio4 Ejercicio4(ElementoMochila[] elem, int c){
		SolucionEjercicio4 sol1;
		SolucionEjercicio4 sol2;
		SolucionEjercicio4 sol = new SolucionEjercicio4(0,0);
		ElementoMochila[]elemNuevo;
		int inst = 0;
		
		inst++;
		
		if (elem.length==0){
			if (c<0){
				sol.setInstrucciones(inst);
				sol.setMaxGanancia((int) Double.NEGATIVE_INFINITY);
			}
		}else{
			elemNuevo = Arrays.copyOfRange(elem, 1, elem.length);
			
			sol1 = Ejercicio4(elemNuevo, c-elem[0].getPeso());
			sol1.setMaxGanancia(sol1.getMaxGanancia()+ elem[0].getGanancia());
			
			sol2 = Ejercicio4(elemNuevo, c);
			
			sol.setMaxGanancia(MaxGanancia(sol1,sol2));
			sol.setInstrucciones(sol1.getInstrucciones() + sol2.getInstrucciones() + inst);
			
		}
		
		
		return sol;
	
	}

	private static int MaxGanancia(SolucionEjercicio4 sol1, SolucionEjercicio4 sol2) {
		int sol;
		if (sol1.getMaxGanancia() > sol2.getMaxGanancia()){
			sol = sol1.getMaxGanancia();
		}else{
			sol = sol2.getMaxGanancia();
		}
		return sol;
	}
	
	
	
}
