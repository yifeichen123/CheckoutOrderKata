import java.util.HashMap;
import java.util.Map;

public class OrderScanner {
	private double total;
	private Map<String, Double> inventory;

	public OrderScanner(Map<String, Double> inventory)
	{
		this.inventory = inventory;
		total = 0;
	}
	
	public double getTotalPrice()
	{
		return total;
	}
	
	public void scan(String name)
	{
		total += inventory.get(name);
	}

	public void add(String itemName, double price)
	{
		inventory.put(itemName, price);
	}

	public static void main(String[] args)
	{
		HashMap<String, Double> inventory = new HashMap<String, Double>();
        inventory.put("orange juice", 2.5);
		System.out.println(inventory.get("orange juice"));
	}


}
