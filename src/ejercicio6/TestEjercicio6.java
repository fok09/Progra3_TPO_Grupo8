package ejercicio6;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEjercicio6 {

	@Test
	public final void testEjercicio6() {
		int[] l1 = new int[0];
		int[] l2 = new int[0];
		SolucionEjercicio6 sol6 = TPEjercicio6.Ejercicio6(ObtenerSecuencia(), l1, l2);

		assertEquals(39, sol6.getSolCorrectas());
	}

	public static int[] ObtenerSecuencia() {
		int[] t = new int[8];
		t[0] = 1;
		t[1] = 4;
		t[2] = 8;
		t[3] = 5;
		t[4] = 3;
		t[5] = 11;
		t[6] = 55;
		t[7] = 20;
	
		return t;
	}
	
}
