package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.*;

public class Aims {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Store anStore = new Store();
        Cart discs = new Cart();
        ArrayList<Media> mediae = new ArrayList<>();
        mediae.add(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87));
        mediae.add(new CompactDisc(2, "Thriller", "Pop", 15.99f, 42, "Michael Jackson", "Various Artists"));
        mediae.add(new Book(3, "The Great Gatsby", "Fiction", 10.99f));
        // while (true) 
        //     System.out.println("Please enter command (add, remove, total, exit):");
        //     String cmd = s.next();
        //     if (cmd.equals("add")) {
        //         System.out.println("Type of DVD you want to add:");
        //         int type = s.nextInt();
        //         if (type > 0 && type < 11) {
        //             an0der.addMedia(discs[type-1]);
        //         }
        //         else {
        //             System.out.println("Error!");
        //         }
        //     } else if (cmd.equals("remove")) {
        //         System.out.println("Type of DVD you want to remove:");
        //         int type = s.nextInt();
        //         if (type > 0 && type < 11) {
        //             an0der.removeMedia(discs[type-1]);
        //         } else {
        //             System.out.println("Error!");
        //         }
        //     } else if (cmd.equals("total")) {
        //         System.out.println("Total cost of yout cart: " + an0der.totalCost());
        //     } else if (cmd.equals("exit")) {
        //         return;
        //     } else {
        //         System.out.println("Wrong command. Please try again!");
        //     }
        // }
        for (Media media: mediae) {
            System.out.println(media.toString());
        }
    }   
}

// This is aims project.