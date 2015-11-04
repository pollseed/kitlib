package src.main.visitor;

public class AcceptImpl1 extends Acceptor {
    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
