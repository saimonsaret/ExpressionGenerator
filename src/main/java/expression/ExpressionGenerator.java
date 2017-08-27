package expression;

import expression.token.NumberToken;
import expression.token.OperationToken;
import expression.token.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExpressionGenerator {
    private Random rng = new Random();

    public Expression generate(List<Token> tokenList) {
        List<Token> expressionList = new ArrayList<Token>();
        for (Token token : tokenList) {
            if (token instanceof OperationToken) {
                expressionList.add(token);
                continue;
            }
            String variable = token.getValue();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < variable.length(); i++) {
                char symbol = variable.charAt(i);
                if (symbol >= '0' && symbol <= '9') {
                    builder.append(String.valueOf(symbol));
                } else {
                    int digit;
                    if (i == 0) {
                        digit = rng.nextInt(9) + 1;
                    } else {
                        digit = rng.nextInt(10);
                    }
                    builder.append(String.valueOf(digit));
                }
            }
            expressionList.add(new NumberToken(builder.toString()));
        }

        return new Expression(expressionList);
    }
}
