package pollseed.gof.visitor;

import pollseed.gof.visitor.abst.Acceptor;
import pollseed.gof.visitor.abst.Visitor;

public class AcceptImpl1 extends Acceptor {
    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
