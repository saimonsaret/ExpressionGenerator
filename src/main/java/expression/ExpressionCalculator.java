package expression;

import expression.token.NumberToken;
import expression.token.OperationToken;
import expression.token.Token;

import java.util.ArrayList;
import java.util.List;

public class ExpressionCalculator {
    public double calculate(Expression expression) {
        List<Token> tokenList = new ArrayList<Token>();
        tokenList.addAll(expression.getTokens());

        while (tokenList.size() > 1) {
            int index = -1;
            OperationToken maxPriorityToken = null;
            for (int i = 0; i < tokenList.size(); i++) {
                if (tokenList.get(i) instanceof OperationToken) {
                    OperationToken operation = (OperationToken) tokenList.get(i);
                    if (maxPriorityToken == null || operation.getPriority() > maxPriorityToken.getPriority()) {
                        index = i;
                        maxPriorityToken = operation;
                    }
                }
            }
            if (index == -1) {
                throw new RuntimeException("Wrong expression data: no operation was found");
            }

            double first = Double.parseDouble(tokenList.get(index - 1).getValue());
            double second = Double.parseDouble(tokenList.get(index + 1).getValue());
            NumberToken newToken = new NumberToken(String.valueOf(maxPriorityToken.calculate(first, second)));
            tokenList.remove(index + 1);
            tokenList.remove(index);
            tokenList.set(index - 1, newToken);
        }

        return Double.parseDouble(tokenList.get(0).getValue());
    }
}
