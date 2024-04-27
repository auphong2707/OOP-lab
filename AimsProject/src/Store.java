
public class Store {
	private final int MAX_SIZE = 100000;
	
	private DigitalVideoDisc[] itemsInStore;
	private int qtyStore = 0;
	
	public Store() {
		itemsInStore = new DigitalVideoDisc[MAX_SIZE];
	}

	public void addDVD(DigitalVideoDisc disc) {
		// Check if the DVD is already in the store
		for(int i = 0; i < qtyStore; ++i) {
			if(itemsInStore[i].equals(disc)) {
				System.out.println("The disc is already in the store!");
				return;
			}
		}
		
		// Add to the store
		itemsInStore[qtyStore++] = disc;
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		// Find position of the disc
		int discPosition = -1;
		for (int i = 0; i < qtyStore; ++i) {
			if (itemsInStore[i].equals(disc)) {
				discPosition = i;
				break;
			}
		}
		
		if (discPosition == -1) {
			System.out.println("The disc is not in the store");
			return;
		}
		
		for(int i = discPosition; i < qtyStore; ++i) {
			if(i == qtyStore - 1) {
				itemsInStore[i] = null;
			}
			else itemsInStore[i] = itemsInStore[i + 1];
		}
		qtyStore -= 1;
		System.out.println("The disc has been removed successfully");
	}
}
