package ch2;

/**
 * Created by lszhen on 2017/3/26.
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
//    public BlankDisc(){}

    @Override
    public String play() {
        return ("Playing "+title+" by "+artist);
    }
}
