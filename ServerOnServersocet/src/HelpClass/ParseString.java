package HelpClass;

import ProdanoGame.DimaSpas;

import java.util.ArrayList;
import java.util.Scanner;

public class ParseString {
    public static ArrayList<Integer> parserString(String in){
        ArrayList<Integer> rez= new ArrayList<>();
        if(in!=null){
            Scanner scanner = new Scanner(in);
            while (scanner.hasNextInt()) {
                rez.add(scanner.nextInt());
            }
        }
        return rez;
    }
    public static String parserArray(ArrayList<Integer> inp){
        String rez = "";
        for (int i = 0; i < inp.size(); i++) {
            rez+=String.valueOf(inp.get(i))+' ';
        }
        return rez;
    }
    public static ArrayList<String> parserArrayDimaSpas(ArrayList<DimaSpas> inp) {
        ArrayList<String> rez = new ArrayList<>();
        String a1 = "", a2 = "";
        for (int i = 0; i < inp.size(); i++) {
            Integer a = poisk(inp, i);
            a1 += inp.get(a).getNedCol() + " ";
            a2 += inp.get(a).getMonCol() + " ";

        }
        rez.add(a1);
        rez.add(a2);
        return rez;
    }
    private static Integer poisk(ArrayList<DimaSpas> inp, Integer a){
        for (int i = 0; i < inp.size(); i++) {
            if(inp.get(i).getNumPlayer()==a){
                return i;
            }
        }
        return 0;
    }
}
