package implimentation;

import java.util.ArrayList;
import java.util.List;

import interfaces.FileSystemItem;

public class Folder implements FileSystemItem{

    String name;    
    List<FileSystemItem> items;
    public Folder(String name){
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void add(FileSystemItem item){
        this.items.add(item);
    }

    public void remove(FileSystemItem item){
        this.items.remove(item);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int ans = 0;
        for(FileSystemItem item : items){
            ans+=item.getSize();
        }        
        return ans;
    }

    @Override
    public void openAll() {
        System.out.println("Opened - " + getName());
        for(FileSystemItem item : items){
            item.openAll();
        }
    }

    @Override
    public void ls() {
        for(FileSystemItem item : items){
            System.out.println(item.getName());
        }
    }
    
}
