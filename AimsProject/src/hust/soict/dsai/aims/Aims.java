package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.*;

public class Aims {
    private static Store store = new Store();   // instance of Store
    private static Cart cart = new Cart();      // instance of Cart
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some sample media so the store isn't empty when running interactively
        seedStore();

        int choice;
        do {
            showMenu();
            choice = readIntInRange(0, 3);
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    // ---------------- HELPERS ----------------
    private static int readIntInRange(int min, int max) {
        while (true) {
            System.out.print("Choose: ");
            String line = scanner.nextLine();
            try {
                int val = Integer.parseInt(line.trim());
                if (val < min || val > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private static float readFloat() {
        while (true) {
            String line = scanner.nextLine();
            try {
                return Float.parseFloat(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter a float value: ");
            }
        }
    }

    private static void seedStore() {
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87));
        store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 124));
        store.addMedia(new Book(3, "The Lord of the Rings", "Fantasy", 29.99f));
        // Add a sample CD
        // CompactDisc constructor: (int id, String title, String category, float cost, int length, String director, String artist)
        CompactDisc cd = new CompactDisc(4, "Hits", "Pop", 15.0f, 40, "Various", "Various Artists");
        cd.addTrack(new Track("Song1", 3));
        cd.addTrack(new Track("Song2", 4));
        store.addMedia(cd);
    }

    // ---------------- MAIN MENU ----------------
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void viewStore() {
        store.print(); // display all items
        int choice;
        do {
            storeMenu();
            choice = readIntInRange(0, 4);
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // ---------------- MEDIA DETAILS MENU ----------------
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.findByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            int choice;
            do {
                mediaDetailsMenu();
                choice = readIntInRange(0, 2);
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        System.out.println("Added to cart.");
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 0);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.findByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Added to cart.");
            if (media instanceof DigitalVideoDisc) {
                System.out.println("Number of DigitalVideoDiscs in cart: " + cart.countDVDs());
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.findByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else if (media != null) {
            System.out.println("This media cannot be played.");
        } else {
            System.out.println("Media not found.");
        }
    }

    // ---------------- UPDATE STORE ----------------
    public static void updateStore() {
        System.out.println("Update Store: ");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        int choice = readIntInRange(1, 2);
        if (choice == 1) {
            // Example: add DigitalVideoDisc
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            System.out.print("Enter cost: ");
            float cost = readFloat();
            Media media = new DigitalVideoDisc(0, title, category, cost, "Unknown", 0);
            store.addMedia(media);
            System.out.println("Media added.");
        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media m = store.findByTitle(title);
            if (m != null) {
                store.removeMedia(m);
                System.out.println("Media removed.");
            } else {
                System.out.println("Media not found in store.");
            }
        }
    }

    // ---------------- CART MENU ----------------
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void seeCurrentCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = readIntInRange(0, 5);
            switch (choice) {
                case 1:
                    cart.filter();
                    break;
                case 2:
                    cart.sort();
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine();
                    // Find media by title in cart items
                    Media toRemove = null;
                    for (Media m : cart.getItemsOrdered()) {
                        if (m.getTitle().equalsIgnoreCase(title)) {
                            toRemove = m;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        cart.removeMedia(toRemove);
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    System.out.println("Order created!");
                    cart.clear();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}