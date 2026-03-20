import java.io.*;

public class FileOperations {

    public static int[] loadFileIntoArray(String path){
        int[] million_array = new int[1000000];
        int index = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = "X";

            while ((line = bufferedReader.readLine()) != null) {

                if (!line.isEmpty()){
                    million_array[index]=Integer.parseInt(line);
                    index++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading file !" + e.getMessage());
            e.printStackTrace();
        }
        return million_array;
    }

    public static void writeArrayToFile(String fileName, int[] arr){
        try (BufferedWriter bufferwriter = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < arr.length; i++) {
                bufferwriter.write(arr[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error while writing file !" + e.getMessage());
        }
    }

}
