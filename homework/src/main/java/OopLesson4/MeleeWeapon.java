package OopLesson4;

public class MeleeWeapon implements Weapon{
    String weaponName;

    private int damagePoint;

    public MeleeWeapon(String weaponName, int damagePoint) {
        this.weaponName = weaponName;
        this.damagePoint = damagePoint;
    }

    @Override
    public String toString() {
        return "MeleeWeapon{" +
                "weaponName='" + weaponName + '\'' +
                ", damagePoint=" + damagePoint +
                '}';
    }

    @Override
    public int damage() {
        return damagePoint;
    }
}