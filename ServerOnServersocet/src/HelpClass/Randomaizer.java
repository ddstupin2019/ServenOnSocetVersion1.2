package HelpClass;

import java.util.ArrayList;

public class Randomaizer {
    public static ArrayList<Integer> random(Integer min, Integer max) {
        ArrayList<Integer> sd = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Integer a = (int) (Math.random() * ((max - min) + 1)) + min;
            while (true) {
                if (ty(a, sd)) {
                    a = (int) (Math.random() * ((max - min) + 1)) + min;
                } else {
                    sd.add(a);
                    break;
                }
            }
        }
        return sd;
    }

    private static boolean ty(int a, ArrayList<Integer> sd) {
        for (int i = 0; i < sd.size(); i++) {
            if (sd.get(i) == a) {
                return true;
            }
        }
        return false;
    }
}
