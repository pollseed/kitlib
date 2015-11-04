package src.main.visitor;

public class AcceptImpl2 extends Acceptor {
    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
