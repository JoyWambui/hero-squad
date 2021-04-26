import static spark.Spark.*;

import models.Hero;
import models.Squad;
import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        //view homepage:
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/index.hbs");
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            req.session().attribute("newSquad");
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads/new", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("squadName");
            String cause = req.queryParams("squadCause");
            int max_size = Integer.parseInt(req.queryParams("squadSize"));
            Squad newSquad = new Squad(name, cause,max_size);
            req.session().attribute("newSquad",newSquad);
            model.put("newSquad",newSquad);
            return new ModelAndView(model, "squad-success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getSquads();
            req.session().attribute("squads");
            model.put("squads",squads);
            return new ModelAndView(model, "all-squads.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squads/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int editSquadId = Integer.parseInt(req.params("id"));
            Squad editSquad = Squad.findSquadId(editSquadId);
            req.session().attribute("editSquad");
            model.put("editSquad",editSquad );
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("squadName");
            String newCause = req.queryParams("squadCause");

            int editSquadId = Integer.parseInt(req.params("id"));
            Squad editSquad = Squad.findSquadId(editSquadId);
            editSquad.update(newName,newCause);
            req.session().attribute("editSquad",editSquad);
            model.put("editSquad", editSquad);
            return new ModelAndView(model, "squad-success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:id/delete", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            int deleteSquadId = Integer.parseInt(req.params("id"));
            Squad squadToDelete = Squad.findSquadId(deleteSquadId);
            model.put("squadToDelete",squadToDelete);
            squadToDelete.deleteById();
            req.session().attribute("squadToDelete");

            return new ModelAndView(model, "squad-success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:id/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int squadToAddHeroes = Integer.parseInt(req.params("id"));
            Squad squadHeroesAdd = Squad.findSquadId(squadToAddHeroes);
            req.session().attribute("squadHeroesAdd");

            model.put("squadHeroesAdd", squadHeroesAdd);
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes/new", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            Squad squadHeroesAdd = Squad.findSquadId(Integer.parseInt(req.queryParams("squadId")));
            String name = req.queryParams("heroName");
            int age = Integer.parseInt(req.queryParams("heroAge"));
            String specialPower = req.queryParams("heroPower");
            String weakness = req.queryParams("heroWeakness");
            Hero newHero = new Hero(name,age,specialPower,weakness);
            squadHeroesAdd.addToSquad(newHero);
            model.put("squadHeroesToAdd", squadHeroesAdd);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:id/heroes",(req,res)->{
            Map<String,Object> model = new HashMap<>();
            int squadToAddHeroes = Integer.parseInt(req.params("id"));
            Squad squadHeroesAdd = Squad.findSquadId(squadToAddHeroes);
            HashSet<Hero> squadHeroes = Squad.getSquadHeroes();
            model.put("squadHeroesAdd",squadHeroesAdd);
            model.put("squadHeroes", squadHeroes);
            return new ModelAndView(model,"squad-heroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getHeroes();
            model.put("heroes",heroes);
            return new ModelAndView(model, "all-heroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int heroId = Integer.parseInt(req.params("id"));
            Hero fetchedHero = Hero.HeroById(heroId);
            model.put("hero", fetchedHero);
            return new ModelAndView(model, "hero-details.hbs");
        }, new HandlebarsTemplateEngine());



        get("/heroes/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int editHeroId = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.HeroById(editHeroId);
            model.put("editHero", editHero);
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("heroName");
            int newAge = Integer.parseInt(req.queryParams("heroAge"));
            String newSpecialPower = req.queryParams("heroPower");
            String newWeakness = req.queryParams("heroWeakness");

            int editHeroId = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.HeroById(editHeroId);
            editHero.update(newName,newAge,newSpecialPower,newWeakness);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id/delete", (req,res)->{
            Map<String,Object> model = new HashMap<>();
            int deleteHeroId = Integer.parseInt(req.params("id"));
            Hero deleteHero = Hero.HeroById(deleteHeroId);
            model.put("deleteHero",deleteHero);
            deleteHero.deleteById();
            return new ModelAndView(model, "success.hbs");
        },new HandlebarsTemplateEngine());


    }
}
