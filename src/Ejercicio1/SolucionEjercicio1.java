package Ejercicio1;

public class SolucionEjercicio1 {
Punto punto1;
Punto punto2;
int instrucciones;

public SolucionEjercicio1(Punto punto1, Punto punto2, int instrucciones) {
	super();
	this.punto1 = punto1;
	this.punto2 = punto2;
	this.instrucciones = instrucciones;
}

public Punto getPunto1() {
	return punto1;
}

public void setPunto1(Punto punto1) {
	this.punto1 = punto1;
}

public Punto getPunto2() {
	return punto2;
}

public void setPunto2(Punto punto2) {
	this.punto2 = punto2;
}

public int getInstrucciones() {
	return instrucciones;
}

public void setInstrucciones(int instrucciones) {
	this.instrucciones = instrucciones;
}



}
