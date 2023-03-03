//Реализовать абстрактный класс Warrior, с полями name, weapon, healthPoint
//Создать интерфейс Weapon с методом damage(), который будет показывать наносимый урон
//На основе класса Warrior создать различные типы воинов, например, лучник, меченосец, ополченец
// и т.п. У лучника добавить поле расстояние поражения.
//Создать различные виды вооружения, например, меч, лук, лопата.
// Обеспечить, чтобы определенный тип воина мог нести только определенной оружие. Можно на определенное оружие добавить уникальные признаки, например, у лука - дальность стрельбы.

//На основе работы на уроке.
//Создать класс щита, разработать разные типы щитов, добавить в семейство классов Warriors обобщения в виде щитов. Реструктуризировать код в конечных классах семейства Warriors.
//Добавить метод определения минимального щита в команде.
//* Продумать, как можно сделать воина без щита.

package OopLesson4;


public class Main {

    public static void main(String[] args) {


                
        System.out.println("~~~~~~~~~~~~~~~~squadF~only~Footmen~~~~~~~~~~~~~~~~~~~~~~");
        Team<Footman> squadF = new Team<>();

        squadF.add(new Footman(55, "joe", new MeleeWeapon("spear", 15)));
        squadF.add(new Footman(55, "moe", new MeleeWeapon("sword", 10)));
        squadF.add(new Footman(55, "doe", new MeleeWeapon("axe", 20)));

        for (Footman item : squadF) {
            System.out.println(item);
        }
        System.out.println(squadF.getTeamHealth());
        System.out.println(squadF.getMaxRange());
        System.out.println(squadF.getSumDamage());

        System.out.println("~~~~~~~~~~~~~~~~squadA~mixed~team~~~~~~~~~~~~~~~~~~~~~~");
        Team<Warrior> squadA = new Team<>();

        squadA.add(new Archer(15, "jonh", new RangedWeapon("bow", 5, 50)));
        squadA.add(new Archer(15, "jonathan", new RangedWeapon("crossbow", 15, 25)));
        squadA.add(new Footman(55, "carl", new MeleeWeapon("sword", 10)));
        squadA.add(new Footman(55, "earl", new MeleeWeapon("axe", 20)));
        
        for (Warrior item : squadA) {
            System.out.println(item);
        }
        System.out.println(squadA.getTeamHealth());
        System.out.println(squadA.getMaxRange());
        System.out.println(squadA.getSumDamage());        

        System.out.println("~~~~~~~~~~~~~~~~battle~~~~~~~~~~~~~~~~~~~~~~~~");
        Footman footman1 = new Footman(77 , "marks" , new MeleeWeapon("book"  , 30));
        Footman footman2 = new Footman(66 , "adamS" , new MeleeWeapon("weights"  , 45));
        doBattle(footman1, footman2);

        System.out.println("~~~~~~~~~~~~~~~~squadS~with~shields~~~~~~~~~~~~~~~~~~~~~~~");
        Team<Warrior> squadS = new Team<>();
        squadS.add(new Archer(15, "jonh", new RangedWeapon("bow", 5, 50)));
        squadS.add(new Archer(15, "jonathan", new RangedWeapon("crossbow", 15, 25),new SmallShield("Wooden", 5)));
        squadS.add(new Footman(55, "carl", new MeleeWeapon("sword", 10), new BigShield("Kalkan" , 20)));
        squadS.add(new Footman(55, "egg", new MeleeWeapon("sword", 10), new SmallShield("Table" , 7)));
        squadS.add(new Footman(55, "earl", new MeleeWeapon("axe", 20)));
        for (Warrior item : squadS) {
            System.out.println(item);
        }
        System.out.println("Minimal shield = " + squadS.getMinShield());


        System.out.println("~~~~~~~~~~~~~~~~battle~with~shields~~~~~~~~~~~~~~~~~~~");
        Footman footman3 = new Footman(40 , "marks" , new MeleeWeapon("book"  , 50), new BigShield("Kalkan" , 13));
        Footman footman4 = new Footman(40 , "adamS" , new MeleeWeapon("weights"  , 45), new SmallShield("Table" , 12));
        doBattle(footman3, footman4);

    }

    private static void doBattle(Warrior w1, Warrior w2){
        System.out.println(w1);
        System.out.println(w2);
        while (w1.getHealth()>0 && w2.getHealth()> 0){
            w1.hit(w2);
            System.out.println(w2);
            w2.hit(w1);
            System.out.println(w1);
        }
        if (w1.getHealth()>0){
            System.out.println(w1.getName() + " is a Winner");
        }
        else if (w2.getHealth()>0){
            System.out.println(w2.getName() + " is a Winner");
        }    
        else {
            System.out.println("No Winner");
        }
    }

}

