package OopLesson4;

public class Archer extends Warrior<RangedWeapon, SmallShield>{

    
    public Archer(int health, String name, RangedWeapon ranged) {
        super(health, name, ranged);
    }

    public Archer(int health, String name, RangedWeapon ranged, SmallShield shield) {
        super(health, name, ranged, shield);
    }

    @Override
    public RangedWeapon getWeapon() {
        return super.getWeapon();
    }

    public  int range(){
        return weapon.getRange();
        //return ((RangedWeapon)weapon).getRange();
    }

    @Override
    public String toString() {
        return "Archer{" + super.toString() + "}";
    }
}
