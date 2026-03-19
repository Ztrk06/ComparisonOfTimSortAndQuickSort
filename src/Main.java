public class Main {

    public static void main(String[] args){

        int[] randomArray = FileOperations.loadFile_generateArray("random.txt");
        int[] semi_orderedArray = FileOperations.loadFile_generateArray("semi_ordered.txt");
        int[] increasingArray = new int[1000000];
        int[] decreasingArray = new int[1000000];


        for(int i = 0; i < increasingArray.length; i++){
            increasingArray[i] = i;
            decreasingArray[decreasingArray.length-i] = i;
        }

    }
}
