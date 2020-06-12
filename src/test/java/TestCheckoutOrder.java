import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
}
