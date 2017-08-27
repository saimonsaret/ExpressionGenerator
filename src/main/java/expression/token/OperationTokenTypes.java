package expression.token;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OperationTokenTypes {
    private Map<String, OperationToken> map = new HashMap<String, OperationToken>();

    @SneakyThrows
    public OperationTokenTypes() {
        Reflections reflections = new Reflections("expression");
        Set<Class<? extends OperationToken>> classes = reflections.getSubTypesOf(OperationToken.class);
        for (Class<? extends OperationToken> aClass : classes) {
            OperationToken operationToken = aClass.newInstance();
            map.put(operationToken.getValue(), operationToken);
        }
    }

    public OperationToken getOperationToken(String s) {
        return map.get(s);
    }
}
