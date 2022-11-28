package environment;

import java.util.HashMap;
import java.util.Map;

public class Environment {

    private Environment enclosingEnvironment;
    private Map<String, Object> elements;

    public Environment(Environment e) {
        this.enclosingEnvironment = e;
        this.elements = new HashMap<>();
    }

    public Object get(String id) {
        Object elem = elements.get(id);
        if(elem != null)
            return elem;
        if(enclosingEnvironment != null)
            return enclosingEnvironment.get(id);
        return null;
    }

    public void define(String id, Object value) {
        elements.put(id, value);
    }

    @Deprecated
    public void assign(String id, Object value) {

    }

    public Environment getEnclosingEnvironment() {
        return enclosingEnvironment;
    }

    public void setEnclosingEnvironment(Environment enclosingEnvironment) {
        this.enclosingEnvironment = enclosingEnvironment;
    }

    public Map<String, Object> getElements() {
        return elements;
    }

    public void setElements(Map<String, Object> elements) {
        this.elements = elements;
    }
}
