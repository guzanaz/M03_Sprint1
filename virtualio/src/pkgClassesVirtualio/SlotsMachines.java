/**
 * 
 */
package pkgClassesVirtualio;

import java.util.Scanner;

/**
 * Sprint 1 M03 SlotsMachines: clase del proyecto Virtualio. Conforma el paquete
 * pkgClassesVirtualio. Contiene atributos y métodos para la definición espacio
 * total para almacenar Máquinas Virtuales. Sus atributos y métodos se utilizan
 * en el programa inicial GestioVirtualio.java
 * 
 * @author Daniela Gallardo Reyes
 * @version 1.0 (entrega final PERO siempre pueden haber mejoras)
 * @since 3-10-2021
 */

public class SlotsMachines {

	public static VirtualMachine[] espacio = new VirtualMachine[1]; // espacio disponible para máquinas

	// ------------------------------------------------------------------------//
	// ---------------------------- Métodos get&set ---------------------------//
	// ------------------------------------------------------------------------//

	/**
	 * @return the espacio
	 */
	public static VirtualMachine[] getEspacio() {
		return espacio;
	}

	/**
	 * @param espacio the espacio to set
	 */
	public static void setEspacio(VirtualMachine[] espacio_arg) {
		espacio = espacio_arg;
	}

	/**
	 * @return the num of slots
	 */
	public static int getNumSlots() {
		return espacio.length;
	}

	/**
	 * Método toStringFormat permite dar formato para mostrarse por pantalla
	 * 
	 * @param void
	 * @return String
	 */
	public static String toStringFormat() {
		String tmpString = "";
		for (int i = 0; i < espacio.length; i++) {
			if (espacio[i] != null) {
				tmpString += (i + 1) + "." + espacio[i].toString();
			}
		}
		return tmpString;
	}

	/**
	 * Método dialogAddMV(). Afegeix una nova màquina virtual a l'últim slot,
	 * mitjançant dialeg I/O.
	 * 
	 * @param void
	 * @return void
	 */
	public static void dialogAddMV(Scanner sc) {
		// Creem nova màquina virtual temporal
		VirtualMachine tmpMaquina = VirtualMachine.dialogCreateMV(sc);
		// L'afegim a l'últim slot
		addMv(tmpMaquina);
	}

	/**
	 * Añade directemente una nueva VM
	 */
	public static void addMv(VirtualMachine maquina) {

		int index = espacio.length;
		// Si la posició 0 no està ocupada, l'ocupem
		if (espacio[0] == null) {
			espacio[0] = maquina;
			// En cas contrari fem un array nou i posem la maquina en l'ultima posició
		} else {
			VirtualMachine[] tmpEspacio = new VirtualMachine[index + 1];
			// Omplim la copia amb les dades antigues
			for (int i = 0; i < index; i++) {
				if (espacio[i] != null) {
					tmpEspacio[i] = espacio[i];
				}
			}
			// Introduim nova màquina sempre a l'última posició
			tmpEspacio[index] = maquina;
			espacio = tmpEspacio;
		}
	}

	/**
	 * Elimina la máquina virtual con id igual a toDelete. Si hubiera más de uno se
	 * borrará solo el primero.
	 * 
	 * @param toDelete: Id de la máquina a eliminar
	 * @return boolean: true si se encuentra el ID, falso en caso contrario
	 */
	public static boolean deleteMv(String toDelete) {
		VirtualMachine[] tmpArr = new VirtualMachine[1];
		boolean found = false;
		if (espacio.length > 1) {
			tmpArr = new VirtualMachine[espacio.length - 1];
		} else {
			tmpArr = new VirtualMachine[1];
			if (espacio[0] == null) {
				System.out.println("No hi ha cap màquina virtual al sistema. No s'eliminarà res.");
				return false;
			}
		}
		for (int i = 0; i < espacio.length; i++) {
			if (espacio[i].getVm_id().equals(toDelete)) {
				found = true;
				for (int index = 0; index < i; index++) {
					tmpArr[index] = espacio[index];
				}
				for (int j = i; j < espacio.length - 1; j++) {
					tmpArr[j] = espacio[j + 1];
				}
				break;
			}
		}
		if (found) {
			espacio = tmpArr;
		}

		return found;
	}

	/**
	 * Método que edita los atributos de un objeto Virtual Machine
	 * @param VirtualMachine.getid()/Id de la máquina a editar
	 * @return VirtualMachine/objeto editado
	 */
	public static void dialogEditMachine(Scanner sc){
		String search_id = "";
		System.out.println("Introdueix l'ID de la màquina que vols modificar:");
		search_id = sc.nextLine();
		try {
			findMaquina(search_id).dialogModifica(sc);
		}catch (NullPointerException e) {
			System.out.println("No s'ha trobat la màquina en els slots");
		}
	}

	public static void resetSlots() {
		espacio = new VirtualMachine[1];
	}

	public static VirtualMachine findMaquina(String id) {
		for (int i = 0; i < espacio.length; i++) {
			if (espacio[i].getVm_id().equals(id)) {
				return SlotsMachines.espacio[i];
			}
		}
		return null;
	}
	
}
