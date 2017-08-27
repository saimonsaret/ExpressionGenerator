package expression;

import expression.token.Token;

import java.util.List;

public class Expression {
    private final List<Token> tokens;

    public Expression(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Token token : tokens) {
            builder.append(token.getValue());
        }
        return builder.toString();
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
