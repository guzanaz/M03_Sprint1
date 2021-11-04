package pkgClassesVirtualio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.After;

class SlotsMachinesTest {
	SlotsMachines slots;
	
	@Before
	void setUp() {
		slots = new SlotsMachines(8);
        slots.espacio[0] = new VirtualMachine("dani", "dfdf", "ss", "ddd", "os_versi", "ram_size", "ssd grande muy grande", "Nada que decir",true);
        System.out.println("Creando");
	}
	
	
	@Test
    public void comprobarCreada()
    {
		setUp();
		//System.out.print("testiando wei!");
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
        slots.deleteMV();
    }
    
    @After
    public void tearDown()
    {
    	System.out.print("Terminado!");
    	
    }

}
