package AlgorythmLesson1;
import java.util.Arrays;
//Пирамидальая сортировка
public class Main {
    public static void main( String[] args )
    {
        int[] intArray = new int[] {3,4,1,2,5,8,5,1,3,5,1,8};
        heapSort(intArray);        
        System.out.println(Arrays.toString(intArray));
    }
    private static void heapSort(int[] intArray)
    {
        for (int i = intArray.length / 2 - 1; i >= 0; i--) {
            heapify(intArray, i, intArray.length);
        }

        for (int i = intArray.length - 1; i >= 0; i--)
        {
            int temp = intArray[0];
            intArray[0] = intArray[i];
            intArray[i] = temp;

            heapify(intArray, 0, i);
        }
    }
    private static void heapify(int[] intArray, int parent, int size)
    {
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        int maxValue = intArray[parent];
        int maxIndex = parent;
        System.out.println(size);

        if (leftChild < size && intArray[leftChild] > maxValue) {
            maxValue = intArray[leftChild];           
            maxIndex = leftChild;
        }
        if (rightChild < size && intArray[rightChild] > maxValue) {
            maxValue = intArray[rightChild];           
            maxIndex = rightChild;
        }
        if (maxIndex != parent) {
            intArray[maxIndex] = intArray[parent];
            intArray[parent] = maxValue;
            heapify(intArray, maxIndex, size);
        }

        
        System.out.println(Arrays.toString(intArray));
    } 

}
