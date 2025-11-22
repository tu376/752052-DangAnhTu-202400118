package hust.soict.dsai.aims.media;

public class MediaComparatorByCostTitle implements java.util.Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        return java.util.Comparator.comparing(Media::getCost)
                         .thenComparing(Media::getTitle)
                         .compare(m1, m2);
    }
}