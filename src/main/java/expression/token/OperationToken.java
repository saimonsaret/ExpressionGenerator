package expression.token;

public interface OperationToken extends Token {
    double calculate(double a, double b);
    int getPriority();
}
