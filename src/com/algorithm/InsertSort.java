package com.algorithm;

/**
 * Created by chuck7 on 16/10/14.
 */
public class InsertSort {
    public static void sort(int[] arr){
        if(arr.length < 2){
            return;
        }
        for(int i = 1;i < arr.length;i++){
            int temp = arr[i];
            int z;
            for(z = i-1;z >= 0;z--){
                if(arr[z] <= temp){
                    break;
                }
                arr[z+1] = arr[z];
            }
            arr[z+1] = temp;
        }
    }
    public static void sort2(int[] arr){
        //上述插入排序过程中存在大量的对元素移动然后插入待排元素的过程,
        //2-路插入排序一般情况下可以使移动次数降低一半,但是要额外占用n个空间;
        //本函数既是2-路插入排序的具体实现;
        if(arr.length < 2){
            return;
        }
        int head,tail = head = 0;
        int[] tempArr = new int[arr.length];
        tempArr[0] = arr[0];
        for(int i =1;i<arr.length;i++){
            if(arr[i] >= tempArr[0]){
                int j = 0;
                while(j <= tail){
                    if(arr[i] > tempArr[j]){
                        j++;
                    }else{
                        break;
                    }
                }
                tail++;
                int z = tail;
                for(;z > j;z--){
                    tempArr[z] = tempArr[z-1];
                }
                tempArr[z] = arr[i];
            }else{
                int j = arr.length - 1;
                if(head == 0){
                    head = j;
                    tempArr[head] = arr[i];
                }else{
                    while(j >= head){
                        if(arr[i] < tempArr[j]){
                            j--;
                        }else{
                            break;
                        }
                    }
                    head--;
                    int z = head;
                    for(;z < j;z++){
                        tempArr[z] = tempArr[z+1];
                    }
                    tempArr[z] = arr[i];
                }
            }
        }
        for(int i = 0;i < arr.length;i++){
            arr[i] = tempArr[(i + head) % arr.length];
        }
    }
    private static class Node{
        //静态链表节点
        int value;
        int next = -1;
        Node(int v){
            this.value = v;
        }
    }
    public static void sort3(int[] arr){
        if(arr.length < 2){
            return;
        }
        Node[] nodeList = new Node[arr.length];
        for(int i = 0; i < arr.length;i++){
            nodeList[i] = new Node(arr[i]);
        }
        Node start = new Node(0);
        start.next = 0;
        Node pointer;
        for(int i = 1;i < arr.length;i++){
            for(pointer = start;(pointer.next != -1) && (nodeList[pointer.next].value < arr[i]);pointer = nodeList[pointer.next]){
            }
            nodeList[i].next = pointer.next;
            pointer.next = i;
        }
        pointer = start;
        int i = 0;
        while(pointer.next != -1){
            pointer = nodeList[pointer.next];
            arr[i] = pointer.value;
            i++;
        }
    }
    public static void main(String args[]){
        System.out.println("直接插入排序: ");
        int[] array = {23,10,54,254,5,6,45,56,73,2,4,636,34};
        sort(array);
        for(int i = 0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        int[] array1 = {23,10,54,254,5,6,45,56,73,2,4,636,34};
        sort2(array1);
        System.out.println("\n2-路插入排序: ");
        for(int i = 0;i<array1.length;i++){
            System.out.print(array[i] + " ");
        }
        int[] array2 = {23,10,54,254,5,6,45,56,73,2,4,636,34};
        sort3(array2);
        System.out.println("\n静态链表插入排序: ");
        for(int i = 0;i<array2.length;i++){
            System.out.print(array2[i] + " ");
        }
    }
}
