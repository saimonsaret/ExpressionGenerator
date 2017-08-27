package expression.token;

public class NumberToken implements Token {
    String value;

    public NumberToken(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
