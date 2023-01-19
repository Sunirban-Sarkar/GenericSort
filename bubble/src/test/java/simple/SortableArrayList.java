package simple;

import sortinterfaces.Sortable;

import java.util.ArrayList;

public class SortableArrayList<E> implements Sortable {
    final private ArrayList<E> actualNames;

    SortableArrayList(ArrayList<E> actualNames) {
        this.actualNames = actualNames;
    }

    @Override
    public E get(int i) {
        return actualNames.get(i);
    }

    @Override
    public int size() {
        return actualNames.size();
    }
}
