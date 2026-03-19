import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {

    public static int[] loadFile_generateArray(String path){
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


}
