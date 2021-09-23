import java.util.*;
class MaxMin{
    static class Pair{
        int max;
        int min;
    }
    public static Pair getMinMax(int[] arr,int size){
        Pair minmax=new Pair();
        if(size==1){
            minmax.max=arr[0];
            minmax.min=arr[1];
            return minmax;
        }
        if(size>1){
            if(arr[0]>arr[1]){
                minmax.max=arr[0];
                minmax.min=arr[1];
            }else if(arr[1]>arr[0]){
                minmax.max=arr[1];
                minmax.min=arr[0];
            }
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i]>minmax.max){
                minmax.max=arr[i];
            }else if(arr[i]<minmax.min){
                minmax.min=arr[i];
            }
        }
        return minmax;

    }


    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
 
    }

}