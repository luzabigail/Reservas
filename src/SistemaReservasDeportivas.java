import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Sistema de reservas para pistas deportivas.
 * Permite realizar reservas, cancelarlas y gestionar la iluminación de las pistas.
 */
public class SistemaReservasDeportivas {

    private List<Reservas> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    /**
     * Constructor que inicializa la lista de reservas y el estado de iluminación de las pistas.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * Intenta reservar una pista en una fecha determinada.
     * 
     * @param idPista  ID de la pista a reservar.
     * @param fecha de la reserva.
     * @param duracion de la reserva en horas.
     * @return true si la reserva se realizó con éxito, false si la pista ya estaba reservada o el ID es inválido.
     */
    public boolean reservarPista(int idPista, LocalDateTime fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reservas r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(new Reservas(idPista, fecha, duracion));
        return true;
    }

    /**
     * Cancela una reserva existente.
     * 
     * @param idReserva ID de la reserva a cancelar.
     * @return true si la reserva fue cancelada con éxito, false si no se encontró la reserva.
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
     * Activa la iluminación de una pista.
     * 
     * @param idPista de la pista.
     * @return true si la iluminación fue activada con éxito, false si el ID de pista es inválido.
     */
    public boolean activarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Desactiva la iluminación de una pista.
     * 
     * @param idPista de la pista.
     * @return true si la iluminación fue desactivada con éxito, false si el ID de pista es inválido.
     */
    public boolean desactivarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }

    /**
     * Verifica la disponibilidad de una pista en una fecha y hora determinada.
     * 
     * @param idPista de la pista.
     * @param fecha a verificar.
     * @param hora a verificar.
     * @return true si la pista está disponible, false si ya está reservada.
     */
    public boolean verificarDisponibilidad(int idPista, LocalDateTime fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reservas r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }
}