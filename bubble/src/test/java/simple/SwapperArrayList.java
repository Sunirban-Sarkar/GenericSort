package simple;

import sortinterfaces.Swapper;

import java.util.ArrayList;

public class SwapperArrayList<E> implements Swapper {
    final private ArrayList<E> actualNames;

    SwapperArrayList(ArrayList<E> actualNames) {
        this.actualNames = actualNames;
    }

    @Override
    public void swap(int i, int j) {
        final E tmp = actualNames.get(i);
        actualNames.set(i, actualNames.get(j));
        actualNames.set(j, tmp);
    }
}
