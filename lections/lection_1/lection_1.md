# Java: знакомство и как пользоваться базовым API (лекции)

План урока:

- Типы данных и переменные
- Неявная типизация
- Классы-обертки
- Операции Java
- Массивы
- Преобразования
- Получение данных из терминала
- Форматированный вывод
- Область видимости переменных
- Функции и методы
- Управляющие конструкции
- Оператор выбора
- Циклы
- Работа с файлами

Почему JAVA

1. Топ 3 ЯП в мире
2. Библиотеки
3. Кроссплатформенность
4. Тысячи вакансий разных направлений (в тч темтирование, автотесты, нагруженные тесты)
5. Начало Android’а (здесь также ЯП kotlin)
6. Безопасность
7. ООП
8. Многопоточность, как она есть

Настройка рабочего места

1. Основы основ - Типы, базовые конструкции
2. Детальный разбор некоторых API - Файлы и работа с потоками ввода\вывода
3. Погружение в Java Collection API - List’ы и не только

Шаг 1: Java JDK https://www.oracle.com/java/technologies/downloads/
Шаг 2: Extension Pack VS Code - https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-javapack
При желании:
https://www.jetbrains.com/ru-ru/idea/ println(“Hello world”);

## Основы:

расширение файлов - **.java**
с какого места будет стартовать программа - обозначить **"точку входа"**:
_метод(ф-я) main с обязательным аргументом (String[] args)_, вот так:

      public class program { // **называем класс (program) по имени файла .java**
         static public void main(String[] args) {

         }
      }

все это укладывается в **сниппеты**(вводятся по ключевому слову, после которого - квадратик; учить):
первая строчка по слову class, вторая (определение точки входа) - по main

## Многострочный комментарий

      /**
      *
      *
      */

## Простой комментарий

      //

## Базовая единица - **класс**, в нем - один **метод (main)**, в кач-ве **аргумента - массив строк**, в котором можно что-то писать

## Типы данных:

- Примитивные: boolean, int, short, long и т.д. float, double Char
- ссылочные: массивы (классы, интерфейсы)

## Создание/определение/объявление переменной

      <тип данных> <идентификатор/имя переменной>;
      <идентификатор> = <значение>;
      прим: string s = null;

## Неявная типизация

int - занимает 4 байта
short
long
byte
**float** - прим: 3.7**f** - на конце числа всегда f
double
char
boolean

## Строки

Один символ в памяти занимает 2 байта, умножаем 2 байта на кол-во символов строки - получаем объем памяти для хранения строки

## НЕявная типизация

      var i = 123;

var = variable, вместо него будет подставлен тип данных, наиболее вероятный для заданонго значения (в нашем случае - 123)

Получить детальную инф о типе данных следующим кодом:

      System.out.printIn(getType(a));


      static String getType(Object o){
         return o.getClass ().getSimpleName();
      }

![Неявная типизация](/lections/lection_1/%D0%9D%D0%B5%D1%8F%D0%B2%D0%BD%D0%B0%D1%8F%20%D1%82%D0%B8%D0%BF%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F.png)

_любой метод в Java должен быть частью класса_

## Классы-обертки

Примитив Обертка
int Integer - занимает 4 байта
short Short
long Long
byte Byte
**float Float** - прим: 3.7**f** - на конце числа всегда f
double Double
char Character
boolean Boolean

      прим:
      System.out.printIn(Integer.<функционал на выбор>)

      Разряды можно разделять для наглядности _ в int или double
      прим:
      int i = 23_123_123;

## Операции Java

      - Присваивание: =
      - Арифметические: *, /, +, -, %, ++ (инкремент; +1), -- (декремент; -1)

- **_операции деления в java для целых и вещественных типов РАЗЛИЧАЮТСЯ_**
- **_операции бывают префиксные (--a записывают в переменную a изменённое значение и его же возвращают вместо себя в исходное выражение) и постфиксные (a-- возвращают вместо себя текущее значение переменной a, а потом записывают в a новое значение)_**

      - Операции сравнения: <, >, ==, !=, >=, <= (для ссылочных типов многое станет неочевидно)
      - Логические операции: ||, &&, ^, !
      - Побитовые операции:
      << (сдвинуть на 1 бит влево, числа рассчитываются по двоичной системе),

      >> (сдвинуть на 1 бит вправо),

       & (1 и 0 = 0),

       | (в двоичной системе сравниваются числа, а именно попарно их каждый 0 и 1, 1 или 0 - всегда 1, отсюда записывается результат тот, который вышел от сравнения 2-х чисел в двоичной системе, затем - переводится в десятиричную),

       **^** - разделяющая дизъюнкция (отдает true только тогда, когда только *одно из значений истинно*)

побитовые сдвиги - сдвиги в контексте битов. могут потребоваться при вычислении корней - в некоторых случаях писать свою ф-ю вычисления корня используя побитовую операцию - быстрее (и исполнение быстрее), чем использовать библиотеки

& и &&
операция с двумя амперсантами - т.н. "быстрая операция", имеет свои тонкости: если левая часть дает false - нет смысла смотреть, что будет справа, тк false и что угодно - будет false.
Операция с одной & проверяет оба условия.
Аналогично работают | и ||

## Массивы Одномерные, синтаксические особенности

      public class Program {
         public static void main(String[] args) {
            int[] arr = new int[10];      // одномерный масив
            System.out.println(arr.length); // 10 обращение к массиву

            arr = new int[] { 1, 2, 3, 4, 5 };
            System.out.println(arr.length); // 5
         }
      }

## Массивы Одномерные, синтаксические особенности

      public class Program {
         public static void main(String[] args) {
            int[] arr[] = new int[3][5];      // двумерный масив, 3 строки, 5 столбцов
            for (int[] line : arr) {
               for (int item : line) {
                  System.out.printf("%d ", item);
               }
               System.out.println();
            }
         }
      }

## Преобразования

- Неявные - не указываем что из чего преобразуем
- Явные - указывая тип данных

Для примитивов работает просто - есть переменная типа byte, она может быть неявно приведена к типа short, та - к int и тд

![Преобразования](/lections/lection_1/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F.png)

      public class Program {
         public static void main(String[] args) {
            int i = 123; double d = i;
            System.out.println(i); // 123
            System.out.println(d); // 123.0
            d = 3.1415; i = (int)d;
            System.out.println(d); // 3.1415
            System.out.println(i); // 3
            d = 3.9415; i = (int)d;
            System.out.println(d); // 3.9415
            System.out.println(i); // 3
            byte b = Byte.parseByte("123");
            System.out.println(b); // 123
            b = Byte.parseByte("1234");
            System.out.println(b); // NumberFormatException: Value out of range
         }
      }

НО в массив целых чисел нельзя положить массив вещественных чисел

      class Program
      {
         public static void main(String[] args) {
            int[] a = new int[10];
            double[] d = a; // ИЗУЧАЕМ ковариантность и контравариантность
         }
      }

## Получение данных из терминала

Строки

      import java.util.Scanner;
      public class Program {
         public static void main(String[] args) {
            Scanner iScanner = new Scanner(System.in);
            System.out.printf("name: ");
            String name = iScanner.nextLine();
            System.out.printf("Привет, %s!", name);
            iScanner.close();
         }
      }

Некоторые примитивы

      import java.util.Scanner;
      public class Program {
         public static void main(String[] args) {
            Scanner iScanner = new Scanner(System.in);
            System.out.printf("int a: ");
            int x = iScanner.nextInt();
            System.out.printf("double a: ");
            double y = iScanner.nextDouble();
            System.out.printf("%d + %f = %f", x, y, x + y);
            iScanner.close();
         }
      }

Проверка на соответствие получаемого типа

      import java.util.Scanner;
      public class Program {
         public static void main(String[] args) {
            Scanner iScanner = new Scanner(System.in);
            System.out.printf("int a: ");
            boolean flag = iScanner.hasNextInt();
            System.out.println(flag);
            int i = iScanner.nextInt();
            System.out.println(i);
            iScanner.close();
         }
      }

## Форматированный вывод

      public class Program {
         public static void main(String[] args) {
            int a = 1, b = 2;
            int c = a + b;
            String res = a + " + " + b + " = " + c;
            System.out.println(res);
         }
      }

      public class Program {
         public static void main(String[] args) {
            int a = 1, b = 2;
            int c = a + b;
            String res = String.format("%d + %d = %d \n", a, b, c);
            System.out.printf("%d + %d = %d \n", a, b, c);
            System.out.println(res);
         }
      }

## Виды спецификаторов

%d: целочисленных значений
%x: для вывода шестнадцатеричных чисел
%f: для вывода чисел с плавающей точкой
%e: для вывода чисел в экспоненциальной форме,
например, 3.1415e+01
%c: для вывода одиночного символа
%s: для вывода строковых значений

      public class Program {
         public static void main(String[] args) {

            float pi = 3.1415f;
            System.out.printf("%f\n", pi); // 3,141500
            System.out.printf("%.2f\n", pi); // 3,14
            System.out.printf("%.3f\n", pi); // 3,141
            System.out.printf("%e\n", pi); // 3,141500e+00
            System.out.printf("%.2e\n", pi); // 3,14e+00
            System.out.printf("%.3e\n", pi); // 3,141e+00
         }
      }

## Область видимости переменных

У переменных существует понятие «область видимости».
Если переменную объявили внутри некоторого блока фигурных скобок { }, то снаружи этого блока переменная будет недоступна.

      public class Program {
         public static void main(String[] args) {
            {
               int i = 123;
               System.out.println(i);
            }
            System.out.println(i); // error: cannot find symbol
         }
      }

## Функции и методы — это технически одно и то же. Функции могут не принадлежать классам, а методы принадлежат.

В java все функции являются методами.
Описание
Вызов
Возвращаемое значение
Рекурсия

Управляющие конструкции – условный и тернарный операторы
Оператор выбора
Циклы
Цикл — это многократное выполнение одинаковой
последовательности действий.
В java доступны следующие циклы:
● цикл while;
● цикл do while;
● цикл for; и его модификация for in

Циклы
continue, break
Операторы для управления циклами — continue и break.
Выполнение следующей итерации цикла — continue.
Прерывание текущей итерации цикла — break.

- ближайшего к оператору

Оператор цикла for
Вложенные циклы
for: Работает только для коллекций

Работа с файлами
Создание и запись\ дозапись
Чтение, Вариант посимвольно
Вариант построчно

Задачи для демонстрации
Задачи для самоконтроля

1. Задана натуральная степень k. Сформировать случайным образом список коэффициентов (значения от 0 до 100) многочлена многочлен степени k.
   *Пример: k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0
2. Даны два файла, в каждом из которых находится запись
   многочлена. Сформировать файл содержащий сумму многочленов

Итоги База еще одного языка
