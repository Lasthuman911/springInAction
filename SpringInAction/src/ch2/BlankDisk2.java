package ch2;

import java.util.List;

/**
 * Created by lszhen on 2017/3/26.
 */
public class BlankDisk2 implements CompactDisc {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    private String artist;
    private List<String> tracks;

    public BlankDisk2(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }
    public BlankDisk2(){}

    @Override
    public String play() {
        return ("Playing "+title+" by "+artist);
    }

    public void play2() {
        System.out.println("Playing "+title+" by "+artist);
        for (String track : tracks){
            System.out.println("-Track: "+track);
        }
    }
}
