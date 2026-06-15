package implimentation;

import interfaces.FileSystemItem;

public class File implements FileSystemItem {

    String name;
    int size;    
    public File(String name,int size){
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void openAll() {
        System.out.println(getName());
    }

    @Override
    public void ls() {
        System.out.println(getName());
    }
    
}
