
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full" );
			return;
		}
		
		itemsOrdered[qtyOrdered] = disc;
		qtyOrdered += 1;
		System.out.println("The disc has been added");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for(DigitalVideoDisc disc : dvdList) {
			addDigitalVideoDisc(disc);
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int discPosition = -1;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; ++i) {
			if (itemsOrdered[i].equals(disc)) {
				discPosition = i;
				break;
			}
		}
		
		if (discPosition == -1) {
			System.out.println("The disc is not in the cart");
			return;
		}
		
		for(int i = discPosition; i < MAX_NUMBERS_ORDERED; ++i) {
			if(i == MAX_NUMBERS_ORDERED - 1) {
				itemsOrdered[i] = null;
			}
			else itemsOrdered[i] = itemsOrdered[i + 1];
		}
		qtyOrdered -= 1;
		System.out.println("The disc has been removed successfully");
	}

	public float totalCost() {
		float result = 0f;
		for(DigitalVideoDisc item : itemsOrdered) {
			if (item == null) break;
			result += item.getCost();
		}
		
		return result;
	}
}
