package OopLesson2;

public class Duck extends Herbivores implements Flyable, Runable, Swimmable{
    public Duck(String nickname) {
        super(nickname);

    }

    public String toString(){
        return "I'm duck. " + super.toString() + ". My speed is " + speedOfRun() + ", speed of fly " + speedOfFly();
    }

    @Override
    public String say() {
        return "Krya-krya";
    }

    @Override
    public int speedOfFly() {
        return 50;
    }
    
    @Override
    public int speedOfRun() {
        return 10;
    }

    @Override
    public int speedOfSwim() {
        return 5;
    }
}
