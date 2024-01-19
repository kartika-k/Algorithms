public class mergeSort {

    //TC- O(n logn)  and SC-O(n)
    public static void MergeSort(int arr[], int si, int ei){
        //base case
        if(si >= ei){
            return;
        }
        //Kaam
        int mid = si + (ei-si)/2;
        MergeSort(arr, si, mid);        //Left Part
        MergeSort(arr, mid+1, ei);      //Right Part
        merge(arr, si, mid, ei);
    }

    //merge method to merge the sorted part
    public static void merge(int arr[], int si, int mid , int ei){
        //Arrays indexing is start from 0. so we need to add 1
        //left(0,3) = 4 and right(4,6) = 3 --> 6-0+1
        int temp[] = new int[ei - si +1];
        int i = si;     //index for 1st sorted part
        int j = mid+1;  //index for 2nd sorted part
        int k = 0;      //index for temp

        while(i<=mid && j<=ei ){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
                // k++;
            }else{
                temp[k] = arr[j];
                j++;
                // k++;
            }
            k++;
        }
        //For leftOver elements of 1st sorted part
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        //For leftover elements of 2nd sorted part
        while(j <= ei){
            temp[k++] = arr[j++];
        }
        //Copy temp to original array
        for(k=0, i=si; k<temp.length; k++,i++){
            arr[i] = temp[k];
        }
    }

    public static void PrintArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[] = {6,3,9,5,2,8};
        MergeSort(arr,0,arr.length-1);
        PrintArray(arr);
    }
}
