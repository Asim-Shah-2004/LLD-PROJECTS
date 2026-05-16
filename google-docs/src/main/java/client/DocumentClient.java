package client;

import document.Document;
import editor.DocumentEditor;
import persistence.PersistFile;
import persistence.Persistance;

public class DocumentClient{
    public static void main(String[] args) {

        Document doc = new Document();
        Persistance storage = new PersistFile();
        DocumentEditor editor = new DocumentEditor(doc,storage);

        editor.addImage("/src/home");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("hello world");
        editor.renderDocument();
        editor.save();

    }
}