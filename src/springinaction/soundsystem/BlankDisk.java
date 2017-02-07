package springinaction.soundsystem;

import java.util.List;

/**
 * Created by admin on 2017/2/6.
 */
public class BlankDisk implements CompactDisc {
    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void setArtist(String artist) {

        this.artist = artist;
    }

    private String artist;
    private List<String> tracks;

    public  BlankDisk(){}
    public  BlankDisk(String title,String artist,List<String> tracks){
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }
    @Override
    public void play() {
        System.out.println("Playing "+title+" by "+artist);
        for (String track : tracks){
            System.out.println("-track"+track);
        }
    }
}
