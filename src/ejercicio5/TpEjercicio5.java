package ejercicio5;

import java.util.Arrays;
import java.util.Comparator;

public class TpEjercicio5 
{
		public static SolucionEjercicio5 Ejercicio5(ElementoMochilaDyn[] e, int cap)
		{
			SolucionEjercicio5 Sol = new SolucionEjercicio5();
			
			ElementoMochilaDyn[] elem = e;//OrdenarElementos(e);
			
			
			int[][] M = new int[elem.length+1][cap+1];
			
			//No se realizan ya que un array de integer se inicialilza en 0 por default
			/*for(int c = 0 ; c < cap ; c++)
				M[0][c] = 0;
			
			for(int f = 0; f < elem.length ; f++)
				M[f][0] = 0;*/
			
			for (int f = 1 ; f < M.length ; f++)
				for (int c = 1 ; c <= cap ; c++)
				{
					Sol.instrucciones++;
					if(c - elem[f-1].getPeso() >= 0)
						M[f][c] = Math.max(elem[f-1].getGanacia()+M[f-1][c-elem[f-1].getPeso()], M[f-1][c]);
					else
						M[f][c] = M[f-1][c];
				}
			
			Sol.setMaxGanancia(M[elem.length][cap]);
			return Sol;
		}
		
//		private static ElementoMochilaDyn[] OrdenarElementos(ElementoMochilaDyn[] e) {
//			
//			Arrays.sort(e, new Comparator<ElementoMochilaDyn>() {
//				public int compare(ElementoMochilaDyn e1, ElementoMochilaDyn e2) {
//					return e1.getPeso() - e2.getPeso();
//				}
//			});
//			
//			return e;
//		}
}
