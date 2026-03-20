public class SortingAlgorithms {

    public enum PivotStrategy {
        FIRST,
        LAST,
        MIDDLE,
        RANDOM,
        MEDIAN
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high, PivotStrategy pivotStrategy) {
        if (low < high) {
            pivot(arr, low, high, pivotStrategy);

            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1,pivotStrategy);
            quickSort(arr, pi + 1, high, pivotStrategy);
        }
    }

    private static void pivot(int[] arr, int low, int high, PivotStrategy strategy) {
        int pivot = high;

        switch (strategy) {
            case FIRST:
                pivot = low;
                break;
            case MIDDLE:
                pivot = low + (high - low) / 2;
                break;
            case MEDIAN:
                pivot = median(arr,low,low + (high - low) / 2,high);
                break;
            case RANDOM:
                pivot = low + (int)(Math.random() * ((high - low) + 1));
                break;
            default:
                pivot = high;
                break;
        }
        if (pivot != high) {
            int temp = arr[pivot];
            arr[pivot] = arr[high];
            arr[high] = temp;
        }
    }

    private static int median(int[] arr,int a, int b, int c) {
        int valA = arr[a];
        int valB = arr[b];
        int valC = arr[c];

        if ((valA >= valB && valA <= valC) || (valA >= valC && valA <= valB)) return a;
        if ((valB >= valA && valB <= valC) || (valB >= valC && valB <= valA)) return b;
        return c;
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int low, int high, int x) {
        if (x < high-low + 1) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid, x);
            mergeSort(arr, mid + 1, high, x);
            merge(arr, low, mid, high);
        }
        else {
            insertionSort(arr, low, high);
        }
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j+1] = arr[j];
                j =  j - 1;
            }
            arr[j+1] = key;
        }
    }
}
