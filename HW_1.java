//*Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму. 
//Пример 1: а = 3, b = 2, ответ: 9 
// Пример 2: а = 2, b = -2, ответ: 0.25
// Пример 3: а = 3, b = 0, ответ: 1
// Пример 4: а = 0, b = 0, ответ: не определено
// Пример 5
// входные данные находятся в файле input.txt в виде
// b 3
// a 10
// Результат нужно сохранить в файле output.txt
// 1000 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HW_1 {
   public static String ReadText(String path)throws IOException {
    FileReader file = new FileReader(path);
		int c;
		String text = "";
		while ((c = file.read()) != -1) {
			char ch = (char) c;
			text += ch;
		}
		file.close();
		return text;
	}
    
    public static int [] MyNum(String text) throws Exception {
		String[] newText = text.split("\n");
		String[] num1 = newText[0].split(" ");
		String[] num2 = newText[1].split(" ");
		int a = 0;
		int b = 0;
		String x = "a";
		if (num1[0].codePointAt(0) == x.codePointAt(0)) {
			a = Integer.parseInt(num2[1].strip());
            System.out.println(a); //проверяю верность считывания
			b = Integer.parseInt(num1[1].strip());
            System.out.println(b); //проверяю верность считывания
		} else {
			a = Integer.parseInt(num1[1].strip());
            System.out.println(a); //проверяю верность считывания
			b = Integer.parseInt(num2[1].strip());
            System.out.println(b); //проверяю верность считывания
		}
		
		int[] nums = {a, b};
		return nums;
	}
    public static void whritePow (int a, int b) 
        {
            try (FileWriter fw = new FileWriter("output.txt", false)) {
                if (a == 0 && b == 0) {
                    fw.write("не определено");
                    fw.close();
                } else {
                    fw.write(String.format("а = %d, b = %d, ответ: %f", a, b, Math.pow(a, b))); //почему-то не рабоает с нулевой степенью
                    fw.close();
                }
            }
    
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    
        }
    public static void main(String[] args)
        throws Exception
    {
        String text = ReadText("input.txt");
		int[] numArray = MyNum(text);
		int a = numArray[0];
		int b = numArray[1];
        whritePow (a, b);
    }
}