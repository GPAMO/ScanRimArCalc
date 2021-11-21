import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerCalc {
    static int a1, a2;
    static char operation;
    static int result;

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int inputInt = getInput(sc);
            System.out.println(inputInt);
        } catch (NumberFormatException e) {
            System.out.println("Error");
        }

    }

    public static int getInput(Scanner sc) {
        try {
            String inPut = sc.nextLine();
            char[] stroka = new char[10];
            for (int i = 0; i < inPut.length(); i++) {
                stroka[i] = inPut.charAt(i);
                if (stroka[i] == '+') {
                    operation = '+';
                }
                if (stroka[i] == '-') {
                    operation = '-';
                }
                if (stroka[i] == '*') {
                    operation = '*';
                }
                if (stroka[i] == '/') {
                    operation = '/';
                }
            }
            String strokaS = String.valueOf(stroka);
            //Разделение символов для вывода.
            String[] blacks = strokaS.split("[+-/*]");
            String s1 = blacks[0];
            String s2 = blacks[1];
            String s3 = s2.trim();
            a1 = numberRim(s1);
            a2 = numberRim(s3);
            if (a1 < 0 || a2 < 0) {
                result = 0;
            } else {
                result = Roman.calcrim(a1, a2, operation);
                String resultRoman = CalcArab.conVert(result);
                System.out.println(resultRoman);
                System.out.println("Введите выражение типа: 5 + 5 или V+V");
                return getInput(sc);
            }
            String operation;
            try {
                a1 = sc.nextInt();
                operation = sc.next();
                a2 = sc.nextInt();
                if (a1 > 10 || a1 < 0 || a2 > 10 || a2 < 0) {
                    System.out.println("  Числа больше 10 не вычисляю\nибо для меня это слишком сложно");
                    System.exit(0);
                }
                if (operation.equals("+")) {
                    System.out.println(a1 + a2);
                }
                if (operation.equals("-")) {
                    System.out.println(a1 - a2);
                }
                if (operation.equals("*")) {
                    System.out.println(a1 * a2);
                }
                if (operation.equals("/")) {
                    System.out.println(a1 / a2);
                } else {
                    return getInput(sc);
                }
            } catch (ArithmeticException e) {
                System.out.println("Нельзя делить на круглик");
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException exception) {
            System.out.println("Введите выражение типа: 5 + 5 или V+V");
        } return getInput(sc);
    }




    public static int numberRim(String rim) {
        try {
            switch (rim) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат");
            System.exit(0);
        }
        return -1;
    }

}
