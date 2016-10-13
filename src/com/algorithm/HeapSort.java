package com.algorithm;

/**
 * Created by chuck7 on 16/10/13.
 */
public class HeapSort {
    public static void sort(int[] arr){
        if(arr.length < 2){
            return;
        }
        for(int i = (arr.length - 2) / 2; i > -1; i--){
            _adjust(arr,i,arr.length-1);
        }
        for(int i = arr.length -1; i > 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            _adjust(arr,0,i-1);
        }
    }
    private static void _adjust(int[] arr, int start, int end){
        int value = arr[start];
        //调整start位置节点,使该节点为顶点的子树成为二叉树
        int j;
        for(j = start * 2 + 1;j < end + 1; j = start * 2 +1){
            if(j < end && arr[j] > arr[j + 1]){
                j++;
            }
            if(value < arr[j]){
                break;
            }
            //这里是直接赋值而不是交换,
            //因为用不着交换,
            arr[start] = arr[j];
            start = j;
        }
        arr[start] = value;
    }
    public static void main(String args[]){
        int[] array = {23,10,54,254,5,6,45,56,73,2,4,636,34};
        sort(array);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
