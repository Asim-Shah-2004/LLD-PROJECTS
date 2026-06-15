import interfaces.FileSystemItem;
import implimentation.File;
import implimentation.Folder;

public class Main {
    public static void main(String[] args) {
        FileSystemItem file1 = new File("document.txt", 500);
        FileSystemItem file2 = new File("image.png", 1200);
        
        System.out.println("--- Single File Test ---");
        System.out.println("File Name: " + file1.getName());
        System.out.println("File Size: " + file1.getSize() + " bytes");
        System.out.print("ls(): ");
        file1.ls();
        System.out.print("openAll(): ");
        file1.openAll();
        System.out.println();

        Folder emptyFolder = new Folder("EmptyFolder");
        System.out.println("--- Empty Folder Test ---");
        System.out.println("Folder Name: " + emptyFolder.getName());
        System.out.println("Folder Size: " + emptyFolder.getSize() + " bytes");
        System.out.println("ls():");
        emptyFolder.ls();
        System.out.println("openAll():");
        emptyFolder.openAll();
        System.out.println();

        Folder root = new Folder("Root");
        Folder subFolder1 = new Folder("SubFolder1");
        Folder subFolder2 = new Folder("SubFolder2");
        
        FileSystemItem subFile1 = new File("subfile1.log", 300);
        FileSystemItem subFile2 = new File("subfile2.csv", 450);
        
        subFolder1.add(subFile1);
        subFolder1.add(subFile2);
        
        FileSystemItem subFile3 = new File("subfile3.json", 150);
        subFolder2.add(subFile3);
        
        root.add(file1);
        root.add(file2);
        root.add(subFolder1);
        root.add(subFolder2);

        System.out.println("--- Nested Folder Test (Composite) ---");
        System.out.println("Root Folder Name: " + root.getName());
        System.out.println("Expected Size: 2600 bytes (500 + 1200 + 300 + 450 + 150)");
        System.out.println("Calculated Size: " + root.getSize() + " bytes");
        
        System.out.println("ls() on Root:");
        root.ls();
        
        System.out.println("openAll() on Root:");
        root.openAll();
        System.out.println();

        System.out.println("--- Child Removal Test ---");
        System.out.println("Removing SubFolder2 from Root...");
        root.remove(subFolder2);
        System.out.println("New Expected Size: 2450 bytes (2600 - 150)");
        System.out.println("New Calculated Size: " + root.getSize() + " bytes");
        System.out.println("ls() on Root after removal:");
        root.ls();
    }
}
