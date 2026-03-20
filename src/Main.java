public class Main {

    public static int quickSort_timeMs(int[] arrayType, SortingAlgorithms.PivotStrategy pivotStrategy) {
        int[] temp = arrayType.clone();
        long startTime = System.currentTimeMillis();
        SortingAlgorithms.quickSort(temp,0,arrayType.length-1, pivotStrategy);
        long endTime = System.currentTimeMillis();
        return (int)(endTime - startTime);
    }

    public static int timSort_timeMs(int[] arrayType,int x){
        int[] temp = arrayType.clone();
        long startTime = System.currentTimeMillis();
        SortingAlgorithms.mergeSort(temp,0,arrayType.length-1,x);
        long endTime = System.currentTimeMillis();
        return (int)(endTime - startTime);
    }

    public static void main(String[] args){

        int[] randomArray = FileOperations.loadFile_generateArray("random.txt");
        int[] semi_orderedArray = FileOperations.loadFile_generateArray("semi_ordered.txt");
        int[] increasingArray = new int[1000000];
        int[] decreasingArray = new int[1000000];


        for(int i = 0; i < increasingArray.length; i++){
            increasingArray[i] = i;
            decreasingArray[decreasingArray.length-i-1] = i;
        }




        System.out.println("Total time of timSorted_randomArray: " + timSort_timeMs(randomArray,64) + " ms");

        System.out.println("Total time of quickSorted_randomArray_first: " + quickSort_timeMs(randomArray, SortingAlgorithms.PivotStrategy.FIRST) + " ms");

        System.out.println("Total time of quickSorted_randomArray_last: " + quickSort_timeMs(randomArray, SortingAlgorithms.PivotStrategy.LAST) + " ms");

        System.out.println("Total time of quickSorted_randomArray_middle: " + quickSort_timeMs(randomArray, SortingAlgorithms.PivotStrategy.MIDDLE) + " ms");

        System.out.println("Total time of quickSorted_randomArray_random: " + quickSort_timeMs(randomArray, SortingAlgorithms.PivotStrategy.RANDOM) + " ms");

        System.out.println("Total time of quickSorted_randomArray_median: " + quickSort_timeMs(randomArray, SortingAlgorithms.PivotStrategy.MEDIAN) + " ms");

        System.out.println();

        System.out.println("Total time of timSorted_randomArray: " + timSort_timeMs(semi_orderedArray,64) + " ms");

        System.out.println("Total time of quickSorted_randomArray_first: " + quickSort_timeMs(semi_orderedArray, SortingAlgorithms.PivotStrategy.FIRST) + " ms");

        System.out.println("Total time of quickSorted_randomArray_last: " + quickSort_timeMs(semi_orderedArray, SortingAlgorithms.PivotStrategy.LAST) + " ms");

        System.out.println("Total time of quickSorted_randomArray_middle: " + quickSort_timeMs(semi_orderedArray, SortingAlgorithms.PivotStrategy.MIDDLE) + " ms");

        System.out.println("Total time of quickSorted_randomArray_random: " + quickSort_timeMs(semi_orderedArray, SortingAlgorithms.PivotStrategy.RANDOM) + " ms");

        System.out.println("Total time of quickSorted_randomArray_median: " + quickSort_timeMs(semi_orderedArray, SortingAlgorithms.PivotStrategy.MEDIAN) + " ms");

        System.out.println();

        System.out.println("Total time of timSorted_randomArray: " + timSort_timeMs(increasingArray,64) + " ms");

        System.out.println("Total time of quickSorted_randomArray_first: " + quickSort_timeMs(increasingArray, SortingAlgorithms.PivotStrategy.FIRST) + " ms");

        System.out.println("Total time of quickSorted_randomArray_last: " + quickSort_timeMs(increasingArray, SortingAlgorithms.PivotStrategy.LAST) + " ms");

        System.out.println("Total time of quickSorted_randomArray_middle: " + quickSort_timeMs(increasingArray, SortingAlgorithms.PivotStrategy.MIDDLE) + " ms");

        System.out.println("Total time of quickSorted_randomArray_random: " + quickSort_timeMs(increasingArray, SortingAlgorithms.PivotStrategy.RANDOM) + " ms");

        System.out.println("Total time of quickSorted_randomArray_median: " + quickSort_timeMs(increasingArray, SortingAlgorithms.PivotStrategy.MEDIAN) + " ms");

        System.out.println();

        System.out.println("Total time of timSorted_randomArray: " + timSort_timeMs(decreasingArray,64) + " ms");

        System.out.println("Total time of quickSorted_randomArray_first: " + quickSort_timeMs(decreasingArray, SortingAlgorithms.PivotStrategy.FIRST) + " ms");

        System.out.println("Total time of quickSorted_randomArray_last: " + quickSort_timeMs(decreasingArray, SortingAlgorithms.PivotStrategy.LAST) + " ms");

        System.out.println("Total time of quickSorted_randomArray_middle: " + quickSort_timeMs(decreasingArray, SortingAlgorithms.PivotStrategy.MIDDLE) + " ms");

        System.out.println("Total time of quickSorted_randomArray_random: " + quickSort_timeMs(decreasingArray, SortingAlgorithms.PivotStrategy.RANDOM) + " ms");

        System.out.println("Total time of quickSorted_randomArray_median: " + quickSort_timeMs(decreasingArray, SortingAlgorithms.PivotStrategy.MEDIAN) + " ms");

        System.out.println();


    }
}
