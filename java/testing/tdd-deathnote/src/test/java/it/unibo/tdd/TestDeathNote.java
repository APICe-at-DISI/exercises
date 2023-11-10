import it.unibo.tdd.DeathNote;
import org.junit.jupiter.api.Test;

import static it.unibo.tdd.DeathNote.RULES;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDeathNote {

    private DeathNote deathNote;

    /**
     * Tests that rule number 0 and negative rules do not exist.
     */
    @Test
    public void testIllegalRule() {

    }

    /**
     * Checks that no rule is empty or null.
     */
    @Test
    public void testRules() {
        for (int i = 0; i < RULES.size(); i++) {
            final var rule = deathNote.getRule(i + 1);
            assertNotNull(rule);
            assertFalse(rule.isEmpty());
        }
    }

    /**
     * Checks that the human whose name is written in this DeathNote will die.
     */
    @Test
    public void testActualDeath() {
        deathNote.writeName("Danilo Pianini");
        deathNote.isNameWritten("Danilo Pianini");
        // a couple of false assertions
    }



}