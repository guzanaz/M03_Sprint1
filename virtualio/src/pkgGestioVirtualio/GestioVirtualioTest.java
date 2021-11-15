package pkgGestioVirtualio;


import org.junit.Before;
import org.junit.jupiter.api.Test;

import pkgClassesVirtualio.SlotsMachines;
import pkgClassesVirtualio.VirtualMachine;



class GestioVirtualioTest {

	@Before
	void setUp() {
		System.out.println("Creando");
		SlotsMachines.addMv(new VirtualMachine("dani", "dfdf", "ss", "ddd", "os_versi", "ram_size", "ssd grande muy grande", "Nada que decir",true));
		SlotsMachines.addMv(new VirtualMachine("Fermín", "dfdf", "ss", "ddd", "os_versi", "ram_size", "ssd grande muy grande", "Nada que decir",true));
		SlotsMachines.addMv(new VirtualMachine("Pinocho", "dfdf", "ss", "ddd", "os_versi", "ram_size", "ssd grande muy grande", "Nada que decir",true));
		System.out.println(SlotsMachines.espacio.length);
	}
	
	@Test
	void test2() {
		setUp();
		GestioVirtualio.deleteMv();
		}

}
