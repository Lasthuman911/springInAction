package book.effectivejava.number46;

/**
 * Name: admin
 * Date: 2017/3/9
 * Time: 15:19
 */
public class ForEacheTest3 {
    public static void main(String[] args) {
        for (Face face : Face.values())
            for (Face facej : Face.values())
                System.out.println(face + " "+facej);
    }
}
