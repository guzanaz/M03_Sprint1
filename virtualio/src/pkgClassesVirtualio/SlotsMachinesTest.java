package pkgClassesVirtualio;


import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.After;

class SlotsMachinesTest {
	
	@Before
	/**
	 * Que no salga en rojo
	 */
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
        tearDown();
    }
    
    @Test
    public void borrarUnaQueExiste()
    {
    	setUp();
    	System.out.println("\nMAQUINAS ACTUALES: ");
    	//System.out.println(SlotsMachines.espacio.length);
    	System.out.println(SlotsMachines.toStringFormat());
    	System.out.println(SlotsMachines.getNumSlots());
    	assert(SlotsMachines.getNumSlots()==3);
    	SlotsMachines.deleteMv("dani");   	
    	System.out.println("\nMAQUINAS DESPUÉS DE BORRAR: ");
    	System.out.println("Espacios según length: " + SlotsMachines.espacio.length);
    	System.out.println(SlotsMachines.toStringFormat());        
        System.out.println("Espacios según getNumSlots: " +SlotsMachines.getNumSlots());
        assert(SlotsMachines.getNumSlots()==2);
        tearDown();
    }
    
    @Test
    public void borrarUnaQueNoExiste()
    {
    	setUp();
    	assert(SlotsMachines.getNumSlots()==3);
    	SlotsMachines.deleteMv("Ataúlfo Lluís");
    	assert(SlotsMachines.getNumSlots()==3);
    }
    
    @After
    public void tearDown()
    {
    	SlotsMachines.resetSlots();
    	System.out.print("Terminado!");
    	
    }

}
