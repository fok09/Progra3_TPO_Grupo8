package ejercicio3;

public class Arista {
Vertice origen;
Vertice destino;
int peso;


public Arista(Vertice origen, Vertice destino, int peso) {
	super();
	this.origen = origen;
	this.destino = destino;
	this.peso = peso;
}

public Vertice getOrigen() {
	return origen;
}
public void setOrigen(Vertice origen) {
	this.origen = origen;
}
public Vertice getDestino() {
	return destino;
}
public void setDestino(Vertice destino) {
	this.destino = destino;
}
public int getPeso() {
	return peso;
}
public void setPeso(int peso) {
	this.peso = peso;
}



}
