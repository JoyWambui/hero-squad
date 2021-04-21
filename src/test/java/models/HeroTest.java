package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        Hero.clearHeroesList();
    }

    @Test
    public void newHeroObjectInstantiatesCorrectly_notNull() {
        Hero hero = createNewHero();

        assertNotNull(hero);
    }

    @Test
    public void HeroInstantiatesWithName_true() {
        Hero hero = createNewHero();
        assertEquals("Strong Woman",hero.getName());
    }
    @Test
    public void HeroInstantiatesWithAge_true() {
        Hero hero = createNewHero();
        assertEquals(300,hero.getAge());
    }
    @Test
    public void HeroInstantiatesWithSpecialPower_true() {
        Hero hero = createNewHero();
        assertEquals("Invisibility",hero.getSpecialPower());
    }

    @Test
    public void HeroInstantiatesWithWeakness_true() {
        Hero hero = createNewHero();
        assertEquals("Fire",hero.getWeakness());
    }

    @Test
    public void AllHeroesAreReturned_true() {
        Hero hero = createNewHero();
        Hero secondHero = new Hero("Batman",40,"Wealth","Humanity");
        assertEquals(2,Hero.getHeroes().size());
    }
    @Test
    public void HeroesListContainsAllHeroes_true() {
        Hero hero = createNewHero();
        Hero secondHero = new Hero("Batman",40,"Wealth","Humanity");
        assertTrue(Hero.getHeroes().contains(hero));
        assertTrue(Hero.getHeroes().contains(secondHero));
    }

    @Test
    public void HeroInstantiatesWithId_true() {
        Hero hero = createNewHero();
        assertEquals(1,hero.getId());
    }
    @Test
    public void FindHeroByIdReturnsCorrectHero(){
        Hero hero = createNewHero();
        assertEquals(1, Hero.HeroById(hero.getId()).getId());
    }
    @Test
    public void FindHeroByIdMoreThanOne(){
        Hero hero = createNewHero();
        Hero secondHero = new Hero("Batman",40,"Wealth","Humanity");
        assertEquals(2, Hero.HeroById(secondHero.getId()).getId());
    }

    @Test
    public void updateHeroInformation(){
        Hero hero = createNewHero();
        String uneditedHero =hero.getCompleteHero();
        hero.update("Batman",40,"Wealth","Humanity");
        int uneditedId = hero.getId();

        assertEquals(uneditedId, hero.getId());
        assertNotEquals(uneditedHero, hero.getCompleteHero());
    }

    @Test
    public void deleteAllHeroes() {
        Hero hero = createNewHero();
        Hero secondHero = new Hero("Batman",40,"Wealth","Humanity");
        Hero.clearHeroesList();
        assertEquals(0, Hero.getHeroes().size());
    }
    @Test
    public void deleteHeroById() {
        Hero hero = createNewHero();
        Hero secondHero = new Hero("Batman",40,"Wealth","Humanity");
        hero.deleteById();
        assertEquals(1, Hero.getHeroes().size());
        assertEquals(Hero.getHeroes().get(0).getId(), 2);

    }



    public Hero createNewHero(){
        return new Hero("Strong Woman", 300, "Invisibility","Fire");

    }
}