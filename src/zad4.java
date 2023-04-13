import java.io.*;
import java.util.Random;

public class zad4 {


    public static void main(String[] args) {
        int w = 5;
        int k = 4;

        Random rng = new Random();
        double[][] tab = new double[w][k];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < k; j++) {
                tab[i][j] = rng.nextDouble() * 10;
            }
        }


        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("tab.bin"))) {
            out.writeInt(w);
            out.writeInt(k);
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < k; j++) {
                    out.writeDouble(tab[i][j]);
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisywania pliku binarnego");
        }


        double[][] tab2 = null;
        try (DataInputStream in = new DataInputStream(new FileInputStream("tab.bin"))) {
            int rows2 = in.readInt();
            int cols2 = in.readInt();
            tab2 = new double[rows2][cols2];
            for (int i = 0; i < rows2; i++) {
                for (int j = 0; j < cols2; j++) {
                    tab2[i][j] = in.readDouble();
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas odczytywania pliku binarnego");
        }


        if (tab2 != null) {
            for (int i = 0; i < tab2.length; i++) {
                for (int j = 0; j < tab2[i].length; j++) {
                    System.out.print(tab2[i][j] + " ");
                }
                System.out.println();
            }


            double max = tab2[0][0];
            int maxW = 0;
            int maxK = 0;
            for (int i = 0; i < tab2.length; i++) {
                for (int j = 0; j < tab2[i].length; j++) {
                    if (tab2[i][j] > max) {
                        max = tab2[i][j];
                        maxW = i;
                        maxK = j;
                    }
                }
            }
            System.out.printf("Element o wartości maksymalnej to "+max+", o indeksach ["+maxW+"]["+maxK+"].");
        }
    }
}