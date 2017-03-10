package book.effectivejava.number46;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**,正确做法1
 * Name: admin
 * Date: 2017/3/9
 * Time: 8:37
 */
enum Face {
    ONE, TWO, THREE, FOUR, FIVE, SIX
}

public class ForEachTest1 {
    public static void main(String[] args) {
        //values: Returns an array containing the constants of this enum type, in the order they are declared.
        Collection<Face> faces = Arrays.asList(Face.values());
        for (Iterator<Face> i = faces.iterator();i.hasNext();){
            Face iFace = i.next();
            for (Iterator<Face> j = faces.iterator(); j.hasNext();)
                System.out.println(iFace +" "+j.next());
        }
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
