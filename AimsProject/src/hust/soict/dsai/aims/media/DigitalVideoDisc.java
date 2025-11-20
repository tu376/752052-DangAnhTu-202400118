package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {

    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super();
        setTitle(title);           // dùng setter
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super();
        setCategory(category);
        setTitle(title);
        setCost(cost);
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super();
        this.director = director;
        setCategory(category);
        setTitle(title);
        setCost(cost);
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
        setCost(cost);
        setId(++nbDigitalVideoDiscs);
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
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + "$";
    }

    public boolean isMatch(String title) {
        return getTitle().equals(title);
    }

    public boolean isMatch(int id) {
        return getId() == id;
    }
}
