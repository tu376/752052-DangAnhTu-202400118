package hust.soict.dsai.aims.media;

import java.util.*;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The track is already in the list");
        } else {
            tracks.add(track);
            System.out.println("The track has been added");
        }
    }
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("The track has been removed");
        } else {
            System.out.println("The track is not in the list");
        }
    }
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super();
        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
        this.artist = artist;
    }
}
