package it.unibo.tdd;

public class DeathNoteImplementation implements DeathNote {

    public static class Death {
        private final String name;

    }

    private final String owner;

    @Override
    public String getRule(int ruleNumber) {
        if (ruleNumber < 1 || ruleNumber > RULES.size()) {
            throw new IllegalArgumentException("Rule index " + ruleNumber + " does not exist");
        }
        return RULES.get(ruleNumber - 1);
    }

    @Override
    public void writeName(String name) {

    }

    @Override
    public boolean writeDeathCause(String cause) {
        return false;
    }

    @Override
    public boolean writeDetails(String details) {
        return false;
    }

    @Override
    public String getDeathCause(String name) {
        return null;
    }

    @Override
    public String getDeathDetails(String name) {
        return null;
    }

    @Override
    public boolean isNameWritten(String name) {
        return false;
    }
}
