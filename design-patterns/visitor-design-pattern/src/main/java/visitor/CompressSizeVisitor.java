public class CompressSizeVisitor implements Visitor{

    @Override
    public void visit(TextElement txt) {
        System.out.println("Compressing text element : " + txt.getText());
    }

    @Override
    public void visit(ImageElement img) {
        System.out.println("Compressing image element : " + img.getImgUrl());
    }

    @Override
    public void visit(PageElement page) {
        System.out.println("Compressing page element : " + page.getPageName());
    }
    
}
