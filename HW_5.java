import java.util.Scanner;

public class HW_5 {
    public static int inputNum() {
        Scanner iScanner = new Scanner(System.in);
        int num;
        do {
            System.out.println("Введите целое число: ");
            while (!iScanner.hasNextInt()) {
                System.out.println("Это не число!");
                iScanner.next();
            }
            num = iScanner.nextInt();
        } while (num <= 0);
        iScanner.close();
        return num;
    }

    public static int triangle(int n) {
        int res = n * (n + 1) / 2;
        return res;
    }

    public static void main(String[] args) {
        int n = inputNum();
        int res = triangle(n);
        System.out.println(n + " треугольное число: " + res);

    }
}
