package Ejercicio1;

public class Vector {

	Punto a;
	Punto b;
	int distancia;
	
	public Vector(Punto A,Punto B,int Distancia)
	{
		this.a = A;
		this.b = B;
		this.distancia = Distancia;
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
}
