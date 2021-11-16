/**
 * 
 */
package pkgGestioVirtualio;

import java.util.Scanner;

import pkgClassesVirtualio.SlotsMachines;

/**
 * Sprint 1 M03 Programa GestioVirtualio: Programa inicial del proyecto del
 * mismo nombre. Implementa una aplicación para hacer un CRUD de máquinas
 * virtuales. Llama a las clases VirtualMachine.java y SlotsMachines.java
 * 
 * @author Daniela Gallardo Reyes
 * @version 1.0 (entrega final PERO siempre pueden haber mejoras)
 * @since 03-10-2021
 */
public class GestioVirtualio {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 1. Declarar array con opcions del menú fuera de la función
		String[] opcions = new String[5];
		opcions[0] = "[C]Nova Màquina Virtual";
		opcions[1] = "[R]Llistar Màquines Virtuals";
		opcions[2] = "[U]Editar Màquina Virtual";
		opcions[3] = "[D]Eliminar Màquina Virtual";
		opcions[4] = "[X]Sortir";

		// 2.variable para salir del programa
		boolean sortir = false;

		do {
			// var para guardarnos la opcion seleccionada
			char opcio;
			// llamada al método para imprimir el menu
			opcio = menu(opcions);

			switch (opcio) {

			case 'C':
				printHeader("[C] Nova Màquina Virutal");
				SlotsMachines.dialogAddMV(sc);
				enterToContinue();
				break;

			case 'R':
				printHeader("[R] Llistar Màquines Virtuals");
				System.out.println(SlotsMachines.toStringFormat());
				enterToContinue();
				break;

			case 'U':
				printHeader("[U] Editar Màquina Virtual");
				SlotsMachines.dialogEditMachine(sc);
				enterToContinue();
				break;

			case 'D':
				printHeader("[D] Eliminar Màquina Virtual");
				deleteMv();
				enterToContinue();
				break;

			case 'X':
				printHeader("[X] Sortir!");
				System.out.println("     Fi del programa. Adeu!     ");
				System.out.println("--------------------------------");
				sortir = true;
				break;

			default:
				printHeader("COMPTE! has d'ingressar una opció vàlida!");
				sortir = false;
			}
		} while (sortir == false);

	}

	/**
	 * Función Menú. Muestra el menú de opciones por pantalla y pide ingresar una
	 * opción del menú por teclado
	 * 
	 * @param opcions
	 * @return variable tipo char (opción seleccionada)
	 */
	private static char menu(String[] opcions) {
		char opcio = ' ';

		printHeader("VIRTUALIO MENU");
		for (int i = 0; i < opcions.length; i++) {
			System.out.println(opcions[i]);
		}
		// Preguntamos qué opción seleccionarán
		printHeader("QUÈ VOLS FER?");

		while ("CRUDX".indexOf(opcio) == -1) {
			System.out.println("OPCIO: " + opcio);
			System.out.println("    [ingressa una opció válida]   ");
			// guardamos la entrada en opcio
			String tmpInput = sc.nextLine(); // Importante para que se vacíe el buffer
			try {
				opcio = tmpInput.toUpperCase().charAt(0);
				if ("CRUDX".indexOf(opcio) == -1) {
					printHeader("COMPTE! has d'ingressar una opció vàlida!");
				}				
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("Has d'introduir una opció valida [CRUDX] (l'Enter sol no val!!)");
			}
		}

		return opcio;
	}

	public static void deleteMv() {
		String toDelete;
		System.out.println(SlotsMachines.toStringFormat());
		printHeader("Ingressa l'ID de la VM que vols eliminar.");
		toDelete = sc.nextLine();
		SlotsMachines.deleteMv(toDelete);
		printHeader("Les Teues Máquines Vituals");
		System.out.println(SlotsMachines.toStringFormat());
	}

	private static void printHeader(String arg) {
		String headerStyle = "----------------------------------------------------------";
		int padding;
		String tmpStr = "";
		if (headerStyle.length() > arg.length()) {
			padding = (int) (Math.floor(headerStyle.length() - arg.length()) / 2);
			for (int i = 0; i < padding; i++) {
				tmpStr += " ";
			}
		}
		System.out.println(headerStyle);
		System.out.println("|" + tmpStr + arg + tmpStr + "|");
		System.out.println(headerStyle);
	}

	private static void enterToContinue() {
		System.out.println("Premi 'enter' per a tornar al menú.");
		sc.nextLine();
	}

}
