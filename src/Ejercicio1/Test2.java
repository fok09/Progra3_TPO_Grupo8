package Ejercicio1;

import java.util.Arrays;

public class Test2 {

	public Vector PuntosMasCercanos(Punto s[]) {
		Vector V;
		Punto SI[];
		Punto SD[];
		Vector VecI, VecD, VecMin;
		int a, b;
		boolean y = true, x = true;

		if (s.length == 0 || s.length == 1) {
			V = null;
		} else {
			if (s.length == 2) {
				V = new Vector(s[0], s[1]);
			} else {
				SI = Arrays.copyOfRange(s, 0, (s.length / 2) - 1);
				SD = Arrays.copyOfRange(s, s.length / 2, s.length - 1);

				VecI = PuntosMasCercanos(SI);
				VecD = PuntosMasCercanos(SD);

				VecMin = minVector(VecI, VecD);

				a = SI.length - 1;
				b = 0;

				while (y) {
					if (SI[a].ObtenerDistanciaDesde(SD[b]) < VecMin.distancia) {
						VecMin = new Vector(SI[a], SD[b]);
						b++;
					} else
						y = false;
				}

				b = 0;
				while (x) {
					if (SI[a].ObtenerDistanciaDesde(SD[b]) < VecMin.distancia) {
						VecMin = new Vector(SI[a], SD[b]);
						a--;
					} else
						x = false;
				}

				V = VecMin;
			}
		}
		return V;
	}

	public Vector minVector(Vector v1, Vector v2) {
		Vector V;

		if (v1 == null) {
			V = v2;
		} else if (v2 == null) {
			V = v1;
		} else if (v1.getDistancia() < v2.getDistancia()) {
			V = v1;
		} else {
			V = v2;
		}

		return V;

	}

}
