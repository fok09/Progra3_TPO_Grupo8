package ejercicio2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEjercicio2 {

	@Test
	public final void testEjercicio2() {
		
		SolucionEjercicio2 sol2 = TPEjercicio2.Ejercicio2(ObtenerSecuencia());
		
		assertEquals(8, sol2.getTareas());
	}
	
	public static Tarea[] ObtenerSecuencia() {
		Tarea[] t = new Tarea[16];
		t[0] = new Tarea(0, 3);
		t[1] = new Tarea(4, 10);
		t[2] = new Tarea(15, 20);
		t[3] = new Tarea(5, 6);
		t[4] = new Tarea(1, 2);
		t[5] = new Tarea(24, 25);
		t[6] = new Tarea(14, 19);
		t[7] = new Tarea(11, 27);
		t[8] = new Tarea(23, 28);
		t[9] = new Tarea(7, 15);
		t[10] = new Tarea(39, 50);
		t[11] = new Tarea(33, 37);
		t[12] = new Tarea(10, 15);
		t[13] = new Tarea(28, 35);
		t[14] = new Tarea(44, 48);
		t[15] = new Tarea(49, 51);
		return t;
	}

}
