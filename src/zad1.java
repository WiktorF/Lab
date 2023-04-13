import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class zad1 {
    public static void main(String[] args) throws IOException {
        File plik = new File("dane.txt");
        Scanner in = new Scanner(plik);

        float suma1 = 0;
        float suma2 = 0;
        float suma3 = 0;
        float suma4 = 0;

        int idx = 0;
        int licz = 0;


        while(in.hasNext()){
            licz++;
            float dane = in.nextFloat();
            if(idx == 0){
                idx++;
            }
            else if(idx == 1){
                suma1 += dane;
                idx++;
            }
            else if(idx == 2){
                suma2 += dane;
                idx++;
            }
            else if(idx == 3){
                suma3 += dane;
                idx++;
            }
            else if(idx == 4){
                suma4 += dane;
                idx = 0;
            }

        }
        licz /= 5;

        float sr1 = suma1/licz;
        float sr2 = suma2/licz;
        float sr3 = suma3/licz;
        float sr4 = suma4/licz;

        FileWriter zad1 = new FileWriter("zad1.txt");
        zad1.write("Ilosc wczytanych wierszy z danymi "+licz+ " średnie wartosci dla kazdej z kolumn: kolumna2 = "+sr1+" kolumna3 = "+sr2+ " kolumna 4 = "+sr3+ " kolumna5 = "+sr4);
        zad1.close();

    }
}
