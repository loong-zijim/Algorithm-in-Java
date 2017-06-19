import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] array) {                        // quick sort first check
        if (array == null) {                                     // check if its null
            return array;                                        // null -> return original array
        }                                                        //
        quickSort(array, 0, array.length - 1);                   // calll real quick sort process, left pointer = 0, right pointer must be (length -1) 
        return array;                                            // after quicksort, return the sorted array
    }

    public void quickSort(int[] array, int left, int right) {    // real quick sort with (array, left p, right p) parameter
        if (left >= right) {                                     // its over, if left pointer pass right pointer
            return;                                              // back...
        }
        
        // define a pivot 
        int pivotPos = partition(array, left, right);            // partition the array with Lp and Rp, and get the pivotPos
        quickSort(array, left, pivotPos - 1);                    // quick sort left part
        quickSort(array, pivotPos + 1, right);                   // quick sort right part
    }

    private int partition(int[] array, int left, int right) {    // partition the array beased on Left pointer and Right pointer
        int pivotIndex = pivotIndex(left, right);                //
        int pivot = array[pivotIndex];

        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            } else if (array[rightBound] >= pivot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }    
    private int pivotIndex(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }
        
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] array = new int[] {4,3,2,1};
        array = qs.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
