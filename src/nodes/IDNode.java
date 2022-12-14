package nodes;

import scopes.Scope;
import visitors.ASTVisitor;

public class IDNode extends ASTNode {

    private Scope scope;
    private String instanceId;
    private String id;

    public IDNode(String instanceId, String id) {
        this.instanceId = instanceId;
        this.id = id;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toStringTree() {
        if (instanceId == null)
            return "ID: " + id;
        else
            return "ID: " + instanceId + "." + id;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Scope getScope() {
        return this.scope;
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }
}
