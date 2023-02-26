package dk.nydt.sscore.api.enums;

public enum Hook {
    VAULT(false),
    PLACEHOLDERAPI(false),
    ACTIONBAR(true)
    ;

    private final boolean isBuiltIn;

    /**
     * @param paramBoolean Whether the hook is built into OreCore or not.
     */
    Hook(boolean paramBoolean) {
        this.isBuiltIn = paramBoolean;
    }

    /**
     * @return Whether the hook is built into OreCore or not.
     */
    public boolean isBuiltIn() {
        return isBuiltIn;
    }
}
