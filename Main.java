/**
 * @author Victor
 * @since 26/05/2022 - 11:59
 */
public class Main {
	public static void main(String[] args) {
		Jugador ganador;
		Juego juego = new Juego(new Tablero(3), new Jugador('X'), new Jugador('O'));
		boolean terminar = false;

		do {
			juego.turno();

			if ((ganador = juego.getGanador()) != null) terminar = true;
		} while (!terminar);

		System.out.println(ganador + " es el ganador");
	}
}