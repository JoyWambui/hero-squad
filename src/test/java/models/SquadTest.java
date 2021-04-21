package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void newSquadObjectInstantiatesCorrectly_notNull() {
        Squad squad = createNewSquad();

        assertNotNull(squad);
    }
    @Test
    public void SquadInstantiatesWithName_true() {
        Squad squad = createNewSquad();
        assertEquals("BattleGirls",squad.getName());
    }
    @Test
    public void SquadInstantiatesWithCause_true() {
        Squad squad = createNewSquad();
        assertEquals("Fighting GBV",squad.getCause());
    }


    public Squad createNewSquad(){
        return new Squad("BattleGirls", "Fighting GBV");
    }
}