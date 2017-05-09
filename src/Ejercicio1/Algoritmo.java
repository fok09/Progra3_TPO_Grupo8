package Ejercicio1;

import java.util.Arrays;
import java.util.Comparator;

public class Algoritmo {

	public static void main(String[] args) {
		System.out.println("inicio");

		Punto[] p = ObtenerSecuencia();
		p = OrdernarPuntosX(p);
		Vector V = PuntosMasCercanos(p);

		System.out.println("PuntoA (" + V.getA().x + "," + V.getA().y
				+ ") - PuntoB (" + V.getB().x + "," + V.getB().y + ") - Dist "
				+ V.getDistancia());

		V = FuerzaBruta(p);

		System.out.println("PuntoA (" + V.getA().x + "," + V.getA().y
				+ ") - PuntoB (" + V.getB().x + "," + V.getB().y + ") - Dist "
				+ V.getDistancia());

		/*
		 * for(int i = 0 ; i<50 ; i++) { Double x = Math.random()*100; Double y
		 * = Math.random()*100;
		 * System.out.println("p["+i+"] = new Punto("+x.intValue
		 * ()+","+y.intValue()+");"); }
		 */
	}

	public static Vector PuntosMasCercanos(Punto s[]) {
		Vector V;
		Punto SI[];
		Punto SD[];
		Vector VecI, VecD, VecMin;
		int a, b;
		boolean y = true, x = true;

		if (s.length == 0 || s.length == 1) {
			// V = null;
			int infPos = (int) Double.POSITIVE_INFINITY;
			V = new Vector(new Punto(infPos, infPos), new Punto(0, 0));
		} else {
			if (s.length == 2) {
				V = new Vector(s[0], s[1]);
			} else {
				SI = Arrays.copyOfRange(s, 0, (s.length / 2));
				SD = Arrays.copyOfRange(s, s.length / 2, s.length);

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

	public static Vector minVector(Vector v1, Vector v2) {
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

	public static Punto[] ObtenerSecuencia() {
		Punto[] p = new Punto[4];

		p[0] = new Punto(1, 4);
		p[1] = new Punto(10, 8);
		p[2] = new Punto(9, 1);
		p[3] = new Punto(5, 5);

		// p[0] = new Punto(90,28);
		// p[1] = new Punto(26,95);
		// p[2] = new Punto(27,32);
		// p[3] = new Punto(93,71);
		// p[4] = new Punto(66,13);
		// p[5] = new Punto(47,64);
		// p[6] = new Punto(62,14);
		// p[7] = new Punto(44,50);
		// p[8] = new Punto(52,25);
		// p[9] = new Punto(42,15);
		// p[10] = new Punto(91,13);
		// p[11] = new Punto(77,78);
		// p[12] = new Punto(87,81);
		// p[13] = new Punto(96,83);
		// p[14] = new Punto(13,72);
		// p[15] = new Punto(79,71);
		// p[16] = new Punto(94,87);
		// p[17] = new Punto(21,82);
		// p[18] = new Punto(67,41);
		// p[19] = new Punto(54,46);
		// p[20] = new Punto(26,91);
		// p[21] = new Punto(57,51);
		// p[22] = new Punto(40,8);
		// p[23] = new Punto(49,87);
		// p[24] = new Punto(43,95);
		// p[25] = new Punto(32,42);
		// p[26] = new Punto(13,16);
		// p[27] = new Punto(79,41);
		// p[28] = new Punto(18,38);
		// p[29] = new Punto(20,65);
		// p[30] = new Punto(17,63);
		// p[31] = new Punto(49,2);
		// p[32] = new Punto(31,82);
		// p[33] = new Punto(86,85);
		// p[34] = new Punto(25,86);
		// p[35] = new Punto(8,73);
		// p[36] = new Punto(1,95);
		// p[37] = new Punto(98,46);
		// p[38] = new Punto(71,48);
		// p[39] = new Punto(2,16);
		// p[40] = new Punto(45,94);
		// p[41] = new Punto(26,90);
		// p[42] = new Punto(84,1);
		// p[43] = new Punto(85,30);
		// p[44] = new Punto(88,85);
		// p[45] = new Punto(85,52);
		// p[46] = new Punto(84,87);
		// p[47] = new Punto(34,10);
		// p[48] = new Punto(63,35);
		// p[49] = new Punto(87,84);

		return p;
	}

	public static Vector FuerzaBruta(Punto[] sp) {
		int infPos = (int) Double.POSITIVE_INFINITY;
		Vector V = new Vector(new Punto(infPos, infPos), new Punto(0, 0));
		Vector auxV;

		for (int i = 0; i < sp.length; i++)
			for (int j = i + 1; j < sp.length; j++) {
				auxV = new Vector(sp[i], sp[j]);
				if (auxV.distancia < V.distancia)
					V = auxV;
			}

		return V;
	}

	public static Punto[] OrdernarPuntosX(Punto[] p) {
		Arrays.sort(p, new Comparator<Punto>() {
			public int compare(Punto p1, Punto p2) {
				// TODO Auto-generated method stub
				return p1.getX()-p2.getX();
			}
		});
		return p;
		}
	
	

}
