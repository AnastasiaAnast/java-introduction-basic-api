// Задание 2

// Для списка из задачи про Солнечную систему удалить все повторяющиеся элементы.

package HW_3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class HW_3_task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество элементов списка:");
        int n = sc.nextInt();
        sc.close();

        ArrayList<String> planet = new ArrayList<>() {
            {
                add("Меркурий");
                add("Венера");
                add("Земля");
                add("Марс");
                add("Юпитер");
                add("Сатурн");
                add("Уран");
                add("Нептун");
            }
        };

        ArrayList<String> morePlanet = findDuplicates(planet, n);
        System.out.println(morePlanet.toString());
        Set<String> newSet = noRepetitions(morePlanet);
        System.out.println(newSet.toString());
    }

    static ArrayList<String> findDuplicates(ArrayList<String> sourceArray, int n) {
        Random rand = new Random();
        ArrayList<String> myNewArray = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int randomIndex = rand.nextInt(sourceArray.size());
            String temp = sourceArray.get(randomIndex);
            myNewArray.add(temp);
        }
        return myNewArray;
    }

    static Set<String> noRepetitions(ArrayList<String> sourceArray){
        Set<String> mySet = Set.copyOf(sourceArray);
        return mySet;
    }
    
}