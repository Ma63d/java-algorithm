package com.algorithm;

/**
 * Created by chuck7 on 16/10/12.
 */
import java.util.*;
public class MergeSort {
    public static void sort(int[] array,int start,int end){
        if(array.length < 2){
            return;
        }
        int mid = (int)Math.floor((start + end) / 2);
        if(start < mid){
            sort(array,start,mid);
        }
        if(end > 1 + mid){
            sort(array,mid+1,end);
        }
        int i = start,j = mid + 1,z = 0;
        int[] tempArr = new int[end-start+1];
        while((i < mid + 1 ) && ( j < end + 1)){
            if(array[i] > array[j]){
                tempArr[z] = array[j];
                j++;
                z++;
            }else{
                tempArr[z] = array[i];
                i++;
                z++;
            }
        }
        if(i < mid + 1){
            while(i < mid + 1){
                tempArr[z] = array[i];
                i++;
                z++;
            }
        }
        if(j < end + 1){
            while(j < end + 1){
                tempArr[z] = array[j];
                j++;
            }
        }
        for(i = 0;i < end + 1 - start;i++){
            array[i+start] =  tempArr[i];
        }
    }
    public static void main (String[] args){
        int[] array = {23,342,54,23,5,6,45,56,73,2,4,636,34};
        sort(array,0,array.length-1);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
