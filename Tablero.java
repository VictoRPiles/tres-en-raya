import java.util.Arrays;

/**
 * @author Victor
 * @since 26/05/2022 - 12:00
 */
public class Tablero {
	private final int base;
	private final char[][] tablero;

	public Tablero(int base) {
		this.base = base;
		if (base > 0) {
			tablero = new char[base][base];
			for (char[] fila : tablero) {
				Arrays.fill(fila, ' ');
			}
		} else {
			throw new IllegalArgumentException("Base incorrectas");
		}
	}

	public int getBase() {
		return base;
	}

	/**
	 * @return Si el índice de la matriz está libre (hay un espacio).
	 */
	public boolean isCasillaLibre(int[] pos) {
		return tablero[pos[0]][pos[1]] == ' ';
	}

	/**
	 * Llena la posición del array con la ficha.
	 *
	 * @param pos   Posición en el array.
	 * @param ficha Ficha.
	 */
	public void setCasilla(int[] pos, char ficha) {
		if (!isCasillaLibre(pos)) {
			System.out.println("Casilla ocupada");
		} else {
			tablero[pos[0]][pos[1]] = ficha;
		}
	}

	/**
	 * Comprueba si todos los valores de alguna de las filas son iguales, a excepción del espacio.
	 *
	 * @return El valor igual en alguna de las filas o espacio si no hay una fila con todos los valores iguales.
	 */
	public char checkFila() {
		char ficha = ' ';

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				/* la ficha és la primera de la fila */
				if (j == 0) ficha = tablero[i][j];

				/* si és diferente cambia de fila */
				if (tablero[i][j] != ficha) break;

				/*
				si ha llegado al final del bucle, todas las fichas son iguales y no son espacios en blanco,
				devuelve la ficha
				*/
				if (j == tablero[i].length - 1 && ficha != ' ') return ficha;
			}
		}

		/* si no ha encontrado una fila con fichas iguales, devuelve espacio */
		return ' ';
	}

	/**
	 * Comprueba si todos los valores de alguna de las columnas son iguales, a excepción del espacio.
	 *
	 * @return El valor igual en alguna de las columnas o espacio si no hay una columna con todos los valores iguales.
	 */
	public char checkColumna() {
		char ficha;

		for (int j = 0; j < tablero.length; j++) {
			/* la ficha és la primera de la columna */
			ficha = tablero[0][j];

			for (int i = 1; i < tablero[0].length; i++) {
				/* si és diferente cambia de columna */
				if (ficha != tablero[i][j]) break;

				/*
				si ha llegado al final del bucle, todas las fichas son iguales y no son espacios en blanco,
				devuelve la ficha
				*/
				if (i == tablero[j].length - 1 && ficha != ' ') return ficha;
			}
		}

		/* si no ha encontrado una fila con fichas iguales, devuelve espacio */
		return ' ';
	}

	/**
	 * Comprueba si todos los valores de alguna de las diagonales son iguales, a excepción del espacio.
	 *
	 * @return El valor igual en alguna de las diagonales o espacio si no hay una diagonal con todos los valores
	 * iguales.
	 */
	public char checkDiagonal() {
		char ficha = ' ';
		char fichaCentro = tablero[base / 2][base / 2];

		/* si no hay ficha en el centro no pueden haver diagonales con todas las fichas iguales  */
		if (fichaCentro == ' ') return ' ';

		for (int i = 0; i < tablero.length; i++) {
			/* primera de la diagonal izquierda - derecha */
			if (i == 0) ficha = tablero[i][i];

			if (ficha != tablero[i][i]) break;

			/* si ha llegado al final y no son espacios */
			if (i == tablero.length - 1 && ficha != ' ') return ficha;
		}

		ficha = ' ';

		for (int i = tablero.length - 1; i >= 0; i--) {
			/* primera de la diagonal derecha - izquierda */
			if (i == tablero.length - 1) ficha = tablero[tablero.length - i - 1][i];

			if (ficha != tablero[tablero.length - i - 1][i]) break;

			/* si ha llegado al principio y no son espacios */
			if (i == 0 && ficha != ' ') return ficha;
		}

		/* si no ha encontrado una fila con fichas iguales, devuelve espacio */
		return ' ';
	}

	/**
	 * Dibuja el tablero y las fichas.
	 */
	public void dibujar() {
		for (int i = 0; i < tablero[0].length; i++) {
			/* Si és la primera columna */
			if (i == 0) System.out.print("  ");

			System.out.printf(" %d ", i + 1);

			/* Si és la última columna */
			if (i == tablero[0].length - 1) System.out.println();

		}
		for (int i = 0; i < tablero.length; i++) {
			System.out.printf("%d ", i + 1);
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.printf("[%c]", tablero[i][j]);
			}
			System.out.println();
		}
	}
}