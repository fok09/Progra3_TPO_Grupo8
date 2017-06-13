package ejercicio4;

import static org.junit.Assert.*;

import org.junit.Test;

import ejercicio2.SolucionEjercicio2;
import ejercicio2.TPEjercicio2;
import ejercicio2.Tarea;

public class TestEjercicio4 {

	@Test
	public final void testEjercicio4() {

		SolucionEjercicio4 sol4 = TPEjercicio4.Ejercicio4(ObtenerSecuencia(), 20);

		assertEquals(37, sol4.getMaxGanancia());
	}

	public static ElementoMochila[] ObtenerSecuencia() {
		ElementoMochila[] t = new ElementoMochila[10];
		t[0] = new ElementoMochila(2, 3);
		t[1] = new ElementoMochila(7, 9);
		t[2] = new ElementoMochila(1, 2);
		t[3] = new ElementoMochila(5, 6);
		t[4] = new ElementoMochila(1, 6);
		t[5] = new ElementoMochila(4, 8);
		t[6] = new ElementoMochila(9, 11);
		t[7] = new ElementoMochila(6, 2);
		t[8] = new ElementoMochila(8, 8);
		t[9] = new ElementoMochila(13, 20);

		return t;
	}
}
