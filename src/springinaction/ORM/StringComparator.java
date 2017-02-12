package springinaction.ORM;

import java.util.Comparator;

/**
 * Created by wzm on 2017/2/12 0012.
 */
public class StringComparator implements Comparator<String> {

    private boolean sortOrderAscending = true;
    public StringComparator(boolean sortOrderAscending)
    {
        this.sortOrderAscending = sortOrderAscending;
    }
    @Override
    public int compare(String o1, String o2) {
        int result = o1.compareTo(o2);

        return sortOrderAscending ? result : -result;
    }
}
