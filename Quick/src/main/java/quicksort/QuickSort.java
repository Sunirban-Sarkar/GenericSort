package quicksort;

import quick.RecursiveQSort;
import sortinterfaces.Sort;
import sortinterfaces.Sortable;
import sortinterfaces.Swapper;

import java.util.Comparator;

public class QuickSort<E> implements Sort<E> {
    final private Comparator<E> comparator;
    final private Swapper swapper;

    public QuickSort(Comparator<E> comparator, Swapper swapper) {
        this.comparator = comparator;
        this.swapper = swapper;
    }

    @Override
    public void sort(Sortable<E> collection) {
        final var qsort = new RecursiveQSort<E>(comparator, swapper);
        qsort.qSort(collection, 0, collection.size()-1);
    }
}
