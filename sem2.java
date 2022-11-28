//Массив из 12 элементов [-9;9], сумма отрицат и положит эл-тов

public class sem2 {
    public static int[] FillArray(int size, int from, int to) {
        int[] arr = new int[size];
        int range = to - from - 1;
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * range) + from;
        }
        return arr;
    }

    public static void PrintArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

    }

    public static int[] SumPosNeg(int[] array) {
        int resPos = 0;
        int resNeg = 0;
        int[] res = new int[2];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                resPos += array[i];
            } else {
                resNeg += array[i];
            }
        }
        res[0] = resPos;
        res[1] = resNeg;
        return res;
    }

    public static void main(String[] args) {
        int[] array = FillArray(12, -9, 9);
        PrintArray(array);
        int[] sumArr = SumPosNeg(array);
        System.out.println();
        System.out.println("Сумма положительных элементов = " + sumArr[0]);
        System.out.println("Сумма отрицательных элементов = " + sumArr[1]);
    }

}
