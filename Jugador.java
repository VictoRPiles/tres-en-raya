import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Victor
 * @since 26/05/2022 - 12:09
 */
public class Jugador {
	private final char ficha;
	private final HashSet<Character> fichas = new HashSet<>();

	public Jugador(char ficha) {
		if (fichas.add(ficha)) {
			this.ficha = ficha;
		} else {
			throw new IllegalArgumentException("La ficha " + ficha + " está siendo utilizada por otro jugador");
		}
	}

	public char getFicha() {
		return ficha;
	}

	public int[] tirar(Tablero tablero) {
		Scanner scanner = new Scanner(System.in);
		int fila, columna;
		System.out.print("Fila -> ");
		fila = scanner.nextInt();
		System.out.print("Columna -> ");
		columna = scanner.nextInt();

		if (!((fila <= tablero.getBase() && fila > 0) && (columna <= tablero.getBase() && columna > 0))) {
			System.out.println("Valor para la fila o columna no válidos");
			return tirar(tablero);
		}

		return new int[]{fila - 1, columna - 1};
	}

	@Override
	public String toString() {
		return "Jugador con ficha " + ficha;
	}
}