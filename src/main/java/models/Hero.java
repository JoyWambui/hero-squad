package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private static ArrayList<Hero> heroes = new ArrayList<>();
    private String specialPower;
    private String weakness;
    private int id;

    public Hero (String name, int age, String specialPower, String weakness){
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        heroes.add(this);
        this.id = heroes.size();

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public int getId() {
        return id;
    }

    public static Hero HeroById(int id){
        return heroes.get(id-1);
    }

    public void update(String newName, int newAge, String newPower, String newWeakness){
        this.name = newName;
        this.age = newAge;
        this.specialPower = newPower;
        this.weakness = newWeakness;
    }

    public static void clearHeroesList(){
        heroes.clear();
    }
    public void deleteById(){
         heroes.remove(id-1);
    }

    public String getCompleteHero(){
        return getName() + " " + getAge() + " " + getSpecialPower() + " " + getWeakness();
    }
}
