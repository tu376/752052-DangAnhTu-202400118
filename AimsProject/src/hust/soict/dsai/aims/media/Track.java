package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;
    private String artist; // optional

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
        this.artist = "";
    }

    // New constructor used in AimsProject: title, artist, length
    public Track(String title, String artist, int length) {
        this.title = title;
        this.artist = artist == null ? "" : artist;
        this.length = length;
    }
    @Override
    public void play() {
        System.out.println("Playing track: " + getTitle());
        System.out.println("Track length: " + getLength());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Track other = (Track) obj;
        return title.equals(other.title) && length == other.length && ((artist == null && other.artist == null) || (artist != null && artist.equals(other.artist)));
    }
    @Override
    public String toString() {
        return "Track - Title: " + title + ", Artist: " + artist + ", Length: " + length;
    }
}