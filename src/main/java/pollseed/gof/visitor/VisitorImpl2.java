package src.main.visitor;

public class VisitorImpl2 extends Visitor {
    @Override
    String visit(AcceptImpl1 acceptImpl1) {
        return "VisitorImpl2 ok 1";
    }

    @Override
    String visit(AcceptImpl2 acceptImpl1) {
        return "VisitorImpl2 ok 2";
    }
}
