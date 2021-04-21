package models;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Squad {
    private String name;
    private String cause;
    private static ArrayList<Squad>  squads= new ArrayList<>();
    private int id;

    public Squad(String name, String cause){
        this.name = name;
        this.cause = cause;
        squads.add(this);
        this.id = squads.size();

    }

    public String getName() {
        return name;
    }

    public String getCause() {
        return cause;
    }

    public static ArrayList<Squad> getSquads() {
        return squads;
    }
    public static void clearSquadsList(){
        squads.clear();
    }


    public int getId() {
        return id;
    }
    public static Squad findSquadId(int id){
       return squads.get(id-1);
    }
}
