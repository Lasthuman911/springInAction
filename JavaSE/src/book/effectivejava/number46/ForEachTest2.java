package book.effectivejava.number46;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**原意是想输出一对骰子所有可能的滚法
 * Name: admin
 * Date: 2017/3/9
 * Time: 15:15
 */
public class ForEachTest2 {
    public static void main(String[] args) {
        Collection<Face> faces = Arrays.asList(Face.values());
        for (Iterator<Face> i = faces.iterator(); i.hasNext();)
            for (Iterator<Face> j = faces.iterator(); j.hasNext();)
                System.out.println(i.next() +" "+j.next());
    }
}
/*
    ONE ONE
    TWO TWO
    THREE THREE
    FOUR FOUR
    FIVE FIVE
    SIX SIX
*/
