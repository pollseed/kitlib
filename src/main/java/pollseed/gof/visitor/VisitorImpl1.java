package src.main.visitor;

public class VisitorImpl1 extends Visitor {
    @Override
    String visit(AcceptImpl1 acceptImpl1) {
        return "VisitorImpl1 ok 1";
    }

    @Override
    String visit(AcceptImpl2 acceptImpl1) {
        return "VisitorImpl1 ok 2";
    }
}
