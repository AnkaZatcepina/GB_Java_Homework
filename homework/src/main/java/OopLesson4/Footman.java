package OopLesson4;

public class Footman extends Warrior<MeleeWeapon, Shield> {

    public Footman(int health, String name, MeleeWeapon weapon) {
        super(health, name, weapon);
    }
    public Footman(int health, String name, MeleeWeapon weapon, Shield shield) {
        super(health, name, weapon, shield);
    }

    @Override
    public String toString() {
        return "Footman{" + super.toString() + "}";
    }
}
