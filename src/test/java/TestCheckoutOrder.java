import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;

public class TestCheckoutOrder
{
    
    private OrderScanner scanner;
    @BeforeEach
    public void setUp()
    {
    	scanner = new OrderScanner();
    }
    
    @Test
    
    public void costIsZeroWhenScanningNothing()
    {
        assertEquals(0, scanner.getTotalPrice());
    }
    
    public void costIsNotZeroWhenOneItemScanner()
    {
    	scanner.scan("orange juice");
    	assertFalse(scanner.getTotalPrice()==0);
    }
}
