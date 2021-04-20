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
    }

    @Test
    public void newHeroObjectInstantiatesCorrectly_true() {
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

    public Hero createNewHero(){
        return new Hero("Strong Woman", 300, "Invisibility","Fire");

    }
}