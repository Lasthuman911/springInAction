package springinaction.soundsystem;

import java.util.List;

/**
 * Created by admin on 2017/2/6.
 */
public class BlankDisk implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

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
