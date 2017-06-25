package ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TPEjercicio1 {

	public static SolucionEjercicio1 Ejercicio1(Punto[] p) {
		
		SolucionEjercicio1 sol;
		
		if(p.length <= 3)
		{
			Vector v = FuerzaBruta(p);
			sol = new SolucionEjercicio1(v.getA(),v.getB(),1);
		}
		else
		{
			Punto SI[] = Arrays.copyOfRange(p, 0, (p.length / 2));
			Punto SD[] = Arrays.copyOfRange(p, p.length / 2, p.length);

			Double Xmd =  (((double)SI[SI.length-1].x+(double)SD[0].x)/2);

			SolucionEjercicio1 SolI = Ejercicio1(SI);
			SolucionEjercicio1 SolD = Ejercicio1(SD);
			
			sol = minVector(SolI, SolD);
			
			sol.instrucciones = SolI.instrucciones + SolD.instrucciones;
			
			ArrayList<Punto> lst = new ArrayList<Punto>();
			for(Punto pto : p)
				if(pto.getX() >= Xmd-sol.getVector() && pto.getX() <= Xmd+sol.getVector())
					lst.add(pto);
			Punto SM[] = new Punto[lst.size()];
			SM = OrdernarPuntosY(lst.toArray(SM));

			for (int i = 0 ; i<SM.length-1 ; i++)
				if(SM[i+1].getY()-SM[i].getY() < sol.getVector())
					sol = minVector(sol, new SolucionEjercicio1(SM[i],SM[i+1],0));			
		}
		
		return sol;
		
		
	}
	
	public static SolucionEjercicio1 minVector(SolucionEjercicio1 s1, SolucionEjercicio1 s2) 
	{
		return s1.getVector() < s2.getVector() ? s1 : s2;
	}

	public static Vector FuerzaBruta(Punto[] sp) {
		int infPos = (int) Double.POSITIVE_INFINITY;
		Vector V = new Vector(new Punto(infPos, infPos), new Punto(0, 0));
		Vector auxV;

		for (int i = 0; i < sp.length; i++)
			for (int j = i + 1; j < sp.length; j++) {
				auxV = new Vector(sp[i], sp[j]);
				if (auxV.distancia < V.distancia)
					V = auxV;
			}

		return V;
	}

	
	
	public static Punto[] OrdernarPuntosY(Punto[] p) 
	{
		Arrays.sort(p, new Comparator<Punto>() {
			public int compare(Punto p1, Punto p2) {
				return p1.getY()-p2.getY();
			}
		});
		return p;
	}

}
