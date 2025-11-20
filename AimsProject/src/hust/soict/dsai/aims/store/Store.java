package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;

public class Store {
    public static final int MAX_ITEMS = 100;
    private final ArrayList<Media> itemsInStore = new ArrayList<>();
    private int qtyStored = 0;

    public void addMedia(Media disc) {
        if (qtyStored >= MAX_ITEMS) {
            System.out.println("Store is full. Cannot add more DVDs.");
        } else {
            itemsInStore.add(disc);
            qtyStored++;
            System.out.println("DVD added to store: " + disc.getTitle());
        }
    }

    public void removeMedia(Media disc) {
        for (Media i: itemsInStore) {
            if (i.equals(disc)) {
                itemsInStore.remove(i);
                qtyStored--;
                System.out.println("DVD removed from store: " + disc.getTitle());
                return;
            }
        }
        System.out.println("DVD not found in store: " + disc.getTitle());
    }

    public void print() {
        System.out.println("All items in store:");
        for (Media i: itemsInStore) {
            System.out.println(i.toString());
        }
    }
}
