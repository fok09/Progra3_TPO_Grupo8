package ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Algoritmo {

	public static void main(String[] args) {
		
		Punto[] p = ObtenerSecuencia();
		p = OrdernarPuntosX(p);

		Vector V = PuntosMasCercanos(p);

		
		System.out.println(V.toString());
		V = FuerzaBruta(p);

		System.out.println(V.toString());

		
	}

	public static Vector PuntosMasCercanos(Punto s[]) {
		
		Vector V;
		
		if(s.length <= 3)
			V = FuerzaBruta(s);
		else
		{
			Punto SI[] = Arrays.copyOfRange(s, 0, (s.length / 2));
			Punto SD[] = Arrays.copyOfRange(s, s.length / 2, s.length);

			Double Xmd =  (((double)SI[SI.length-1].x+(double)SD[0].x)/2);

			Vector VI = PuntosMasCercanos(SI);
			Vector VD = PuntosMasCercanos(SD);
			
			V = minVector(VI, VD);
			
			ArrayList<Punto> lst = new ArrayList<Punto>();
			for(Punto p : s)
				if(p.getX() >= Xmd-V.getDistancia() && p.getX() <= Xmd+V.getDistancia())
					lst.add(p);
			Punto SM[] = new Punto[lst.size()];
			SM = OrdernarPuntosY(lst.toArray(SM));

			for (int i = 0 ; i<SM.length-1 ; i++)
				if(SM[i+1].getY()-SM[i].getY() < V.getDistancia())
					V = minVector(V, new Vector(SM[i],SM[i+1]));			
		}
		return V;
	}

	public static Vector minVector(Vector v1, Vector v2) 
	{
		return v1.getDistancia() < v2.getDistancia() ? v1 : v2;
	}

	public static Punto[] ObtenerSecuencia() 
	{
		Punto[] p = new Punto[10];
		
		
		for(int i = 0 ; i<10 ; i++)
		{
			Double x = Math.random()*100;
			Double y = Math.random()*100;
			p[i] = new Punto(x.intValue(),y.intValue()); 
		}
		return p;
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

	public static Punto[] OrdernarPuntosX(Punto[] p) 
	{
		Arrays.sort(p, new Comparator<Punto>() {
			public int compare(Punto p1, Punto p2) {
				// TODO Auto-generated method stub
				return p1.getX()-p2.getX();
			}
		});
		return p;
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
