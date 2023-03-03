package OopLesson4;

public class SmallShield implements Shield{
    private String name;
    private int defence = 0;

    public SmallShield(String name, int defence) {
        this.name = name;
        this.defence = defence;
    }

    @Override
    public String toString(){
        return "SmallShield{" +
                "name='" + name + '\'' +
                ", defence=" + defence +
                '}';
    };

    public int getDefence(){
        return defence;
    }
}
