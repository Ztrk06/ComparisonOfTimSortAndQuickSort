public class Main {

    public static void quickSort_Operations(int[] arrayType, SortingAlgorithms.PivotStrategy pivotStrategy,String fileName) {
        int[] temp = arrayType.clone();
        long startTime = System.currentTimeMillis();
        SortingAlgorithms.quickSort(temp,0,arrayType.length-1, pivotStrategy);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time of " + fileName + ": " +(int)(endTime - startTime)+" ms");
        FileOperations.writeArrayToFile(fileName,temp);
    }

    public static void timSort_Operations(int[] arrayType,int x,String fileName){
        int[] temp = arrayType.clone();
        long startTime = System.currentTimeMillis();
        SortingAlgorithms.mergeSort(temp,0,arrayType.length-1,x);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time of " + fileName + ": " +(int)(endTime - startTime)+" ms");
        FileOperations.writeArrayToFile(fileName,temp);
    }

    public static void main(String[] args){

        int[] randomArray = FileOperations.loadFileIntoArray("random.txt");
        int[] semi_orderedArray = FileOperations.loadFileIntoArray("semi_ordered.txt");
        int[] increasingArray = new int[1000000];
        int[] decreasingArray = new int[1000000];


        for(int i = 0; i < increasingArray.length; i++){
            increasingArray[i] = i;
            decreasingArray[decreasingArray.length-i-1] = i;
        }

        timSort_Operations(randomArray,64,"timsort_random_out.txt");
        quickSort_Operations(randomArray, SortingAlgorithms.PivotStrategy.FIRST,"quicksort_first_random_out.txt");
        quickSort_Operations(randomArray, SortingAlgorithms.PivotStrategy.LAST,"quicksort_last_random_out.txt");
        quickSort_Operations(randomArray, SortingAlgorithms.PivotStrategy.MIDDLE,"quicksort_middle_random_out.txt");
        quickSort_Operations(randomArray, SortingAlgorithms.PivotStrategy.RANDOM,"quicksort_random_random_out.txt");
        quickSort_Operations(randomArray, SortingAlgorithms.PivotStrategy.MEDIAN,"quicksort_median_random_out.txt");
        System.out.println();
        timSort_Operations(semi_orderedArray,64,"timsort_semi_ordered_out.txt");
        quickSort_Operations(semi_orderedArray, SortingAlgorithms.PivotStrategy.FIRST,"quicksort_first_semi_ordered_out.txt");
        quickSort_Operations(semi_orderedArray, SortingAlgorithms.PivotStrategy.LAST,"quicksort_last_semi_ordered_out.txt");
        quickSort_Operations(semi_orderedArray, SortingAlgorithms.PivotStrategy.MIDDLE,"quicksort_middle_semi_ordered_out.txt");
        quickSort_Operations(semi_orderedArray, SortingAlgorithms.PivotStrategy.RANDOM,"quicksort_random_semi_ordered_out.txt");
        quickSort_Operations(semi_orderedArray, SortingAlgorithms.PivotStrategy.MEDIAN,"quicksort_median_semi_ordered_out.txt");
        System.out.println();
        timSort_Operations(increasingArray,64,"timsort_increasing_out.txt");
        quickSort_Operations(increasingArray, SortingAlgorithms.PivotStrategy.FIRST,"quicksort_first_increasing_out.txt");
        quickSort_Operations(increasingArray, SortingAlgorithms.PivotStrategy.LAST,"quicksort_last_increasing_out.txt");
        quickSort_Operations(increasingArray, SortingAlgorithms.PivotStrategy.MIDDLE,"quicksort_middle_increasing_out.txt");
        quickSort_Operations(increasingArray, SortingAlgorithms.PivotStrategy.RANDOM,"quicksort_random_increasing_out.txt");
        quickSort_Operations(increasingArray, SortingAlgorithms.PivotStrategy.MEDIAN,"quicksort_median_increasing_out.txt");
        System.out.println();
        timSort_Operations(decreasingArray,64,"timsort_decreasing_out.txt");
        quickSort_Operations(decreasingArray, SortingAlgorithms.PivotStrategy.FIRST,"quicksort_first_decreasing_out.txt");
        quickSort_Operations(decreasingArray, SortingAlgorithms.PivotStrategy.LAST,"quicksort_last_decreasing_out.txt");
        quickSort_Operations(decreasingArray, SortingAlgorithms.PivotStrategy.MIDDLE,"quicksort_middle_decreasing_out.txt");
        quickSort_Operations(decreasingArray, SortingAlgorithms.PivotStrategy.RANDOM,"quicksort_random_decreasing_out.txt");
        quickSort_Operations(decreasingArray, SortingAlgorithms.PivotStrategy.MEDIAN,"quicksort_median_decreasing_out.txt");
    }
}
