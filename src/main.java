import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Satir sayisi : ");
        int a = input.nextInt();
        System.out.print("Sutun sayisi : ");
        int b = input.nextInt();
        String[][] alan = minesweeper.mayinTarlasiAlani(a, b);
        String[][] bosAlan = minesweeper.bosAlan(a, b);
        minesweeper.print(bosAlan);

//        MineSweeper.print(alan);

        minesweeper.check(alan, bosAlan, a, b);
    }
}