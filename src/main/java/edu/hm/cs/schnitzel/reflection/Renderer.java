package edu.hm.cs.schnitzel.reflection;

public class Renderer {

    private final Object object;

    public Renderer(Object object) {
        this.object = object;
    }

    public String render() {

        
        //loop over object variables of object
            
            //check annotations == renderMe
            //if annotation has param -> call param rendererer method
            //else just render the object

        return "";
    }

    private Object getObject() {
        return object;
    }
}
