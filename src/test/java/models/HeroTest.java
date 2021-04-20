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
        assertEquals("Strong Woman",hero.getmName());
    }
    @Test
    public void HeroInstantiatesWithAge_true() {
        Hero hero = createNewHero();
        assertEquals(300,hero.getmAge());
    }
    @Test
    public void HeroInstantiatesWithSpecialPower_true() {
        Hero hero = createNewHero();
        assertEquals("Invisibility",hero.getmSpecialPower());
    }

    @Test
    public void HeroInstantiatesWithWeakness_true() {
        Hero hero = createNewHero();
        assertEquals("Fire",hero.getmWeakness());
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
        assertEquals(1,hero.getmId());
    }
    @Test
    public void FindHeroByIdReturnsCorrectHero(){
        Hero hero = createNewHero();
        assertEquals(1, Hero.HeroById(hero.getmId()).getmId());
    }
    @Test
    public void FindHeroByIdMoreThanOne(){
        Hero hero = createNewHero();
        Hero secondHero = new Hero("Batman",40,"Wealth","Humanity");
        assertEquals(2, Hero.HeroById(secondHero.getmId()).getmId());
    }

    
    public Hero createNewHero(){
        return new Hero("Strong Woman", 300, "Invisibility","Fire");

    }
}