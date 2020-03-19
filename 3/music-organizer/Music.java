public class Music {
    private String file;
    private String artist;
    private int year;

    public Music(String file, String artist, int year) {
        this.file = file;
        this.artist = artist;
        this.year = year;
    }

    public Music(String file) {
        this.file = file;
        artist = "Unknown";
        year = -1;
    }

    public String getFile() {
        return file;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Artist: " + artist + " | File address: " + file + " | Year: " + year;
    }

}