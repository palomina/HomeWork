import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

abstract class Hero {

    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;

    public Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    abstract void hit(Hero hero);

    abstract void healing(Hero hero);

    void causeDamage(int damage) {
        if(health < 0) {
            System.out.println("Герой уже мертвый!");
        } else {
            health -= damage;
        }

    }

    public int getHealth() {
        return health;
    }

    void addHealth(int health) {
        this.health += health;
    }

    void info() {

        System.out.println(name + " " + (health <= 0 ? "Герой мертвый" : health) + " " + damage);
    }
}

class Warrior extends Hero {

    public Warrior(int health, String type, int damage, int addHeal) {
        super(health, type, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health <= 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                hero.causeDamage(damage);
            }
            System.out.println(this.name + " нанес урон " + hero.name + " на " + damage);
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }
}

class Assasin extends Hero {

    int cricitalHit;
    Random random = new Random();

    public Assasin(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
        this.cricitalHit = random.nextInt(20);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health <= 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                hero.causeDamage(damage + cricitalHit);
            }
            System.out.println(this.name + " нанес урон " + hero.name + " на " + damage);
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }
}

class Doctor extends Hero {

    public Doctor(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        System.out.println("Доктор не может бить!");
    }

    @Override
    void healing(Hero hero) {
        //если доктор еще жив и пациент тоже жив
        if (this.getHealth() > 0 && hero.getHealth() > 0) {
            //тогда лечим
            hero.addHealth(addHeal);
            System.out.println(this.name + " вылечил " + hero.name + " на " + addHeal);
        } else {
            if (this.getHealth() <= 0) {
                System.out.println(this.name + " доктор мертв ");
            }
            if (hero.getHealth() <= 0) {
                System.out.println(hero.name + " герой мертв ");
            }
        }
    }
}


class Game {
    public static void main(String[] args) {

        Random randomStep = new Random();
        Random randomHealing = new Random();
        int round = 1;

        Hero[] team1 = new Hero[]{new Warrior(250, "Тигрил", 50, 0)
                , new Assasin(150, "Акали", 70, 0)
                , new Doctor(120, "Жанна", 0, 60)};

        Hero[] team2 = new Hero[]{new Warrior(290, "Минотавр", 60, 0)
                , new Assasin(160, "Джинкс", 90, 0)
                , new Doctor(110, "Зои", 0, 80)};

        Hero target;
        do {
            System.out.println("Раунд " + round++);
            for (int i = 0; i < team1.length; i++) {
                if(randomStep.nextInt(2) == 0) {
                    if(team1[i] instanceof Doctor) {
                        target = getTarget(team1);
                        team1[i].healing(target);
                    } else {
                        if (!isFail(team2)) {
                            target = getTarget(team2);
                            team1[i].hit(target);
                        }
                    }
                } else {
                    if(team2[i] instanceof Doctor) {
                        target = getTarget(team2);
                        team2[i].healing(target);
                    } else {
                        if (!isFail(team1)) {
                            target = getTarget(team1);
                            team2[i].hit(target);
                        }
                    }
                }
            }
        } while (!isFail(team1) && !isFail(team2));

        if (isFail(team1) && isFail(team2)) {
            System.out.println("Ничья");
        } else {
            if (isFail(team1)) {
                System.out.println("Победила команда 2");
            }
            if (isFail(team2)) {
                System.out.println("Победила команда 1");
            }
        }

        System.out.println("---------------");

        for (Hero t1: team1) {
            t1.info();
        }

        for (Hero t2: team2) {
            t2.info();
        }
    }

    public static Hero getTarget(Hero[] team) {
        Hero target;
        Random r = new Random();

        do {
            target = team[r.nextInt(team.length)];
        } while (target.getHealth()<=0);

        return target;
    }

    public static boolean isFail (Hero[] team) {
        int teamHealth = 0;
        for (Hero h: team) {
            teamHealth += h.getHealth() > 0 ? h.getHealth() : 0;
        }
        return teamHealth <= 0;
    }

}