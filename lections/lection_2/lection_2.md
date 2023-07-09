# Почему вы не можете не использовать API

## API (application programm interface) - сторонний сервис (все, что угодно), позволяющий нам взаимодействовать с ним. Возможности, кот предоставляют разработчики языка.

API на примерах:

1. Строки
2. Работа с файловой системой
3. Логирование
4. Импорт
5. Xml

Пример работы со строками:
создать строку, где есть 1 млн "+"

такой код выполняется ~40сек:

        String str = "";
        for (int i = 0; i < 1_000_000; i++) {
            str += "+";
        }

при использовании stringbilder код выполняется за 9 милисекунд

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append("+");
        }

Весь код:

        public class program {
            public static void main(String[] args) {
                var s = System.currentTimeMillis();
                //String str = "";
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 1_000_000; i++) {
                    //str += "+";
                    sb.append("+");
            }
            System.out.println(System.currentTimeMillis() - s);
            //System.out.println(str);
            //System.out.println(sb);
            }
        }

Много изменений – String
Много преобразований – StringBuilder

- stringbilder - выгоднее использовать при изменении строк, сборе и компановке материала
- строки - если ищем внутри большой строки вхождения или кусок, т.е. разбираем готовый материал

Что такое API для нас: строки

concat(): объединение строк
valueOf(): преобразует Object в строковое представление (завязан на toString())
join(): объединяет набор строк в одну с учетом разделителя
charAt(): получение символа по индексу
indexOf(): первый индекс вхождения подстроки
lastIndexOf(): последний индекс вхождения подстроки
startsWith()/endsWith(): определяет, начинается/заканчивается ли строка с подстроки
replace(): замена одной подстроки на другую
trim(): удаляет начальные и конечные пробелы
substring(): возвращает подстроку, см.аргументы
toLowerCase()/toUpperCase(): возвращает новую строку в нижнем/верхнем регистре
сompareTo(): сравнивает две строки
equals(): сравнивает строки с учетом регистра
equalsIgnoreCase(): сравнивает строки без учета регистра
regionMatches(): сравнивает подстроки в строках

        public class program {
            public static void main(String[] args) {
                String[] name = { "C", "е", "р", "г", "е", "й" };
                String sk = "СЕРГЕЙ КА.";
                System.out.println(sk.toLowerCase()); // сергей ка.
                System.out.println(String.join("", name)); // Cергей
                System.out.println(String.join("", "C", "е", "р", "г", "е", "й"));
                // C,е,р,г,е,й
                System.out.println(String.join(",", "C", "е", "р", "г", "е", "й"));
            }
        }

## Работа с файловой системой

Внутри файловой системы есть 2 основных столпа:

Для работы нужно:
File <имя> = new File(<полный путь к файлу>);
File f1 = new File("file.txt");
File f2 = new File("/Users/sk/vscode/java_projects/file.txt");

Что предпочтительнее?

        import java.io.File;
        public class fileSystemDemo {
            public static void main(String[] args) {
                String pathProject = System.getProperty("user.dir");
                String pathFile = pathProject.concat("/file.txt");
                File f3 = new File(pathFile);
                System.out.println(f3.getAbsolutePath ());
                // /Users/sk/vscode/java_projects/file.txt
                // C:/Users/Sk/Documents/xxx/brainexplosion/java/file.txt
            }
        }

- каталоги
- файлы (внутри зашиты 0 и 1, считываемые в опред последовательности)

Чтобы начать работать с файловой системой потребуется большой тип - File (посмотрев документацию - делать с ним что угодно - перемещать, копировать, делать замены и тп). Для отдельных типов файлов может потребоваться изучить определенные библиотеки или создать собственную.
Взять файл целиком загрузить его в память, производить с ним манипуляции или скачать часть файла в память, произвести над ней манипуляции, сохранить, считать новую порцию данных и тд.
Примерно так работает скачивание из интернета - запрашиваем некий файл - запрос отправляется на сервер - с сервера приходит часть файла, сохраняется на наш комп - с нашего компа отправляется запрос на получение новой порции данных и это делается много-много раз.

Есть тонкости работы с данными файлами - тк java - кросплатформенный язык, то при написании кода следует думать о том, что программа может быть запущена на разных ОС.

Пути к файлу:

- абсолютный
- относительный - .txt - маршрутизация от той папки в рамках которой запущен наш проект

Пути будут выглядеть по-разному на платфомах Windows и Linux-подобных. По документации смотреть как получить системный путь к папке.

## Работа с файловой системой - может возникнуть мн-во ошибок

- непраивльный путь
- отсутствие какой-либо папки
- отсутствие файла
- файл неверного типа
- файл был очень большой - не хватило памяти выгрузить
- файл пустой
- файл частично битый (часть скачалась, прервалось интернет-соединения - части файла нет)
- файл был открыт сторонней программой (вирус/антивирус) - при попытке считать файл к нему нет доступа
  и проч

## Блоки **try catch finaly**, обрабатывающие ошибки:

try {
_написать код, который потенциально может содержать ошибку_

} catch (Exception e) {
_Обработка, если ошибка случилась (чтобы прог-ма не вылетала)_
}

finally {
_Код, выполняемый в любом случае, была ошибка или нет_
}

        import java.io.File;
        public class tryDemo {
            public static void main(String[] args) {
                try {
                    String pathProject = System.getProperty("user.dir"); //прописываем путь к текущей папке с которой запускается проект
                    String pathFile = pathProject.concat("/file.txt"); //указываем конкретный файл
                    File f3 = new File(pathFile); //нужно создать файл и связать файловую переменную f3 с текущим по текущему пути
                    System.out.println("try"); //если все ок - будет выведено сообщение try
                } catch (Exception e) { //если не будет файла или путь к нему будет кривой - будет выведено сообщение exeption
                    System.out.println("catch");
                }
                finally
                { System.out.println("finally"); // вне зависимости от того будет try или catch, блок fanally будет показан}
            }
        }

Технически избавить от блоков try-catch можно - если можно избавиться от них - лучше избавиться

Работа с файловой системой

- isHidden(): возвращает истину, если каталог или файл является скрытым
- length(): возвращает размер файла в байтах
- lastModified(): возвращает время последнего изменения файла или каталога
- list(): возвращает массив файлов и подкаталогов, которые находятся в каталоге
- listFiles(): возвращает массив файлов и подкаталогов, которые находятся
  в определенном каталоге
- mkdir(): создает новый каталог
- renameTo(File dest): переименовывает файл или каталог
- length(): возвращает размер файла в байтах
- lastModified(): возвращает время последнего изменения
  файла или каталога
- list(): возвращает массив файлов и подкаталогов, которые находятся в каталоге
- listFiles(): возвращает массив файлов и подкаталогов, которые
  находятся в определенном каталоге
- mkdir(): создает новый каталог
- renameTo(File dest): переименовывает файл или каталог

          String line = "empty";
          try {
              File file = new File(pathFile);
              if (file.createNewFile()) { //если file.creatNewFile возвращает истину - говорит о том, что файл был создан, если возвращается false - такой файл уже был найден, работать с ним уже нужно по-другому
                  System.out.println("file.created"); }
              else {
                  BufferedReader bufReader =
                  new BufferedReader(new FileReader(file));
                  System.out.println("file.existed");
                  line = bufReader.readLine();
                  bufReader.close(); }
              } catch (Exception e) {
                  //e.printStackTrace();
              } finally {
                  System.out.println(line);
          }

Работа с файловой системой. Каталоги

        import java.io.File;
        public class Ex0043 {
            public static void main(String[] args) {
                String pathProject = System.getProperty("user.dir");
                String pathDir = pathProject.concat("/files");
                File dir = new File(pathDir);
                System.out.println(dir.getAbsolutePath ());
                if (dir.mkdir()) {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
                for (String fname : dir.list()) {
                    System.out.println(fname);
                }
            }
        }

- Бинарные(двоичные) файлы – содержат биты, которые нужно будет преобразовать, чтобы оттуда получить информацию в виде, который может прочитать/понять пользователь (для машины разницы нет)
- Текстовый файл - строка с инф.

Основной функционал работы с бинарными файлами: ф-ии позволяющие:

- считывать данные
- создавать данные/файл
- поиск данных внутри бинарного файла
- вставка данных

## Логирование/Журналирование

Есть опред АПИ, позволяющее воспользоваться данным функционалом.
Суть - при написании систем, рано или поздно они начинают сбоить. Чтобы понять, что к этому привело - посмотреть журнал - любое действие (нажатие кнопки, выполнение любого метода) должно быть записано в журнал.

Логи содержат системную информацию работы программного или аппаратного комплекса.
В них записываются действия разного приоритета от пользователя, или программного продукта.
Процесс ведения логов называют “логированием” (журналированием).

### Использование

Logger logger = Logger.getLogger()

### Уровни важности

INFO, DEBUG, ERROR, WARNING и др.

### Вывод

    ConsoleHandler info = new ConsoleHandler();
    log.addHandler(info);

### Формат вывода: структурированный, абы как\*

XMLFormatter, SimpleFormatter

        import java.util.logging.*;
        public class Ex0043 {
            public static void main(String[] args) {
                Logger logger = Logger.getLogger(Ex0043.class.getName());
                logger.setLevel(Level.INFO);
                ConsoleHandler ch = new ConsoleHandler ();
                logger.addHandler(ch);
                SimpleFormatter sFormat = new SimpleFormatter ();
                ch.setFormatter(sFormat);
                logger.log(Level.WARNING, "Тестовое логирование" );
                logger.info("Тестовое логирование" );
            }
        }

        import java.util.logging.*;
        public class Ex0043 {
            public static void main(String[] args) {
                Logger logger = Logger.getLogger(Ex0043.class.getName());
                logger.setLevel(Level.INFO);
                ConsoleHandler ch = new ConsoleHandler();
                logger.addHandler(ch);
                //SimpleFormatter sFormat = new SimpleFormatter();
                XMLFormatter xml = new XMLFormatter();
                //ch.setFormatter(sFormat);
                ch.setFormatter(xml);
                logger.log(Level.WARNING, "Тестовое логирование");
                logger.info("Тестовое логирование");
            }
        }
