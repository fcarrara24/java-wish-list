package bonus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("inserire una stringa di testo per contare le occorrenze con le quali i ciascun carattere compare");
        String line = sc.nextLine().replaceAll(" ", "");

        char[] charArray = line.toCharArray();
        // map for occurrences
        Map<Character, Integer> occurerences = new HashMap<>();

        for(char c : charArray){
            Integer value = occurerences.get(c);
            if(value != null){
                occurerences.put(c, value + 1);
            } else {
                occurerences.put(c, 1);
            }
        }

        //stampo l'array mappato
        for (char i: occurerences.keySet()){
            System.out.println(i + ": "+occurerences.get(i));
        }

    }
}
