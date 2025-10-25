public class Cart {
    private int qtyOrdered = 0;
    public static final int MAX_NUMBERS_ORDERS = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERS];

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered >= 20) {
            System.out.println("Your cart is full!");
        } else {
            itemsOrdered[this.qtyOrdered] = disc;
            this.qtyOrdered++;
            System.out.println("Add successfully!");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (dvdList.length + qtyOrdered > MAX_NUMBERS_ORDERS) {
            System.out.println("There is not enough space!");
            return;
        } for (DigitalVideoDisc disc: dvdList) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered > 18) {
            System.out.println("There is not enough space!");
            return;
        }
        itemsOrdered[qtyOrdered] = dvd1; qtyOrdered++;
        itemsOrdered[qtyOrdered] = dvd2; qtyOrdered++;
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < this.qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < this.qtyOrdered-1; j++) {
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                itemsOrdered[this.qtyOrdered-1] = null;
                this.qtyOrdered--;
                System.out.println("Remove successfully!");
                return;
            }
        } System.out.println("DVD is not found in cart!");
    }

    public float totalCost() {
        float total = 0f;
        for (int i = 0; i < this.qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void check(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println(itemsOrdered[i].toString());
                return;
            }
        } System.out.println("Cannot find that type of dvd!");
    }
    public void check(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(id)) {
                System.out.println(itemsOrdered[i].toString());
                return;
            }
        } System.out.println("Cannot find that type of dvd!");
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
}
