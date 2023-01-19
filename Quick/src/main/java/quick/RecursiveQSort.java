package quick;

import sortinterfaces.Sortable;
import sortinterfaces.Swapper;

import java.util.Comparator;

public class RecursiveQSort<E> {
    final private Comparator<E> comparator;
    final private Swapper swapper;

    public RecursiveQSort(Comparator<E> comparator, Swapper swapper) {
        this.comparator = comparator;
        this.swapper = swapper;
    }

    public void qSort(Sortable<E> sortableDs, int start, int end) {
        if (start < end) {
            final var pivot = sortableDs.get(start);
            final var partitioner = new Partitioner<E>(comparator, swapper);
            var cutIndex = partitioner.partition(sortableDs, start, end, pivot);
            if (cutIndex == start) {
                cutIndex++;
            }
            qSort(sortableDs, start, cutIndex - 1);
            qSort(sortableDs, cutIndex, end);
        }
    }
}
