package OopLesson2;

public class Cow extends Herbivores implements Runable{
    public Cow(String nickname) {
        super(nickname);
    }

    public String toString(){
        return "I'm cow. " + super.toString() + ". My speed is " + speedOfRun();
    }
    public String say(){
        return "Mu-mu";
    }

    @Override
    public int speedOfRun() {
        return 5;
    }
}
