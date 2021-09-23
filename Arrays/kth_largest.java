import java.util.Iterator;
import java.util.PriorityQueue;

public class kth_largest {

    public static void FirstKelements(int[] arr,int size,int k){
        PriorityQueue<Integer> firstk= new PriorityQueue<>();
        for(int i=0;i<k;i++){//first add the initial elements untill it achieves the size of k 
            firstk.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(firstk.peek()>arr[i]){
                continue;
            }else{
                firstk.poll();
                firstk.offer(arr[i]);
            }
        }
        // System.out.println(firstk.peek());// gives the kth largest element

        Iterator iterator =firstk.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    public static void main (String[] args)

    {
        int arr[] = { 11, 3, 2, 1, 15, 5, 4,
                        45, 88, 96, 50, 45 };
            
        int size = arr.length;
            
        // Size of Min Heap
        int k = 3;
            
        FirstKelements(arr, size, k);
    }
}
