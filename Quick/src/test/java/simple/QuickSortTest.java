package simple;

import org.junit.Assert;
import org.junit.Test;
import quick.Partitioner;
import quicksort.QuickSort;
import support.ArraySwapper;
import support.ArrayWrapper;

import java.util.Comparator;

public class QuickSortTest {
    private void assertLeftHalf(Integer[] array, int cutIndex, Integer pivot) {
        for (int i = 0; i < cutIndex; i++) {
            Assert.assertTrue(array[i] < pivot);
        }
    }

    private void assertRightHalf(Integer[] array, int cutIndex, Integer pivot) {
        for (int i = cutIndex; i < array.length; i++) {
            Assert.assertTrue(array[i] >= pivot);
        }
    }

    @Test
    public void partitionInArray() {
        final var partitionThis = new Integer[]{0, 7, 6, 2};
        final var swapper = new ArraySwapper<>(partitionThis);
        final var partitioner = new Partitioner<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        }, swapper);
        final Integer pivot = 6;
        final int cutIndex = partitioner.partition(new ArrayWrapper<>(partitionThis),
                0, partitionThis.length-1, pivot);
        Assert.assertEquals(2, cutIndex);
        assertLeftHalf(partitionThis, cutIndex, pivot);
        assertRightHalf(partitionThis, cutIndex, pivot);
    }

    @Test
    public void canSortStrings(){
        final var actualNames = new String[]{"Shayam", "Ram", "Allu", "Mahesh", "Bhuvam"};
        final var expected = new String[]{"Allu", "Bhuvam", "Mahesh", "Ram", "Shayam"};
        var sort = new QuickSort<>(String::compareTo, new ArraySwapper<>(actualNames));
        sort.sort(new ArrayWrapper<>(actualNames));
        Assert.assertArrayEquals(expected, actualNames);
    }
}
