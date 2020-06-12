import java.util.Map;

public class OrderScanner {
	private int total;

	public OrderScanner(Map<String, Double> inventory)
	{
		total = 0;
	}
	
	public int getTotalPrice()
	{
		return total;
	}
	
	public void scan(String name)
	{
		total++;
	}
}
