import java.util.Scanner;

/**
 * // На вход
 * // некоторому исполнителю
 * // подаётся четыре числа (a, b, c, d).
 * // У исполнителя есть две команды
 * // - команда 1 (к1): увеличить в с раз, а умножается на c
 * // - команда 2 (к2): увеличить на d , к a прибавляется d
 * // написать программу, которая выдаёт общее количество
 * // возможных преобразований a в b
 * // набор команд, позволяющий число a превратить в число b или сообщить, что
 * это
 * // невозможно
 * // Пример 1: а = 1, b = 7, c = 2, d = 1
 * // ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
 * // Пример 2: а = 11, b = 7, c = 2, d = 1
 * // ответ: нет решения.
 * // *Подумать над тем, как сделать вывод маршрута (хотя бы одного)
 * Тестовые данные
 * a: 2 b: 7 c: 2 d: 1 -> 3
 * a: 3 b: 27 c: 3 d: 2 -> 6
 * a: 30 b: 345 c: 5 d: 6 -> 0
 * a: 30 b: 345 c: 2 d: 1 -> 7047
 * a: 22 b: 333 c: 3 d: 1 -> 467
 * a: 55 b: 555 c: 5 d: 2 -> 30
 * a: 22 b: 2022 c: 11 d: 56 -> 0
 * a: 22 b: 2022 c: 11 d: 10 -> 18
 * a: 22 b: 2022 c: 3 d: 1 -> 763827
 * a: 22 b: 20220 c: 3 d: 1 -> 535173226980
 * a: 1 b: 1111 c: 2 d: 1 -> 3990330794
 * a: 1 b: 11111 c: 2 d: 1 -> 606408167570737286
 */
public class HW_3 {
    public static int[] myMeth(int a, int b, int c, int d) {
        int[] newArr = new int[b + 1];
        newArr[a] = 1;
        for (int i = 0; i <= b; i++) {
            if (i % c == 0 && i / c > 0) {
                newArr[i] += newArr[i / c];
            }
            if (i > a && i - d > 0) {
                newArr[i] += newArr[i - d];
            }
        }
        return newArr;
    }

    public static String mPath(int a, int b, int c, int d, int[] array) {
        String res = "";
        while (b > a) {
            if (b % c == 0 && array[b/c] != 0) {
                res = String.format(" *%d", c) + res;
                b = b / c;
            } else {
                res = String.format(" +%d", d) + res;
                b -= d;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите целое число от которого двигаемся: ");
        int a = iScanner.nextInt();
        System.out.printf("Введите конечное целое число: ");
        int b = iScanner.nextInt();
        System.out.printf("Введите множитель: ");
        int c = iScanner.nextInt();
        System.out.printf("Введите слагаемое: ");
        int d = iScanner.nextInt();
        iScanner.close();
        int[] res = myMeth(a, b, c, d);
        if (res[b] == 0) {
            System.out.println("Нет решения!");
        } else {
            System.out.println("Количество возможных путей из " + a + " в " + b + ": " + res[b]);
            System.out.println(mPath(a, b, c, d, res));
        }
    }
}