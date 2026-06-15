package virtualproxy;

public class ImageDisplayProxy implements IDisplay{

    private String path;
    private ImageDisplay imageDisplay;
    public ImageDisplayProxy(String path){
        this.path = path;
    }
    @Override
    public void display() {
        if(imageDisplay == null){
            imageDisplay = new ImageDisplay(path);
        }
        imageDisplay.display();
    }
}
