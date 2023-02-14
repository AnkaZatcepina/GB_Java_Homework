package OopLesson1.Classes;

public class Milk extends CursedProducts{
    private Double fat = 0.00;

    public Milk(String name, Double price, Integer longevity) {
        super(name, price, longevity);
    }

    public Milk(String name, Double price, Integer longevity, Double fat) {
        this(name, price, longevity);
        this.fat = fat;

    }

    @Override
    public String toString(){
        return String.format("%s fat = %2.1f %% " , super.toString(), fat);
    }
}
