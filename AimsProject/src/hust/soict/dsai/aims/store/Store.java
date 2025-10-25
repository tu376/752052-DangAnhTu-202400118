package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS = 100;
    private DigitalVideoDisc[] itemsStored = new DigitalVideoDisc[MAX_ITEMS];
    private int qtyStored = 0;

    public void addDVD(DigitalVideoDisc disc) {
        if (qtyStored >= MAX_ITEMS) {
            System.out.println("Store is full. Cannot add more DVDs.");
        } else {
            itemsStored[qtyStored] = disc;
            qtyStored++;
            System.out.println("DVD added to store: " + disc.getTitle());
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyStored; i++) {
            if (itemsStored[i].equals(disc)) {
                for (int j = i; j < qtyStored - 1; j++) {
                    itemsStored[j] = itemsStored[j + 1];
                }
                itemsStored[qtyStored - 1] = null;
                qtyStored--;
                System.out.println("DVD removed from store: " + disc.getTitle());
                return;
            }
        }
        System.out.println("DVD not found in store: " + disc.getTitle());
    }

    public void print() {
        System.out.println("All items in store:");
        for (int i = 0; i < qtyStored; i++) {
            System.out.println(itemsStored[i].toString());
        }
    }
}
