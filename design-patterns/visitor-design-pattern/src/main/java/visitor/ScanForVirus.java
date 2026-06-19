public class ScanForVirus implements Visitor{

    @Override
    public void visit(TextElement txt) {
        System.out.println("Scanning text element for virus : " + txt.getText());
    }

    @Override
    public void visit(ImageElement img) {
        System.out.println("Scanning image element for virus : " + img.getImgUrl());
    }

    @Override
    public void visit(PageElement page) {
        System.out.println("Scanning page element for virus : " + page.getPageName());
    }
}
