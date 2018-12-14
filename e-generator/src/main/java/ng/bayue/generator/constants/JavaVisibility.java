package ng.bayue.generator.constants;

public enum JavaVisibility {
    PUBLIC("public "), //$NON-NLS-1$
    PRIVATE("private "), //$NON-NLS-1$
    PROTECTED("protected "), //$NON-NLS-1$
    DEFAULT(""); //$NON-NLS-1$

    private String value;

    private JavaVisibility(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}