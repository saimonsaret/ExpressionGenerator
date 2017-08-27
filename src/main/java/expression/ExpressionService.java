package expression;

import expression.token.TokenParser;

public class ExpressionService {

    private ExpressionGenerator generator = new ExpressionGenerator();
    private TokenParser parser = new TokenParser();
    private ExpressionCalculator calculator = new ExpressionCalculator();

    public Expression generateExpression(String template) {
        return generator.generate(parser.parse(template));
    }

    public double calculateExpression(Expression expression) {
        return calculator.calculate(expression);
    }
}
