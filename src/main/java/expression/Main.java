package expression;

public class Main {
    public static void main(String[] args) {
        ExpressionService service = new ExpressionService();
        Expression expression = service.generateExpression("a-b/c+d");
        System.out.println(expression.toString() + "=" + service.calculateExpression(expression));
    }
}
