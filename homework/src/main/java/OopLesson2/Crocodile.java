package OopLesson2;

public class Crocodile extends Predator implements Runable, Swimmable{

    public Crocodile(String nickname){
        super(nickname);
    }

    @Override
    public String toString()
    {
        return "I'm crocidile. " + super.toString() + ". My speed is " + speedOfRun() + ", speed of swim " + speedOfSwim();
    }

    @Override
    public String say() {
        return "Wryyyy";
    }

    @Override
    public int speedOfSwim() {
        return 15;
    }

    @Override
    public int speedOfRun() {
        return 5;
    }
   
}
