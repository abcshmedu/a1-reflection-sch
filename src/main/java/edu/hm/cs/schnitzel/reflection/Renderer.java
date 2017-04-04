package edu.hm.cs.schnitzel.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Renderer {

    private final Object object;

    public Renderer(Object object) {
        this.object = object;
    }

    public String render() {

        final Class<?> toRender = getObject().getClass();
        final Field[] fields = toRender.getFields();
        //loop over object variables of object
        for (final Field field : fields) {
            //check annotations == renderMe
            RenderMe renderMe = field.getAnnotation(RenderMe.class);
            if(renderMe != null) {
                try {
                    //if annotation has param -> call param rendererer method
                    String path = renderMe.with();
                    Class<?> renderClass = Class.forName(path); 
                    if(renderClass != this.getClass()) {
                        
                        Object object = renderClass.getConstructor(Object.class).newInstance(getObject());
                        Method method = renderClass.getMethod("render");
                        method.invoke(object);
                        
                    } else {
                        //else just render the object
                        
                    }
                } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    System.out.println("ERRRRor");
                }
            }

        }

        return "";
    }

    private Object getObject() {
        return object;
    }
}
