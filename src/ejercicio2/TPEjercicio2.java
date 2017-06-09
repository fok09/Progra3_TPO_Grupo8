package ejercicio2;

import java.util.Arrays;
import java.util.Comparator;

public class TPEjercicio2 {

	public static SolucionEjercicio2 Ejercicio2(Tarea[] tareas) {
		int cantTareas = 0;
		int inst = 0;
		Tarea anterior = null;
		
		tareas = OrdenarFin(tareas);

		if (tareas.length > 0) {

			for (int i = 0; i < tareas.length; i++) {
				inst++;
				
				if (i == 0) {
					anterior = tareas[i];
					cantTareas++;
				} else {
					if (anterior.getFin()<=tareas[i].getInicio()){
						anterior = tareas[i];
						cantTareas++;
					}
				}
			}

		}

		return new SolucionEjercicio2(cantTareas, inst);

	}

	public static Tarea[] ObtenerSecuencia() {
		Tarea[] t = new Tarea[10];
		t[0] = new Tarea(1, 4);
		t[1] = new Tarea(10, 8);
		t[2] = new Tarea(9, 1);
		t[3] = new Tarea(5, 5);
		t[4] = new Tarea(13, 9);
		t[5] = new Tarea(47, 64);
		t[6] = new Tarea(62, 14);
		t[7] = new Tarea(44, 50);
		t[8] = new Tarea(52, 25);
		t[9] = new Tarea(42, 15);

		return t;
	}

	public static Tarea[] OrdenarFin(Tarea[] t) {
		Arrays.sort(t, new Comparator<Tarea>() {
			public int compare(Tarea t1, Tarea t2) {
				// TODO Auto-generated method stub
				return t1.getFin() - t2.getFin();
			}
		});
		return t;
	}

}
