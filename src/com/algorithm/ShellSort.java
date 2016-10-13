package com.algorithm;

/**
 * Created by chuck7 on 16/10/13.
 */
public class ShellSort {
    public static void sort(int[] arr){
        if(arr.length < 2){
            return;
        }
        int growth = 1;
        while(growth < arr.length / 3){
            //先计算出growth可取的最大值,
            //在后面的代码中,growth不断减小,从而实现希尔排序的缩小增量排序
            growth = growth * 3 + 1;
        }
        while(growth > 0){
            _sortWithGrowth(arr,growth);
            growth = (growth - 1)/3;
        }
    }
    private static void _sortWithGrowth(int[] arr,int growth){
        for(int i = 0;i < growth;i++){
            for(int j = i + growth;j < arr.length; j += growth){
                int temp = arr[j];
                int z = j - growth;
                while(z >= i){
                    if(arr[z] <= temp){
                        break;
                    }
                    arr[z+growth] = arr[z];
                    z -= growth;
                }
                arr[z + growth] = temp;
            }
        }
    }

    public static void main(String args[]){
        int[] array = {23,10,54,254,5,6,45,56,73,2,4,636,34};
        sort(array);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
