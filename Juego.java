/**
 * @author Victor
 * @since 27/05/2022 - 10:02
 */
public class Juego {
	private final Tablero tablero;
	private final Jugador[] jugadores;

	public Juego(Tablero tablero, Jugador... jugadores) {
		this.tablero = tablero;
		this.jugadores = jugadores;
	}

	/**
	 * Comprueba si algún jugador ha ganado, si no ha ganado imprime el tablero y pide la siguiente tirada.
	 */
	public void turno() {
		for (Jugador jugador : jugadores) {
			if (getGanador() != null) break;

			tablero.dibujar();
			System.out.println("Turno del " + jugador);
			tablero.setCasilla(jugador.tirar(tablero), jugador.getFicha());
		}
	}

	/**
	 * @return Jugador ganador o null.
	 */
	public Jugador getGanador() {
		char fichaGanadora = 0;
		if (tablero.checkFila() != ' ') fichaGanadora = tablero.checkFila();
		else if (tablero.checkColumna() != ' ') fichaGanadora = tablero.checkColumna();
		else if (tablero.checkDiagonal() != ' ') fichaGanadora = tablero.checkDiagonal();

		for (Jugador jugador : jugadores) {
			if (jugador.getFicha() == fichaGanadora) {
				return jugador;
			}
		}

		return null;
	}
}