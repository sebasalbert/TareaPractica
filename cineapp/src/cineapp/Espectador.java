package cineapp;

public class Espectador {
	//nos interesa saber su nombre, edad y el dinero que tiene.
	private String nombre;
	private int edad;
	private float dinero;
	
	
	public Espectador(String nombre, float dinero, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = dinero;
	}


	@Override
	public String toString() {
		return "Espectador [nombre=" + nombre + ", edad=" + edad + ", dinero=" + dinero + "]";
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public float getDinero() {
		return dinero;
	}


	public void setDinero(float dinero) {
		this.dinero = dinero;
	}
}
