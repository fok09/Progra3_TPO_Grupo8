package ejercicio3;

import java.util.*;

public class Main {

	public static void main(String[] args)
	{
		Grafo G = GenerarGrafo();
		
		SolucionEjercicio3 S = Ejercicio3(G);
		
		System.out.println(String.format("Acumulado: %d - instrucciones: %d",S.aristaSum,S.instrucciones));
	}
	
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

	private static Grafo GenerarGrafo()
	{
		Grafo G = new Grafo();
		
		G.getVertice().add(new Vertice("A"));
		G.getVertice().add(new Vertice("B"));
		G.getVertice().add(new Vertice("C"));
		G.getVertice().add(new Vertice("D"));
		
		G.getAristas().add(new Arista(new Vertice("A"),new Vertice("B"),10));
		G.getAristas().add(new Arista(new Vertice("A"),new Vertice("D"),5));
		G.getAristas().add(new Arista(new Vertice("A"),new Vertice("C"),6));
		G.getAristas().add(new Arista(new Vertice("B"),new Vertice("D"),15));
		G.getAristas().add(new Arista(new Vertice("D"),new Vertice("C"),4));
		
		return G;
	}
}
