//tournament method
class Tournament{

    static class Pair{
        int min;
        int max;

    }

    public static Pair getMinMax(int[] arr,int l,int h){
        Pair minmax= new Pair();
        Pair mml= new Pair();
        Pair mmr= new Pair();
        int mid;

        if(l==h){//means single element is present
            minmax.min=arr[l];
            minmax.max=arr[h];
            return minmax;
        }
        if(h==l+1){
            if(arr[l]>arr[h]){
                minmax.min=arr[h];
                minmax.max=arr[l];
            }else if(arr[h]>arr[l]){
                minmax.min=arr[l];
                minmax.max=arr[h];
            }
            return minmax;
        }
        mid=(l+h)/2;
        mml=getMinMax(arr,l,mid);
        mmr=getMinMax(arr,mid+1,h);

        //compare minimum of two parts
        if(mml.min<mmr.min){
            minmax.min=mml.min;
        }else if(mmr.min<mml.min){
            minmax.min=mmr.min;
        }
        if(mml.max>mmr.max){
            minmax.max=mml.max;

        }else if(mmr.max>mmr.max){
            minmax.max=mmr.max;
        }

        return minmax;
    }


    public static void main(String args[]) {
    int arr[] = {1000, 11, 445, 1, 330, 3000};
    int arr_size = 6;
    Pair minmax = getMinMax(arr, 0, arr_size - 1);
    System.out.printf("\nMinimum element is %d", minmax.min);
    System.out.printf("\nMaximum element is %d", minmax.max);

    }
}