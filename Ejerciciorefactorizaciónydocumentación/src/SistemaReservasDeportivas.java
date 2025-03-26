
import java.util.ArrayList;

import java.util.List;

import entidades.Reserva;

/**
 * Clase que representa el sistema de reservas para pistas deportivas.
 * Gestiona las reservas, la iluminación de las pistas y la disponibilidad de las mismas.
 */

public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas
    
    /**
     * Constructor del sistema de reservas deportivas.
     * Inicializa las reservas y el estado de iluminación de las pistas.
     */

    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }
    
    /**
     * Reserva una pista deportiva en una fecha y duración específica.
     * 
     * @param idPista El ID de la pista que se desea reservar.
     * @param fecha La fecha en la que se desea realizar la reserva.
     * @param duracion La duración de la reserva en minutos.
     * @return true si la reserva fue exitosa, false si la pista ya está reservada
     *         en esa fecha o si el ID de la pista es inválido.
     */

    public boolean reservarPista(int idPista, String fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(new Reserva(idPista, fecha, duracion));
        return true;
    }
    
    /**
     * Cancela una reserva existente.
     * 
     * @param idReserva El ID de la reserva a cancelar.
     * @return true si la reserva fue cancelada exitosamente, false si no se encontró
     *         la reserva con el ID especificado.
     */

    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }
    
    /**
     * Activa la iluminación de una pista deportiva.
     * 
     * @param idPista El ID de la pista a la que se le desea activar la iluminación.
     * @return true si la iluminación fue activada exitosamente, false si el ID de
     *         la pista es inválido.
     */

    public boolean activarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }
    
    /**
     * Desactiva la iluminación de una pista deportiva.
     * 
     * @param idPista El ID de la pista a la que se le desea desactivar la
     *                iluminación.
     * @return true si la iluminación fue desactivada exitosamente, false si el ID
     *         de la pista es inválido.
     */

    public boolean desactivarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
    
    /**
     * Verifica si una pista deportiva está disponible en una fecha y hora
     * específica.
     * 
     * @param idPista El ID de la pista que se desea verificar.
     * @param fecha La fecha en la que se desea verificar la disponibilidad.
     * @param hora La hora en la que se desea verificar la disponibilidad.
     * @return true si la pista está disponible en esa fecha y hora, false si la
     *         pista ya está reservada.
     */

    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }
}