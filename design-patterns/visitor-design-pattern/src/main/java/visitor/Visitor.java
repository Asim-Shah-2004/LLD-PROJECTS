public interface Visitor {
    void visit(TextElement txt);
    void visit(ImageElement img);
    void visit(PageElement page);
}
