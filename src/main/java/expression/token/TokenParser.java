package expression.token;

import java.util.ArrayList;
import java.util.List;

public class TokenParser {
    private OperationTokenTypes operationTokenTypes = new OperationTokenTypes();

    public List<Token> parse(String template) {
        List<Token> list = new ArrayList<Token>();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < template.length(); i++) {
            String symbol = String.valueOf(template.charAt(i));
            OperationToken token = operationTokenTypes.getOperationToken(symbol);
            if (token == null) {
                builder.append(symbol);
            } else {
                list.add(new VariableToken(builder.toString()));
                builder = new StringBuilder();
                list.add(token);
            }
        }

        String suffix = builder.toString();
        if (suffix.length() == 0 || operationTokenTypes.getOperationToken(suffix) != null) {
            throw new RuntimeException("Wrong input format");
        }
        list.add(new VariableToken(suffix));

        return list;
    }
}
