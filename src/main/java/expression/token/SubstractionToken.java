package expression.token;

public class SubstractionToken implements OperationToken {
    public String getValue() {
        return "-";
    }

    public double calculate(double a, double b) {
        return a - b;
    }

    public int getPriority() {
        return 1;
    }
}
