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
        String result = "";

        final Class<?> toRender = getObject().getClass();
        //get all the fields
        final Field[] fields = toRender.getDeclaredFields();
        //get all the methods
        final Method[] methods = toRender.getDeclaredMethods();
        result += "Instance of " + toRender.getName() + ":\n";
        //loop over object variables of object
        for (final Field field : fields) {
            field.setAccessible(true);
            //check annotations == renderMe
            final RenderMe renderMe = field.getAnnotation(RenderMe.class);
            if (renderMe != null) {
                try {
                    //if annotation has param -> call param rendererer method
                    final String path = renderMe.with();
                    final Class<?> renderClass = Class.forName(path);
                    if (renderClass != this.getClass()) {

                        // create a new object instance of the given renderer
                        final Object obj = renderClass.getConstructor().newInstance();
                        // get the method render()
                        final Method method = renderClass.getMethod("render", field.getType());
                        // invoke the method with the previously created object
                        result += (field.getName() + " (Type " + field.getType().getSimpleName() + "): " + (String) method.invoke(obj, field.get(getObject())) + "\n");

                    } else {
                        //else just render the field
                        result += (field.getName() + " (Type " + field.getType().getName() + "): " + field.get(getObject()).toString() + "\n");

                    }
                } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    System.out.println(ex.toString());
                }
            }

        }

        for (final Method method : methods) {
            //set accessible
            method.setAccessible(true);
            //check annotation
            final RenderMe renderMe = method.getAnnotation(RenderMe.class);
            if (renderMe != null) {
                //check for no param and not void
                if (method.getParameterCount() == 0 && !method.getReturnType().equals(Void.TYPE)) {
                    //check for a different renderer
                    try {
                        //if annotation has param -> call param rendererer method
                        final String path = renderMe.with();
                        final Class<?> renderClass = Class.forName(path);
                        //execute the annotated method once and safe the result to render it
                        final Object renderObject = method.invoke(getObject());
                        if (renderClass != this.getClass()) {
                            // create a new object instance of the given renderer
                            final Object obj = renderClass.getConstructor().newInstance();
                            // get the method render()
                            final Method renderMethod = renderClass.getMethod("render", method.getReturnType());

                            // invoke the method with the previously created object
                            result += (method.getName() + " (Type " + method.getReturnType().getSimpleName() + "): " + (String) renderMethod.invoke(obj, renderObject) + "\n");

                        } else {
                            //else just render the field
                            result += (method.getName() + " (Type " + method.getReturnType().getSimpleName() + "): " + renderObject.toString() + "\n");

                        }
                    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        System.out.println(ex.toString());
                    }
                }

            }
        }

        return result;
    }

    private Object getObject() {
        return object;
    }
}
