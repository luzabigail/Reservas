
public class GestorIluminacion {
	public boolean[] iluminacion;

	public GestorIluminacion() {
	}

	/**
	 * Activa la iluminación de una pista.
	 * 
	 * @param sistemaReservasDeportivas TODO
	 * @param idPista de la pista.
	 * @return true si la iluminación fue activada con éxito, false si el ID de pista es inválido.
	 */
	public boolean encenderLuces(SistemaReservasDeportivas sistemaReservasDeportivas, int idPista) {
	    if (idPista < 0 || idPista >= SistemaReservasDeportivas.MAX_PISTAS) {
	        return false; // ID de pista inválido
	    }
	    iluminacion[idPista] = true;
	    return true;
	}

	/**
	 * Desactiva la iluminación de una pista.
	 * 
	 * @param sistemaReservasDeportivas TODO
	 * @param idPista de la pista.
	 * @return true si la iluminación fue desactivada con éxito, false si el ID de pista es inválido.
	 */
	public boolean apagarLuces(SistemaReservasDeportivas sistemaReservasDeportivas, int idPista) {
	    if (idPista < 0 || idPista >= SistemaReservasDeportivas.MAX_PISTAS) {
	        return false; // ID de pista inválido
	    }
	    iluminacion[idPista] = false;
	    return true;
	}
}