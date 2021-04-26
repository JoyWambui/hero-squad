package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Squad {
    private String name;
    private String cause;
    private static ArrayList<Squad>  squads= new ArrayList<>();
    private static HashSet<Hero> squadHeroes = new HashSet<>();
    private int id;

    public Squad(String name, String cause){
        this.name = name;
        this.cause = cause;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj== null||obj.getClass()!= this.getClass()) return true;
        Squad squad = (Squad) obj;
        return this.getName().equals(squad.getName())&&
                this.getId()==squad.getId()&&
                this.getCause().equals(squad.getCause());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cause, id);
    }
}
