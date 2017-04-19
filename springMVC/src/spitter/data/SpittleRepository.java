package spitter.data;

import java.util.List;
import spitter.Spittle;


/**
 * Name: admin
 * Date: 2017/3/27
 * Time: 10:42
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
