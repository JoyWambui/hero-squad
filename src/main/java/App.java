import static spark.Spark.*;

import models.Hero;
import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;

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


        get("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes/new", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("heroName");
            int age = Integer.parseInt(req.queryParams("heroAge"));
            String power = req.queryParams("heroPower");
            String weakness = req.queryParams("heroWeakness");
            Hero newHero = new Hero(name,age,power,weakness);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
