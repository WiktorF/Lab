import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class zad3 {
    public static int[][] tworzTab(int wiersze, int kolumny) {
        if(wiersze < 0){
            wiersze *= (-1);
        }
        if(kolumny < 0){
            kolumny *= (-1);
        }
        Random rng = new Random();
        int[][] tab = new int[wiersze][kolumny];
        for (int i = 0; i < wiersze; i++) {
            for (int j = 0; j < kolumny; j++) {
                tab[i][j] = rng.nextInt(100);
            }
        }
        return tab;
    }
    public static  void zapiszTab(int tab[][], String FileName) throws IOException {
        FileWriter plik = new FileWriter(FileName);
        plik.write("Macierz \n");
        plik.write("Liczba wierszy "+tab.length+"\n");
        plik.write("Liczba kolumn "+tab[0].length+"\n");
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                plik.write(tab[i][j] + " ");
            }
            plik.write("\n");
        }
        plik.close();

    }

    public static int[][] wczytajTabzPliku(String FileName) throws FileNotFoundException {
        File file = new File(FileName);
        int[][] tab = null;
        Scanner in = new Scanner(file);
        in.nextLine();
        in.next();
        in.next();
        int liczbaWierszy = in.nextInt();
        in.next();
        in.next();
        int liczbaKolumn = in.nextInt();
        tab = new int[liczbaWierszy][liczbaKolumn];
        for (int i = 0; i < liczbaWierszy; i++) {
            for (int j = 0; j < liczbaKolumn; j++) {
                tab[i][j] = in.nextInt();
            }
        }
        in.close();
        return tab;
    }

    public static void wypiszTab(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                System.out.format("%4d", tab[i][j]);
            }
            System.out.println();
        }
    }
    public static String Max(int[][] tab){
        int max = tab[0][0];
        int wiersz = 0;
        int kolumna = 0;
        for(int i=0; i<tab.length; i++){
            for(int j=0; j<tab[0].length; j++){
                if(tab[i][j] > max){
                    max = tab[i][j];
                    wiersz = i;
                    kolumna = j;
                }
            }
        }
        return "Maksymalna wartość macierzy to "+max+" o indeksach "+"["+wiersz+"]["+kolumna+"].";
    }


    public static void main(String[] args) throws IOException {
        int[][] tab = tworzTab(10, -8);

        zapiszTab(tab, "test");

        int[][] tab1 = wczytajTabzPliku("test");

        wypiszTab(tab1);
        System.out.println(Max(tab));

    }


}
