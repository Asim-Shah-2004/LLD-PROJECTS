package interfaces;

public interface FileSystemItem{
    String getName();
    int getSize();
    void openAll();
    void ls();
}