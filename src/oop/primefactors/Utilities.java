package oop.primefactors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilities {

    public static List<Integer> getPrimeFactors(int zahl) {

        List<Integer> isPrimZahl = new ArrayList<>();

        if (zahl == 1) {
            return new ArrayList<>();
        }
        else if(zahl <= 0) {
            throw new IllegalArgumentException();
        }

        for (int i : primzahlBerechnung(zahl)) {
            if (zahl == i) {
                isPrimZahl.add(zahl);
                return isPrimZahl;
            }

            while (zahl%i == 0) {
                zahl /= i;
                isPrimZahl.add(i);
            }

        }
        return isPrimZahl;
    }

    public static List<Integer> primzahlBerechnung(int zahl) {
        boolean[] isPrimzahl = new boolean[zahl + 1];
        Arrays.fill(isPrimzahl, true);

        List<Integer> primzahlen = new ArrayList<>();

        for (int i = 2; i <= zahl; i++) {
            if (isPrimzahl[i]) {
                primzahlen.add(i);

                // Sieb des Eratosthenes
                for (int j = i * i; j <= zahl; j += i) {
                    if (j < 0 || j >= isPrimzahl.length) {
                        continue;
                    }
                    isPrimzahl[j] = false;
                }
            }
        }

        return primzahlen;
    }



    public static int gcd(int zahl1, int zahl2) {
        List<Integer> primeFactors1 = getPrimeFactors(zahl1);
        List<Integer> primeFactors2 = getPrimeFactors(zahl2);

        int gcd = 1;

        int index1 = 0, index2 = 0;
        while (index1 < primeFactors1.size() && index2 < primeFactors2.size()) {
            int prime1 = primeFactors1.get(index1);
            int prime2 = primeFactors2.get(index2);

            if (prime1 == prime2) {
                gcd *= prime1;
                index1++;
                index2++;
            }
            else if (prime1 < prime2) {
                index1++;
            }
            else {
                index2++;
            }
        }

        return gcd;
    }

    public static int lcm(int zahl1, int zahl2) {
        if (zahl1 <= 0 || zahl2 <= 0) {
            throw new IllegalArgumentException();
        }

        return (zahl1 * zahl2) / gcd(zahl1, zahl2);

    }
}
