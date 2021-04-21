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
        Squad.clearSquadsList();
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
    @Test
    public void AllSquadsAreReturned_true() {
        Squad squad = createNewSquad();
        Squad secondSquad = new Squad("Team PC","Political Correctness");
        assertEquals(2,Squad.getSquads().size());
    }
    @Test
    public void SquadsListContainsAllSquads_true() {
        Squad squad = createNewSquad();
        Squad secondSquad = new Squad("Team PC","Political Correctness");
        assertTrue(Squad.getSquads().contains(squad));
        assertTrue(Squad.getSquads().contains(secondSquad));
    }
    @Test
    public void SquadInstantiatesWithId_true() {
        Squad squad = createNewSquad();
        assertEquals(1,squad.getId());
    }
    @Test
    public void FindSquadById(){
        Squad squad = createNewSquad();
        Squad secondSquad = new Squad("Team PC","Political Correctness");
        assertEquals(2, Squad.findSquadId(secondSquad.getId()).getId());
    }
    @Test
    public void updateSquadInfo(){
        Squad squad = createNewSquad();
        String previousSquad = squad.fullSquadInfo();
        squad.update("Team PC","Political Correctness");
        int uneditedId = squad.getId();

        assertEquals(uneditedId, squad.getId());
        assertNotEquals(previousSquad, squad.fullSquadInfo());
    }


    public Squad createNewSquad(){
        return new Squad("BattleGirls", "Fighting GBV");
    }
}