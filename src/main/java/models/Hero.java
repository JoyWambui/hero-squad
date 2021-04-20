package models;

import java.util.ArrayList;

public class Hero {
    private String mName;
    private int mAge;
    private static ArrayList<Hero> heroes = new ArrayList<>();
    private String mSpecialPower;
    private String mWeakness;
    private int mId;

    public Hero (String name, int age, String specialPower, String weakness){
        this.mName = name;
        this.mAge = age;
        this.mSpecialPower = specialPower;
        this.mWeakness = weakness;
        heroes.add(this);
        this.mId = heroes.size();

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

    public int getmId() {
        return mId;
    }

    public static Hero HeroById(int mId){
        return heroes.get(mId-1);
    }

    public static void clearHeroesList(){
        heroes.clear();
    }
    public void deleteById(){
         heroes.remove(mId-1);
    }
}
