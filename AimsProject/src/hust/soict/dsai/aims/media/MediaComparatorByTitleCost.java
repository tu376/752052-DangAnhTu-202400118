package hust.soict.dsai.aims.media;

public class MediaComparatorByTitleCost implements java.util.Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            return Float.compare(m1.getCost(), m2.getCost());
        }
    }
}
