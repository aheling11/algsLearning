package Niuke;

public class heapsort {
    public static void heapsort(int[] arr) {
        if (arr == null || arr.length < 2 ) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapinsert(arr, i);
        }

        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }


    }


    public static void heapinsert(int[] arr, int index) {
        while(arr[index] > arr[( index - 1 ) / 2]) {
            swap(arr, (index - 1)/2, index);
            index = (index - 1) / 2;
        }

    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while ( left < size ) {
//            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
//            int largest = index;
//            if ( left + 1 < size) {
//                if (arr[left] > arr[left + 1]) {
//                    largest = left;
//                } else {
//                    largest = left + 1;
//                }
//            }
            largest = arr[index] > arr[largest] ? index : largest;

            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = (index * 2) + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,5,1,6,8,3};
        heapsort(arr);
        printArray(arr);
    }
}
