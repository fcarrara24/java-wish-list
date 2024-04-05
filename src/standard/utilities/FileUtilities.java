package standard.utilities;

import standard.object.Regalo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtilities {
    /**
     * scompone e inserisce una lista di <Regalo> all'interno di data.txt
     * lancia un eccezione se nessun file di quel tipo è presente
     * @param regali
     * @throws IOException
     */
    public static void writeData(List<Regalo> regali) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./res/data.txt"))){
            for (Regalo regalo : regali){
                writer.write(regalo.toString()+",");
            }

        } catch (IOException e){
            throw new IOException("file non trovato");
        }

    }

    /**
     * legge i dati da "data.txt" e li inserisce in una lista di dati,
     * lancia un eccezione se non trova il fle
     * @return
     * @throws IOException
     */
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
