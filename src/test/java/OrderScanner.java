
public class OrderScanner {
	private int total;

	public OrderScanner()
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
