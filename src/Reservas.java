import java.time.LocalDateTime;

public class Reservas {
    private int idPista;
    private LocalDateTime fecha;
    private int duracion;
    /**
     * Constructor de la clase Reservas.
     * 
     * @param idPista de la pista reservada.
     * @param Fecha de la reserva.
     * @param Duración de la reserva en horas.
     */
    public Reservas(int idPista, LocalDateTime fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }
    /**
     * Obtiene el ID de la pista reservada.
     * 
     * @return ID de la pista.
     */

    public int getIdPista() {
        return idPista;
    }

    /**
     * Obtiene la fecha de la reserva.
     * 
     * @return Fecha de la reserva.
     */

    public LocalDateTime getFecha() {
        return fecha;
    }
    /**
     * Obtiene la duración de la reserva.
     * 
     * @return Duración de la reserva en horas.
     */
    public int getDuracion() {
        return duracion;
    }
}
