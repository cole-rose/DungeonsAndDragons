import java.util.Random;
public abstract class Character {
    private String name;
    private int level;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int health;
    private boolean isDead = false;
    public static final int initialLevel = 1;
    public static final int initialHealth = 5;

    public Character(String name, int seed) {
        this.name = name;
        setLevel(initialLevel);
        setHealth(initialHealth);
        Random oneToSix = new Random();
        int randomStrength = oneToSix.nextInt(6) + 1;
        setStrength(randomStrength);
        int randomDexterity = oneToSix.nextInt(6) + 1;
        setDexterity(randomDexterity);
        int randomIntelligence = oneToSix.nextInt(6) + 1;
        setIntelligence(randomIntelligence);
        int randomWisdom = oneToSix.nextInt(6) + 1;
        setWisdom(randomWisdom);
    }

    public Character(String name, int level,
                     int strength, int dexterity,
                     int intelligence, int wisdom) {
        this.name = name;
        setHealth(5 * level);
        setLevel(level);
        setStrength(strength);
        setDexterity(dexterity);
        setIntelligence(intelligence);
        setWisdom(wisdom);
        //implement this constructor
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return this.wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.isDead = true;
            this.health = 0;
        }
        else if (health > 5 * this.getLevel()) {
            System.out.println("Health cannot be set above max.");
        } else {
            this.health = health;
        }
    }

    public boolean getIsDead() {
        return this.isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public abstract void levelUp();

    public abstract void attack(Character c);

    public abstract String toString();

}
