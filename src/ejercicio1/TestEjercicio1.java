package ejercicio1;



import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;


public  class TestEjercicio1 {

	@Test
	public final void testEjercicio1() {
		SolucionEjercicio1 Sol = TPEjercicio1.Ejercicio1(OrdernarPuntosX(ObtenerSecuencia()));
		Double r = 1.00;
		assertEquals(r, Sol.getVector());
	}
	
	public static Punto[] ObtenerSecuencia() 
	{
		Punto[] e = new Punto[5];
		e[0] = new Punto(1, 1);
		e[1] = new Punto(1, 8);
		e[2] = new Punto(5, 3);
		e[3] = new Punto(8, 3);
		e[4] = new Punto(2, 1);
		
		return e;
	}
	
	public static Punto[] OrdernarPuntosX(Punto[] p) 
	{
		Arrays.sort(p, new Comparator<Punto>() {
			public int compare(Punto p1, Punto p2) {
				return p1.getX()-p2.getX();
			}
		});
		return p;
	}

}
