package models;

import java.util.ArrayList;

public class Hero {
    private String mName;
    private int mAge;
    private static ArrayList<Hero> heroes = new ArrayList<>();
    private String mSpecialPower;
    private String mWeakness;

    public Hero (String name, int age, String specialPower, String weakness){
        this.mName = name;
        this.mAge = age;
        this.mSpecialPower = specialPower;
        this.mWeakness = weakness;
        heroes.add(this);

    }

    public String getmName() {
        return mName;
    }

    public int getmAge() {
        return mAge;
    }

    public String getmSpecialPower() {
        return mSpecialPower;
    }

    public String getmWeakness() {
        return mWeakness;
    }

    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }
    public static void clearHeroesList(){
        heroes.clear();
    }
}
