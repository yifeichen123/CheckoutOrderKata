import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckoutOrder
{
    @Test
    public void costIsZeroWhenScanningNothing()
    {
        var scanner = new OrderScanner();
        assertEquals(0, scanner.getTotalPrice());
    }
}
