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
		scan(name, 1);
	}

	public void scan(String name, double weight)
	{
	    Double unitPrice = inventory.get(name);
	    if (unitPrice == null)
		{
			throw new OrderScanner.ItemNotInInventoryException();
		}
		total += weight * unitPrice;
	}

	public void add(String itemName, double price)
	{
		inventory.put(itemName, price);
	}

	public static void main(String[] args)
	{
		HashMap<String, Double> inventory = new HashMap<>();
        inventory.put("orange juice", 2.5);
		System.out.println(inventory.get("orange juice"));
	}

	public void markdown(String name, double discount)
	{
		var originalPrice = this.inventory.get(name);
		var discountedPrice = originalPrice - discount;
		this.inventory.replace(name, discountedPrice);
	}

	public class ItemNotInInventoryException extends RuntimeException
	{
		
	}

}
