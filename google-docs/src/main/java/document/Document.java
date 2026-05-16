package document;

import elements.DocumentElement;
import java.util.*;

public class Document{
    private List<DocumentElement> elements;

    public Document(){
        elements = new ArrayList<>();
    }

    public void addElement(DocumentElement element){
        elements.add(element);
    }

    public String render(){

        StringBuilder result = new StringBuilder();

        for(DocumentElement element : elements){
            result.append(element.render());
        }

        return result.toString();

    }

}