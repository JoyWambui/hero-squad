package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Squad {
    private String name;
    private String cause;
    private  int maxSize;
    private final Boolean maxLimit;
    private static ArrayList<Squad>  squads= new ArrayList<>();
    private static HashSet<Hero> squadHeroes = new HashSet<>();
    private int id;

    public Squad(String name, String cause, int maxSize){
        this.name = name;
        this.cause = cause;
        this.maxSize = maxSize;
        this.maxLimit = exceedsMaxSize();
        squads.add(this);
        this.id = squads.size();

    }
    public static Squad findSquadId(int id){
        return squads.get(id-1);
    }
    public static ArrayList<Squad> getSquads() {
        return squads;
    }
    public static void clearSquadsList(){
        squads.clear();
    }
    public  void addToSquad(Hero hero){
        squadHeroes.add(hero);
    }

    public String getName() {
        return name;
    }

    public String getCause() {
        return cause;
    }

    public int getId() {
        return id;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public Boolean getMaxLimit() {
        return maxLimit;
    }

    public static HashSet<Hero> getSquadHeroes() {
        return squadHeroes;
    }

    public void update(String newName, String newCause){
        this.name = newName;
        this.cause = newCause;
    }
    public void deleteById(){
        squads.remove(id-1);
    }

    public String fullSquadInfo(){
        return getName() + " " + getCause();
    }
    public Boolean exceedsMaxSize(){
        return getSquadHeroes().size() > maxSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Squad)) return false;
        Squad squad = (Squad) o;
        return getMaxSize() == squad.getMaxSize() && getId() == squad.getId() && getName().equals(squad.getName()) && getCause().equals(squad.getCause()) && getMaxLimit().equals(squad.getMaxLimit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCause(), getMaxSize(), getMaxLimit(), getId());
    }
}
