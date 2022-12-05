//*/ На вход некоторому исполнителю
// подаётся два числа (a, b).

// У исполнителя есть две команды
// - команда 1 (к1): увеличить в с раз (xC), а умножается на c
// - команда 2 (к2): увеличить на d ( +d ), к a прибавляется d
// написать программу, которая выдаёт общее количество
// возможных преобразований a в b.

// a < b; a, b, c, d - натуральные

// Пример 1: а = 2, b = 7, c = 2, d = 1 ответ 3

// Подумать как можно показать хотя бы один маршрут преобразования

// ответ: (+1) (x2) (+1) или (х2) (+1) (+1) (+1)
// Пример 2: а = 11, b = 7, c = 2, d = 1
// ответ: нет решения. */
public class sem {
    public static int myMeth(int a, int b, int c, int d) {
        if (a > b) {
            return 0;
        }
        if (a == b) {
            return 1;
        } else {
            return myMeth(a + d, b, c, d) + myMeth(a * c, b, c, d);
        }

    }

    public static String PMeth(int a, int b, int c, int d) {
        if (a > b) {
            System.out.println("Число " + a + "больше числа " + b);
        }
        if (a == b) {
            System.out.println("Число " + a + "равно числу " + b);
        }
        String res = "";
        while (b > a) {
            if (b % c == 0) {
                res += String.format(" %d*", c);
                // System.out.printf("*%d ", c);
                b = b / c;
            } else {
                res += String.format(" %d+", d);
                // System.out.printf("+%d ", d);
                b -= d;
            }
        }

        return res;
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        int a = 22;
        int b = 20220;
        int c = 3;
        int d = 1;
        System.out.println(myMeth(a, b, c, d));
        // String temp = PMeth(3, 27, 2, 3);
        // System.out.println(reverseString(temp));
    }
}