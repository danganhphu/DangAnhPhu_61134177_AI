package di_truyen;

import java.util.Arrays;
import java.util.Random;

//danganhphu 61134177
public class TSP {
    public int  max = 10000;
    public int[][] khoangcach = {
            {max, 5, 6, 9, max},
            {5, max, 10, 2, 7},
            {6, 10, max, max, 15},
            {9, 2, max, max, 1},
            {max, 7, 15, 1, max}
    };
    public Random random = new Random();
    public static int n = 1000;
    int[][] nghiem = new int [n][];
    int[] thichNghi = new int[n];

    public void khoiTao()
    {
        for (int i = 0; i < n; i++)
        {
            nghiem[i] = new int[5];
            for (int j = 0;j < 5; j++)
                nghiem[i][j] = random.nextInt(5);
        }
    }

    public void danhGiaThichNghi()
    {
        for (int i = 0; i < n; i++)
        {
            thichNghi[i] = 0;
            for(int j = 0; j < 4; j++)
                thichNghi[i] += khoangcach[nghiem[i][j]][nghiem[i][j + 1]];
            for(int j = 0;j < 4; j++)
                for (int t = j + 1; t < 5; t++)
                    if (nghiem[i][j] == nghiem[i][t])
                        thichNghi[i]+= 100000;
        }
    }

    public void chonLoc()
    {
        int [] temp = thichNghi.clone();
        Arrays.sort(temp);
        int nguong = temp[n * 80 / 100];
        for (int i = 0; i < n; i++) {
            if (thichNghi[i] > nguong) {
                nghiem[i] = nghiem[random.nextInt(n)].clone();
            }
        }
    }

    public void laiGhep() {
        for (int i = 0; i < 20; i++) {
            int cha = random.nextInt(n);
            int me = random.nextInt(n);
            for (int j = 0; j < nghiem[cha].length; j++)
                if (random.nextInt(2) == 1) {
                    int temp = nghiem[cha][j];
                    nghiem[cha][j] = nghiem[me][j];
                    nghiem[me][j] = temp;
                }
        }
    }

    public void dotBien()
    {
        int index = random.nextInt(n);
        int bit = random.nextInt(5);
        nghiem[index][bit] = random.nextInt(5);
    }

    public void inKetQua() {
        int [] temp = thichNghi.clone();
        Arrays.sort(temp);
        int best = temp[0];
        System.out.print(best + ": ");
        for (int i = 0; i < n; i++){
            if (thichNghi[i] == best){
                for (int j = 0; j< nghiem[i].length; j++)
                    System.out.print(nghiem[i][j] + " ,");
                System.out.println();
                break;
            }
        }
    }

}
