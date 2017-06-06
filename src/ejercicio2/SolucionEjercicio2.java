package ejercicio2;

import java.util.Arrays;
import java.util.Comparator;

import ejercicio1.Punto;
import ejercicio1.Vector;

public class SolucionEjercicio2 {
	int tareas;
	int instrucciones;

	public SolucionEjercicio2(int tareas, int instrucciones) {
		super();
		this.tareas = tareas;
		this.instrucciones = instrucciones;
	}

	public int getTareas() {
		return tareas;
	}

	public void setTareas(int tareas) {
		this.tareas = tareas;
	}

	public int getInstrucciones() {
		return instrucciones;
	}

	public void setInstrucciones(int instrucciones) {
		this.instrucciones = instrucciones;
	}

	public static SolucionEjercicio2 Ejercicio2(){
		SolucionEjercicio2 sol = new SolucionEjercicio2(0, 0);
		Tarea[] tareas = ObtenerSecuencia();
		tareas = OrdenarInicio(tareas);
		int dispo = 100;
		Tarea anterior = null;
		
		
		sol.setTareas(MaxTareas(dispo, tareas, anterior));



		return sol;

	}

	public static Tarea[] ObtenerSecuencia() {
		Tarea[] t = new Tarea[10];
		t[0] = new Tarea(1, 4);
		t[1] = new Tarea(10, 8);
		t[2] = new Tarea(9, 1);
		t[3] = new Tarea(5, 5);
		t[4] = new Tarea(13,9);
		t[5] = new Tarea(47,64);
		t[6] = new Tarea(62,14);
		t[7] = new Tarea(44,50);
		t[8] = new Tarea(52,25);
		t[9] = new Tarea(42,15);

		return t;
	}

	public static Tarea[] OrdenarInicio(Tarea[] t) {
		Arrays.sort(t, new Comparator<Tarea>() {
			public int compare(Tarea t1, Tarea t2) {
				// TODO Auto-generated method stub
				return t1.getFin()-t2.getFin();
			}
		});
		return t;
	}

	public static int MaxTareas(int dispo, Tarea[] t, Tarea anterior){
		int sol = 0;
		int sol1 = 0;
		int sol2 = 0;
		Tarea anteriorYes;
		Tarea[] tbis;

		if (t.length==0){
			if (dispo < 0){
				int infNeg = (int) Double.NEGATIVE_INFINITY;
				sol = infNeg;
			}
		}else{

			if(anterior == null || t[0].getInicio()>= anterior.getFin()){
				tbis = Arrays.copyOfRange(t, 1, t.length);
				anteriorYes = t[0];
				//Tomo la Tarea
				sol1 = 1 + MaxTareas(dispo -t[0].duracion(), tbis, anteriorYes);

				//No tomo la Tarea
				sol2 = MaxTareas(dispo, tbis, anterior);

				//Tomo el mayor
				if (sol1>sol2){
					sol = sol1;
				}else{
					sol = sol2;
				}
			}else{
				tbis = Arrays.copyOfRange(t, 1, t.length);
				sol = MaxTareas(dispo, tbis, anterior);
			}
		}

		return sol;
	}


}
