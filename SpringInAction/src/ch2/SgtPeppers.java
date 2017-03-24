package ch2; /**
 * Created by admin on 2017/2/4.
 */
import org.springframework.stereotype.Component;


@Component//表示此类为组件类，不需要显示的配置
public class SgtPeppers implements CompactDisc
{
    private String title = "sgt.title";
    private String artist = "sgt.artist";
    public void play()
    {
        System.out.println("Playing"+title+" by "+artist);
        //注意这里若使用println，则输出是带有下一行的
    }
}
