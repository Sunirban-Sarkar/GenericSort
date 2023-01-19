package quick;

import sortinterfaces.Sortable;
import sortinterfaces.Swapper;

import java.util.Comparator;

public class Partitioner<E> {
    final private Comparator<E> comparator;
    final private Swapper swapper;

    public Partitioner(Comparator<E> comparator, Swapper swapper) {
        this.comparator = comparator;
        this.swapper = swapper;
    }

    public int partition(Sortable<E> sortableDS, int start, int end, E pivot) {
        var small = start;
        var large = end;
        while (large > small) {
            while (comparator.compare(sortableDS.get(small), pivot) < 0 && small < large) {
                small++;
            }
            while (comparator.compare(sortableDS.get(large), pivot) >= 0 && small < large) {
                large--;
            }
            if (small < large) {
                swapper.swap(small, large);
            }
        }
        return large;
    }
}
