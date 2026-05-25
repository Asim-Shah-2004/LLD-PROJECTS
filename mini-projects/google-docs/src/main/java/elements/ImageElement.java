package elements;

public class ImageElement implements DocumentElement {

    String path;


    public ImageElement(String path) {
        this.path = path;
    }

    @Override
    public String render() {
        return "Image [ "+path+" ]";
    }

}