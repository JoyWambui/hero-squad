import static spark.Spark.*;

import models.Hero;
import models.Squad;
import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //view homepage:
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/index.hbs");
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads/new", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("squadName");
            String cause = req.queryParams("squadCause");
            Squad newSquad = new Squad(name, cause);
            return new ModelAndView(model, "squad-success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getSquads();
            model.put("squads",squads);
            return new ModelAndView(model, "all-squads.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int squadId = Integer.parseInt(req.params("id"));
            Squad viewSquad = Squad.findSquadId(squadId);
            res.redirect("/heroes");
            return new ModelAndView(model,"all-heroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes/new", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("heroName");
            int age = Integer.parseInt(req.queryParams("heroAge"));
            String specialPower = req.queryParams("heroPower");
            String weakness = req.queryParams("heroWeakness");
            Hero newHero = new Hero(name,age,specialPower,weakness);
            return new ModelAndView(model, "success.hbs");
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
            deleteHero.deleteById();
            return new ModelAndView(model, "success.hbs");
        },new HandlebarsTemplateEngine());


    }
}
