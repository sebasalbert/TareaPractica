package cineapp;

import java.util.Random;

public class Cine {
	
	private Pelicula pelicula;
	private float precio;
	private int espectadores;
	private Espectador tespectadores [][];
	
	
	public Cine( int filas, int columnas, Pelicula pelicula, float precio) {
		super();
		this.pelicula = pelicula;
		this.precio = precio;
		tespectadores = new Espectador [filas][columnas];
	}
	
	public String venderAsiento(Espectador esp) {
		
		if ( precio > esp.getDinero()) {
			return esp.getNombre() + "No tiene dinero suficiente";
		}
		
		if ( esp.getEdad() < pelicula.getEdadMinima()) {
			return esp.getNombre() + "No tiene la edad minima";
		}
		
		if ( espectadores == ( tespectadores.length * tespectadores[0].length)) {
			return "la sala esta llena";		}
		
		
		
		Random rd = new Random();
		
		int fila = rd.nextInt(0, tespectadores.length);
		int columnas = rd.nextInt(0, tespectadores[0].length);
		
		while ( tespectadores[fila][columnas] != null) {
			 fila = rd.nextInt(0, tespectadores.length);
			 columnas = rd.nextInt(0, tespectadores[0].length);
		}
		
		tespectadores[fila][columnas] = esp;
		espectadores ++;
		
		String resu = "Fila " + (fila + 1) + "Asiento" + (char) ('A' + columnas);
		
		return resu;
	}
	
	public void informeSala() {
		
		int totalPlazas = tespectadores.length * tespectadores[0].length;
        float ocupacion = (float) espectadores / totalPlazas * 100;
        System.out.println("Película: " + pelicula.getTitulo());
        System.out.println("N.º de espectadores: " + espectadores);
        System.out.println("N.º de plazas: " + totalPlazas);
        System.out.println("Ocupación: " + ocupacion + "%");
        System.out.println("Recaudación: " + (espectadores * precio) + " Euros");
		
	}
	
	public void listadoAsientos() {
		
		System.out.println("Listado de asientos ocupados y libres:");
	    
		System.out.print("  ");
	    for (int j = 0; j < tespectadores[0].length; j++) {
	        System.out.print((char) ('A' + j) + " ");  
	    }
	    System.out.println(); 

	   for (int i = tespectadores.length - 1; i >= 0; i--) {
	        System.out.print((i + 1) + " "); 
	        
	        for (int j = 0; j < tespectadores[0].length; j++) {
	            if (tespectadores[i][j] != null) {
	                System.out.print("X ");  
	            } else {
	                System.out.print(" ");  
	            }
	        }
	        System.out.println();  
	    }
	}
	
	public void listadoEspectadores() {
		
		System.out.println("Lista de espectadores");
		System.out.println("-------------------------");
		System.out.println("Nombre             Asiento");
		
		for (int i = 0; i < tespectadores.length; i++) {
            for (int j = 0; j < tespectadores[0].length; j++) {
                if (tespectadores[i][j] != null) {
                    char columnaLetra = (char) ('A' + j);
                    System.out.println(tespectadores[i][j].getNombre() + "     " + (tespectadores.length - i) + "" + columnaLetra);
                }
            }
        }
    }
		
 }

