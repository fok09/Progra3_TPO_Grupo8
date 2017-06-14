package ejercicio5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEjercicio5 {

	@Test
	public final void testEjercicio5() {
		SolucionEjercicio5 Sol = TpEjercicio5.Ejercicio5(ObtenerSecuencia(), 4);
		
		assertEquals(5, Sol.getMaxGanancia());
		assertEquals(12, Sol.getInstrucciones());
	}
	
	public static ElementoMochilaDyn[] ObtenerSecuencia() 
	{
		ElementoMochilaDyn[] e = new ElementoMochilaDyn[3];
		e[0] = new ElementoMochilaDyn(1, 2);
		e[1] = new ElementoMochilaDyn(2, 2);
		e[2] = new ElementoMochilaDyn(2, 3);
		
		return e;
	}

}
