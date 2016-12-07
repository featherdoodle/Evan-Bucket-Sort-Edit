/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketsort;


import java.util.*;


public class BucketSort {


    /**
     * method to sort an array of numbers from lowest to highest using
     * bucket sort
     * pre: takes in an array of unsorted numbers and the highest value of the array
     * post: prints out a list of sorted numbers and 
     * @param input
     * @param max
     * @return 
     */
    public int[] sort(int[] input, int max) {
        //creating an array to store the output (the sorted list)
        int[] listOutput = new int[input.length];//its the length of the input
        int bucketCount = input.length/10;//the number of buckets used
        /*if(input.length >= 32){
            bucketCount = (input.length/32);//each bucket contains 32 values
        }else{
            bucketCount = 10;//with smaller numbers, use 10 buckets
        }*/
        
        int size = max/bucketCount;
        //Create a list of buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>()); //adding array lists for each individual bucket
        }
        //Add the numbers to the buckets
        for (int i = 0; i < input.length; i++) {
            int bucketIndex = (input[i]) / size;
            int index = getIndex(buckets.get(bucketIndex), input[i]);
            buckets.get(bucketIndex).add(index, input[i]);//finding the proper index to put the new value
        }

        //putting the values in the final list. (merging the buckets into one list)
        int counter = 0; 
        for(int i = 0; i < buckets.size(); i++){
            for(int j = 0; j < buckets.get(i).size(); j++){
                listOutput[counter] = buckets.get(i).get(j);
                counter++;
            }
        }
        
        return listOutput;
    }
    /**
     * 
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
    
     public int[] reverseSort(int[] input, int max) {
         
        int[] listOutput = new int[input.length];
        int bucketCount = 10;//(int)Math.ceil(input.length/32);
        int size = max/bucketCount;
        //Creat a list of bucket 
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        //Add the numbers to the buckets
        for (int i = 0; i < input.length; i++) {
            int bucketIndex = (input[i]) / size;
            int index = getIndex(buckets.get(bucketIndex), input[i]);
            buckets.get(bucketIndex).add(index, input[i]);
        }
        /*this is where it varies from normal order. the counter goes backwards 
        so it merges the buckets in reverse order*/
        int counter = listOutput.length-1; 
        for(int i = 0; i < buckets.size(); i++){
            for(int j = 0; j < buckets.get(i).size(); j++){
                listOutput[counter] = buckets.get(i).get(j);
                counter--;
            }
        }
        
        return listOutput;
    }
    
}
