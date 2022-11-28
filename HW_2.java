/*Реализовать алгоритм сортировки массива слиянием */
public class HW_2 {
    public static int [] sortArray(int[] arrayA){ 
        if (arrayA == null) { //обрабатываю пустой массив
            return null;
        }
        if (arrayA.length == 1) {
            return arrayA; // если элемет один, он уже отсортирован
        }
        int [] arrayB = new int[arrayA.length / 2];  //делим исходный массив пополам
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);
        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);
        arrayB = sortArray(arrayB); //крутим рекурсией одну и другую части
        arrayC = sortArray(arrayC); 
        return mergeArray(arrayB, arrayC); //запускаем слияние
    }
    public static int [] mergeArray(int [] arrayА, int [] arrayB) {
        int aLen = arrayА.length;
        int bLen = arrayB.length;
        int [] arrayC = new int [aLen+bLen]; //создаю итоговый массив
        int posA = 0, posB = 0, i = 0;//счетчики позиций
        while (posA < aLen && posB < bLen ) {
            if (arrayА [posA] <= arrayB[posB]) {
                arrayC[i] = arrayА [posA];
                posA++;}
            else {
                arrayC[i] = arrayB[posB];
                posB++;
            }
            i++;
            }
            while (posA < aLen) {
                arrayC [i] = arrayА [posA];
                posA++;
                i++;
            }
            while (posB < bLen) {
                arrayC [i] = arrayB[posB];
                posB++;
                i++;  
            }

        return arrayC;      
}
public static int[] newArray(int size, int from, int to) {
    int[] arr = new int[size];
    int range = to - from - 1;
    for (int i = 0; i < size; i++) {
        arr[i] = (int) (Math.random() * range) + from;
    }
    return arr;
}

public static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + ", ");
    }

}
public static void main(String[] args) {
    int [] myArray = newArray(9, -10, 10);
    printArray(myArray);
    System.out.println();
    int [] sArray = sortArray(myArray);
    printArray(sArray);
    }
}
