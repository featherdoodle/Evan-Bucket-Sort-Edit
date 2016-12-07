/*
 * Program finished on December 8, 2016 to demonstrate Bucket Sort.
 */
package bucketsort;


import java.util.Arrays;
import java.util.Random;




public class Main {
    
    public static void main(String[] args) {

        Random random = new Random();

        int size = 100000; //the number of values that will be generated
        int max = 100000; //the maximum value of the numbers generated


        int[] num = new int[size]; //creating a new array to store the unsorted list


        for (int i = 0; i < size; i++) {
            //iterating through the array and filling it with a random number
            num[i] = random.nextInt(max); 
        }


        //uncomment to print out the unsorted array (faster without printing it)
        //System.out.println(Arrays.toString(num));

        BucketSort bucketSort = new BucketSort();
        //finding the time the sort starts to find sort efficiency
        long startTime = System.nanoTime();
        //calling the sort method and assigning the sorted list to a variable
        int[] sortedList = bucketSort.sort(num, max);
        //int[] sortedList = bucketSort.reverseSort(num, max);
        //finding the time when the sort is finished
        long endTime = System.nanoTime();
        //printing out the sorted list and the time
        //System.out.println(Arrays.toString(sortedList));
        System.out.println("Time: " + (endTime-startTime));
        
        
    }
}

