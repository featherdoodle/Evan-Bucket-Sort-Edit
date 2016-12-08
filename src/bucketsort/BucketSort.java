package bucketsort;




import java.util.*;




public class BucketSort {


    /**
     * method to sort an array of numbers from lowest to highest using
     * bucket sort
     * pre: takes in an array of unsorted numbers and the highest value of the array
     * post: returns a list of sorted numbers
     * @param input
     * @param max
     * @return 
     */
    public int[] sort(int[] input, int max) {
        //creating an array to store the output (the sorted list)
        int[] listOutput = new int[input.length];//its the length of the input
        
        int bucketRange = 10; //the size of the buckets is 10 values
        int bucketCount = max/bucketRange; //calculating the number of buckets needed
        
        //Create a list of buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= bucketCount; i++) {
            buckets.add(new ArrayList<>()); //adding array lists for each individual bucket
        }
        //Add the numbers to the buckets
        for (int i = 0; i < input.length; i++) {
            //finding the bucket where the number should be placed
            int bucketIndex = (input[i]) / bucketRange;
            //finfing the index where the value should be placed
            int index = getIndex(buckets.get(bucketIndex), input[i]);
            buckets.get(bucketIndex).add(index, input[i]);//finding the proper index to put the new value
        }


        //putting the values in the final list. (merging the buckets into one list)
        int counter = 0; //a counter to keep track of the output array index
        for(int i = 0; i < buckets.size(); i++){ //iterating through the buckets
            //iterating through the length of the buckets
            for(int j = 0; j < buckets.get(i).size(); j++){
                listOutput[counter] = buckets.get(i).get(j);
                counter++; //incrementing the counter
            }
        }
        return listOutput;
    }
    
    /**
     * Method to get the proper index of the bucket where the value fits
     * (so the bucket doesn't need to be sorted later)
     * pre: requires the array of the bucket and the value to be inserted into the bucket
     * post: returns the index of the value
     * @param bucket
     * @param value
     * @return 
     */
    public int getIndex(ArrayList<Integer> bucket, int value){
        int size = bucket.size();
        int index = 0;
        if(bucket.isEmpty()){
            index = 0;
        }else if(value <= bucket.get(0)){
            index = 0;
        }else if(value > bucket.get(size-1)){
            index = size;
        }else{
            for(int i = 0; i < size; i++){
                if((value > bucket.get(i))&&(value <= bucket.get(i+1))){
                    index = i+1;
                }
            }
        }
        return index;
    }
    
    /////////////REVERSE ORDER///////////////////
    
    /**
     * method to sort an array of numbers from highest to lowest using
     * bucket sort
     * pre: takes in an array of unsorted numbers and the highest value of the array
     * post: returns a list of sorted numbers
     * @param input
     * @param max
     * @return 
     */
     public int[] reverseSort(int[] input, int max) {
         
        int[] listOutput = new int[input.length];//its the length of the input
        
        int bucketRange = 10; //the size of the buckets is 10 values
        int bucketCount = max/bucketRange; //calculating the number of buckets needed
        
        //Create a list of buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= bucketCount; i++) {
            buckets.add(new ArrayList<>()); //adding array lists for each individual bucket
        }
        //Add the numbers to the buckets
        for (int i = 0; i < input.length; i++) {
            //finding the bucket where the number should be placed
            int bucketIndex = (input[i]) / bucketRange;
            //finfing the index where the value should be placed
            int index = getIndex(buckets.get(bucketIndex), input[i]);
            buckets.get(bucketIndex).add(index, input[i]);//finding the proper index to put the new value
        }


        //putting the values in the final list. (merging the buckets into one list)
        int counter = listOutput.length-1;  //this is where reverse is different from regular
        for(int i = 0; i < buckets.size(); i++){ //iterating through the buckets
            //iterating through the length of the buckets
            for(int j = 0; j < buckets.get(i).size(); j++){
                listOutput[counter] = buckets.get(i).get(j);
                counter--; //incrementing the counter
            }
        }
        return listOutput;
    }
    
}





