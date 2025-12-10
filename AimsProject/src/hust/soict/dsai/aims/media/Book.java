package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
    private final ArrayList<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // New constructor used in AimsProject: no id
    public Book(String title, String category, float cost) {
        super(0, title, category, cost);
    }

    // New constructor to accept initial authors list
    public Book(String title, String category, float cost, List<String> initialAuthors) {
        super(0, title, category, cost);
        if (initialAuthors != null) {
            for (String a : initialAuthors) {
                if (a != null && !a.trim().isEmpty()) {
                    this.authors.add(a.trim());
                }
            }
        }
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