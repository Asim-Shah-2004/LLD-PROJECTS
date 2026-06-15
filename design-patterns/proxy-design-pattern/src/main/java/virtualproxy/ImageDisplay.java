package virtualproxy;

public class ImageDisplay implements IDisplay{
    private String path;
    public ImageDisplay(String path){
        this.path = path;
        // very timeconsuming methods
        System.out.println("loading image from path: " + path);
        System.out.println("apply compression algo");
        System.out.println("applying pixelation");
        System.out.println("image loaded suuccessfully");
    }

    @Override
    public void display() {
        System.out.println("displaying image from path: " + path);
    }
}
