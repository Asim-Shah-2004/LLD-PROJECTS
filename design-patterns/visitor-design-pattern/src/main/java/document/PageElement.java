public class PageElement implements DocumentElement{
    private String pageName = "Main Home Page";

    public String getPageName() {
        return this.pageName;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
