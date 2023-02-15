package OopLesson2;

public class Dolphin extends Predator implements Swimmable{
    public Dolphin(String nickname) {
        super(nickname);
    }

    public String toString(){
        return "I'm dolphin. " + super.toString() + ". My speed is " + speedOfSwim();
    }

    @Override
    public String say() {
        return "eEeEeEeE";
    }

    @Override
    public int speedOfSwim() {
        return 50;
    }
    

}
