public interface Visitor {
    void visit(Infantryman infantryman);
    void visit(Horseman horseman);
    void visit(ProxySoldier proxy);
    void visit(SoldierGroup group);
}
