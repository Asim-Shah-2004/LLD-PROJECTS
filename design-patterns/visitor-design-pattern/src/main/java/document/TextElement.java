public class TextElement implements DocumentElement{
    private String text = "Sample Text Data";

    public String getText() {
        return this.text;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
}
