public class SizeCalculatorVisitor implements Visitor{

    @Override
    public void visit(TextElement txt) {
        System.out.println("Calculating size of text element : " + txt.getText());
    }

    @Override
    public void visit(ImageElement img) {
        System.out.println("Calculating size of image element : " + img.getImgUrl());
    }

    @Override
    public void visit(PageElement page) {
        System.out.println("Calculating size of page element : " + page.getPageName());
    }
}
