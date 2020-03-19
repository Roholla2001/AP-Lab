import java.util.ArrayList;
// mistake #1: forgetting to import Iterator class
import java.util.Iterator;

public class MusicOrganizer {
    private ArrayList<String > tracks;

    // mistake #2: forgetting constructor
    public MusicOrganizer() {
        tracks = new ArrayList<String>();
    }

    // mistake #3: you cant remove tracks without adding them!
    public void addTrack(String track) {
        tracks.add(track);
    }

    public void removeTrack(String nameLike) {
        // mistake #4: removing from a list, using a regular for loop and not an iterator
        Iterator<String> it = tracks.iterator();
        while(it.hasNext()) {
            if(it.next().contains(nameLike))
                it.remove();
        }
    }
}
