package scopes;

import java.util.HashMap;
import java.util.Map;

public class Scope {

    private Scope enclosingScope;
    private Map<String, Symbol> symbols;

    public Scope(Scope enclosingScope){
        this.enclosingScope = enclosingScope;
        this.symbols = new HashMap<>();
    }

    public void bind(Symbol symbol){
        symbols.put(symbol.getName(), symbol);
    }

    public Symbol resolve(String name){
        if (symbols.get(name) != null) return symbols.get(name);
        if (enclosingScope != null) return enclosingScope.resolve(name);

        return null;
    }

    public Scope getScope(){
        return this.enclosingScope;
    }

    @Override
    public String toString(){
        return symbols.toString();
    }
}
