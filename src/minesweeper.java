import java.util.Scanner;
import java.util.Random;

public class minesweeper {
    static String[][] mayinTarlasiAlani(int a, int b) {
        Random randomNumber = new Random();
        String[][] area = new String[a][b];

        int low = 0;
        int highA = a;
        int highB = b;
        int mine = a * b / 4;
        int i = 0;

        while (i < mine) {
            int randomrow = randomNumber.nextInt(highA - low) + low;
            int randomcol = randomNumber.nextInt(highB - low) + low;
            if (area[randomrow][randomcol] != " * ") {
                area[randomrow][randomcol] = " * ";
                i++;
            }
        }
        for (i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (area[i][j] != " * ") {
                    area[i][j] = " - ";
                }
            }
        }
        return area;
    }

    static void print(String[][] area) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                System.out.print(area[i][j]);
            }
            System.out.println();
        }
    }

    static String[][] bosAlan(int a, int b) {
        String[][] bosAlan = new String[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                bosAlan[i][j] = " - ";
            }
        }
        return bosAlan;
    }

    static String[][] check(String[][] alan, String[][] bosAlan, int x, int y) {
        int mine = x * y / 4;
        int kalan = (x * y) - mine;

        boolean devam = true;

        while (devam) {
            Scanner input = new Scanner(System.in);
            System.out.print("Satir seciniz : ");
            int a = input.nextInt();
            System.out.print("Sutun seciniz : ");
            int b = input.nextInt();

            if (a < 0 || a >= x || b < 0 || b >= y) {
                System.out.println("Hatali deger girdiniz");
                continue;
            }
            if (alan[a][b].equals(" * ")) {
                System.out.println("===================Oyun Bitti===================");
                System.out.println("==================Mayin Tarlasi=================");
                minesweeper.print(alan);
                devam = false;
                break;
            } else if (alan[a][b].equals(bosAlan[a][b])) {
                int count = 0;
                for (int i = -1; i <= 1; i++) {
                    if (((a + i) < 0) || (a + i >= alan.length)) {
                        continue;
                    }
                    for (int j = -1; j <= 1; j++) {
                        if (((b + j) < 0) || (b + j >= alan.length)) {
                            continue;
                        }
                        if (alan[a + i][b + j].equals(" * ")) {
                            count++;
                        }
                    }
                }
                bosAlan[a][b] = " " + count + " ";
                minesweeper.print(bosAlan);
                kalan--;
            }
            System.out.println("kalan bosluk : " + kalan);
            if (kalan == 0) {
                System.out.println("win");
                break;
            }
        }
        return alan;
    }
}
