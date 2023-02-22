package lesson5;

import java.util.*;
import java.util.Map.Entry;

/*
 * Пусть дан список сотрудников
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
 * Отсортировать по убыванию популярности.
 */
public class EmployeesCount {
    public static void main( String[] args )
    {
        List<String> employees = new ArrayList<>();
        employees.add("Иван Иванов");
        employees.add("Светлана Петрова");
        employees.add("Кристина Белова");
        employees.add("Анна Мусина");
        employees.add("Анна Крутова");
        employees.add("Иван Юрин");
        employees.add("Петр Лыков");
        employees.add("Павел Чернов");
        employees.add("Петр Чернышов");
        employees.add("Мария Федорова");
        employees.add("Марина Светлова");
        employees.add("Мария Савина");
        employees.add("Мария Рыкова");
        employees.add("Марина Лугова");
        employees.add("Анна Владимирова");
        employees.add("Иван Мечников");
        employees.add("Петр Петин");
        employees.add("Иван Ежов");

        //Подсчитываем количество имён
        HashMap<String,Integer> countNames = new HashMap<>();
        for (String employee : employees) {
            String name = employee.split(" ")[0];
            if (!countNames.containsKey(name)) 
            {
                countNames.putIfAbsent(name, 1);
            } else {
                countNames.put(name, countNames.get(name) + 1);
            } 
        }

        System.out.println(countNames);

        //Сортируем количество имён по убыванию
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> countValues = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : countNames.entrySet()) {
            countValues.add(entry.getValue());
        }
        Collections.sort(countValues, Collections.reverseOrder()); 
        for (int count : countValues) {
            for (Entry<String, Integer> entry : countNames.entrySet()) {
                if (entry.getValue().equals(count)) {
                    sortedMap.put(entry.getKey(), count);
                }
            }
        }
        System.out.println(sortedMap);


    }

    
}
