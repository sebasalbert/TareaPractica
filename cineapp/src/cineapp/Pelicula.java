package cineapp;

public class Pelicula {
	
	private String titulo;
	private int duracion;
	private int edadMinima;
	private Genero genero;
	

	public Pelicula(String titulo, int duracion, int edadMinima, Genero genero) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
		this.genero = genero;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public int getEdadMinima() {
		return edadMinima;
	}


	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	@Override
    public String toString() {
        return titulo + " (" + genero + ", " + duracion + " min)";
    }
	
	
}
