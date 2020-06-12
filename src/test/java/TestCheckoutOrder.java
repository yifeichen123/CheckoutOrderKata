import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    	var exception = assertThrows(OrderScanner.ItemNotInInventoryException.class,
                () -> {
                    scanner.scan("invalid item");
                });
    	assertTrue(exception.toString().contains("invalid item"));
        assertEquals(0, scanner.getTotalPrice());
    }
    
    @Test
    public void scannedItemInAWeight()
    {
    	scanner.add("apple", 1.5);
    	scanner.scan("apple", 4);
    	assertEquals(6, scanner.getTotalPrice());
    }
    
}
