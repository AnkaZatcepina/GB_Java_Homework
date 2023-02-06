package lesson3;

import java.util.*;

public class Main 
{
    public static void main( String[] args )
    {    
        //Задание 1 
        System.out.println();
        System.out.println("Задание 1");
        deleteEvenFromArrayList();

        //Задание 2
        System.out.println();
        System.out.println("Задание 2");
        getArrayCharacteristics();

        //Задание 3
        System.out.println();
        System.out.println("Задание 3");
        deleteDuplicatesFromArrayList();
    
    }


    /*
        Пусть дан произвольный список целых чисел, 
        удалить из него четные числа 
        (в языке уже есть что-то готовое для этого)
    */
    private static void deleteEvenFromArrayList()
    {
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            arrayList.add(random.nextInt(11));
        }
        System.out.println("Исходный массив:");
        System.out.println(arrayList);
        
        arrayList.removeIf(n -> (n % 2 == 0));
        
        System.out.println("Итоговый массив:");
        System.out.println(arrayList);
    }

    /*
        Задан целочисленный список ArrayList. 
        Найти минимальное, максимальное и среднее арифметическое из этого списка.
    */
    private static void getArrayCharacteristics()
    {       
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random random = new Random();

        for (int i = 0; i < 13; i++) {
            arrayList.add(random.nextInt(11));
        }
        System.out.println("Исходный массив:");
        System.out.println(arrayList);
        
        double sum = 0.0;
        for (int number : arrayList){
            sum += number;
        }
        System.out.println("Максимум = " + Collections.max(arrayList));
        System.out.println("Минимум = " + Collections.min(arrayList));
        System.out.println("Среднее арифметическое = " + sum / arrayList.size());
    }

    /*
        Пройти по списку из задания 2 с урока 
        и удалить повторяющиеся элементы.
    */
    public static void deleteDuplicatesFromArrayList() {
        List<String> planets = new ArrayList<>();
        Random rand = new Random();

        String[] solarSystemPlanets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
        for (int i = 0; i < 10; i++) {
            int randIndex = rand.nextInt(solarSystemPlanets.length);
            planets.add(solarSystemPlanets[randIndex]);
        }

        planets.add("Pluto");
        planets.add("Pluto");
        planets.add("Pluto");
        planets.add("Pluto");

        
        System.out.println("Исходный массив:");
        System.out.println(planets);

        System.out.println("Подсчёт планет:");
        for (String planet : solarSystemPlanets) {
            int frequency = Collections.frequency(planets, planet);
            if (frequency > 0){
                System.out.printf("%s\t%s\n", planet, frequency);
            }
        }

        Set<String> set = new HashSet<>(planets);
        planets.clear();
        planets.addAll(set);

                
        System.out.println("Массив без повторов:");
        System.out.println(planets);
        

        /*for (String planet : planets) {
            if (planetCount.containsKey(planet)) {
                planetCount.put(planet, planetCount.get(planet) + 1);
            } else {
                planetCount.put(planet, 1);
            }
        }

        for (String planet : planetCount.keySet()) {
            System.out.printf("%s\t%s%n", planet, planetCount.get(planet));
        }
        */

        //planets.retainAll(Arrays.asList(solarSystemPlanets));
        //System.out.println(planets);
    }


}    
