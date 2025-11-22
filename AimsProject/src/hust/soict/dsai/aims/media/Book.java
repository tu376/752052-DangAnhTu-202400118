package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
    private final ArrayList<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author already exists!");
        } else {
            authors.add(authorName);
            System.out.println("Author added successfully.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author removed successfully.");
        } else {
            System.out.println("Author not found!");
        }
    }
    @Override
    public String toString() {
        return "Book - " + super.toString() + ", Authors: " + String.join(", ", authors);
    }
}
