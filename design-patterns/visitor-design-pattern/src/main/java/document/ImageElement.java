public class ImageElement implements DocumentElement{
    private String imgUrl = "https://example.com/image.png";

    public String getImgUrl() {
        return this.imgUrl;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
}
