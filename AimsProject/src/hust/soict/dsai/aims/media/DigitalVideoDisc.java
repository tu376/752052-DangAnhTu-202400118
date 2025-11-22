package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media implements Playable {

    private String director;
    private int length;
    
    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
    @Override
    public String toString() {
        return "DVD - " + super.toString() + ", Director: " + director + ", Length: " + length;
    }
}
