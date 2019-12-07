

import java.util.*;
import java.util.Scanner;

public class HundirLaFlota {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();

		
		int coo1 = 0;
		int coo2 = 0;
		//contador barcos tocados
		int couShipTou = 0;
		//contador barcos hundidos 1 y 2
		int couShipSun1 = 0;
		int couShipSun2 = 0;
		//contador de bombas
		int cou = 0;
		int al1 = rnd.nextInt(5);
		// al2, aleatorio en rango 2,5 (para que no choque)
		int al2 = rnd.nextInt((5 - 2) + 1) + 2;

		char array[][] = new char[6][6];
		for (int i = 0; i < 6; i++) {
			for (int x = 0; x < 6; x++) {
				array[i][x] = '0';
			}
		}
		
		// primer barco posicion, valor 1. Tamaño 2
		for (int i = 0; i < 2; i++) {
			array[al1][i] = '1';
		}

		// segundo barco posicion,valor 2. Tamaño 3
		for (int i = 0; i < 3; i++) {
			array[i][al2] = '2';

		}
// !!!!!!!!!!   SOLUCION AL JUEGO , SOLO MIRAR PARA MODIFICAR
		// Descomentar para ver la posicion de los barcos
		
	/**	for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		**/


		System.out.println("Bienvenido al hundir los barcos");
		System.out.println("Instrucciones:");
		System.out.println("");
		System.out.println("Este es el tablero de juego, en el se crean dos barcos aleatorios");
		System.out.println(
				"Uno de los barcos estara en horizontal y otro en vertical ocupando 2 y 3 casillas del tablero");
		System.out.println("Recuerde que las coordenadas solo podran recorrer de 0 a 5");
		// mapeado del tablero
		System.out.println(" __ __  __  __  __  __  __");
		System.out.println("|    0   1   2   3   4   5");
		System.out.println("");
		System.out.println("|0   0   0   0   0   0   0");
		System.out.println("");
		System.out.println("|1   0   0   0   0   0   0");
		System.out.println("");
		System.out.println("|2   0   0   0   0   0   0");
		System.out.println("");
		System.out.println("|3   0   0   0   0   0   0");
		System.out.println("");
		System.out.println("|4   0   0   0   0   0   0");
		System.out.println("  ");
		System.out.println("|5   0   0   0   0   0   0");
		System.out.println("  ");

		System.out.println("Pulsa 1-STAR para comenzar a jugar o 2-EXIT, para salir");
		int option = sc.nextInt();

		switch (option) {
		case 1:
			System.out.println("START");

			do {
				System.out.println("Diga su primera coordenada BOMBA");
				coo1 = sc.nextInt();
				cou++;
				System.out.println("Diga su segunda coordenada BOMBA");
				coo2 = sc.nextInt();
				cou++;
				
				// en 1ºtirada NUNCA entra en HUNDIDO, y pasa a ELSE IF porque seria el 1ºtocado
				
				if (array[coo1][coo2] == '1' && couShipSun1 == 1) {
					System.out.println("¡¡ TOCADO Y !!");
					System.out.println("¡¡ HUNDIDO  !!");
					array[coo1][coo2] = 'X';
					couShipTou = couShipTou + 1;
				} else if (array[coo1][coo2] == '1') {
					System.out.println("¡¡ TOCADO !!  ");
					array[coo1][coo2] = 'X';
					couShipTou = couShipTou + 1;
					couShipSun1 = 1;
				} else if (array[coo1][coo2] == '2' && couShipSun2 == 2) {
					System.out.println("¡¡ TOCADO Y !!");
					System.out.println("¡¡ HUNDIDO  !!");
					array[coo1][coo2] = 'X';
					// CONTADOR VALORES BARCOS (suma 2 al contador de barcos)
					couShipTou = couShipTou + 2;
				} else if (array[coo1][coo2] == '2') {
					System.out.println("¡¡ TOCADO !!");
					array[coo1][coo2] = 'X';
					couShipTou = couShipTou + 2;
					couShipSun2 = couShipSun2 + 1;
				}

				else if (array[coo1][coo2] == '0') {
					System.out.println("AGUA. Vuelve a tirar");
					array[coo1][coo2] = '-';
				} else
					System.out.println("YA HAS TOCADO ESE BARCO.");
			} while (couShipTou < 8);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("TODOS LOS BARCOS HUNDIDOS");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("                         ");

			System.out.println("Tus BOMBAS han sido " + cou / 2);
			System.out.println("                           ");

			if (cou / 2 < 10) {
				System.out.println("                         ");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("Te has clasificado para la siguiente ronda");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("                         ");

			} else if (cou / 2 > 10 && cou < 14) {
				System.out.println("                         ");
				System.out.println("Puedes volver a intentarlo");
				System.out.println("                         ");

			} else if (cou / 2 > 14) {
				System.out.println("         G A M E   O V E R           ");
				System.out.println("Demasiadas BOMBAS,busca otro juego mas facil");
				System.out.println("         G A M E   O V E R           ");

			}
			System.out.println("Este ha sido tu  tablero");
			System.out.println("                        ");
			System.out.println("FIN DEL JUEGO");

			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					System.out.print(array[i][j] + " ");
				}
				System.out.println();
			}

			break;
		case 2:
			System.out.println("EXIT");
			break;
		}
	}
}
