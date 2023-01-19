package bubble;

import sortinterfaces.Sort;
import sortinterfaces.SortSupport;
import sortinterfaces.Sortable;
import sortinterfaces.Swapper;

import java.util.Comparator;

public class BubbleSort<E> implements Sort<E>, SortSupport<E> {
    private Comparator<E> comparator = null;
    private Swapper swapper = null;
    @Override
    public void sort(Sortable<E> collection) {
        var n = collection.size();
        for(int i=0;i<n-1;i++){
            boolean flag = false;
            for (int j = 0; j < n-1-i; j++) {
                if(comparator.compare(collection.get(j),
                        collection.get(j+1))>0){
                    swapper.swap(j, j+1);
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }


    @Override
    public void setComparator(Comparator<E> comparator) {
        this.comparator = comparator;
    }


    @Override
    public void setSwapper(Swapper swapper) {
        this.swapper = swapper;
    }
}
