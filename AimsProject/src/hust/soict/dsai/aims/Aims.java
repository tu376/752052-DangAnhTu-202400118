package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc[] discs = {
        new DigitalVideoDisc("Action", "Mad Max: Fury Road", "George Miller", 120, 19.99f),
        new DigitalVideoDisc("Sci-Fi", "Interstellar", "Christopher Nolan", 169, 24.99f),
        new DigitalVideoDisc("Animation", "Spirited Away", "Hayao Miyazaki", 125, 18.50f),
        new DigitalVideoDisc("Adventure", "Jurassic Park", "Steven Spielberg", 127, 15.75f),
        new DigitalVideoDisc("Fantasy", "Harry Potter and the Sorcerer's Stone", "Chris Columbus", 152, 20.00f),
        new DigitalVideoDisc("Drama", "The Shawshank Redemption", "Frank Darabont", 142, 22.00f),
        new DigitalVideoDisc("Comedy", "The Grand Budapest Hotel", "Wes Anderson", 99, 17.25f),
        new DigitalVideoDisc("Horror", "Get Out", "Jordan Peele", 104, 16.80f),
        new DigitalVideoDisc("Romance", "La La Land", "Damien Chazelle", 128, 21.50f),
        new DigitalVideoDisc("Documentary", "Free Solo", "Jimmy Chin", 100, 14.99f)
        };
        Scanner s = new Scanner(System.in);
        Cart an0der = new Cart();
        while (true) {
            System.out.println("Please enter command (add, remove, total, exit):");
            String cmd = s.next();
            if (cmd.equals("add")) {
                System.out.println("Type of DVD you want to add:");
                int type = s.nextInt();
                if (type > 0 && type < 11) {
                    an0der.addDigitalVideoDisc(discs[type-1]);
                }
                else {
                    System.out.println("Error!");
                }
            } else if (cmd.equals("remove")) {
                System.out.println("Type of DVD you want to remove:");
                int type = s.nextInt();
                if (type > 0 && type < 11) {
                    an0der.removeDigitalVideoDisc(discs[type-1]);
                } else {
                    System.out.println("Error!");
                }
            } else if (cmd.equals("total")) {
                System.out.println("Total cost of yout cart: " + an0der.totalCost());
            } else if (cmd.equals("exit")) {
                return;
            } else {
                System.out.println("Wrong command. Please try again!");
            }
        }
    }   
}

// This is aims project.