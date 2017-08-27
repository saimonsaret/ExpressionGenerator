package expression.token;

public class VariableToken implements Token {
    private String value;

    public VariableToken(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
