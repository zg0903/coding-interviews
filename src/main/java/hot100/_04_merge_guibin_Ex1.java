package hot100;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name hot100
 * @date 2023-08-16-21:26
 * @Desc:
 */
public class _04_merge_guibin_Ex1 {

    public static void main(String[] args) {
        int[] arr = { 20 , 15 , 12 , 9 , 18 , 16 , 10 , 8 };

        mergeSort(arr,0,arr.length-1);

        for ( int e : arr ) {
            System.out.print( e + " ");
        }
    }

    public static void mergeSort( int[] arr ,int left ,int right ) {
        if ( left >= right )
            return;
        int mid = (left + right) >> 1;

        mergeSort(arr, left , mid);
        mergeSort(arr, mid+1,right);

        sort(arr,left,mid,right);
    }
    public static void sort( int[] arr, int left,int mid,int right ){
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid + 1;
        int t = 0;

        while ( i <= mid && j <= right ){
            if ( arr[i] < arr[j] )
                temp[t++] = arr[i++];
            else
                temp[t++] = arr[j++];
        }

        while ( i <= mid )
            temp[t++] = arr[i++];
        while ( j <= right )
            temp[t++] = arr[j++];
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}



