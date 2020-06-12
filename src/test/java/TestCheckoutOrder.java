import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

public class TestCheckoutOrder
{
    
    private OrderScanner scanner;

    @BeforeEach
    public void setUp()
    {
        var inventory = new HashMap<String, Double>();
        inventory.put("orange juice", 2.5);
    	scanner = new OrderScanner(inventory);
    }
    
    @Test
    public void costIsZeroWhenScanningNothing()
    {
        assertEquals(0, scanner.getTotalPrice());
    }

    @Test
    public void scanningSingleItem()
    {
    	scanner.scan("orange juice");
    	assertEquals(2.5, scanner.getTotalPrice());
    }
    
    @Test
    public void scanningTwoItem()
    {
    	scanner.scan("orange juice");
    	scanner.add("apple juice", 3);
    	scanner.scan("apple juice");
    	assertEquals(5.5, scanner.getTotalPrice());
    }

    @Test
    public void scannedItemMustBeInInventory()
    {
        assertThrows(ItemNotInInventoryException.class,
                () -> {
                    scanner.scan("invalid item");
                });
        assertEquals(0, scanner.getTotalPrice());
    }
    
}
