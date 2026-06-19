public class Main {
    public static void main(String[] args) {
        DocumentElement txt = new TextElement();
        DocumentElement img = new ImageElement();
        DocumentElement page = new PageElement();

        Visitor visitor = new SizeCalculatorVisitor();
        txt.accept(visitor);
        img.accept(visitor);
        page.accept(visitor);

        System.out.println("\n\n");

        visitor = new CompressSizeVisitor();
        txt.accept(visitor);
        img.accept(visitor);
        page.accept(visitor);

        System.out.println("\n\n");

        visitor = new ScanForVirus();
        txt.accept(visitor);
        img.accept(visitor);
        page.accept(visitor);
    }
}
