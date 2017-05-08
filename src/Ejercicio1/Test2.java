package Ejercicio1;

import java.util.Arrays;

public class Test2 {

	public Vector PuntosMasCercanos(Punto s[])
	{
		Vector V = null;
		Punto SI[];
		Punto SD[];
		Vector VecI,VecD,VecMin;
		int a,b;
		boolean y=true,x=true;
		
		if(s.length == 0 || s.length == 1)
		{
			return V;
		}
		else
		{
			if(s.length == 2)
			{
				V = new Vector(s[0],s[1]);
				return V;
			}
			else
			{
				SI = Arrays.copyOfRange(s, 0, (s.length/2)-1);
				SD = Arrays.copyOfRange(s, s.length/2, s.length-1);
				
				VecI = PuntosMasCercanos(SI);
				VecD = PuntosMasCercanos(SD);
				
				VecMin = VecI.distancia < VecD.distancia?VecI:VecD;
				
				a = SI.length-1;
				b = 1;
				
				while(y)
				{
					if(SI[a].ObtenerDistanciaDesde(SD[b]) < VecMin.distancia)
					{
						VecMin = new Vector(SI[a],SD[b]);
						b++;
					}
					else
						y = false;
				}
				
				while(x)
				{
					if(SI[a].ObtenerDistanciaDesde(SD[b]) < VecMin.distancia)
					{
						VecMin = new Vector(SI[a],SD[b]);
						a--;
					}
					else
						x = false;
				}
				
				V = VecMin;
			}
			
			return V;
		}
	}
	
	
}
