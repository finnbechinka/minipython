package nodes;

import scopes.Scope;
import visitors.ASTVisitor;

public class IDNode extends ASTNode {

    private Scope scope;
    private String instanceId;
    private String id;
    private String type;

    public IDNode(String instanceId, String id, String type) {
        this.instanceId = instanceId;
        this.id = id;
        this.type = type;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toStringTree() {
        if (instanceId == null)
            return "ID: " + id + " Type: " + type;
        else
            return "ID: " + instanceId + "." + id  + " Type: " + type;
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
