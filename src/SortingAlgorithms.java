public class SortingAlgorithms {

    public enum PivotStrategy {
        FIRST,
        LAST,
        MIDDLE,
        RANDOM,
        MEDIAN
    }

    public static int partition(int[] arr, int low, int high) {
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
        if ((arr[a] - arr[b]) * (arr[c] - arr[a]) >= 0) return a;
        else if ((arr[b] - arr[a]) * (arr[c] - arr[b]) >= 0) return b;
        else return c;
    }

}
