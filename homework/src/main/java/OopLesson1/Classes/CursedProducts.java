package OopLesson1.Classes;

public class CursedProducts extends Product {

    private Integer longevity;
    public CursedProducts(String name, Double price, Integer longevity) {
        super(name, price);
        this.longevity = longevity;
    }

    @Override
    public String toString(){
        return String.format("%s longevity = %d  " , super.toString(), longevity);
    }

}

