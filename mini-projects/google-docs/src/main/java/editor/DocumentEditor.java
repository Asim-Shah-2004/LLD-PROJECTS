package editor;
import document.*;
import elements.*;
import persistence.*;

public class DocumentEditor{
    private Document document;
    private Persistance storage;

    public DocumentEditor(Document document,Persistance storage) {
        this.document = document;
        this.storage = storage;
    }

    public void addText(String text){
        document.addElement(new TextElement(text));
    }

    public void addImage(String path){
        document.addElement(new ImageElement(path));
    }

    public void addNewLine(){
        document.addElement(new NewLineElement());
    }

    public void addTabSpace(){
        document.addElement(new TabElement());
    }

    public String renderDocument(){
        return document.render();
    }

    public void save(){
        storage.save(renderDocument());
    }

}
