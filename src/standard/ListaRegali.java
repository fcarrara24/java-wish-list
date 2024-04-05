package standard;

import java.io.IOException;
import java.util.*;

public class ListaRegali {
    public static boolean ordineAlfabetico(){
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String ordine = "";
        while(!flag){
            System.out.print("selezionare se si preferisce vedere la lista filtrata in ordine alfabetico \"a\" o inverso \"i\" ");
            ordine = sc.nextLine();

            switch (ordine.toLowerCase()){
                case "a":
                    return true;
                case "i":
                    return false;
            }
        }
        return true;
    }

    public static Regalo insertRegalo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome regalo: ");
        String nome = sc.nextLine();
        return new Regalo(nome);
    }

    public static  String stampaLista(List<Regalo> lista){
        Iterator<Regalo> it = lista.iterator();
        StringBuilder outString = new StringBuilder();
        while(it.hasNext()){
            outString.append(it.next()).append(",");
        }
        return outString.toString();
    }
    public static void main(String[] args) {



        List<Regalo> lista =  new ArrayList<>();
        try{
            lista = FileUtilities.readDataAsList();
        } catch (IOException e){
            System.out.println("file not found");
        }

        //inserimento file nello stack della sita
        boolean continua = true;
        Scanner scan = new Scanner(System.in);
        while(continua){
            System.out.print("inserire un nuovo elemento? y/n ");
            String res = scan.nextLine().toLowerCase();
            if(res.equals("n")) continua = false;
            else lista.add(insertRegalo());
        }


        //stampo la lista come data in input
        System.out.println("lista originale: "+stampaLista(lista));


        //ordinamento stringa passo il parametro ordine per decretare tra A-Z o Z-A
        boolean ordine = ordineAlfabetico();

        Collections.sort(lista, new ComparatoreRegali(ordine));
        System.out.println("lista ordinata: "+stampaLista(lista));


        //salvo in un file la lista
        try {
            FileUtilities.writeData(lista);
        } catch (IOException e) {
            throw new RuntimeException("file di salvataggio non trovato");
        }
    }
}
