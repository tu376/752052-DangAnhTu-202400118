package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.*;
import java.util.*;

public class Cart {
    private int qtyOrdered = 0;
    public static final int MAX_NUMBERS_ORDERS = 20;
    private final ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media disc) {
        if (this.qtyOrdered >= MAX_NUMBERS_ORDERS) {
            System.out.println("Your cart is full!");
        } else {
            itemsOrdered.add(disc);
            this.qtyOrdered++;
            System.out.println("Add successfully!");
        }
    }

    public void addMedia(ArrayList<Media> List) {
        if (List.size() + qtyOrdered > MAX_NUMBERS_ORDERS) {
            System.out.println("There is not enough space!");
            return;
        } for (Media disc: List) {
            itemsOrdered.add(disc);
            qtyOrdered++;
        }
    }

    public void addMedia(Media dvd1, Media dvd2) {
        if (qtyOrdered > 18) {
            System.out.println("There is not enough space!");
            return;
        }
        itemsOrdered.add(dvd1); qtyOrdered++;
        itemsOrdered.add(dvd2); qtyOrdered++;
    }

    public void removeMedia(Media disc) {
        for (Media i: itemsOrdered) {
            if (i.equals(disc)) {
                itemsOrdered.remove(i);
                System.out.println("Remove successfully!");
                return;
            }
        } System.out.println("DVD is not found in cart!");
    }

    public float totalCost() {
        float total = 0f;
        for (Media i: itemsOrdered) {
            total += i.getCost();
        }
        return total;
    }
}
