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
public class VirtualMachine {
	private String vm_id;
	private String user;
	private String name;
	private String os;
	private String os_version;
	private String ram_size;
	private String ssd_size;
	private String description;
//	private Date creation_date=new Date();
	private boolean power_on;

	// ------------------------------------------------------------------------//
	// ---------------------------- Métodos get&set ---------------------------//
	// ------------------------------------------------------------------------//

	/**
	 * @return the vm_id
	 */
	public String getVm_id() {
		return vm_id;
	}

	/**
	 * @param vm_id the vm_id to set
	 */
	public void setVm_id(String vm_id) {
		this.vm_id = vm_id;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param usuario the user to set
	 */
	public void setUsuario(String user) {
		this.user = user;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the os
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * @return the os_version
	 */
	public String getOs_version() {
		return os_version;
	}

	/**
	 * @param os_version the os_version to set
	 */
	public void setOs_version(String os_version) {
		this.os_version = os_version;
	}

	/**
	 * @return the ram_size
	 */
	public String getRam_size() {
		return ram_size;
	}

	/**
	 * @param ram_size the ram_size to set
	 */
	public void setRam_size(String ram_size) {
		this.ram_size = ram_size;
	}

	/**
	 * @return the ssd_size
	 */
	public String getSsd_size() {
		return ssd_size;
	}

	/**
	 * @param ssd_size the ssd_size to set
	 */
	public void setSsd_size(String ssd_size) {
		this.ssd_size = ssd_size;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the power_on
	 */
	public boolean isPower_on() {
		return power_on;
	}

	/**
	 * @param power_on the power_on to set
	 */
	public void setPower_on(boolean power_on) {
		this.power_on = power_on;
	}

	/*
	 * Constructor que permite crear Máquinas con valores null
	 */
	public VirtualMachine() {

	}

	/*
	 * Constructor que permite crear Máquinas con todos los valores del objeto
	 * definidos
	 */
	public VirtualMachine(String vm_id, String user, String name, String os, String os_version, String ram_size,
			String ssd_size, String description, boolean power_on) {

		this.vm_id = vm_id;
		this.user = user;
		this.name = name;
		this.os = os;
		this.os_version = os_version;
		this.ram_size = ram_size;
		this.ssd_size = ssd_size;
		this.description = description;
		this.power_on = power_on;

	}

	public String toString() {
		return "VirtualMachine \n" + "\tVM Id: " + vm_id + "\n\tUser: " + user + "\n\tName: " + name + "\n\tOS: " + os
				+ "\n\tOS version: " + os_version + "\n\tRam size: " + ram_size + "\n\tSsd size: " + ssd_size
				+ "\n\tDescription: " + description + "\n\tState: " + state() + "\n \n";
	}

	public String state() {
		String resultado;
		if (power_on == false) {
			resultado = "stopped";
		} else {
			resultado = "running";
		}
		return resultado;
	}
	
	

	/**
	 * Método crateMV(). Crea un objeto de tipo VirtualMachine
	 * 
	 * @param void
	 * @return VirtualMachine.
	 */
	public static VirtualMachine dialogCreateMV(Scanner sc) {
		VirtualMachine novaMV;
		String vm_id, user, name, os, os_version, ram_size, ssd_size, description;
		boolean power_on = false;
		System.out.println("Ingressa la ID de la màquina");
		vm_id = sc.nextLine();
		System.out.println("Ingressa el teu nom d'usuari");
		user = sc.nextLine();
		System.out.println("Ingressa el nom de la teua màquina virtual");
		name = sc.nextLine();
		System.out.println("Ingressa el TIPUS de sistema operatiu a utilitzar");
		os = sc.nextLine();
		System.out.println("Ingressa la VERSIÓ del sistema operatiu a utilitzar");
		os_version = sc.nextLine();
		System.out.println("Ingressa la capacitat de la RAM");
		ram_size = sc.nextLine();
		System.out.println("Ingressa la capacitat de la memòria SSD");
		ssd_size = sc.nextLine();
		System.out.println("Ingressa una breu descripció per a la teua màquina virtual");
		description = sc.nextLine();

		novaMV = new VirtualMachine(vm_id, user, name, os, os_version, ram_size, ssd_size, description, power_on);
		System.out.println("---------------");
		System.out.println("MV CREAT...");
		System.out.println("---------------");
		return novaMV;
	}

		
	/**
	 * Método digalogModificar().
	 * @param sc
	 */
	public void dialogModifica(Scanner sc) {
		this.vm_id = prompInputDefault("ID:", vm_id, sc);
		this.user = prompInputDefault("Usuari:", user, sc);
		this.name = prompInputDefault("Nom:", name, sc);
		this.os = prompInputDefault("Sistema operatiu:", os, sc);
		this.os_version = prompInputDefault("Versió SO:", os_version, sc);
		this.ram_size = prompInputDefault("RAM:", ram_size, sc);
		this.ssd_size = prompInputDefault("SSD:", ssd_size, sc);
		this.description = prompInputDefault("Descripció:", description, sc);
		this.power_on = reverseState(prompInputDefault("Estat:", state(), sc), power_on);		
	}
	
	/**
	 * Método prompInputDefault().
	 * @param sc: entrada por teclado.
	 * @param prompt: enunciado explicativo.
	 * @param sDefault: valor actual.
	 */
	private static String prompInputDefault(String prompt, String sDefault, Scanner sc) {
		  String prmpt = prompt + " (Presiona enter per deixar-ho com \"" + sDefault + "\"):";
		  String tmpch = null;
		  System.out.print(prmpt);
		  tmpch = sc.nextLine().trim();
		  if (tmpch == null || tmpch.equals("")) {
		     return sDefault;
		  } else {
		     return tmpch;
		  }
		  
	}
	
	/**
	 * 
	 * @param state
	 * @param bDefault
	 * @return
	 */
	private static boolean reverseState(String state, boolean bDefault) {
		if (state.equals("running")){
			return true;
		}else if((state.equals("stopped"))){
			return false;
		}else {
			System.out.println("El valor introduit no correspon a cap estat vàlid (running/stopped). L'estat no es modificarà.");
			return bDefault;
		}
	}
}
