package models;

public class Hero {
    private String mName;
    private int mAge;
    private String mSpecialPower;
    private String mWeakness;
    public Hero (String name, int age, String specialPower, String weakness){
        this.mName = name;
        this.mAge = age;
        this.mSpecialPower = specialPower;
        this.mWeakness = weakness;
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
}
