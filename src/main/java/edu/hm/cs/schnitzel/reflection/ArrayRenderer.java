package edu.hm.cs.schnitzel.reflection;

/**
 *
 * @author nicfel
 */
public class ArrayRenderer {

    private final Object object;

    public ArrayRenderer(Object object) {
        this.object = object;
    }

    public String render() {

        getObject(); // TODO: do sth with this object
        // suche alle methoden mit annotation RenderMe
        return "";
    }

    private Object getObject() {
        return object;
    }

}
