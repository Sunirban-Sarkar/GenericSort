package simple;

import bubble.BubbleSort;
import org.junit.Assert;
import org.junit.Test;
import sortinterfaces.Swapper;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortTest {

    @Test
    public void canSortStrings() {
        var actualNames = new ArrayList<>(List.of("Ram", "Allu", "Mahesh", "Bhuvam"));
        var expectedResult = List.of("Allu", "Bhuvam", "Mahesh", "Ram");

        var names = new SortableArrayList<>(actualNames);
        var sort = new BubbleSort<String>();
        sort.setSwapper(new SwapperArrayList<>(actualNames));
        sort.setComparator(String::compareTo);
        sort.sort(names);
        Assert.assertEquals(expectedResult, actualNames);
    }

    @Test
    public void throwsWhateverComparatorDoes() {
        final var actualNames = new ArrayList<>(List.of("", "Bhuvam"));

        final var names = new SortableArrayList<>(actualNames);
        final var sort = new BubbleSort<>();
        final var exception = new RuntimeException();
        sort.setComparator((i,j) -> {
            throw exception;
        });
        final Swapper neverInvoked = null;
        sort.setSwapper(neverInvoked);
        try{
            sort.sort(names);
        }catch (Exception e){
            Assert.assertSame(exception, e);
            return;
        }
        Assert.fail();
    }
}
