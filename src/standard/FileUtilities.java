package standard;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtilities {
    public static void writeData(List<Regalo> regali) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./res/data.txt"))){
            for (Regalo regalo : regali){
                writer.write(regalo.toString()+",");
            }

        } catch (IOException e){
            throw new IOException("file non trovato");
        }

    }

    public static List<Regalo> readDataAsList() throws  IOException{
        List<Regalo> outList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./res/data.txt"))){
            String line = null;
            while ((line = reader.readLine()) != null){
                String[] arrayLine = line.split(",");
                for(String nome : arrayLine){
                    outList.add(new Regalo(nome));
                }
            }

        } catch (IOException e ){
            throw new IOException("file non trovato");
        }

        return outList;
    }
}
