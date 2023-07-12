package HW_5;

import java.util.*;

public class HW_5 {
    static void sortedPrint(Map<String, ArrayList> map) {
        Set<String> keySet = map.keySet();

        int maxCount = 0;
        int minCount = 1_000;
        
        for (var item : map.entrySet()) {
            if (maxCount < item.getValue().size())
                maxCount = item.getValue().size();
            if (minCount > item.getValue().size())
                minCount = item.getValue().size();
            
        }

        Stack<String> st = new Stack<>();
        int num = minCount;
        while (num <= maxCount) {

            for (var item : map.entrySet()) {
                if (item.getValue().size() == num) {
                    st.push(item.getKey());
                }  
            }
            num += 1;
        }

        String name;
        for (int i = 0; i < keySet.size(); i++) {
            name = st.pop();
            for (var item : map.entrySet()) {
                if (name == item.getKey()) {
                    System.out.printf("%8s: ", item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Map<String, ArrayList> abon = new HashMap<>() {
            {
                put("Иванов", new ArrayList<Integer>() {
                    {
                        add(1111111);
                        add(2222222);
                        add(3333333);
                        add(4444444);
                    }
                });
                put("Петров", new ArrayList<Integer>() {
                    {
                        add(4444444);
                    }
                });
                put("Васечкин", new ArrayList<Integer>() {
                    {
                        add(1001122);
                        add(2002211);

                    }
                });
                put("Сидоров", new ArrayList<Integer>() {
                    {
                        add(5555555);
                        add(6666666);
                        add(7777777);
                    }
                });
            }
        };
        System.out.println();
        System.out.println("Данные абонентов: ");
        sortedPrint(abon);

        Scanner scan = new Scanner(System.in, "o999");
        Boolean getOut = false;
        String st;
        while (!getOut) {
            System.out.println("Введите цифру (1 - добавить нового абонента, 0 - завершить сеанс):");
            st = scan.nextLine();
            String name = "";
            String phString;
            switch (st) {
                case "1": {
                    System.out.println("Введите фамилию нового абонента:");
                    name = scan.nextLine();
                    if (abon.containsKey(name)) {
                        System.out.println("Такой абонент уже зарегистрирован");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Введите номера телефонов через запятую: ");
                        phString = scan.nextLine();
                        String[] arr = phString.split(",");
                        ArrayList<Integer> arrInt = new ArrayList<>();
                        for (String item: arr) {
                            arrInt.add(Integer.parseInt(item.trim())) ;
                        }
                        abon.put(name, arrInt);
                        System.out.println();
                        sortedPrint(abon);
                        break;
                    }
                }
                case "0": {
                    getOut = true;
                    System.out.println();
                    System.out.println("До свидания!");
                    System.out.println();
                    break;
                } 
            }
        }
    }
}