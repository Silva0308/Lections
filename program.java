//задана натуральная степень k. Формируем многочлен
import java.util.Scanner; // импорт сканера

public class program {
    public static void main(String[] args) {

        Scanner k = new Scanner(System.in);
        System.out.println("Введите натуральную степень k: ");
        int number = k.nextInt();// считывает число и присваивает значение в number
        int[] arr = new int[number]; // создаем массив размера k
        for (int i = 0; i < number; i++) {
            arr[i] = (int) (Math.random() * 11); // заполнняем случайными числами до 10
        }
        String res = "";
        int i = 0;
        int j = number;
        while (number > 1) {
            if (arr[i] != 0) {
                res += arr[i] + "x^" + number + "+";
                number--;
                i++;
            } else {
                i++;
            }
        }
        res += arr[j - 2] + "x+" + arr[j - 1] + "=0";
        System.out.print(res);
    }
}