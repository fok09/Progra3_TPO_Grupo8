package ejercicio1;

public class Vector {

	Punto a;
	Punto b;
	Double distancia;
	
	public Vector(Punto A,Punto B)
	{
		this.a = A;
		this.b = B;
		this.distancia = A.ObtenerDistanciaDesde(B);
	}
	
	public Punto getA()
	{
		return this.a;
	}
	
	public void setA(Punto A)
	{
		this.a = A;
	}
	
	public Punto getB()
	{
		return b;
	}
	
	public void setB(Punto B)
	{
		this.b = B;
	}
	
	public Double getDistancia()
	{
		return this.distancia;
	}
	
	public String toString()
	{
		return "A:"+getA().toString()+" - B:"+getB().toString()+" -> "+getDistancia();
	}
}
