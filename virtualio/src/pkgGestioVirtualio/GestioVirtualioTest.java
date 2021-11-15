package pkgGestioVirtualio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import pkgClassesVirtualio.SlotsMachines;
import pkgClassesVirtualio.VirtualMachine;

class GestioVirtualioTest {

	@Before
	void setUp() {
		SlotsMachines.espacio[0] = new VirtualMachine("dani", "dfdf", "ss", "ddd", "os_versi", "ram_size", "ssd grande muy grande", "Nada que decir",true);
		SlotsMachines.espacio[1] = new VirtualMachine("Fermín", "28", "ss", "ddd", "os_versi", "ram_size", "ssd grande muy grande", "Nada que decir",true);
		SlotsMachines.espacio[2] = new VirtualMachine("Pinocho", "dfdf", "ss", "ddd", "os_versi", "ram_size", "ssd grande muy grande", "Nada que decir",true);
		System.out.println("Creando");
		System.out.println(SlotsMachines.espacio.length);
		
	}
	
	@Test
	void test() {
		setUp();
		GestioVirtualio.deleteMV();
	}

}
