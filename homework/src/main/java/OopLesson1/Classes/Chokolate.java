package OopLesson1.Classes;

public class Chokolate extends Product{
    String type = "dark";

    public Chokolate(String name, Double price) {
        super(name, price);
    }

    public Chokolate(String name, Double price, String type) {
        super(name, price);
        this.type = type;
    }

    @Override
    public String toString(){     
        return String.format("%s, %s " , super.toString(), type);
    }
}
