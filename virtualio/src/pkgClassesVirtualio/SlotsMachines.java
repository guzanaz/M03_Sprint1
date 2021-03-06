/**
 * 
 */
package pkgClassesVirtualio;

import java.util.Arrays;
/**
 * Sprint 1
 * M03 SlotsMachines: clase del proyecto Virtualio. 
 * Conforma el paquete pkgClassesVirtualio. Contiene atributos y métodos para la definición
 * espacio total para almacenar Máquinas Virtuales. 
 * Sus atributos y métodos se utilizan en el programa
 * inicial GestioVirtualio.java
 * 
 * @author Daniela Gallardo Reyes
 * @version 1.0 (entrega final PERO siempre pueden haber mejoras)
 * @since 3-10-2021
 */
import java.util.Scanner;

public class SlotsMachines {
	
	
	static VirtualMachine[] espacio;// espacio disponible para máquinas
	int num;// para asignar el índice de VM al array espacio

	// ------------------------------------------------------------------------//
	// ------------------------- Métodos Constructores ------------------------//
	// ------------------------------------------------------------------------//
	public SlotsMachines() {

	}

	// Constructor con tamaño
	public SlotsMachines(int num) {
		// inicializamos la llargada del array
		this.espacio = new VirtualMachine[num];
		// iniciar el valor del índice
		this.num = num;
	}
	
	
	// ------------------------------------------------------------------------//
	// ---------------------------- Métodos get&set ---------------------------//
	// ------------------------------------------------------------------------//

	/**
	 * @return the espacio
	 */
	public VirtualMachine[] getEspacio() {
		return espacio;
	}

	/**
	 * @param espacio the espacio to set
	 */
	public void setEspacio(VirtualMachine[] espacio) {
		this.espacio = espacio;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}


	/**
	 * Método toString por default permite hacer pruebas
	 * 
	 * @param String (array)
	 * @return String
	 */
	public String toString() {
		return Arrays.toString(espacio);
	}

	/**
	 * Método toStringFormat permite dar formato para mostrarse por pantalla
	 * 
	 * @param void
	 * @return void
	 */
	public void toStringFormat() {
		for (int i = 0; i < num; i++) {
			espacio[i] = new VirtualMachine();
			System.out.print(i + 1 + "." + espacio[i].toString());
		}
		return;
	}

	/**
	 * Método crearEspai(). 
	 * Permite asignar el índice del array que guardará las MV.
	 * índice del array = total de mv posibles de almacenar.
	 * 
	 * @param void
	 * @return void
	 */
	public static void crearEspai() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------------------------");
		System.out.println("| Quantes màquines virtuals voldràs emmagatzemar? |");
		System.out.println("---------------------------------------------------");
		int num2 = sc.nextInt();
		System.out.println("---------------------------------------------------");
		System.out.println("|                      Creant...                  |");
		System.out.println("---------------------------------------------------");
		SlotsMachines nuevo = new SlotsMachines(num2);
		System.out.println("---------------------------------------------------");
		System.out.println("|                " + num2 + " Espai/s Creats               |");
		System.out.println("---------------------------------------------------");

	}

	/**
	 * Método addMV(). Recorre los índices del array espacio para mv. Se detiene en
	 * el índice disponible. Llama al método createMV().
	 * 
	 * @param void
	 * @return void
	 */
	public static void addMV() {
		for (int i = 0; i < espacio.length; i++) {
			if (espacio[i] == null) {
				espacio[i] = VirtualMachine.createMV();
				System.out.println("---------------");
				System.out.println("MV CREAT...");
				System.out.println("---------------");
				System.out.println(espacio[i].toString());
				break;
			}
		}
		return;
	}

	/**
	 * Método printMvs(). Recorre los índices del array espacio para mv. Identifica
	 * los índices con datos personalizados. Imprime una lista de las MV creadas.
	 * 
	 * @param void
	 * @return void
	 */
	public static void printMvs() {
		for (int i = 0; i < espacio.length; i++) {
			if (espacio[i] != null) {
				System.out.println(espacio[i].toString());
			}
		}
		return;
	}

	public static VirtualMachine[] deleteMV() {
		String toDelete;
		VirtualMachine[] newArr = null;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		printMvs();
		System.out.println("---------------------------------------");
		System.out.println("|          Ingressa la VM Id          |");
		System.out.println("|   de la màquina que vols eliminar   |");
		System.out.println("--------------------------------------");
		toDelete = sc.nextLine();
		for (int i = 0; i < espacio.length-1; i++) {
				if (espacio[i].getVm_id().equals(toDelete)) { 
					newArr = new VirtualMachine[espacio.length - 1];
					for(int index = 0; index < i; index++){
	                    newArr[index] = espacio[index];
	                }
					for(int j = i; j < espacio.length - 1; j++){
	                    newArr[j] = espacio[j+1];
	                }
				break;
				}
		}
		
		System.out.println("--------------------------------------");
		System.out.println("|     Les Teues Máquines Vituals     |");
		System.out.println("--------------------------------------");
		return newArr;
	}

	/**
	 * Método main de la clase SlotsMachines para hacer pruebas
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		crearEspai();

	}
}
