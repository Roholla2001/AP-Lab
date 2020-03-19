import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Music> musics;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        musics = new ArrayList<Music>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param music The file to be added.
     */
    public void addMusic(Music music)
    {
        musics.add(music);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfMusics()
    {
        return musics.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listMusic(int index)
    {
        System.out.println(musics.get(index));
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllMusics()
    {
        int i = 1;
        for(Music music: musics)
            System.out.println(i++ + ". " + music);
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index))
            musics.remove(index);
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index))
            player.startPlaying(musics.get(index));
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        if(index >= 0 && index < musics.size())
            return true;
        System.out.println("Invalid index!");
        return false;
    }

    public void search(String toBeSearched) {
        Iterator<Music> it = musics.iterator();
        System.out.println("Search result for \"" + toBeSearched + "\":");
        while(it.hasNext()) {
            Music music = it.next();
            if(music.getFile().contains(toBeSearched) || music.getArtist().contains(toBeSearched))
                System.out.println(music);
        }
    }
}