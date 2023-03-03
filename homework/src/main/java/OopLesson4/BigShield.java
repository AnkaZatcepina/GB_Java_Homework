package OopLesson4;

public class BigShield implements Shield{
    private String name;
    private int defence = 0;

    public BigShield(String name, int defence) {
        this.name = name;
        this.defence = defence;
    }

    @Override
    public String toString(){
        return "BigShield{" +
                "name='" + name + '\'' +
                ", defence=" + defence +
                '}';
    };

    public int getDefence(){
        return defence;
    }
}
