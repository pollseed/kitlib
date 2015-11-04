package pollseed.gof.visitor.abst;

import pollseed.gof.visitor.AcceptImpl1;
import pollseed.gof.visitor.AcceptImpl2;

public abstract class Visitor {
    public abstract String visit(AcceptImpl1 acceptImpl1);

    public abstract String visit(AcceptImpl2 acceptImpl1);
}
