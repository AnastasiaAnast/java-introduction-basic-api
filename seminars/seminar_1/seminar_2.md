Все классы именуются с большой буквы

Первый класс - точка входа в программу, отсюда будет спускаться вся логика программы.

Оранжевым выделяются ключевые слова.
Public - идентификатор доступа, один из нескольких (есть еще protected, default, privat), помогают разграничить логику приложения (прим: сделать методы, к которым нельзя достучаться вне класса)

Слово class означает файл класса, далее - название класса. Далее в фигурных скобках начинается статический блок (именование, инициализация переменных, метод)

Название метода всегда с маленькой буквы, в стиле camelCase

Ключевое слово public - идентификатор доступа, означает то же самое, что и в public при описании класса.
Ключевое слово static - показывает, что данный метод доступен по имени класса (создание объекта для вызова этого метода не нужно, можно просто создать класс main и из него получить доступ к этому методу)
void обозначает, что данный метод ничего не возвращает.
Методы могут возвращать 2 значения: какой-то класс или ничего (void)

Метод main явл зарезервированным и явл точкой входа.
Внутри метода указывается переменная.

Каждую отдельную задачу делать в своем классе - не будет нагромаждения всей логики внутри одного метода.

Создали класс, внутри объявили переменную. Это статический блок.
внутри класса - конструктор класса public <name of class>, конструктор не в статическом блоке, он представляет собой специальный метод, который показывает как надо формироваться классу, что ему делать. Специальный метод, кот запускается, когда создается объект класса. **Имя конструктора должно совпадать с именем класса**.
Как класс собирается? Как создается объект?

sout - сгенерировать system.out.println

чтобы передать что-л в программу (вводом с клавиатуры) есть класс Scanner
объект класса сканер - Scanner

        Scanner input = new Scanner(System.in);

Почитать более подробно про каждый элемент - java doc - правой кнопкой на интересующий эл-т. Зеленым шрифтом будет написана документация к, например, классу, для чего класс нужен, как работает и тд.

Можно посмотреть какие методы доступны у объекта, который создали - набираем его и ставим точку, смотрим предложенные варианты.

Конкатинация строк - склейка строк

Мы создали класс для решения задачи. Теперь нужно создать объекты этого класса, чтобы вызвать нужные методы и получить результат в консоли.

все, что из библиотеки с припиской m - метод, f - переменная

import java.util.Scanner;

        /*
        Написать программу, которая запросит пользователя ввести <Имя> в консоли.
        Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”
        */
        public class FirstTask {
            //int, char, float, double, byte, ...
            String name;

            public FirstTask() {
                System.out.println("Введите имя!");
                Scanner input = new Scanner(System.in);
                name = input.next();
                input.close();
            }

            public void printHelloName() {
                System.out.println("Привет, " + name);
            }
        }