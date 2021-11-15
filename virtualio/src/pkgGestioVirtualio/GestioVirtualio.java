/**
 * 
 */
package pkgGestioVirtualio;

import java.util.Scanner;

import pkgClassesVirtualio.VirtualMachine;
import pkgClassesVirtualio.SlotsMachines;

/**
 * Sprint 1
 * M03 Programa GestioVirtualio: Programa inicial del proyecto del mismo nombre. 
 * Implementa una aplicación para hacer un CRUD de máquinas virtuales.  
 * Llama a las clases VirtualMachine.java y SlotsMachines.java
 * @author Daniela Gallardo Reyes
 * @version 1.0 (entrega final PERO siempre pueden haber mejoras)
 * @since 03-10-2021
 */
public class GestioVirtualio {
	public static Scanner sc = new Scanner(System.in);
	
		
	// método main
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
			//var para guardarnos la opcion seleccionada
			char opcio;
			//llamada al método para imprimir el menu
			opcio = menu(opcions);

			switch (opcio) {

			case 'C':
				System.out.println("----------------------------------");
				System.out.println("|     [C]Nova Màquina Virutal    |");
				System.out.println("----------------------------------");
				SlotsMachines.addMV();
				break;
			case 'R':
				System.out.println("--------------------------------");
				System.out.println("  [R]Llistar Màquines Virtuals  ");
				System.out.println("--------------------------------");
				SlotsMachines.printMvs();
				break;

			case 'U':
				System.out.println("--------------------------------");
				System.out.println("   [U]Editar Màquina Virtual    ");
				System.out.println("--------------------------------");
				
				break;

			case 'D':
				System.out.println("--------------------------------");
				System.out.println("   [D]Eliminar Màquina Virtual    ");
				System.out.println("--------------------------------");
				
				
				break;

			case 'X':
				System.out.println("--------------------------------");
				System.out.println("           [X]Sortir!           ");
				System.out.println("--------------------------------");
				System.out.println("     Fi del programa. Adeu!     ");
				System.out.println("--------------------------------");
				sortir = true;
				break;

			default:
				System.out.println("\n-----------------------------------------");
				System.out.println("| COMPTE! has d'ingressar una opció vàlida!|");
				System.out.println("-----------------------------------------\n");
				sortir = false;
			}
		} while (sortir == false);

	}// fin método main

	/**
	 * Función Menú. Muestra el menú de opciones por pantalla y pide ingresar una
	 * opción del menú por teclado
	 * 
	 * @param opcions
	 * @return variable tipo char (opción seleccionada)
	 */
	public static char menu(String[] opcions) {
		System.out.println("-----------------------------");
		System.out.println("|       VIRTUALIO MENU      |");
		System.out.println("-----------------------------");
		for (int i = 0; i < opcions.length; i++) {
			System.out.println(opcions[i]);
		}
		// Preguntamos qué opción seleccionarán
		System.out.println("-----------------------------");
		System.out.println("|       QUÉ VOLS FER?       |");
		System.out.println("-----------------------------");
		System.out.println("    [ingressa una opció]   ");

		// entrada por teclado
		Scanner sc = new Scanner(System.in);
		// guardamos la entrada en opcio
		char opcio1 = sc.next().toUpperCase().charAt(0);
		
		// retornamos opcio al main
		return opcio1;

	}
	
	@SuppressWarnings("resource")
	public static void deleteMV() {
		String toDelete;	
		SlotsMachines.printMvs();
		System.out.println("---------------------------------------");
		System.out.println("|          Ingressa la VM Id          |");
		System.out.println("|   de la màquina que vols eliminar   |");
		System.out.println("--------------------------------------");
		toDelete = sc.nextLine();
		SlotsMachines.deleteMV(toDelete);		
		System.out.println("--------------------------------------");
		System.out.println("|     Les Teues Máquines Vituals     |");
		System.out.println("--------------------------------------");
		SlotsMachines.printMvs();
	}
	
	
}
