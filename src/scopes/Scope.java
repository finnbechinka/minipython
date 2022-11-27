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
        symbol.setScope(this);
    }

    public Symbol resolve(String name){
        if (symbols.get(name) != null) return symbols.get(name);
        if (enclosingScope != null) return enclosingScope.resolve(name);

        return null;
    }

    public Scope getEnclosingScope(){
        return this.enclosingScope;
    }

    public void setEnclosingScope(Scope enclosingScope) {
        this.enclosingScope = enclosingScope;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(Map<String, Symbol> symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("Symboltabelle: ").append(symbols);

        return str.toString();
    }
 }
