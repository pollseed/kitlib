package pollseed.gof.visitor;

import pollseed.gof.visitor.abst.Visitor;

public class VisitorImpl1 extends Visitor {
    @Override
    public String visit(AcceptImpl1 acceptImpl1) {
        return "VisitorImpl1 ok 1";
    }

    @Override
    public String visit(AcceptImpl2 acceptImpl1) {
        return "VisitorImpl1 ok 2";
    }
}
