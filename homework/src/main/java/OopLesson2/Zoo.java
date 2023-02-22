package OopLesson2;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private Radio radio = new Radio();
    private List<Animal> animals = new ArrayList<>();

    public List<Animal> addAnimals(List<Animal> animals){
        this.animals.addAll(animals);
        return this.animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Sayable> getSayable(){
        List<Sayable> result = new ArrayList<>();
        for (Animal item : animals) {
            result.add(item);
        }
        result.add(radio);
        return result;
    }

    public List<Runable> getRunable(){
        List<Runable> result = new ArrayList<>();
        for (Animal item : animals) {
            if (item instanceof Runable){
                result.add((Runable) item);
            }
        }
        return result;
    }

    public List<Flyable> getFlyable(){
        List<Flyable> result = new ArrayList<>();
        for (Animal item : animals) {
            if (item instanceof Flyable){
                result.add((Flyable) item);
            }
        }
        return result;
    }

    public List<Swimmable> getSwimmable(){
        List<Swimmable> result = new ArrayList<>();
        for (Animal item : animals) {
            if (item instanceof Swimmable){
                result.add((Swimmable) item);
            }
        }
        return result;
    }

    public Runable getWinner(){
        List<Runable> runanimals = getRunable();
        Runable winner = runanimals.get(0);
        for (Runable item : runanimals) {
            if (winner.speedOfRun() < item.speedOfRun()){
                winner = item;
            }
        }
        return winner;
    }

    public Flyable getWinnerFly(){
        List<Flyable> flyanimals = getFlyable();
        Flyable winner = flyanimals.get(0);
        for (Flyable item : flyanimals) {
            if (winner.speedOfFly() < item.speedOfFly()){
                winner = item;
            }
        }
        return winner;
    }

    public Swimmable getWinnerSwim(){
        List<Swimmable> swimanimals = getSwimmable();
        Swimmable winner = swimanimals.get(0);
        for (Swimmable item : swimanimals) {
            if (winner.speedOfSwim() < item.speedOfSwim())
            {
                winner = item;
            }
        }
        return winner;
    }
}
