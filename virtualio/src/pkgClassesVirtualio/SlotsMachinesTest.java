package pkgClassesVirtualio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.After;

class SlotsMachinesTest {
	
	@Before
	void setUp() {
		System.out.println("Creando");
		SlotsMachines.addMv(new VirtualMachine("dani", "dfdf", "ss", "ddd", "os_versi", "ram_size", "ssd grande muy grande", "Nada que decir",true));
		SlotsMachines.addMv(new VirtualMachine("Fermín", "dfdf", "ss", "ddd", "os_versi", "ram_size", "ssd grande muy grande", "Nada que decir",true));
		SlotsMachines.addMv(new VirtualMachine("Pinocho", "dfdf", "ss", "ddd", "os_versi", "ram_size", "ssd grande muy grande", "Nada que decir",true));
		System.out.println(SlotsMachines.espacio.length);
	}
	
	
	@Test
    public void comprobarCreada()
    {
		setUp();
        for(VirtualMachine vm: SlotsMachines.espacio){
            if(vm != null){
                System.out.println(vm.toString());
            }
        }
    }
    
    @Test
    public void borrarUna()
    {
    	setUp();
    	System.out.println("\nMAQUINAS ACTUALES: ");
    	System.out.println(SlotsMachines.espacio.length);
    	SlotsMachines.printMvs();
    	SlotsMachines.deleteMV("dani");   	
    	System.out.println("\nMAQUINAS DESPUÉS DE BORRAR: ");
    	System.out.println(SlotsMachines.espacio.length);
    	SlotsMachines.printMvs();
        tearDown();
    }
    
    @After
    public void tearDown()
    {
    	SlotsMachines.resetSlots();
    	System.out.print("Terminado!");
    	
    }

}
