package OopLesson4;

import java.util.Random;


public abstract class Warrior <W extends Weapon, S extends Shield>  {

    private String name;
    private int health;
    protected W weapon;
    private S shield = null;

    protected Warrior(int health, String name, W weapon) {
        this.health = health;
        this.name = name;
        this.weapon = weapon;
    }    
    
    protected Warrior(int health, String name, W weapon, S shield) {
        this.health = health;
        this.name = name;
        this.weapon = weapon;
        this.shield = shield;
    }


    public int damageFork(){
        Random random = new Random();
        return random.nextInt(weapon.damage());

    }

    public boolean hit(Warrior recepient){
        int damage = damageFork();
        System.out.println("Hit="+damage);
        return ! recepient.reduceHealth(damage);
    }

    public boolean reduceHealth(int damage){
        int defence = 0;
        if (this.isShielded())
            defence = shield.getDefence();
        if (defence < damage)
            health -= (damage - defence);
            
        System.out.println("Get damage="+(damage - defence));
        return health>0;
    }

    public boolean isShielded(){
        return (shield != null);
    }

    public int getDefence() {
        if (this.isShielded())
            return shield.getDefence();
        return 0;    
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public W getWeapon() {
        return weapon;
    }

    public void setWeapon(W weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() { 
        String str = name +
            ", health=" + health +
            ", weapon=" + weapon;
        if (this.isShielded())      
            str += ", shield=" + shield;
        return str;   
    }

}
