package com.algorithm;
public class QuickSort{
    public static void sort(int[] array,int start,int end){
        if(array.length < 2){
            return;
        }
        int pivot = array[start];
        int left = start;
        int right = end;
        while(left < right){
            while(left < right && array[right] >= pivot){
                right--;
            }
            array[left] = array[right];
            while(left < right && array[left] <= pivot){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        if(left - 1 > start){
            sort(array,start,left-1);
        }
        if(left +1 < end){
            sort(array,left +1,end);
        }
    }
    public static void main(String[] args){
        int[] array = {23,342,54,23,5,6,45,56,73,2,4,636,34};
        sort(array,0,array.length-1);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}