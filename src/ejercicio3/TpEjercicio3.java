package ejercicio3;

import java.util.*;

public class TpEjercicio3 {
	
	public static SolucionEjercicio3 Ejercicio3(Grafo G)
	{
		SolucionEjercicio3 sol = new SolucionEjercicio3();
		
		Grafo Sp = new Grafo(G.getVertice(),new ArrayList<Arista>());
		Hashtable<String, Integer> Particiones = new Hashtable<String, Integer>();
		int P = 1;
		
		for (Vertice V : G.getVertice())
		{
			Particiones.put(V.getNombre(), P);
			P++;
		}
		ArrayList<Arista> Aristas = OrdenarAristas(G.getAristas());
		
		for(Arista A : Aristas)
			if(Particiones.get(A.getOrigen().getNombre()) != Particiones.get(A.getDestino().getNombre()))
			{
				Particiones = Unirparticiones(Particiones, A);
				Sp.getAristas().add(A);
				sol.aristaSum += A.getPeso();
				sol.instrucciones++;
			}
		
		return sol;
	}
	
	private static ArrayList<Arista> OrdenarAristas(ArrayList<Arista> aristas) {
		
		Collections.sort(aristas,new Comparator<Arista>()
		{
			public int compare(Arista a1, Arista a2) {             
			      return a1.getPeso()-a2.getPeso();           
			    }    
		});
		
		return aristas;
	}


	private static Hashtable<String, Integer> Unirparticiones(Hashtable<String,Integer> Particiones, Arista A)
	{
		int orig = Particiones.get(A.getOrigen().getNombre()); 
		int dest = Particiones.get(A.getDestino().getNombre());
		int max = orig > dest ? orig : dest ;
		int min = orig < dest ? orig : dest;
		
		if(orig != dest)
			for(String V : Particiones.keySet())
				if(Particiones.get(V) == max)
					Particiones.put(V, min);
		
		return Particiones;
		
	}

	
}
