package OopLesson2;

public class Rabbit extends Herbivores implements Runable {
    public Rabbit (String nickname) {
        super(nickname);
    }

    public String toString(){
        return "I'm rabbit. " + super.toString() + ". My speed is " + speedOfRun();
    }
    public String say(){
        return "kdfgk";
    }

    @Override
    public int speedOfRun() {
        return 30;
    }
}
