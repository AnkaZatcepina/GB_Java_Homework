package OopLesson4;

public class RangedWeapon implements Weapon {

    private String weaponName;
    private int damagePoint;
    private int range;

    public int getRange() {
        return range;
    }

    public RangedWeapon(String weaponName, int damagePoint, int range) {
        this.weaponName = weaponName;
        this.damagePoint = damagePoint;
        this.range = range;
    }

    @Override
    public String toString() {
        return "RangedWeapon{" +
                "weaponName='" + weaponName + '\'' +
                ", damagePoint=" + damagePoint +
                ", range=" + range +
                '}';
    }

    @Override
    public int damage() {
        return damagePoint;
    }
}
