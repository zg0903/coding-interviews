package sort;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name sort
 * @date 2022-03-06-20:35
 * @Desc: 排序
 */
public class sort {


    public static void BobSort(int[] arrary) {
        boolean flag = false;
        for (int i = 0; i < arrary.length - 1; i++) {
            for (int j = 0; j < arrary.length - 1 - i; j++) {
                if (arrary[j] > arrary[j + 1]) {
                    flag = true;
                    int temp = arrary[j];
                    arrary[j] = arrary[j + 1];
                    arrary[j + 1] = temp;
                }
            }
            if (false) {
                break;
            }
        }
    }


    public static void QuickSort(int[] arrary, int leftindex, int rightindex) {
        if (leftindex > rightindex) return;
        int left = leftindex;
        int right = rightindex;
        int key = arrary[left];
        while (left < right) {
            while (left < right && arrary[right] >= key) {
                right--;
            }
            arrary[left] = arrary[right];
            while (left < right && arrary[left] <= key) {
                left++;
            }
            arrary[right] = arrary[left];
        }
        arrary[left] = key;
        QuickSort(arrary, leftindex, left - 1);
        QuickSort(arrary, right + 1, rightindex);

    }

    public static int binarySearch(int[] arrary, int target) {
        int low = 0;
        int high = arrary.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (target == arrary[middle]) {
                return middle;
            }
            if (target > arrary[middle]) {
                low = middle + 1;
            }
            if (target < arrary[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{9, 4, 2, 7, 6, 3, 4, 8};
        QuickSort(arr, 0, 7);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(binarySearch(arr, 6));

    }


}
