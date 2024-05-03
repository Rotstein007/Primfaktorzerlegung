package oop.primefactors;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static List<Integer> getPrimeFactors(int Zahl) {
        if (Zahl == 1) {
            return new ArrayList<>();
        }
        else if(Zahl <= 0) {
            throw new IllegalArgumentException();
        }

    }

    public List<Integer> PrimzahlBerechnung (int Zahl) {

        List<Integer> list = new ArrayList<Integer>();

        Zahl = Zahl/2;
        for (int i = 1; i <= Zahl; i++) {
                list.add(Integer.ValueOf(i));
            }
        list.remove(new Integer(1));

        }

    }

    public static void gcd() {

    }

    public static void lcm() {

    }

}
