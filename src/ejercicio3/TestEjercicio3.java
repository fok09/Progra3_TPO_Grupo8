package ejercicio3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEjercicio3 {

	@Test
	public final void testEjercicio3() {
		SolucionEjercicio3 Sol = TpEjercicio3.Ejercicio3(GenerarGrafo());
		
		assertEquals(19, Sol.getAristaSum());
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
