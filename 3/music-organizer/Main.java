import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();

        MusicCollection favorites = new MusicCollection();

        Music music1 = new Music("Musics Folder", "Taylor Swift", 2017);
        Music music2 = new Music("Musics Folder", "Eminem", 2018);
        Music music3 = new Music("Musics Folder", "Ed Sheeran", 2019);

        pop.addMusic(music1);
        pop.addMusic(music2);
        pop.addMusic(music3);
        country.addMusic(music1);
        favorites.addMusic(music2);

        System.out.println("Listing a playlist:");
        pop.listAllMusics();
        System.out.println();

        pop.search("E");
        System.out.println();

        pop.search("Fold");
        System.out.println();

        System.out.println("Removing a music...\n");
        pop.removeFile(1);

        System.out.println("Listing the playlist:");
        pop.listAllMusics();
        System.out.println();

        System.out.println("Playing a song:");
        pop.startPlaying(1);
        System.out.println();
    }
}