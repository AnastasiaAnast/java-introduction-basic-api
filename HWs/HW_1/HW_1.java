package HW_1;

import java.util.Scanner;

public class HW_1 {
    static Scanner iScanner = new Scanner(System.in);

// 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    public static void factorial() {
        System.out.print("Введите n: ");
        int n = Integer.parseInt(iScanner.nextLine());
        System.out.printf("Треугольного число n!: %d\n", n * (n + 1) / 2);
        System.out.println();
    }

// 2) Вывести все простые числа от 1 до 1000
    public static void simple() {
        System.out.printf("Простые числа от 1 до 1000: ");
        for (int i = 2; i < 1000; i++) {
            boolean flag = false;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) System.out.printf("%d ", i);
        }
        System.out.println();
    }

// 3) Реализовать простой калькулятор
    public static void calc() {
        System.out.println("Введите выражение из двух чисел (прим: 1 + 2) с любой операцией из указанных: +, -, *, /. Для выхода введите q.");
        while (true) {
            String[] str = iScanner.nextLine().split(" ");
            if (str[0].equals("q")) break;
            float a = Float.parseFloat(str[0]);
            float b = Float.parseFloat(str[2]);
            float result = 0;
            String operation = str[1];
            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
            }

            if (result - (int)result < 0.000000001) 
                System.out.printf("= %d\n", (int)result);
            else
                System.out.printf("= %f\n", result);
        }
    }
}