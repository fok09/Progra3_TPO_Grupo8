package ejercicio3;
import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> V;
	private ArrayList<Arista> A;
	
	public Grafo()
	{
		this.V = new ArrayList<Vertice>();
		this.A = new ArrayList<Arista>();
	}
	
	public Grafo(ArrayList<Vertice> v, ArrayList<Arista> a)
	{
		super();
		this.V = v;
		this.A = a;
	}
	
	public ArrayList<Vertice> getVertice()
	{
		return this.V;
	}
	
	public ArrayList<Arista> getAristas()
	{
		return this.A;
	}
}
 