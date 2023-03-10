package simple;

import java.util.Comparator;

public class StringComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        try {
            final String f = (String) o1;
            final String s = (String) o2;
            return f.compareTo(s);
        } catch (ClassCastException cce) {
            throw new NonStringElementFoundException("Mixed Elements", cce);
        }
    }
}
